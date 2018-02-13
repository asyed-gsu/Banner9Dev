package net.hedtech.banner.student.gsu.student.Worsfrm.services;

import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import net.hedtech.banner.student.gsu.student.Worsfrm.WorsfrmTask;
import net.hedtech.banner.student.gsu.student.Worsfrm.model.WorsfrmModel;
import morphis.common.forms.baseForm.services.DefaultSupportCodeObject;

public class WorsfrmServices extends DefaultSupportCodeObject {

	public WorsfrmServices(ISupportCodeContainer container) {
		super(container);
	}

	public WorsfrmTask getTask() {
		return (WorsfrmTask) super.getContainer();
	}

	public WorsfrmModel getFormModel() {
		return getTask().getModel();
	}

	// TODO: put your services here

}