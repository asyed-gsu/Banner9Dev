package net.hedtech.banner.student.gsu.student.Wtvlocn.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import morphis.foundations.core.types.NDate;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Wtvlocn.WtvlocnTask;
import net.hedtech.banner.student.gsu.student.Wtvlocn.model.WtvlocnAdapter;
import net.hedtech.banner.student.gsu.student.Wtvlocn.model.WtvlocnModel;
import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;
import morphis.foundations.core.appdatalayer.events.BeforeRowUpdate;

import static morphis.foundations.core.appsupportlib.Globals.*;
import morphis.foundations.core.appdatalayer.events.BeforeRowInsert;

public class WtvlocnController extends DefaultBlockController {

	public WtvlocnController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WtvlocnTask getTask() {
		return (WtvlocnTask) super.getTask();
	}

	public WtvlocnModel getFormModel() {
		return getTask().getModel();
	}

	@BeforeRowUpdate
	public void wtvlocn_BeforeRowUpdate(RowAdapterEvent args) {
		WtvlocnAdapter wtvlocnElement = (WtvlocnAdapter) args.getRow();
		wtvlocnElement.setWtvlocnUserId(getGlobal("CURRENT_USER"));
		wtvlocnElement.setWtvlocnActivityDate(NDate.getNow());
	}

	@BeforeRowInsert
	public void wtvlocn_BeforeRowInsert(RowAdapterEvent args) {
		WtvlocnAdapter wtvlocnElement = (WtvlocnAdapter) args.getRow();
		wtvlocnElement.setWtvlocnUserId(getGlobal("CURRENT_USER"));
		wtvlocnElement.setWtvlocnActivityDate(NDate.getNow());
	}
	
}