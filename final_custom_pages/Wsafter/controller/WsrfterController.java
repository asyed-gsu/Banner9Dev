package net.hedtech.banner.student.gsu.student.Wsafter.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Woalocn.model.WorlocnAdapter;
import net.hedtech.banner.student.gsu.student.Wsafter.WsafterTask;
import net.hedtech.banner.student.gsu.student.Wsafter.model.WsafterModel;
import morphis.foundations.core.appsupportlib.runtime.action.*;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import morphis.foundations.core.types.NBool;
import morphis.foundations.core.types.NDate;
import morphis.foundations.core.types.NString;

import static morphis.foundations.core.types.Types.*;
import static morphis.foundations.core.util.globals.Globals.setGlobal;

import morphis.core.utils.behavior.annotations.*;
import morphis.foundations.core.appdatalayer.data.*;
import morphis.foundations.core.appdatalayer.events.BeforeQuery;
import morphis.foundations.core.appdatalayer.events.BeforeRowInsert;
import morphis.foundations.core.appdatalayer.events.BeforeRowUpdate;
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
import net.hedtech.banner.student.gsu.student.Wsafter.model.*;
import morphis.foundations.core.appdatalayer.events.AfterQuery;

public class WsrfterController extends DefaultBlockController {

	public WsrfterController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WsafterTask getTask() {
		return (WsafterTask) super.getTask();
	}

	public WsafterModel getFormModel() {
		return getTask().getModel();
	}

	@After
	@ActionTrigger(action="PRE-BLOCK", function=KeyFunction.BLOCK_IN)
	public void wsrfter_blockIn()
	{
		//TODO to be filled by the user
	}

	@BeforeQuery
	public void wsrfter_BeforeQuery(QueryEvent args) {
		((IDBBusinessObject)args.getSource()).getSelectCommandParams().add(DbManager.getDataBaseFactory().createDataParameter("TERM",
		this.getFormModel().getKeyBlock().getTermCode()));
		
	}

	@BeforeRowInsert
	public void wsrfter_BeforeRowInsert(RowAdapterEvent args) {
		WsrfterAdapter wsrfterElement = (WsrfterAdapter) args.getRow();
	/*	wsrfterElement.setWsrfterTermCode(this.getFormModel().getKeyBlock().getTermCode());*/
		wsrfterElement.setWsrfterUserId(getGlobal("CURRENT_USER"));
		wsrfterElement.setWsrfterActivityDate(NDate.getNow());	
	}

	@BeforeRowUpdate
	public void wsrfter_BeforeRowUpdate(RowAdapterEvent args) {
		WsrfterAdapter wsrfterElement = (WsrfterAdapter) args.getRow();
		wsrfterElement.setWsrfterUserId(getGlobal("CURRENT_USER"));
		wsrfterElement.setWsrfterActivityDate(NDate.getNow());
	}

	@ValidationTrigger(item = "WSRFTER_FGRP_CODE")
	public void wsrfter_fgrp_code_validation() {
		WsrfterAdapter wsrfterElement = (WsrfterAdapter)this.getFormModel().getWsrfter().getRowAdapter(true);

		if (wsrfterElement != null) {

			int rowCount = 0;
			if (wsrfterElement.getWsrfterFgrpCode().isNull()) {
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
					String sqlptiCursor = "SELECT WTVFGRP_DESC FROM WTVFGRP "
							+ " WHERE WTVFGRP_CODE = :WSRFTER_FGRP_CODE ";
					DataCursor ptiCursor = new DataCursor(sqlptiCursor);
					try {
						// Setting query parameters
						ptiCursor.addParameter("WSRFTER_FGRP_CODE", wsrfterElement.getWsrfterFgrpCode());
						ptiCursor.open();
						ResultSet ptiCursorResults = ptiCursor.fetchInto();
						if (ptiCursorResults != null) {
							ptiIntoTemp = ptiCursorResults.getStr(0);
							wsrfterElement.setFgrpDesc(ptiIntoTemp);									
						}

						getTask().getGoqrpls().gCheckValue(toBool(ptiCursor.notFound()),
								GNls.Fget(toStr("WSAFTER-0001"), toStr("FORM"),
										toStr("*ERROR* Invalid Group Code; press LIST for valid codes")),
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

	
	@ValidationTrigger(item = "WSRFTER_LEVL_CODE")
	public void wsrfter_levl_code_validation() {
		WsrfterAdapter wsrfterElement = (WsrfterAdapter)this.getFormModel().getWsrfter().getRowAdapter(true);

		if (wsrfterElement != null) {

			int rowCount = 0;
			if (wsrfterElement.getWsrfterFgrpCode().isNull()) {
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
					String sqlptiCursor = "SELECT STVLEVL_CODE FROM STVLEVL "
							+ " WHERE STVLEVL_CODE = :WSRFTER_LEVL_CODE ";
					DataCursor ptiCursor = new DataCursor(sqlptiCursor);
					try {
						// Setting query parameters
						ptiCursor.addParameter("WSRFTER_LEVL_CODE", wsrfterElement.getWsrfterLevlCode());
						ptiCursor.open();
						ResultSet ptiCursorResults = ptiCursor.fetchInto();
						if (ptiCursorResults != null) {
							ptiIntoTemp = ptiCursorResults.getStr(0);
						}

						getTask().getGoqrpls().gCheckValue(toBool(ptiCursor.notFound()),
								GNls.Fget(toStr("WSAFTER-0002"), toStr("FORM"),
										toStr("*ERROR* Invalid Levl Code; press LIST for valid codes")),
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

	@AfterQuery
	public void wsrfter_AfterQuery(RowAdapterEvent args) {
		WsrfterAdapter wsrfterElement = (WsrfterAdapter) args.getRow();

		NString ptiIntoTemp = NString.getNull();
		String sqlptiCursor = "SELECT WTVFGRP_DESC FROM WTVFGRP "
				+ " WHERE WTVFGRP_CODE = :FGRP_CODE ";
		DataCursor ptiCursor = new DataCursor(sqlptiCursor);
		try {
			// Setting query parameters
			ptiCursor.addParameter("FGRP_CODE", wsrfterElement.getWsrfterFgrpCode());
			ptiCursor.open();
			ResultSet ptiCursorResults = ptiCursor.fetchInto();
			if (ptiCursorResults != null) {
				ptiIntoTemp = ptiCursorResults.getStr(0);
				wsrfterElement.setFgrpDesc(ptiIntoTemp);				
			}

		} finally {
			ptiCursor.close();
		}
		
	}
	
}