package net.hedtech.banner.student.gsu.student.Wortrdt.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.banner.student.gsu.student.Wortrdt.WortrdtTask;
import net.hedtech.banner.student.gsu.student.Wortrdt.model.WortrdtModel;
import net.hedtech.general.common.forms.controller.DefaultBlockController;

public class ButtonControlBlockController extends DefaultBlockController {

	public ButtonControlBlockController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WortrdtTask getTask() {
		return (WortrdtTask) super.getTask();
	}

	public WortrdtModel getFormModel() {
		return getTask().getModel();
	}
	
}