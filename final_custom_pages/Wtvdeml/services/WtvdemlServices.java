package net.hedtech.banner.student.gsu.student.Wtvdeml.services;

import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import morphis.common.forms.baseForm.services.DefaultSupportCodeObject;
import net.hedtech.banner.student.gsu.student.Wtvdeml.WtvdemlTask;
import net.hedtech.banner.student.gsu.student.Wtvdeml.model.WtvdemlModel;

public class WtvdemlServices extends DefaultSupportCodeObject {

	public WtvdemlServices(ISupportCodeContainer container) {
		super(container);
	}

	public WtvdemlTask getTask() {
		return (WtvdemlTask) super.getContainer();
	}

	public WtvdemlModel getFormModel() {
		return getTask().getModel();
	}

	// TODO: put your services here

}