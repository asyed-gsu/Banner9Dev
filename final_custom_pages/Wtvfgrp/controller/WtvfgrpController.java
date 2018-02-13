package net.hedtech.banner.student.gsu.student.Wtvfgrp.controller;

import static morphis.foundations.core.appsupportlib.Globals.getGlobal;
import static morphis.foundations.core.types.Types.toBool;
import static morphis.foundations.core.types.Types.toStr;
import static morphis.foundations.core.util.globals.Globals.setGlobal;

import morphis.foundations.core.appdatalayer.data.DataCursor;
import morphis.foundations.core.appdatalayer.data.ResultSet;
import morphis.foundations.core.appdatalayer.events.BeforeRowInsert;
import morphis.foundations.core.appdatalayer.events.BeforeRowUpdate;
import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;
import morphis.foundations.core.appsupportlib.exceptions.ApplicationException;
import morphis.foundations.core.appsupportlib.runtime.action.ValidationTrigger;
import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import morphis.foundations.core.types.NBool;
import morphis.foundations.core.types.NDate;
import morphis.foundations.core.types.NString;
import net.hedtech.general.common.dbservices.GNls;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Woalocn.model.WorlocnAdapter;
import net.hedtech.banner.student.gsu.student.Wtvfgrp.WtvfgrpTask;
import net.hedtech.banner.student.gsu.student.Wtvfgrp.model.WtvfgrpModel;
import net.hedtech.banner.student.gsu.student.Wtvfgrp.model.WtvfgrpAdapter;

public class WtvfgrpController extends DefaultBlockController {

	public WtvfgrpController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WtvfgrpTask getTask() {
		return (WtvfgrpTask) super.getTask();
	}

	public WtvfgrpModel getFormModel() {
		return getTask().getModel();
	}
	
	@BeforeRowUpdate
	public void wtvlocn_BeforeRowUpdate(RowAdapterEvent args) {
		WtvfgrpAdapter wtvfgrpElement = (WtvfgrpAdapter) args.getRow();
		wtvfgrpElement.setWtvfgrpUserId(getGlobal("CURRENT_USER"));
		wtvfgrpElement.setWtvfgrpActivityDate(NDate.getNow());
	}

	@BeforeRowInsert
	public void wtvlocn_BeforeRowInsert(RowAdapterEvent args) {
		WtvfgrpAdapter wtvfgrpElement = (WtvfgrpAdapter) args.getRow();
		wtvfgrpElement.setWtvfgrpUserId(getGlobal("CURRENT_USER"));
		wtvfgrpElement.setWtvfgrpActivityDate(NDate.getNow());
	}	

	@ValidationTrigger(item = "WTVFGRP_LEVL_CODE")
	public void wtvfgrp_levl_code_validation() {
		WtvfgrpAdapter wtvfgrpElement = (WtvfgrpAdapter)this.getFormModel().getWtvfgrp().getRowAdapter(true);

		if (wtvfgrpElement != null) {

			int rowCount = 0;
			if (wtvfgrpElement.getWtvfgrpLevlCode().isNull()) {
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
					String sqlptiCursor = "SELECT STVLEVL_CODE " + " FROM STVLEVL "
							+ " WHERE STVLEVL_CODE = :WTVFGRP_LEVL_CODE ";
					DataCursor ptiCursor = new DataCursor(sqlptiCursor);
					try {
						// Setting query parameters
						ptiCursor.addParameter("WTVFGRP_LEVL_CODE", wtvfgrpElement.getWtvfgrpLevlCode());
						ptiCursor.open();
						ResultSet ptiCursorResults = ptiCursor.fetchInto();
						if (ptiCursorResults != null) {
							ptiIntoTemp = ptiCursorResults.getStr(0);
						}

						getTask().getGoqrpls().gCheckValue(toBool(ptiCursor.notFound()),
								GNls.Fget(toStr("WTVFGRP-0001"), toStr("FORM"),
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
	
}