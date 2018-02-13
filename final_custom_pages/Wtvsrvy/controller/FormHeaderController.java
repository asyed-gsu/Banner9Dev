package net.hedtech.banner.student.gsu.student.Wtvsrvy.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.banner.student.gsu.student.Wtvsrvy.WtvsrvyTask;
import net.hedtech.banner.student.gsu.student.Wtvsrvy.model.WtvsrvyModel;
import net.hedtech.general.common.forms.controller.DefaultBlockController;

public class FormHeaderController extends DefaultBlockController {

	public FormHeaderController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WtvsrvyTask getTask() {
		return (WtvsrvyTask) super.getTask();
	}

	public WtvsrvyModel getFormModel() {
		return getTask().getModel();
	}
	
}