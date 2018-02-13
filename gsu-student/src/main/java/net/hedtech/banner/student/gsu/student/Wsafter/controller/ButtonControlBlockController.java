package net.hedtech.banner.student.gsu.student.Wsafter.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Wsafter.WsafterTask;
import net.hedtech.banner.student.gsu.student.Wsafter.model.WsafterModel;

public class ButtonControlBlockController extends DefaultBlockController {

	public ButtonControlBlockController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WsafterTask getTask() {
		return (WsafterTask) super.getTask();
	}

	public WsafterModel getFormModel() {
		return getTask().getModel();
	}
	
}