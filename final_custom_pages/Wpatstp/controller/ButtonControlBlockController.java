package net.hedtech.banner.student.gsu.student.Wpatstp.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.banner.student.gsu.student.Wpatstp.WpatstpTask;
import net.hedtech.banner.student.gsu.student.Wpatstp.model.WpatstpModel;
import net.hedtech.general.common.forms.controller.DefaultBlockController;

public class ButtonControlBlockController extends DefaultBlockController {

	public ButtonControlBlockController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WpatstpTask getTask() {
		return (WpatstpTask) super.getTask();
	}

	public WpatstpModel getFormModel() {
		return getTask().getModel();
	}
	
}