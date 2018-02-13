package net.hedtech.banner.student.gsu.student.Worschp.services;

import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import net.hedtech.banner.student.gsu.student.Worschp.WorschpTask;
import net.hedtech.banner.student.gsu.student.Worschp.model.WorschpModel;
import morphis.common.forms.baseForm.services.DefaultSupportCodeObject;

public class WorschpServices extends DefaultSupportCodeObject {

	public WorschpServices(ISupportCodeContainer container) {
		super(container);
	}

	public WorschpTask getTask() {
		return (WorschpTask) super.getContainer();
	}

	public WorschpModel getFormModel() {
		return getTask().getModel();
	}

	// TODO: put your services here

}