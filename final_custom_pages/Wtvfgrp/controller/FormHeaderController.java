package net.hedtech.banner.student.gsu.student.Wtvfgrp.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Wtvfgrp.WtvfgrpTask;
import net.hedtech.banner.student.gsu.student.Wtvfgrp.model.WtvfgrpModel;

public class FormHeaderController extends DefaultBlockController {

	public FormHeaderController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WtvfgrpTask getTask() {
		return (WtvfgrpTask) super.getTask();
	}

	public WtvfgrpModel getFormModel() {
		return getTask().getModel();
	}
	
}