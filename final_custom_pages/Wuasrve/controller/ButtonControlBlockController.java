package net.hedtech.banner.student.gsu.student.Wuasrve.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Wuasrve.WuasrveTask;
import net.hedtech.banner.student.gsu.student.Wuasrve.model.WuasrveModel;

public class ButtonControlBlockController extends DefaultBlockController {

	public ButtonControlBlockController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WuasrveTask getTask() {
		return (WuasrveTask) super.getTask();
	}

	public WuasrveModel getFormModel() {
		return getTask().getModel();
	}
	
}