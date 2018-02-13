package net.hedtech.banner.student.gsu.student.Wuasrve.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Wuasrve.WuasrveTask;
import net.hedtech.banner.student.gsu.student.Wuasrve.model.WuasrveModel;
import morphis.foundations.core.appsupportlib.runtime.action.*;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import morphis.foundations.core.types.NBool;
import morphis.foundations.core.types.NDate;
import morphis.foundations.core.types.NString;
import morphis.foundations.flavors.forms.appsupportlib.runtime.action.AfterValueChangedTrigger;

import static morphis.foundations.core.types.Types.*;
import morphis.core.utils.behavior.annotations.*;
import morphis.foundations.core.appdatalayer.data.*;
import morphis.foundations.core.appdatalayer.events.AfterQuery;
import morphis.foundations.core.appdatalayer.events.BeforeQuery;
import morphis.foundations.core.appdatalayer.events.BeforeRowInsert;
import morphis.foundations.core.appdatalayer.events.BeforeRowUpdate;
import morphis.foundations.core.appdatalayer.events.QueryEvent;
import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;
import morphis.foundations.core.appsupportlib.exceptions.ApplicationException;
import morphis.foundations.core.appsupportlib.model.IDBBusinessObject;
import net.hedtech.general.common.dbservices.GNls;

import static morphis.foundations.core.appsupportlib.Globals.getGlobal;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.*;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.deleteRecord;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.nextBlock;
import static morphis.foundations.core.appsupportlib.runtime.MessageServices.errorMessage;
import static morphis.foundations.core.appsupportlib.runtime.TaskServices.commitTask;
import static morphis.foundations.core.appsupportlib.runtime.ItemServices.*;
import morphis.foundations.core.appsupportlib.Lib;
import morphis.foundations.core.appsupportlib.runtime.*;
import net.hedtech.banner.student.gsu.student.Wuasrve.model.*;
import morphis.foundations.core.appdatalayer.events.BeforeRowDelete;
import morphis.foundations.core.appsupportlib.runtime.action.ActionTrigger;

public class WursrveController extends DefaultBlockController {

	public WursrveController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WuasrveTask getTask() {
		return (WuasrveTask) super.getTask();
	}

	public WuasrveModel getFormModel() {
		return getTask().getModel();
	}

	@After
	@ActionTrigger(action="PRE-BLOCK", function=KeyFunction.BLOCK_IN)
	public void wursrve_blockIn()
	{
		//TODO to be filled by the user
	}
	
	//Added the following controllers
	
	/* PRE-QUERY trigger
	DECLARE
	   CURSOR PTI_CURSOR IS
	      SELECT WUBSRVY_TERM_CODE_START, WUBSRVY_TERM_CODE_END
	      FROM   WUBSRVY
	      WHERE  WUBSRVY_CODE = :KEY_SRVY
	        AND  :KEY_TERM_CODE BETWEEN WUBSRVY_TERM_CODE_START AND WUBSRVY_TERM_CODE_END ;
	BEGIN
		OPEN PTI_CURSOR ;
		FETCH PTI_CURSOR INTO :WURSRVE_CTRL_BLOCK.FROM_TERM, :WURSRVE_CTRL_BLOCK.TO_TERM ;
	END ;

	IF :WURSRVE_CTRL_BLOCK.TO_TERM = '999999' THEN
		SET_BLOCK_PROPERTY('WURSRVE',INSERT_ALLOWED,PROPERTY_TRUE);
		SET_BLOCK_PROPERTY('WURSRVE',UPDATE_ALLOWED,PROPERTY_TRUE);
		SET_BLOCK_PROPERTY('WURSRVE',DELETE_ALLOWED,PROPERTY_TRUE);
	ELSE
		SET_BLOCK_PROPERTY('WURSRVE',INSERT_ALLOWED,PROPERTY_FALSE);
		SET_BLOCK_PROPERTY('WURSRVE',UPDATE_ALLOWED,PROPERTY_FALSE);
		SET_BLOCK_PROPERTY('WURSRVE',DELETE_ALLOWED,PROPERTY_FALSE);
	END IF;
	*/
	
