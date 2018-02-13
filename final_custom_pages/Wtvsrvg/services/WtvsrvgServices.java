package net.hedtech.banner.student.gsu.student.Wtvsrvg.services;

import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import net.hedtech.banner.student.gsu.student.Wtvsrvg.WtvsrvgTask;
import net.hedtech.banner.student.gsu.student.Wtvsrvg.model.WtvsrvgModel;
import morphis.common.forms.baseForm.services.DefaultSupportCodeObject;

public class WtvsrvgServices extends DefaultSupportCodeObject {

	public WtvsrvgServices(ISupportCodeContainer container) {
		super(container);
	}

	public WtvsrvgTask getTask() {
		return (WtvsrvgTask) super.getContainer();
	}

	public WtvsrvgModel getFormModel() {
		return getTask().getModel();
	}

	// TODO: put your services here

}