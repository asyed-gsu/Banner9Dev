package net.hedtech.banner.student.gsu.student.Wtvdeml.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Wtvdeml.WtvdemlTask;
import net.hedtech.banner.student.gsu.student.Wtvdeml.model.WtvdemlModel;

public class FormHeaderController extends DefaultBlockController {

	public FormHeaderController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WtvdemlTask getTask() {
		return (WtvdemlTask) super.getTask();
	}

	public WtvdemlModel getFormModel() {
		return getTask().getModel();
	}
	
}