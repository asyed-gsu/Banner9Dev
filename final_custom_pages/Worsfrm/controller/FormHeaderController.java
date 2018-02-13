package net.hedtech.banner.student.gsu.student.Worsfrm.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.banner.student.gsu.student.Worsfrm.WorsfrmTask;
import net.hedtech.banner.student.gsu.student.Worsfrm.model.WorsfrmModel;
import net.hedtech.general.common.forms.controller.DefaultBlockController;

public class FormHeaderController extends DefaultBlockController {

	public FormHeaderController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WorsfrmTask getTask() {
		return (WorsfrmTask) super.getTask();
	}

	public WorsfrmModel getFormModel() {
		return getTask().getModel();
	}
	
}