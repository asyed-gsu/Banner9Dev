package net.hedtech.banner.student.gsu.student.Wtvsrvg.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.banner.student.gsu.student.Wtvsrvg.WtvsrvgTask;
import net.hedtech.banner.student.gsu.student.Wtvsrvg.model.WtvsrvgModel;
import net.hedtech.general.common.forms.controller.DefaultBlockController;

public class FormHeaderController extends DefaultBlockController {

	public FormHeaderController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WtvsrvgTask getTask() {
		return (WtvsrvgTask) super.getTask();
	}

	public WtvsrvgModel getFormModel() {
		return getTask().getModel();
	}
	
}