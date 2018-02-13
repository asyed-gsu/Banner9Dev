package net.hedtech.banner.student.gsu.student.Wuasrve.controller;

import static morphis.foundations.core.appsupportlib.runtime.BlockServices.deleteRecord;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.setBlockDeleteAllowed;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.setBlockInsertAllowed;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.setBlockUpdateAllowed;
import static morphis.foundations.core.appsupportlib.runtime.ItemServices.goItem;
import static morphis.foundations.core.appsupportlib.runtime.MessageServices.errorMessage;
import static morphis.foundations.core.appsupportlib.runtime.TaskServices.commitTask;
import static morphis.foundations.core.types.Types.toBool;
import static morphis.foundations.core.types.Types.toStr;

import morphis.foundations.core.appdatalayer.data.DataCursor;
import morphis.foundations.core.appdatalayer.data.DbManager;
import morphis.foundations.core.appdatalayer.data.ResultSet;
import morphis.foundations.core.appdatalayer.events.AfterQuery;
import morphis.foundations.core.appdatalayer.events.BeforeQuery;
import morphis.foundations.core.appdatalayer.events.BeforeRowInsert;
import morphis.foundations.core.appdatalayer.events.BeforeRowUpdate;
import morphis.foundations.core.appdatalayer.events.QueryEvent;
import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;
import morphis.foundations.core.appsupportlib.exceptions.ApplicationException;
import morphis.foundations.core.appsupportlib.model.IDBBusinessObject;
import morphis.foundations.core.appsupportlib.runtime.action.ActionTrigger;
import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import morphis.foundations.core.types.NBool;
import morphis.foundations.core.types.NDate;
import morphis.foundations.core.types.NString;
import net.hedtech.general.common.dbservices.GNls;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Wuasrve.WuasrveTask;
import net.hedtech.banner.student.gsu.student.Wuasrve.model.WuasrveModel;
import net.hedtech.banner.student.gsu.student.Wuasrve.model.WursrvxAdapter;

public class WursrvxController extends DefaultBlockController {

	public WursrvxController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WuasrveTask getTask() {
		return (WuasrveTask) super.getTask();
	}

	public WuasrveModel getFormModel() {
		return getTask().getModel();
	}
	
	//Added the following controllers
	@BeforeQuery
	public void wursrvx_BeforeQuery(QueryEvent args) {
		((IDBBusinessObject)args.getSource()).getSelectCommandParams().add(DbManager.getDataBaseFactory().createDataParameter("SRVY_ID",
		this.getFormModel().getKeyBlock().getSrvyCode()));
		((IDBBusinessObject)args.getSource()).getSelectCommandParams().add(DbManager.getDataBaseFactory().createDataParameter("TERM",
		this.getFormModel().getKeyBlock().getTermCode()));	
		
		NString ptiIntoTemp= NString.getNull();
		String sqlptiCursor = "SELECT WUBSRVY_TERM_CODE_START, WUBSRVY_TERM_CODE_END " +
	      "FROM   WUBSRVY " +
	      "WHERE  WUBSRVY_CODE = :KEY_SRVY" +
	      "  AND  :KEY_TERM_CODE BETWEEN WUBSRVY_TERM_CODE_START AND WUBSRVY_TERM_CODE_END ";
		DataCursor ptiCursor = new DataCursor(sqlptiCursor);
		try {
			//Setting query parameters
			ptiCursor.addParameter("KEY_TERM_CODE", this.getFormModel().getKeyBlock().getTermCode());
			ptiCursor.addParameter("KEY_SRVY", this.getFormModel().getKeyBlock().getSrvyCode());
			//F2J_WARNING : Make sure that the method "Close" is being called over the variable ptiCursor.
			ptiCursor.open();
			ResultSet ptiCursorResults = ptiCursor.fetchInto();
			if ( ptiCursorResults != null ) {
				ptiIntoTemp = ptiCursorResults.getStr(1);
			}
			if (ptiIntoTemp.equals("999999") ) { 
				setBlockInsertAllowed("WURSRVX",true);
				setBlockUpdateAllowed("WURSRVX",true);
				setBlockDeleteAllowed("WURSRVX",true);				
			}
			else {
				setBlockInsertAllowed("WURSRVX",false);
				setBlockUpdateAllowed("WURSRVX",false);
				setBlockDeleteAllowed("WURSRVX",false);						
			}
		}
		finally{
			ptiCursor.close();
		}				
		
	}
	
