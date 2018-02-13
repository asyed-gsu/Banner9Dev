package net.hedtech.banner.student.gsu.student.Wsaopti.services;

import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import morphis.common.forms.baseForm.services.DefaultSupportCodeObject;
import net.hedtech.banner.student.gsu.student.Wsaopti.WsaoptiTask;
import net.hedtech.banner.student.gsu.student.Wsaopti.model.WsaoptiModel;

public class WsaoptiServices extends DefaultSupportCodeObject {

	public WsaoptiServices(ISupportCodeContainer container) {
		super(container);
	}

	public WsaoptiTask getTask() {
		return (WsaoptiTask) super.getContainer();
	}

	public WsaoptiModel getFormModel() {
		return getTask().getModel();
	}

	// TODO: put your services here

}