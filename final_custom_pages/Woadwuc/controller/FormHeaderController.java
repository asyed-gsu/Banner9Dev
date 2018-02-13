package net.hedtech.banner.student.gsu.student.Woadwuc.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Woadwuc.WoadwucTask;
import net.hedtech.banner.student.gsu.student.Woadwuc.model.WoadwucModel;

public class FormHeaderController extends DefaultBlockController {

	public FormHeaderController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WoadwucTask getTask() {
		return (WoadwucTask) super.getTask();
	}

	public WoadwucModel getFormModel() {
		return getTask().getModel();
	}
	
}