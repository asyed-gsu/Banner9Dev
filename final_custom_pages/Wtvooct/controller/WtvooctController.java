package net.hedtech.banner.student.gsu.student.Wtvooct.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import morphis.foundations.core.types.NDate;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Wtvooct.WtvooctTask;
import net.hedtech.banner.student.gsu.student.Wtvooct.model.WtvooctModel;
import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;
import morphis.foundations.core.appdatalayer.events.BeforeRowInsert;
import morphis.foundations.core.appdatalayer.events.BeforeRowUpdate;

import static morphis.foundations.core.appsupportlib.Globals.*;
import net.hedtech.banner.student.gsu.student.Wtvooct.controller.WtvooctController;
import net.hedtech.banner.student.gsu.student.Wtvooct.model.WtvooctAdapter;

public class WtvooctController extends DefaultBlockController {

	public WtvooctController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WtvooctTask getTask() {
		return (WtvooctTask) super.getTask();
	}

	public WtvooctModel getFormModel() {
		return getTask().getModel();
	}

	@BeforeRowInsert
	public void wtvooct_BeforeRowInsert(RowAdapterEvent args) {
		WtvooctAdapter wtvooctElement = (WtvooctAdapter) args.getRow();
		
		wtvooctElement.setWtvooctUserId(getGlobal("CURRENT_USER"));
		wtvooctElement.setWtvooctActivityDate(NDate.getNow());
	}

	@BeforeRowUpdate
	public void wtvooct_BeforeRowUpdate(RowAdapterEvent args) {
        WtvooctAdapter wtvooctElement = (WtvooctAdapter) args.getRow();
		
		wtvooctElement.setWtvooctUserId(getGlobal("CURRENT_USER"));
		wtvooctElement.setWtvooctActivityDate(NDate.getNow());
		
	}
	
}