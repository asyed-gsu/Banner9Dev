package net.hedtech.banner.student.gsu.student.Whacrep.services;

import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import morphis.common.forms.baseForm.services.DefaultSupportCodeObject;
import net.hedtech.banner.student.gsu.student.Whacrep.WhacrepTask;
import net.hedtech.banner.student.gsu.student.Whacrep.model.WhacrepModel;

public class WhacrepServices extends DefaultSupportCodeObject {

	public WhacrepServices(ISupportCodeContainer container) {
		super(container);
	}

	public WhacrepTask getTask() {
		return (WhacrepTask) super.getContainer();
	}

	public WhacrepModel getFormModel() {
		return getTask().getModel();
	}

	// TODO: put your services here

}