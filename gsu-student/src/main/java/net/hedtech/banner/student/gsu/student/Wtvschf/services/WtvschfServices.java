package net.hedtech.banner.student.gsu.student.Wtvschf.services;

import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import net.hedtech.banner.student.gsu.student.Wtvschf.WtvschfTask;
import net.hedtech.banner.student.gsu.student.Wtvschf.model.WtvschfModel;
import morphis.common.forms.baseForm.services.DefaultSupportCodeObject;

public class WtvschfServices extends DefaultSupportCodeObject {

	public WtvschfServices(ISupportCodeContainer container) {
		super(container);
	}

	public WtvschfTask getTask() {
		return (WtvschfTask) super.getContainer();
	}

	public WtvschfModel getFormModel() {
		return getTask().getModel();
	}

	// TODO: put your services here

}