	@BeforeQuery
	public void wursrve_BeforeQuery(QueryEvent args) {
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
				setBlockInsertAllowed("WURSRVE",true);
				setBlockUpdateAllowed("WURSRVE",true);
				setBlockDeleteAllowed("WURSRVE",true);				
			}
			else {
				setBlockInsertAllowed("WURSRVE",false);
				setBlockUpdateAllowed("WURSRVE",false);
				setBlockDeleteAllowed("WURSRVE",false);						
			}
		}
		finally{
			ptiCursor.close();
		}				

		
	}

	@AfterQuery
	public void wursrve_AfterQuery(RowAdapterEvent args) {

		WursrveAdapter wursrveElement = (WursrveAdapter) args.getRow();

		String sqlptrmCursor = "SELECT SSBSECT_PTRM_CODE, SSBSECT_SUBJ_CODE, SSBSECT_CRSE_NUMB " +
            "FROM   SSBSECT " +
            "WHERE  SSBSECT_TERM_CODE = :KEY_TERM_CODE " +
            "AND		SSBSECT_CRN = :WURSRVE_CRN";

		DataCursor ptrmCursor = new DataCursor(sqlptrmCursor);
		try {

			ptrmCursor.addParameter("KEY_TERM_CODE", wursrveElement.getWursrveSrvyTermCode());
			ptrmCursor.addParameter("WURSRVE_CRN", wursrveElement.getWursrveCrn());			
			ptrmCursor.open();
			ResultSet ptrmCursorResult = ptrmCursor.fetchInto();
			if (ptrmCursorResult != null) {
				wursrveElement.setPtrmCode(ptrmCursorResult.getStr(0));
				wursrveElement.setSubjCode(ptrmCursorResult.getStr(1));
				wursrveElement.setCrseNumb(ptrmCursorResult.getStr(2));
			}
			getTask().getGoqrpls().gCheckValue(ptrmCursor.notFound(), GNls.Fget(toStr("WUASRVE-0001"),
					toStr("FORM"), toStr("*ERROR* Invalid CRN code, press LIST for valid codes.")), toBool(NBool.True));

		} finally {
			ptrmCursor.close();
		}
	}
	
	@BeforeRowInsert
	public void wursrve_BeforeRowInsert(RowAdapterEvent args) {
		WursrveAdapter wursrveElement = (WursrveAdapter) args.getRow();
		wursrveElement.setWursrveActivityDate(NDate.getNow());					
	}

	@BeforeRowUpdate
	public void wursrve_BeforeRowUpdate(RowAdapterEvent args) {
		WursrveAdapter wursrveElement = (WursrveAdapter) args.getRow();
		wursrveElement.setWursrveActivityDate(NDate.getNow());
	}	

	/*KEY-DELREC trigger 
	DECLARE
	   CURSOR PTI_CURSOR_1 IS
	      SELECT NVL(WURSRVD_AVAIL_COMPLETE_IND,'N')
	      FROM   WURSRVD
	      WHERE  WURSRVD_SRVY_ID = :KEY_SRVY_ID
	      AND		 WURSRVD_SRVY_TERM_CODE = :KEY_TERM_CODE
	      AND		 WURSRVD_PTRM_CODE = :WURSRVE.PTRM_CODE ;
	BEGIN
		OPEN PTI_CURSOR_1 ;
		FETCH PTI_CURSOR_1 INTO :WURSRVE.AVAIL_COMPLETE_IND ;
	  G$_CHECK_VALUE (:WURSRVE.AVAIL_COMPLETE_IND = 'Y','*ERROR* Part of Term has already been run.', TRUE);
	END ;*/

	@ActionTrigger(action="KEY-DELREC", function=KeyFunction.DELETE_RECORD)
	public void wursrve_DeleteRecord() {
		
		WursrveAdapter wursrveElement = (WursrveAdapter)this.getFormModel().getWursrve().getRowAdapter(true);
		if(wursrveElement==null)
			return;		
		
		NString ptiIntoTemp= NString.getNull();
		String sqlptiCursor = "SELECT NVL(WURSRVD_AVAIL_COMPLETE_IND,'N') " +
	      "FROM   WURSRVD " +
	      "WHERE  WURSRVD_SRVY_ID = :SRVY_ID " + 
	      "AND		 WURSRVD_SRVY_TERM_CODE = :TERM_CODE " + 
	      "AND		 WURSRVD_PTRM_CODE = :PTRM_CODE ";
		DataCursor ptiCursor = new DataCursor(sqlptiCursor);
		try {
			//Setting query parameters
			ptiCursor.addParameter("TERM_CODE", wursrveElement.getWursrveSrvyTermCode());
			ptiCursor.addParameter("PTRM_CODE", wursrveElement.getPtrmCode());
			ptiCursor.addParameter("SRVY_ID", wursrveElement.getWursrveSrvyId());
			//F2J_WARNING : Make sure that the method "Close" is being called over the variable ptiCursor.
			ptiCursor.open();
			ResultSet ptiCursorResults = ptiCursor.fetchInto();
			if ( ptiCursorResults != null ) {
				ptiIntoTemp = ptiCursorResults.getStr(0);
			}
			getTask().getGoqrpls().gCheckValue(ptiIntoTemp.equals("Y"), toStr("*ERROR* Part of Term has already been run."), toBool(NBool.True));
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
		IF (:WURSRVE_CRN IS NULL AND 
				:WURSRVE_EXCEPT_IND IS NULL) THEN
		    RETURN;
		END IF;
		IF (:WURSRVE_CRN IS NULL OR 
				:WURSRVE_EXCEPT_IND IS NULL)
		THEN
				MESSAGE ('*ERROR* Required fields must be entered.');
				IF :WURSRVE_CRN IS NULL THEN
					GO_ITEM('WURSRVE_CRN');
					RAISE FORM_TRIGGER_FAILURE ;
					RETURN;
				END IF;
				IF :WURSRVE_EXCEPT_IND IS NULL THEN
					GO_ITEM('WURSRVE_EXCEPT_IND');
					RAISE FORM_TRIGGER_FAILURE ;
					RETURN;
				END IF;
		
				RAISE FORM_TRIGGER_FAILURE ;
				RETURN;
		
		END IF;
		
		IF (:WURSRVE_EXCEPT_IND NOT IN ('P','I','E'))
		THEN
				MESSAGE ('*ERROR* Required field must be P (paper), I (include), or E (exclude).');
				GO_ITEM('WURSRVE_EXCEPT_IND');
				RAISE FORM_TRIGGER_FAILURE ;
				RETURN;
		
				RAISE FORM_TRIGGER_FAILURE ;
				RETURN;
		
		END IF;
	*/
	@ActionTrigger(action="KEY-COMMIT", function=KeyFunction.SAVE)
	public void wursrve_Save() {
		WursrveAdapter wursrveElement = (WursrveAdapter)this.getFormModel().getWursrve().getRowAdapter(true);
		if(wursrveElement==null)
			return;		
		
		if ( wursrveElement.getWursrveCrn().isNull() &&  wursrveElement.getWursrveExceptInd().isNull() ) {			
			return;
		}
		
		if ( wursrveElement.getWursrveCrn().isNull() ||  wursrveElement.getWursrveExceptInd().isNull() ) {
			errorMessage("*ERROR* Required fields must be entered.");
			if ( wursrveElement.getWursrveCrn().isNull() ) {
				goItem(toStr("WURSRVE_CRN"));
			     throw new ApplicationException();				
			}
			if ( wursrveElement.getWursrveExceptInd().isNull() ) {
				goItem(toStr("WURSRVE_EXCEPT_IND"));
			     throw new ApplicationException();				
			}			
		}
		
		if ( wursrveElement.getWursrveExceptInd().notEquals("P") &&
			 wursrveElement.getWursrveExceptInd().notEquals("I") &&
			 wursrveElement.getWursrveExceptInd().notEquals("E")) {
			errorMessage("*ERROR* Required field must be P (paper), I (include), or E (exclude).");
			goItem(toStr("WURSRVE_EXCEPT_IND"));
			throw new ApplicationException();	
		}
		getTask().getGoqrpls().gCheckFailure();
		commitTask();
	}

	// Source for POST-CHANGE of the field WURSRVE_CRN
    /*
		   DECLARE
		      CURSOR PTI_CURSOR IS
		         SELECT SSBSECT_PTRM_CODE,
		         				SSBSECT_SUBJ_CODE,
		         				SSBSECT_CRSE_NUMB
		         FROM   SSBSECT
		         WHERE  SSBSECT_TERM_CODE = :KEY_TERM_CODE
		         AND		SSBSECT_CRN = :WURSRVE_CRN ;
		   BEGIN
		      OPEN PTI_CURSOR ;
		      FETCH PTI_CURSOR INTO :WURSRVE.PTRM_CODE, :WURSRVE.SUBJ_CODE, :WURSRVE.CRSE_NUMB ;
		      G$_CHECK_VALUE (PTI_CURSOR%NOTFOUND,'*ERROR* Invalid CRN, press LIST for valid CRN.', TRUE);
		   END;
		
		IF :SYSTEM.BLOCK_STATUS <> 'QUERY' THEN
		
		DECLARE
		   CURSOR PTI_CURSOR_1 IS
		      SELECT NVL(WURSRVD_AVAIL_COMPLETE_IND,'N')
		      FROM   WURSRVD
		      WHERE  WURSRVD_SRVY_ID = :KEY_SRVY_ID
		      AND		 WURSRVD_SRVY_TERM_CODE = :KEY_TERM_CODE
		      AND		 WURSRVD_PTRM_CODE = :WURSRVE.PTRM_CODE ;
		BEGIN
			OPEN PTI_CURSOR_1 ;
			FETCH PTI_CURSOR_1 INTO :WURSRVE.AVAIL_COMPLETE_IND ;
		  G$_CHECK_VALUE (:WURSRVE.AVAIL_COMPLETE_IND = 'Y','*ERROR* Part of Term has already been run.', TRUE);
		END ;   
		
		END IF;
     */
	@AfterValueChangedTrigger( item="WURSRVE_CRN" )
	public void wursrveCrn_PostChange()
	{
		WursrveAdapter wursrveElement = (WursrveAdapter)this.getFormModel().getWursrve().getRowAdapter(true);
		if(wursrveElement==null)
			return;	
			
		String sqlptrmCursor = "SELECT SSBSECT_PTRM_CODE, SSBSECT_SUBJ_CODE, SSBSECT_CRSE_NUMB " +
	            "FROM   SSBSECT " +
	            "WHERE  SSBSECT_TERM_CODE = :KEY_TERM_CODE " +
	            "AND		SSBSECT_CRN = :WURSRVE_CRN";

		DataCursor ptrmCursor = new DataCursor(sqlptrmCursor);
		try {

				ptrmCursor.addParameter("KEY_TERM_CODE", wursrveElement.getWursrveSrvyTermCode());
				ptrmCursor.addParameter("WURSRVE_CRN", wursrveElement.getWursrveCrn());			
				ptrmCursor.open();
				ResultSet ptrmCursorResult = ptrmCursor.fetchInto();
				if (ptrmCursorResult != null) {
					wursrveElement.setPtrmCode(ptrmCursorResult.getStr(0));
					wursrveElement.setSubjCode(ptrmCursorResult.getStr(1));
					wursrveElement.setCrseNumb(ptrmCursorResult.getStr(2));
				}
				getTask().getGoqrpls().gCheckValue(ptrmCursor.notFound(), GNls.Fget(toStr("WUASRVE-0002"),
						toStr("FORM"), toStr("*ERROR* Invalid CRN, press LIST for valid CRN.")), toBool(NBool.True));

		} finally {
				ptrmCursor.close();
		}
		
		NString ptiIntoTemp= NString.getNull();
		String sqlptiCursor = "SELECT NVL(WURSRVD_AVAIL_COMPLETE_IND,'N') " +
	      "FROM   WURSRVD " +
	      "WHERE  WURSRVD_SRVY_ID = :SRVY_ID " + 
	      "AND		 WURSRVD_SRVY_TERM_CODE = :TERM_CODE " + 
	      "AND		 WURSRVD_PTRM_CODE = :PTRM_CODE ";
		DataCursor ptiCursor = new DataCursor(sqlptiCursor);
		try {
			//Setting query parameters
			ptiCursor.addParameter("TERM_CODE", wursrveElement.getWursrveSrvyTermCode());
			ptiCursor.addParameter("PTRM_CODE", wursrveElement.getPtrmCode());
			ptiCursor.addParameter("SRVY_ID", wursrveElement.getWursrveSrvyId());
			//F2J_WARNING : Make sure that the method "Close" is being called over the variable ptiCursor.
			ptiCursor.open();
			ResultSet ptiCursorResults = ptiCursor.fetchInto();
			if ( ptiCursorResults != null ) {
				ptiIntoTemp = ptiCursorResults.getStr(0);
			}
			getTask().getGoqrpls().gCheckValue(ptiIntoTemp.equals("Y"), toStr("*ERROR* Part of Term has already been run."), toBool(NBool.True));
		}
		finally{
			ptiCursor.close();
		}						
	}
	
	// Source for POST-TEXT-ITEM of the field WURSRVE_CRN
	/*
		IF :WURSRVE_CRN IS NULL THEN
			:WURSRVE.PTRM_CODE := NULL;
			:WURSRVE.SUBJ_CODE := NULL;
			:WURSRVE.CRSE_NUMB := NULL;
			:WURSRVE.AVAIL_COMPLETE_IND := NULL;
		END IF;	
	 */

	@ActionTrigger(action="POST-TEXT-ITEM", item="WURSRVE_CRN", function=KeyFunction.ITEM_OUT)
	public void wursrveCrn_itemOut()
	{		
		WursrveAdapter wursrveElement = (WursrveAdapter)this.getFormModel().getWursrve().getRowAdapter(true);
		if(wursrveElement==null)
			return;	
		
		if ( wursrveElement.getWursrveCrn().isNull() ) {
			wursrveElement.setPtrmCode(toStr(""));
			wursrveElement.setSubjCode(toStr(""));
			wursrveElement.setCrseNumb(toStr(""));		
		}
	}	
	
}

