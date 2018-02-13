package net.hedtech.banner.student.gsu.student.Worapts.services;

import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import morphis.common.forms.baseForm.services.DefaultSupportCodeObject;
import net.hedtech.banner.student.gsu.student.Worapts.WoraptsTask;
import net.hedtech.banner.student.gsu.student.Worapts.model.WoraptsModel;

public class WoraptsServices extends DefaultSupportCodeObject {

	public WoraptsServices(ISupportCodeContainer container) {
		super(container);
	}

	public WoraptsTask getTask() {
		return (WoraptsTask) super.getContainer();
	}

	public WoraptsModel getFormModel() {
		return getTask().getModel();
	}

	// TODO: put your services here

}