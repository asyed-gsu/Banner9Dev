package net.hedtech.banner.student.gsu.student.Wsaopti.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Wsafter.model.WsrfterAdapter;
import net.hedtech.banner.student.gsu.student.Wsaopti.WsaoptiTask;
import net.hedtech.banner.student.gsu.student.Wsaopti.model.WsaoptiModel;
import morphis.foundations.core.appsupportlib.runtime.action.*;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import morphis.foundations.core.types.NString;

import static morphis.foundations.core.types.Types.*;
import morphis.core.utils.behavior.annotations.*;
import morphis.foundations.core.appdatalayer.data.*;
import morphis.foundations.core.appsupportlib.exceptions.ApplicationException;
import morphis.foundations.core.appsupportlib.model.IDBBusinessObject;
import net.hedtech.general.common.dbservices.GNls;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.nextBlock;
import static morphis.foundations.core.appsupportlib.runtime.MessageServices.errorMessage;
import morphis.foundations.core.appsupportlib.Lib;
import morphis.foundations.core.appsupportlib.runtime.*;
import net.hedtech.banner.student.gsu.student.Wsaopti.model.*;
import morphis.foundations.core.appdatalayer.events.BeforeQuery;
import morphis.foundations.core.appdatalayer.events.QueryEvent;
import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;
import morphis.foundations.core.appdatalayer.events.AfterQuery;

public class WsroptiController extends DefaultBlockController {

	public WsroptiController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WsaoptiTask getTask() {
		return (WsaoptiTask) super.getTask();
	}

	public WsaoptiModel getFormModel() {
		return getTask().getModel();
	}

	@After
	@ActionTrigger(action="PRE-BLOCK", function=KeyFunction.BLOCK_IN)
	public void wsropti_blockIn()
	{
		//TODO to be filled by the user
	}

	@BeforeQuery
	public void wsropti_BeforeQuery(QueryEvent args) {
		((IDBBusinessObject)args.getSource()).getSelectCommandParams().add(DbManager.getDataBaseFactory().createDataParameter("TERM",
		this.getFormModel().getKeyBlock().getTermCode()));	
		((IDBBusinessObject)args.getSource()).getSelectCommandParams().add(DbManager.getDataBaseFactory().createDataParameter("PIDM",
		this.getFormModel().getKeyBlock().getPidm()));			
	}

	@AfterQuery
	public void wsropti_AfterQuery(RowAdapterEvent args) {
		WsroptiAdapter wsroptiElement = (WsroptiAdapter) args.getRow();

		NString ptiIntoTemp = NString.getNull();
		String sqlptiCursor = "SELECT WTVFGRP_DESC FROM WTVFGRP "
				+ " WHERE WTVFGRP_CODE = :FGRP_CODE ";
		DataCursor ptiCursor = new DataCursor(sqlptiCursor);
		try {
			// Setting query parameters
			ptiCursor.addParameter("FGRP_CODE", wsroptiElement.getWsroptiFgrpCode());
			ptiCursor.open();
			ResultSet ptiCursorResults = ptiCursor.fetchInto();
			if (ptiCursorResults != null) {
				ptiIntoTemp = ptiCursorResults.getStr(0);
				wsroptiElement.setFgrpDesc(ptiIntoTemp);				
			}

		} finally {
			ptiCursor.close();
		}
	}
	
}