	@AfterQuery
	public void wursrvx_AfterQuery(RowAdapterEvent args) {

		WursrvxAdapter wursrvxElement = (WursrvxAdapter) args.getRow();

		String sqlptrmCursor = "SELECT SSBSECT_PTRM_CODE, SSBSECT_SUBJ_CODE, SSBSECT_CRSE_NUMB " +
            "FROM   SSBSECT " +
            "WHERE  SSBSECT_TERM_CODE = :KEY_TERM_CODE " +
            "AND		SSBSECT_CRN = :WURSRVE_CRN";

		DataCursor ptrmCursor = new DataCursor(sqlptrmCursor);
		try {

			ptrmCursor.addParameter("KEY_TERM_CODE", wursrvxElement.getWursrvxSrvyTermCode());
			ptrmCursor.addParameter("WURSRVE_CRN", wursrvxElement.getWursrvxCrn());			
			ptrmCursor.open();
			ResultSet ptrmCursorResult = ptrmCursor.fetchInto();
			if (ptrmCursorResult != null) {
				wursrvxElement.setPtrmCode(ptrmCursorResult.getStr(0));
				wursrvxElement.setSubjCode(ptrmCursorResult.getStr(1));
				wursrvxElement.setCrseNumb(ptrmCursorResult.getStr(2));
			}
			getTask().getGoqrpls().gCheckValue(ptrmCursor.notFound(), GNls.Fget(toStr("WUASRVE-0002"),
					toStr("FORM"), toStr("*ERROR* Invalid CRN code, press LIST for valid codes.")), toBool(NBool.True));

		} finally {
			ptrmCursor.close();
		}
	}

	@BeforeRowInsert
	public void wursrvx_BeforeRowInsert(RowAdapterEvent args) {
		WursrvxAdapter wursrvxElement = (WursrvxAdapter) args.getRow();
		wursrvxElement.setWursrvxActivityDate(NDate.getNow());	
	}

	@BeforeRowUpdate
	public void wursrvx_BeforeRowUpdate(RowAdapterEvent args) {
		WursrvxAdapter wursrvxElement = (WursrvxAdapter) args.getRow();
		wursrvxElement.setWursrvxActivityDate(NDate.getNow());
	}	

