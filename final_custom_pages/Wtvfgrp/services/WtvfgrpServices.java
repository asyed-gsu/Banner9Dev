package net.hedtech.banner.student.gsu.student.Wtvfgrp.services;

import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import morphis.common.forms.baseForm.services.DefaultSupportCodeObject;
import net.hedtech.banner.student.gsu.student.Wtvfgrp.WtvfgrpTask;
import net.hedtech.banner.student.gsu.student.Wtvfgrp.model.WtvfgrpModel;

public class WtvfgrpServices extends DefaultSupportCodeObject {

	public WtvfgrpServices(ISupportCodeContainer container) {
		super(container);
	}

	public WtvfgrpTask getTask() {
		return (WtvfgrpTask) super.getContainer();
	}

	public WtvfgrpModel getFormModel() {
		return getTask().getModel();
	}

	// TODO: put your services here

}