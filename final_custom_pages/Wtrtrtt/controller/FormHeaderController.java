package net.hedtech.banner.student.gsu.student.Wtrtrtt.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Wtrtrtt.WtrtrttTask;
import net.hedtech.banner.student.gsu.student.Wtrtrtt.model.WtrtrttModel;

public class FormHeaderController extends DefaultBlockController {

	public FormHeaderController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WtrtrttTask getTask() {
		return (WtrtrttTask) super.getTask();
	}

	public WtrtrttModel getFormModel() {
		return getTask().getModel();
	}
	
}