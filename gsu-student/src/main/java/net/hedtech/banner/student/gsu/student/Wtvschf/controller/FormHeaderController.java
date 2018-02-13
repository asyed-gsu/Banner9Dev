package net.hedtech.banner.student.gsu.student.Wtvschf.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.banner.student.gsu.student.Wtvschf.WtvschfTask;
import net.hedtech.banner.student.gsu.student.Wtvschf.model.WtvschfModel;
import net.hedtech.general.common.forms.controller.DefaultBlockController;

public class FormHeaderController extends DefaultBlockController {

	public FormHeaderController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WtvschfTask getTask() {
		return (WtvschfTask) super.getTask();
	}

	public WtvschfModel getFormModel() {
		return getTask().getModel();
	}
	
}