package net.hedtech.banner.student.gsu.student.Wuasrve.services;

import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import morphis.common.forms.baseForm.services.DefaultSupportCodeObject;
import net.hedtech.banner.student.gsu.student.Wuasrve.WuasrveTask;
import net.hedtech.banner.student.gsu.student.Wuasrve.model.WuasrveModel;

public class WuasrveServices extends DefaultSupportCodeObject {

	public WuasrveServices(ISupportCodeContainer container) {
		super(container);
	}

	public WuasrveTask getTask() {
		return (WuasrveTask) super.getContainer();
	}

	public WuasrveModel getFormModel() {
		return getTask().getModel();
	}

	// TODO: put your services here

}