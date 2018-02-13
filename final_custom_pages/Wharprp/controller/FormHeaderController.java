package net.hedtech.banner.student.gsu.student.Wharprp.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Wharprp.WharprpTask;
import net.hedtech.banner.student.gsu.student.Wharprp.model.WharprpModel;

public class FormHeaderController extends DefaultBlockController {

	public FormHeaderController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WharprpTask getTask() {
		return (WharprpTask) super.getTask();
	}

	public WharprpModel getFormModel() {
		return getTask().getModel();
	}
	
}