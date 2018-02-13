package net.hedtech.banner.student.gsu.student.Wtrtrtt.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;

import net.hedtech.banner.student.gsu.student.Wtrtrtt.WtrtrttTask;
import net.hedtech.banner.student.gsu.student.Wtrtrtt.model.WtrtrttModel;
import morphis.foundations.core.appsupportlib.runtime.action.*;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import morphis.foundations.core.types.NBool;
import morphis.foundations.core.types.NDate;

import static morphis.foundations.core.types.Types.*;
import static net.hedtech.general.common.forms.services.BaseTaskServices.executeAction;

import morphis.core.utils.behavior.annotations.*;
import morphis.foundations.core.appdatalayer.data.*;
import morphis.foundations.core.appsupportlib.exceptions.ApplicationException;
import morphis.foundations.core.appsupportlib.model.IDBBusinessObject;
import net.hedtech.general.common.dbservices.GNls;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.nextBlock;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.setBlockWhereClause;
import static morphis.foundations.core.appsupportlib.runtime.MessageServices.errorMessage;
import static morphis.foundations.core.appsupportlib.runtime.TaskServices.executeQuery;
import static morphis.foundations.core.appsupportlib.runtime.TaskServices.goBlock;

import morphis.foundations.core.appsupportlib.Lib;
import morphis.foundations.core.appsupportlib.runtime.*;
import net.hedtech.banner.student.gsu.student.Wtrtrtt.model.*;
import morphis.foundations.core.appdatalayer.events.AfterQuery;
import morphis.foundations.core.appdatalayer.events.BeforeQuery;
import morphis.foundations.core.appdatalayer.events.QueryEvent;
import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;
import morphis.foundations.core.appdatalayer.events.BeforeRowInsert;
import static morphis.foundations.core.appsupportlib.Globals.*;
import morphis.foundations.core.appdatalayer.events.BeforeRowUpdate;

import static morphis.foundations.core.appsupportlib.Lib.*;
import morphis.foundations.core.types.NString;

public class WtrtrttController extends DefaultBlockController {

	public WtrtrttController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WtrtrttTask getTask() {
		return (WtrtrttTask) super.getTask();
	}

	public WtrtrttModel getFormModel() {
		return getTask().getModel();
	}

	/*
	@After
	@ActionTrigger(action="PRE-BLOCK", function=KeyFunction.BLOCK_IN)
	public void wtrtrtt_blockIn()
	{
		//TODO to be filled by the user
	}*/


	
	
	@BeforeQuery
	public void wtrtrtt_BeforeQuery(QueryEvent args)
	{

           // F2J_WARNING : Query Parameters initialization. Make sure that all the query parameters are properly initialized
		
		    WtrtrttAdapter wtrtrttElement = (WtrtrttAdapter) this.getFormModel().getWtrtrtt().getRowAdapter();			
			setBlockWhereClause("WTRTRTT", "WHERE WTRTRTT_LABL_CODE = :KEYBLOCK_LABL_CODE AND WTRTRTT_TPRT_CODE = :KEYBLOCK_TPRT_CODE");
			((IDBBusinessObject)args.getSource()).getSelectCommandParams().add(DbManager.getDataBaseFactory().createDataParameter("KEYBLOCK_LABL_CODE",this.getFormModel().getKeyBlock().getKeyblockLablCode()));     
			((IDBBusinessObject)args.getSource()).getSelectCommandParams().add(DbManager.getDataBaseFactory().createDataParameter("KEYBLOCK_TPRT_CODE",this.getFormModel().getKeyBlock().getKeyblockTprtCode()));
			
					
			/*((IDBBusinessObject)args.getSource()).getSelectCommandParams().add(DbManager.getDataBaseFactory().createDataParameter("ssaexcl_ptrm_code",this.getFormModel().getKeyBlock().getSsaexclPtrmCode()));*/             
		       
    }
		
	/* Original PL/SQL code for  
BEGIN
  G$_INVALID_FUNCTION_MSG;
END;*/
	
	@ActionTrigger(action="KEY-PRVBLK", function=KeyFunction.PREVIOUS_BLOCK)
	public void wtrtrtt_PreviousBlock()
	{
		
			getTask().getGoqrpls().gInvalidFunctionMsg();
			throw new ApplicationException();
		}
/*Original PL/SQL code for 
	BEGIN
	  G$_INVALID_FUNCTION_MSG;
	END;*/
	
	@ActionTrigger(action="KEY-NXTBLK", function=KeyFunction.NEXT_BLOCK)
	public void wtrtrtt_NextBlock()
	{
		
			getTask().getGoqrpls().gInvalidFunctionMsg();
			throw new ApplicationException();
		}

	/*Original PL/SQL code for TRIGGER WTRTRTT.PRE-INSERT
	   :WTRTRTT_CREATE_USER := USER;
	   :WTRTRTT_CREATE_DATE := SYSDATE;
	   :WTRTRTT_USER := USER;
	   :WTRTRTT_ACTIVITY_DATE := SYSDATE;
	   :WTRTRTT_DATA_ORIGIN := 'WTRTRTT';
	  G$_CHECK_FAILURE ;*/
	
	