	//Source for KEY-DELREC
	/*
	DECLARE
	   CURSOR PTI_CURSOR_1 IS
	      SELECT NVL(WURSRVG_AVAIL_COMPLETE_IND,'N')
	      FROM   WURSRVG
	      WHERE  WURSRVG_SRVY_ID = :KEY_SRVY_ID
	      AND		 WURSRVG_SRVY_TERM_CODE = :KEY_TERM_CODE
	      AND		 WURSRVG_GROUP_CODE = :WURSRVX_GROUP_CODE ;
	BEGIN
		OPEN PTI_CURSOR_1 ;
		FETCH PTI_CURSOR_1 INTO :WURSRVX.AVAIL_COMPLETE_IND ;
	  G$_CHECK_VALUE (:WURSRVX.AVAIL_COMPLETE_IND = 'Y','*ERROR* Group has already been run.', TRUE);
	END ;   
    
	DELETE_RECORD;
	*/
	@ActionTrigger(action="KEY-DELREC", function=KeyFunction.DELETE_RECORD)
	public void wursrvx_DeleteRecord() {
		
		WursrvxAdapter wursrvxElement = (WursrvxAdapter)this.getFormModel().getWursrvx().getRowAdapter(true);
		if(wursrvxElement==null)
			return;		
		
		NString ptiIntoTemp= NString.getNull();
		String sqlptiCursor = "SELECT NVL(WURSRVG_AVAIL_COMPLETE_IND,'N') " +
	      "FROM   WURSRVG " +
	      "WHERE  WURSRVG_SRVY_ID = :SRVY_ID " + 
	      "AND	  WURSRVG_SRVY_TERM_CODE = :TERM_CODE " + 
	      "AND	  WURSRVG_GROUP_CODE = :GROUP_CODE  ";
		DataCursor ptiCursor = new DataCursor(sqlptiCursor);
		try {
			//Setting query parameters
			ptiCursor.addParameter("TERM_CODE", wursrvxElement.getWursrvxSrvyTermCode());
			ptiCursor.addParameter("GROUP_CODE", wursrvxElement.getWursrvxGroupCode());
			ptiCursor.addParameter("SRVY_ID", wursrvxElement.getWursrvxSrvyId());
			//F2J_WARNING : Make sure that the method "Close" is being called over the variable ptiCursor.
			ptiCursor.open();
			ResultSet ptiCursorResults = ptiCursor.fetchInto();
			if ( ptiCursorResults != null ) {
				ptiIntoTemp = ptiCursorResults.getStr(0);
			}
			getTask().getGoqrpls().gCheckValue(ptiIntoTemp.equals("Y"), toStr("*ERROR* Group has already been run."), toBool(NBool.True));
		}
		finally{
			ptiCursor.close();
		}				
		getTask().getGoqrpls().gCheckFailure();
		deleteRecord();		
	}

	// Source for KEY-COMMIT
	/*
	EXECUTE_TRIGGER('CHECK_REQD');
	G$_CHECK_FAILURE;
	commit_form;  	
	*/
	
	// Source for CHECK_REQD
	/*
	IF (:WURSRVX_CRN IS NULL AND 
			:WURSRVX_GROUP_CODE IS NULL) THEN
	    RETURN;
	END IF;
	IF (:WURSRVX_CRN IS NULL OR 
			:WURSRVX_GROUP_CODE IS NULL)
	THEN
			MESSAGE ('*ERROR* Required fields must be entered.');
			IF :WURSRVX_CRN IS NULL THEN
				GO_ITEM('WURSRVX_CRN');
				RAISE FORM_TRIGGER_FAILURE ;
				RETURN;
			END IF;
			IF :WURSRVX_GROUP_CODE IS NULL THEN
				GO_ITEM('WURSRVX_GROUP_CODE');
				RAISE FORM_TRIGGER_FAILURE ;
				RETURN;
			END IF;
	
			RAISE FORM_TRIGGER_FAILURE ;
			RETURN;
	
	END IF;	
 */
	@ActionTrigger(action="KEY-COMMIT", function=KeyFunction.SAVE)
	public void wursrvx_Save() {
		WursrvxAdapter wursrvxElement = (WursrvxAdapter)this.getFormModel().getWursrvx().getRowAdapter(true);
		if(wursrvxElement==null)
			return;		
		
		if ( wursrvxElement.getWursrvxCrn().isNull() &&  wursrvxElement.getWursrvxGroupCode().isNull() ) {			
			return;
		}
		
		if ( wursrvxElement.getWursrvxCrn().isNull() ||  wursrvxElement.getWursrvxGroupCode().isNull() ) {
			errorMessage("*ERROR* Required fields must be entered.");
			if ( wursrvxElement.getWursrvxCrn().isNull() ) {
				goItem(toStr("WURSRVX_CRN"));
			     throw new ApplicationException();				
			}
			if ( wursrvxElement.getWursrvxGroupCode().isNull() ) {
				goItem(toStr("WURSRVX_GROUP_CODE"));
			     throw new ApplicationException();				
			}			
		}
		
		getTask().getGoqrpls().gCheckFailure();
		commitTask();
	}	
}