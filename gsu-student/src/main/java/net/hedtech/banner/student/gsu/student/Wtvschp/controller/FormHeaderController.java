package net.hedtech.banner.student.gsu.student.Wtvschp.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.banner.student.gsu.student.Wtvschp.WtvschpTask;
import net.hedtech.banner.student.gsu.student.Wtvschp.model.WtvschpModel;
import net.hedtech.general.common.forms.controller.DefaultBlockController;

public class FormHeaderController extends DefaultBlockController {

	public FormHeaderController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WtvschpTask getTask() {
		return (WtvschpTask) super.getTask();
	}

	public WtvschpModel getFormModel() {
		return getTask().getModel();
	}
	
}