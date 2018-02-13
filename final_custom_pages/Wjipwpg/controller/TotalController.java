package net.hedtech.banner.student.gsu.student.Wjipwpg.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Wjipwpg.WjipwpgTask;
import net.hedtech.banner.student.gsu.student.Wjipwpg.model.WjipwpgModel;

public class TotalController extends DefaultBlockController {

	public TotalController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WjipwpgTask getTask() {
		return (WjipwpgTask) super.getTask();
	}

	public WjipwpgModel getFormModel() {
		return getTask().getModel();
	}
	
}