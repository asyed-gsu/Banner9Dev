package net.hedtech.banner.student.gsu.student.Woawdpr.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.banner.student.gsu.student.Woawdpr.WoawdprTask;
import net.hedtech.banner.student.gsu.student.Woawdpr.model.WoawdprModel;
import net.hedtech.general.common.forms.controller.DefaultBlockController;

public class ButtonControlBlockController extends DefaultBlockController {

	public ButtonControlBlockController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WoawdprTask getTask() {
		return (WoawdprTask) super.getTask();
	}

	public WoawdprModel getFormModel() {
		return getTask().getModel();
	}
	
}