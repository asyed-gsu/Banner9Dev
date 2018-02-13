package net.hedtech.banner.student.gsu.student.Wjipwpg.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Wjipwpg.WjipwpgTask;
import net.hedtech.banner.student.gsu.student.Wjipwpg.model.WjipwpgModel;
import net.hedtech.banner.student.gsu.student.Woalocn.model.WorlocnAdapter;
import morphis.foundations.core.appsupportlib.runtime.action.*;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import morphis.foundations.core.types.NBool;
import morphis.foundations.core.types.NDate;
import morphis.foundations.core.types.NString;

import static morphis.foundations.core.types.Types.*;
import morphis.core.utils.behavior.annotations.*;
import morphis.foundations.core.appdatalayer.data.*;
import morphis.foundations.core.appdatalayer.events.AfterQuery;
import morphis.foundations.core.appdatalayer.events.BeforeQuery;
import morphis.foundations.core.appdatalayer.events.QueryEvent;
import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;
import morphis.foundations.core.appsupportlib.exceptions.ApplicationException;
import morphis.foundations.core.appsupportlib.model.IDBBusinessObject;
import net.hedtech.general.common.dbservices.GNls;

import static morphis.foundations.core.appsupportlib.Globals.getGlobal;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.nextBlock;
import static morphis.foundations.core.appsupportlib.runtime.MessageServices.errorMessage;
import morphis.foundations.core.appsupportlib.Lib;
import morphis.foundations.core.appsupportlib.runtime.*;
import net.hedtech.banner.student.gsu.student.Wjipwpg.model.*;

public class WjrpwpgController extends DefaultBlockController {

	public WjrpwpgController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WjipwpgTask getTask() {
		return (WjipwpgTask) super.getTask();
	}

	public WjipwpgModel getFormModel() {
		return getTask().getModel();
	}

	@After
	@ActionTrigger(action="PRE-BLOCK", function=KeyFunction.BLOCK_IN)
	public void wjrpwpg_blockIn()
	{
		//TODO to be filled by the user
	}

	@BeforeQuery
	public void wjrpwpg_BeforeQuery(QueryEvent args) {
		((IDBBusinessObject)args.getSource()).getSelectCommandParams().add(DbManager.getDataBaseFactory().createDataParameter("AIDYEAR",
		this.getFormModel().getKeyBlock().getAidyCode()));	
		((IDBBusinessObject)args.getSource()).getSelectCommandParams().add(DbManager.getDataBaseFactory().createDataParameter("PIDM",
		this.getFormModel().getKeyBlock().getPidm()));				
	}
	
	@AfterQuery
	public void wjrpwpg_AfterQuery(RowAdapterEvent args) {
		WjrpwpgAdapter wjrpwpgElement = (WjrpwpgAdapter) args.getRow();
		/*wjrpwpgElement.setWorlocnLocnCode(this.getFormModel().getKeyBlock().getLocnCode());
		worlocnElement.setWorlocnUser(getGlobal("CURRENT_USER"));
		worlocnElement.setWorlocnActivityDate(NDate.getNow());	
		if ( worlocnElement.getWorlocnOfficialInd().isNull() ) {
		   worlocnElement.setWorlocnOfficialInd(toStr("N"));
		}		*/
		
		NString ptiIntoTemp = NString.getNull();
		String sqlptiCursor = "SELECT RJRSEAR_PLACE_CDE, RJRSEAR_FUND_CODE "
         + "FROM   RJRSEAR "
         + "WHERE  RJRSEAR_AIDY_CODE = :WJRPWPG_AIDY_CODE" 
         + "  AND  RJRSEAR_PIDM = :WJRPWPG_PIDM "
         + "  AND  RJRSEAR_POSN = :WJRPWPG_POSN "
         + "  AND  RJRSEAR_SUFF = :WJRPWPG_SUFF "
         + "  AND :WJRPWPG_PAY_END_DATE BETWEEN "
         + "       RJRSEAR_PAY_START_DATE AND RJRSEAR_PAY_END_DATE  ";
		DataCursor ptiCursor = new DataCursor(sqlptiCursor);
		try {
			// Setting query parameters
			ptiCursor.addParameter("WJRPWPG_AIDY_CODE", wjrpwpgElement.getWjrpwpgAidyCode());			
			ptiCursor.addParameter("WJRPWPG_PIDM", wjrpwpgElement.getWjrpwpgPidm());
			ptiCursor.addParameter("WJRPWPG_POSN", wjrpwpgElement.getWjrpwpgPosn());
			ptiCursor.addParameter("WJRPWPG_SUFF", wjrpwpgElement.getWjrpwpgSuff());
			ptiCursor.addParameter("WJRPWPG_PAY_END_DATE", wjrpwpgElement.getWjrpwpgPayEndDate());			
			ptiCursor.open();
			ResultSet ptiCursorResults = ptiCursor.fetchInto();
			if (ptiCursorResults != null) {
				wjrpwpgElement.setDisplayPlaceCde(ptiCursorResults.getStr(0));
				wjrpwpgElement.setDisplayFundCode(ptiCursorResults.getStr(1));				
			}

		} finally {
			ptiCursor.close();
		}
		
		/*this.getFormModel().getTotal().setTotalAmt(wjrpwpgElement.getWjrpwpgAmt() + this.getFormModel().getTotal().getTotalAmt());*/
		
		NString ptiIntoTemp1 = NString.getNull();
		String sqlptiCursor1 = "SELECT sum(WJRPWPG_HRS), sum(WJRPWPG_AMT) "
         + "FROM  WJRPWPG "
         + "WHERE WJRPWPG_AIDY_CODE = :WJRPWPG_AIDY_CODE" 
         + "  AND  WJRPWPG_PIDM = :WJRPWPG_PIDM ";
		DataCursor ptiCursor1 = new DataCursor(sqlptiCursor1);
		try {
			// Setting query parameters
			ptiCursor1.addParameter("WJRPWPG_AIDY_CODE", wjrpwpgElement.getWjrpwpgAidyCode());			
			ptiCursor1.addParameter("WJRPWPG_PIDM", wjrpwpgElement.getWjrpwpgPidm());
			ptiCursor1.open();
			ResultSet ptiCursorResults = ptiCursor1.fetchInto();
			if (ptiCursorResults != null) {
				this.getFormModel().getTotal().setTotalHrs(ptiCursorResults.getNumber(0));
				this.getFormModel().getTotal().setTotalAmt(ptiCursorResults.getNumber(1));				
			}

		} finally {
			ptiCursor1.close();
		}		
	
	}
	
}