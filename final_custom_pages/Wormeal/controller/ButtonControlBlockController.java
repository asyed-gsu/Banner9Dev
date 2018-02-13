package net.hedtech.banner.student.gsu.student.Wormeal.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.banner.student.gsu.student.Wormeal.WormealTask;
import net.hedtech.banner.student.gsu.student.Wormeal.model.WormealModel;
import net.hedtech.general.common.forms.controller.DefaultBlockController;

public class ButtonControlBlockController extends DefaultBlockController {

	public ButtonControlBlockController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WormealTask getTask() {
		return (WormealTask) super.getTask();
	}

	public WormealModel getFormModel() {
		return getTask().getModel();
	}
	
}