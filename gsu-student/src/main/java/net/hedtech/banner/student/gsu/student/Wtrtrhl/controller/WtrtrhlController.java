package net.hedtech.banner.student.gsu.student.Wtrtrhl.controller;

import morphis.foundations.core.appsupportlib.exceptions.ApplicationException;
import morphis.foundations.core.appsupportlib.runtime.action.ValidationTrigger;
import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import morphis.foundations.core.types.NBool;
import morphis.foundations.core.types.NDate;
import morphis.foundations.core.types.NString;
import net.hedtech.general.common.dbservices.GNls;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Wtrtrhl.WtrtrhlTask;
import net.hedtech.banner.student.gsu.student.Wtrtrhl.model.WtrtrhlAdapter;
import net.hedtech.banner.student.gsu.student.Wtrtrhl.model.WtrtrhlModel;
import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;
import morphis.foundations.core.appdatalayer.events.BeforeRowUpdate;
import static morphis.foundations.core.appsupportlib.Globals.*;
import static morphis.foundations.core.types.Types.toBool;
import static morphis.foundations.core.types.Types.toStr;
import static morphis.foundations.core.util.globals.Globals.setGlobal;

import morphis.foundations.core.appdatalayer.data.DataCursor;
import morphis.foundations.core.appdatalayer.data.ResultSet;
import morphis.foundations.core.appdatalayer.events.BeforeRowInsert;

public class WtrtrhlController extends DefaultBlockController {

	public WtrtrhlController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WtrtrhlTask getTask() {
		return (WtrtrhlTask) super.getTask();
	}

	public WtrtrhlModel getFormModel() {
		return getTask().getModel();
	}

	@BeforeRowUpdate
	public void wtrtrhl_BeforeRowUpdate(RowAdapterEvent args) {
		WtrtrhlAdapter wtrtrhlElement = (WtrtrhlAdapter) args.getRow();
		wtrtrhlElement.setWtrtrhlUser(getGlobal("CURRENT_USER"));
		wtrtrhlElement.setWtrtrhlActivityDate(NDate.getNow());
	}

	@BeforeRowInsert
	public void wtrtrhl_BeforeRowInsert(RowAdapterEvent args) {
		WtrtrhlAdapter wtrtrhlElement = (WtrtrhlAdapter) args.getRow();
		wtrtrhlElement.setWtrtrhlCreateUser(getGlobal("CURRENT_USER"));
		wtrtrhlElement.setWtrtrhlCreateDate(NDate.getNow());		
		wtrtrhlElement.setWtrtrhlUser(getGlobal("CURRENT_USER"));		
		wtrtrhlElement.setWtrtrhlActivityDate(NDate.getNow());
	}

	@ValidationTrigger(item = "WTRTRHL_TRTG_CODE")
	public void wtrtrhl_trtg_code_validation() {

			WtrtrhlAdapter wtrtrhlElement = (WtrtrhlAdapter)this.getFormModel().getWtrtrhl().getRowAdapter(true);

		if (wtrtrhlElement != null) {

			int rowCount = 0;
			if (wtrtrhlElement.getWtrtrhlTrtgCode().isNull()) {
				return;
			}
			try {
				getTask().getGoqrpls().gCheckQueryMode();
				//
				if ((getGlobal("QUERY_MODE").equals("1"))) {
					// goto PTI_END_TRIGGER;
					// PTI_END_TRIGGER:;
					setGlobal("QUERY_MODE", toStr("0"));
				}
				{
					NString ptiIntoTemp = NString.getNull();
					String sqlptiCursor = "SELECT WTVTRTG_CODE " + " FROM WTVTRTG "
							+ " WHERE WTVTRTG_CODE = :WTRTRHL_TRTG_CODE ";
					DataCursor ptiCursor = new DataCursor(sqlptiCursor);
					try {
						// Setting query parameters
						ptiCursor.addParameter("WTRTRHL_TRTG_CODE", wtrtrhlElement.getWtrtrhlTrtgCode());
						ptiCursor.open();
						ResultSet ptiCursorResults = ptiCursor.fetchInto();
						if (ptiCursorResults != null) {
							ptiIntoTemp = ptiCursorResults.getStr(0);
						}

						getTask().getGoqrpls().gCheckValue(toBool(ptiCursor.notFound()),
								GNls.Fget(toStr("WTRTRHL-0001"), toStr("FORM"),
										toStr("*ERROR* Invalid TRTG Code; press LIST for valid codes")),
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