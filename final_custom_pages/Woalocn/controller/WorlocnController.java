package net.hedtech.banner.student.gsu.student.Woalocn.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Woalocn.WoalocnTask;
import net.hedtech.banner.student.gsu.student.Woalocn.model.WoalocnModel;
import net.hedtech.banner.student.gsu.student.Woalocn.model.WorlocnAdapter;
import net.hedtech.banner.student.gsu.student.Wtrtrhl.model.WtrtrhlAdapter;
import morphis.foundations.core.appsupportlib.runtime.action.*;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import morphis.foundations.core.types.NBool;
import morphis.foundations.core.types.NDate;
import morphis.foundations.core.types.NString;

import static morphis.foundations.core.appsupportlib.Globals.*;
import static morphis.foundations.core.types.Types.*;
import static morphis.foundations.core.util.globals.Globals.setGlobal;

import morphis.core.utils.behavior.annotations.*;
import morphis.foundations.core.appdatalayer.data.*;
import morphis.foundations.core.appsupportlib.exceptions.ApplicationException;
import morphis.foundations.core.appsupportlib.model.IDBBusinessObject;
import net.hedtech.general.common.dbservices.GNls;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.nextBlock;
import static morphis.foundations.core.appsupportlib.runtime.MessageServices.errorMessage;
import morphis.foundations.core.appsupportlib.Lib;
import morphis.foundations.core.appsupportlib.runtime.*;
import net.hedtech.banner.student.gsu.student.Woalocn.model.*;
import morphis.foundations.core.appdatalayer.events.BeforeQuery;
import morphis.foundations.core.appdatalayer.events.QueryEvent;
import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;
import morphis.foundations.core.appdatalayer.events.BeforeRowInsert;
import morphis.foundations.core.appdatalayer.events.BeforeRowUpdate;
import morphis.foundations.core.appsupportlib.runtime.action.ValidationTrigger;

// added
import static morphis.foundations.core.appsupportlib.runtime.TaskServices.executeQuery;
import static morphis.foundations.core.appsupportlib.runtime.TaskServices.goBlock; 
import static net.hedtech.general.common.forms.services.BaseTaskServices.executeAction;
import morphis.foundations.core.appsupportlib.runtime.action.ActionTrigger;

public class WorlocnController extends DefaultBlockController {

	public WorlocnController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WoalocnTask getTask() {
		return (WoalocnTask) super.getTask();
	}

	public WoalocnModel getFormModel() {
		return getTask().getModel();
	}

	@After
	@ActionTrigger(action="PRE-BLOCK", function=KeyFunction.BLOCK_IN)
	public void worlocn_blockIn()
	{
		//TODO to be filled by the user
	}
	
	// added the following triggers
	
	
	@BeforeQuery
	public void worlocn_BeforeQuery(QueryEvent args) {
		((IDBBusinessObject)args.getSource()).getSelectCommandParams().add(DbManager.getDataBaseFactory().createDataParameter("LOCN",
		this.getFormModel().getKeyBlock().getLocnCode()));
		
	}

	@BeforeRowInsert
	public void worlocn_BeforeRowInsert(RowAdapterEvent args) {
		WorlocnAdapter worlocnElement = (WorlocnAdapter) args.getRow();
		worlocnElement.setWorlocnLocnCode(this.getFormModel().getKeyBlock().getLocnCode());
		worlocnElement.setWorlocnUser(getGlobal("CURRENT_USER"));
		worlocnElement.setWorlocnActivityDate(NDate.getNow());	
		if ( worlocnElement.getWorlocnOfficialInd().isNull() ) {
		   worlocnElement.setWorlocnOfficialInd(toStr("N"));
		}
	}

	@BeforeRowUpdate
	public void worlocn_BeforeRowUpdate(RowAdapterEvent args) {
		WorlocnAdapter worlocnElement = (WorlocnAdapter) args.getRow();
		worlocnElement.setWorlocnUser(getGlobal("CURRENT_USER"));
		worlocnElement.setWorlocnActivityDate(NDate.getNow());
	}

