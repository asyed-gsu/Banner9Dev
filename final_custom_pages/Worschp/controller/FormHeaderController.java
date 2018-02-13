package net.hedtech.banner.student.gsu.student.Worschp.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.banner.student.gsu.student.Worschp.WorschpTask;
import net.hedtech.banner.student.gsu.student.Worschp.model.WorschpModel;
import net.hedtech.general.common.forms.controller.DefaultBlockController;

public class FormHeaderController extends DefaultBlockController {

	public FormHeaderController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WorschpTask getTask() {
		return (WorschpTask) super.getTask();
	}

	public WorschpModel getFormModel() {
		return getTask().getModel();
	}
	
}