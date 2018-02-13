package net.hedtech.banner.student.gsu.student.Wsaopti.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Wsaopti.WsaoptiTask;
import net.hedtech.banner.student.gsu.student.Wsaopti.model.WsaoptiModel;

public class ButtonControlBlockController extends DefaultBlockController {

	public ButtonControlBlockController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WsaoptiTask getTask() {
		return (WsaoptiTask) super.getTask();
	}

	public WsaoptiModel getFormModel() {
		return getTask().getModel();
	}
	
}