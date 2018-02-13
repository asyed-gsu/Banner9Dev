package net.hedtech.banner.student.gsu.student.Woadwuc.services;

import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import morphis.common.forms.baseForm.services.DefaultSupportCodeObject;
import net.hedtech.banner.student.gsu.student.Woadwuc.WoadwucTask;
import net.hedtech.banner.student.gsu.student.Woadwuc.model.WoadwucModel;

public class WoadwucServices extends DefaultSupportCodeObject {

	public WoadwucServices(ISupportCodeContainer container) {
		super(container);
	}

	public WoadwucTask getTask() {
		return (WoadwucTask) super.getContainer();
	}

	public WoadwucModel getFormModel() {
		return getTask().getModel();
	}

	// TODO: put your services here

}