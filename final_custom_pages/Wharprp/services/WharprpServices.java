package net.hedtech.banner.student.gsu.student.Wharprp.services;

import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import morphis.common.forms.baseForm.services.DefaultSupportCodeObject;
import net.hedtech.banner.student.gsu.student.Wharprp.WharprpTask;
import net.hedtech.banner.student.gsu.student.Wharprp.model.WharprpModel;

public class WharprpServices extends DefaultSupportCodeObject {

	public WharprpServices(ISupportCodeContainer container) {
		super(container);
	}

	public WharprpTask getTask() {
		return (WharprpTask) super.getContainer();
	}

	public WharprpModel getFormModel() {
		return getTask().getModel();
	}

	// TODO: put your services here

}