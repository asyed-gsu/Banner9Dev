package net.hedtech.banner.student.gsu.student.Woawdpr.services;

import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import net.hedtech.banner.student.gsu.student.Woawdpr.WoawdprTask;
import net.hedtech.banner.student.gsu.student.Woawdpr.model.WoawdprModel;
import morphis.common.forms.baseForm.services.DefaultSupportCodeObject;

public class WoawdprServices extends DefaultSupportCodeObject {

	public WoawdprServices(ISupportCodeContainer container) {
		super(container);
	}

	public WoawdprTask getTask() {
		return (WoawdprTask) super.getContainer();
	}

	public WoawdprModel getFormModel() {
		return getTask().getModel();
	}

	// TODO: put your services here

}