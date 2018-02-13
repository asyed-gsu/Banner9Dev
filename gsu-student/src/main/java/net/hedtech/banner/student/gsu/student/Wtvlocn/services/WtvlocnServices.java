package net.hedtech.banner.student.gsu.student.Wtvlocn.services;

import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import morphis.common.forms.baseForm.services.DefaultSupportCodeObject;
import net.hedtech.banner.student.gsu.student.Wtvlocn.WtvlocnTask;
import net.hedtech.banner.student.gsu.student.Wtvlocn.model.WtvlocnModel;

public class WtvlocnServices extends DefaultSupportCodeObject {

	public WtvlocnServices(ISupportCodeContainer container) {
		super(container);
	}

	public WtvlocnTask getTask() {
		return (WtvlocnTask) super.getContainer();
	}

	public WtvlocnModel getFormModel() {
		return getTask().getModel();
	}

	// TODO: put your services here

}