package net.hedtech.banner.student.gsu.student.Whawitd.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.banner.student.gsu.student.Whawitd.WhawitdTask;
import net.hedtech.banner.student.gsu.student.Whawitd.model.WhawitdModel;
import net.hedtech.general.common.forms.controller.DefaultBlockController;

public class ButtonControlBlockController extends DefaultBlockController {

	public ButtonControlBlockController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WhawitdTask getTask() {
		return (WhawitdTask) super.getTask();
	}

	public WhawitdModel getFormModel() {
		return getTask().getModel();
	}
	
}