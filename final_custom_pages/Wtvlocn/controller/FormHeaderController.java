package net.hedtech.banner.student.gsu.student.Wtvlocn.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Wtvlocn.WtvlocnTask;
import net.hedtech.banner.student.gsu.student.Wtvlocn.model.WtvlocnModel;

public class FormHeaderController extends DefaultBlockController {

	public FormHeaderController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WtvlocnTask getTask() {
		return (WtvlocnTask) super.getTask();
	}

	public WtvlocnModel getFormModel() {
		return getTask().getModel();
	}
	
}