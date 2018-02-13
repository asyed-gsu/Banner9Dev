package net.hedtech.banner.student.gsu.student.Wtvtrtg.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Wtvtrtg.model.WtvtrtgModel;
import net.hedtech.banner.student.gsu.student.Wtvtrtg.WtvtrtgTask;

public class FormHeaderController extends DefaultBlockController {

	public FormHeaderController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WtvtrtgTask getTask() {
		return (WtvtrtgTask) super.getTask();
	}

	public WtvtrtgModel getFormModel() {
		return getTask().getModel();
	}
	
}