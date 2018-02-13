package net.hedtech.banner.student.gsu.student.Worapts.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Worapts.WoraptsTask;
import net.hedtech.banner.student.gsu.student.Worapts.model.WoraptsModel;

public class WoraptsController extends DefaultBlockController {

	public WoraptsController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WoraptsTask getTask() {
		return (WoraptsTask) super.getTask();
	}

	public WoraptsModel getFormModel() {
		return getTask().getModel();
	}
	
}