	@ValidationTrigger(item = "WORLOCN_TPRT_CODE")
	public void worlocn_tprt_code_validation() {
		WorlocnAdapter worlocnElement = (WorlocnAdapter)this.getFormModel().getWorlocn().getRowAdapter(true);

		if (worlocnElement != null) {

			int rowCount = 0;
			if (worlocnElement.getWorlocnTprtCode().isNull()) {
				return;
			}
			try {
				getTask().getGoqrpls().gCheckQueryMode();
				//
				if ((getGlobal("QUERY_MODE").equals("1"))) {
					setGlobal("QUERY_MODE", toStr("0"));
				}
				{
					NString ptiIntoTemp = NString.getNull();
					String sqlptiCursor = "SELECT STVTPRT_CODE " + " FROM STVTPRT "
							+ " WHERE STVTPRT_CODE = :WORLOCN_TPRT_CODE ";
					DataCursor ptiCursor = new DataCursor(sqlptiCursor);
					try {
						// Setting query parameters
						ptiCursor.addParameter("WORLOCN_TPRT_CODE", worlocnElement.getWorlocnTprtCode());
						ptiCursor.open();
						ResultSet ptiCursorResults = ptiCursor.fetchInto();
						if (ptiCursorResults != null) {
							ptiIntoTemp = ptiCursorResults.getStr(0);
						}

						getTask().getGoqrpls().gCheckValue(toBool(ptiCursor.notFound()),
								GNls.Fget(toStr("WOALOCN-0001"), toStr("FORM"),
										toStr("*ERROR* Invalid Transcript Code; press LIST for valid codes")),
								toBool(NBool.True));
					} finally {
						ptiCursor.close();
					}
				}

			} catch (ApplicationException e) {
				setGlobal("QUERY_MODE", toStr("0"));
				throw new ApplicationException();
			}
		}
	}

	@ValidationTrigger(item = "WORLOCN_PRNT_CODE")
	public void worlocn_prnt_code_validation() {
		WorlocnAdapter worlocnElement = (WorlocnAdapter)this.getFormModel().getWorlocn().getRowAdapter(true);

		if (worlocnElement != null) {

			int rowCount = 0;
			if (worlocnElement.getWorlocnPrntCode().isNull()) {
				return;
			}
			try {
				getTask().getGoqrpls().gCheckQueryMode();
				//
				if ((getGlobal("QUERY_MODE").equals("1"))) {
					setGlobal("QUERY_MODE", toStr("0"));
				}
				{
					NString ptiIntoTemp = NString.getNull();
					String sqlptiCursor = "SELECT GTVPRNT_CODE " + " FROM GTVPRNT "
							+ " WHERE GTVPRNT_CODE = :WORLOCN_PRNT_CODE ";
					DataCursor ptiCursor = new DataCursor(sqlptiCursor);
					try {
						// Setting query parameters
						ptiCursor.addParameter("WORLOCN_PRNT_CODE", worlocnElement.getWorlocnPrntCode());
						ptiCursor.open();
						ResultSet ptiCursorResults = ptiCursor.fetchInto();
						if (ptiCursorResults != null) {
							ptiIntoTemp = ptiCursorResults.getStr(0);
						}

						getTask().getGoqrpls().gCheckValue(toBool(ptiCursor.notFound()),
								GNls.Fget(toStr("WOALOCN-0002"), toStr("FORM"),
										toStr("*ERROR* Invalid Printer Code; press LIST for valid codes")),
								toBool(NBool.True));
					} finally {
						ptiCursor.close();
					}
				}

			} catch (ApplicationException e) {
				setGlobal("QUERY_MODE", toStr("0"));
				throw new ApplicationException();
			}
		}		
	}

/*	@ActionTrigger(action = "WHEN_NEW_BLOCK_INSTANCE")
	public void worlocn_WhenNewBlockInstance() {
		if ( getFormModel().getButtonControlBlock().getCheckKeys().equals("Y") )
		{
			getFormModel().getButtonControlBlock().setCheckKeys(toStr("N"));
			goBlock(toStr("KEY_BLOCK"));
			executeAction("CHECK_KEYS");
			getTask().getGoqrpls().gCheckFailure();

			nextBlock();
			executeQuery();
			
			executeAction("DISABLE_KEYS");
			getTask().getGoqrpls().gCheckFailure();				
		}		
	}*/
	
}