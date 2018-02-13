package net.hedtech.banner.student.gsu.student.Wtvooct.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Wtvooct.WtvooctTask;
import net.hedtech.banner.student.gsu.student.Wtvooct.model.WtvooctModel;

public class FormHeaderController extends DefaultBlockController {

	public FormHeaderController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WtvooctTask getTask() {
		return (WtvooctTask) super.getTask();
	}

	public WtvooctModel getFormModel() {
		return getTask().getModel();
	}
	
}