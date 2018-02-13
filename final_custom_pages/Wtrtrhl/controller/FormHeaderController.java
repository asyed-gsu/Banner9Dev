package net.hedtech.banner.student.gsu.student.Wtrtrhl.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Wtrtrhl.WtrtrhlTask;
import net.hedtech.banner.student.gsu.student.Wtrtrhl.model.WtrtrhlModel;

public class FormHeaderController extends DefaultBlockController {

	public FormHeaderController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WtrtrhlTask getTask() {
		return (WtrtrhlTask) super.getTask();
	}

	public WtrtrhlModel getFormModel() {
		return getTask().getModel();
	}
	
}