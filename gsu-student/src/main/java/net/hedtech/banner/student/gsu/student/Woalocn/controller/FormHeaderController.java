package net.hedtech.banner.student.gsu.student.Woalocn.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Woalocn.WoalocnTask;
import net.hedtech.banner.student.gsu.student.Woalocn.model.WoalocnModel;

public class FormHeaderController extends DefaultBlockController {

	public FormHeaderController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WoalocnTask getTask() {
		return (WoalocnTask) super.getTask();
	}

	public WoalocnModel getFormModel() {
		return getTask().getModel();
	}
	
}