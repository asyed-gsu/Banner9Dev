package net.hedtech.banner.student.gsu.student.Wcascmt.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.banner.student.gsu.student.Wcascmt.WcascmtTask;
import net.hedtech.banner.student.gsu.student.Wcascmt.model.WcascmtModel;
import net.hedtech.general.common.forms.controller.DefaultBlockController;

public class FormHeaderController extends DefaultBlockController {

	public FormHeaderController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WcascmtTask getTask() {
		return (WcascmtTask) super.getTask();
	}

	public WcascmtModel getFormModel() {
		return getTask().getModel();
	}
	
}