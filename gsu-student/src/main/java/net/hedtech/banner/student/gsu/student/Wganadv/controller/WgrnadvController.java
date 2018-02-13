package net.hedtech.banner.student.gsu.student.Wganadv.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Wganadv.WganadvTask;
import net.hedtech.banner.student.gsu.student.Wganadv.model.WganadvModel;


public class WgrnadvController extends DefaultBlockController {

	public WgrnadvController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WganadvTask getTask() {
		return (WganadvTask) super.getTask();
	}

	public WganadvModel getFormModel() {
		return getTask().getModel();
	}
	
}