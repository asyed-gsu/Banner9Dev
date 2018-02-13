package net.hedtech.banner.student.gsu.student.Whacrep.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Whacrep.WhacrepTask;
import net.hedtech.banner.student.gsu.student.Whacrep.model.WhacrepModel;

public class FormHeaderController extends DefaultBlockController {

	public FormHeaderController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WhacrepTask getTask() {
		return (WhacrepTask) super.getTask();
	}

	public WhacrepModel getFormModel() {
		return getTask().getModel();
	}
	
}