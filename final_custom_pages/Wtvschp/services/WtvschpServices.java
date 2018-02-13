package net.hedtech.banner.student.gsu.student.Wtvschp.services;

import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import net.hedtech.banner.student.gsu.student.Wtvschp.WtvschpTask;
import net.hedtech.banner.student.gsu.student.Wtvschp.model.WtvschpModel;
import morphis.common.forms.baseForm.services.DefaultSupportCodeObject;

public class WtvschpServices extends DefaultSupportCodeObject {

	public WtvschpServices(ISupportCodeContainer container) {
		super(container);
	}

	public WtvschpTask getTask() {
		return (WtvschpTask) super.getContainer();
	}

	public WtvschpModel getFormModel() {
		return getTask().getModel();
	}

	// TODO: put your services here

}