package net.hedtech.banner.student.gsu.student.Wsafter.services;

import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import morphis.common.forms.baseForm.services.DefaultSupportCodeObject;
import net.hedtech.banner.student.gsu.student.Wsafter.WsafterTask;
import net.hedtech.banner.student.gsu.student.Wsafter.model.WsafterModel;

public class WsafterServices extends DefaultSupportCodeObject {

	public WsafterServices(ISupportCodeContainer container) {
		super(container);
	}

	public WsafterTask getTask() {
		return (WsafterTask) super.getContainer();
	}

	public WsafterModel getFormModel() {
		return getTask().getModel();
	}

	// TODO: put your services here

}