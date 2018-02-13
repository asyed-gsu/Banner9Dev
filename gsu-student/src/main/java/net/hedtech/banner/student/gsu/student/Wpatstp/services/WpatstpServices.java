package net.hedtech.banner.student.gsu.student.Wpatstp.services;

import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import net.hedtech.banner.student.gsu.student.Wpatstp.WpatstpTask;
import net.hedtech.banner.student.gsu.student.Wpatstp.model.WpatstpModel;
import morphis.common.forms.baseForm.services.DefaultSupportCodeObject;

public class WpatstpServices extends DefaultSupportCodeObject {

	public WpatstpServices(ISupportCodeContainer container) {
		super(container);
	}

	public WpatstpTask getTask() {
		return (WpatstpTask) super.getContainer();
	}

	public WpatstpModel getFormModel() {
		return getTask().getModel();
	}

	// TODO: put your services here

}