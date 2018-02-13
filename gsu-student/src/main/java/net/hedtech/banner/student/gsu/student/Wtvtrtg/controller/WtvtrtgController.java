package net.hedtech.banner.student.gsu.student.Wtvtrtg.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import morphis.foundations.core.types.NDate;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Wtvtrtg.model.WtvtrtgAdapter;
import net.hedtech.banner.student.gsu.student.Wtvtrtg.model.WtvtrtgModel;
import net.hedtech.banner.student.gsu.student.Wtvtrtg.WtvtrtgTask;
import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;
import morphis.foundations.core.appdatalayer.events.BeforeRowInsert;
import morphis.foundations.core.appdatalayer.events.BeforeRowUpdate;
import static morphis.foundations.core.types.Types.*;
import static morphis.foundations.core.appsupportlib.Globals.*;

public class WtvtrtgController extends DefaultBlockController {

	public WtvtrtgController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WtvtrtgTask getTask() {
		return (WtvtrtgTask) super.getTask();
	}

	public WtvtrtgModel getFormModel() {
		return getTask().getModel();
	}

	@BeforeRowInsert
	public void wtvtrtg_BeforeRowInsert(RowAdapterEvent args) {
		WtvtrtgAdapter WtvtrtgElement = (WtvtrtgAdapter)args.getRow();
		WtvtrtgElement.setWtvtrtgCreateUser(getGlobal("CURRENT_USER"));
		WtvtrtgElement.setWtvtrtgCreateDate(NDate.getNow());
		//WtvtrtgElement.setWtvtrtgUser(toStr("CURRENT_USER"));
		WtvtrtgElement.setWtvtrtgUser(getGlobal("CURRENT_USER"));
		WtvtrtgElement.setWtvtrtgActivityDate(NDate.getNow());
		WtvtrtgElement.setWtvtrtgDataOrigin(toStr("WTVTRTG"));
	}

	@BeforeRowUpdate
	public void wtvtrtg_BeforeRowUpdate(RowAdapterEvent args) {
		WtvtrtgAdapter WtvtrtgElement = (WtvtrtgAdapter)args.getRow();
		WtvtrtgElement.setWtvtrtgUser(getGlobal("CURRENT_USER"));
		WtvtrtgElement.setWtvtrtgActivityDate(NDate.getNow());
	}
	
}