	@BeforeRowInsert
	public void wtrtrtt_BeforeRowInsert(RowAdapterEvent args) {
		
		WtrtrttAdapter wtrtrttElement = (WtrtrttAdapter) args.getRow();
		
		wtrtrttElement.setWtrtrttCreateUser(getGlobal("CURRENT_USER"));
		wtrtrttElement.setWtrtrttCreateDate(NDate.getNow());
		wtrtrttElement.setWtrtrttUser(getGlobal("CURRENT_USER"));
		wtrtrttElement.setWtrtrttActivityDate(NDate.getNow());
		wtrtrttElement.setWtrtrttDataOrigin(toStr("WTRTRTT"));
		getTask().getGoqrpls().gCheckFailure();
		
	}

	/*Original PL/SQL code for TRIGGER WTRTRTT.PRE-UPDATE
	   :WTRTRTT_USER := USER;
	   :WTRTRTT_ACTIVITY_DATE := SYSDATE;
	   :WTRTRTT_DATA_ORIGIN := 'WTRTRTT';*/
	   
	@BeforeRowUpdate
	public void wtrtrtt_BeforeRowUpdate(RowAdapterEvent args) {
		WtrtrttAdapter wtrtrttElement = (WtrtrttAdapter) args.getRow();
		
		wtrtrttElement.setWtrtrttUser(getGlobal("CURRENT_USER"));
		wtrtrttElement.setWtrtrttActivityDate(NDate.getNow());
		wtrtrttElement.setWtrtrttDataOrigin(toStr("WTRTRTT"));
		
	}
	
	@ActionTrigger(action = "WHEN_NEW_BLOCK_INSTANCE")
	public void Wtrtrtt_WhenNewBlockInstance() {
		if (getFormModel().getButtonControlBlock().getCheckKeys().equals("Y")) {
			getFormModel().getButtonControlBlock().setCheckKeys(toStr("N"));
			goBlock(toStr("KEY_BLOCK"));
			executeAction("CHECK_KEYS");
			getTask().getGoqrpls().gCheckFailure();

			nextBlock();
			executeQuery();

			getFormModel().getButtonControlBlock().setCheckKeys(toStr("N"));
			executeAction("DISABLE_KEYS");
			getTask().getGoqrpls().gCheckFailure();
		}
		
		
	}
	
	/*
	 *<p>
	 *<b>Migration Comments</b>
	 * Generated from trigger:
	 * WTRTRTT_REQ_IND.WHEN-VALIDATE-ITEM
	 *
	 *
	 *</p>
	*/
	
	@ValidationTrigger(item="WTRTRTT_REQ_IND")
	public void wtrtrttreqind_Validate()
	{
	
	    WtrtrttAdapter wtrtrttElement = (WtrtrttAdapter) this.getFormModel().getWtrtrtt().getRowAdapter();		
		
	   	if ( notIn(wtrtrttElement.getWtrtrttReqInd(), "Y", "N", null).getValue() )
		{
			errorMessage(GNls.Fget(toStr("WTRTRTT-0001"), toStr("FORM"), toStr("*ERROR* Invalid value.")));
			throw new ApplicationException();
		}
	
	}

	/*
	 *<p>
	 *<b>Migration Comments</b>
	 * Generated from trigger:
	 * WTRTRTT_TRTG_CODE.WHEN-VALIDATE-ITEM
	 *
	 *
	 *</p>
	*/
	
	@ValidationTrigger(item="WTRTRTT_TRTG_CODE")
	public void wtrtrtttrtgcode_Validate()
	{
	
	    WtrtrttAdapter wtrtrttElement = (WtrtrttAdapter) this.getFormModel().getWtrtrtt().getRowAdapter();		
		
	   		   	
	   	NString vwtvtrtgcode = NString.getNull();
		String sqlptiCursor = "SELECT  WTVTRTG_CODE FROM WTVTRTG"
				+ " WHERE WTVTRTG_CODE = :WTRTRTT_TRTG_CODE";
		DataCursor ptiCursor = new DataCursor(sqlptiCursor);
		try {
			// Setting query parameters
			ptiCursor.addParameter("WTRTRTT_TRTG_CODE", wtrtrttElement.getWtrtrttTrtgCode());
			
			ptiCursor.open();
			ResultSet ptiCursorResults = ptiCursor.fetchInto();
			if (ptiCursorResults != null) {
				vwtvtrtgcode = ptiCursorResults.getStr(0);
			}
			getTask().getGoqrpls().gCheckValue(ptiCursor.notFound(),GNls.Fget(toStr("WTRTRTT-0001"),
					toStr("FORM"), toStr("*ERROR* Invalid code, press LIST for valid codes.")), toBool(NBool.True));
			
		} 
		finally {
		  ptiCursor.close();
       }		

	}

	
}