package net.hedtech.banner.student.gsu.student.Wcascmt.services;

import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import net.hedtech.banner.student.gsu.student.Wcascmt.WcascmtTask;
import net.hedtech.banner.student.gsu.student.Wcascmt.model.WcascmtModel;
import morphis.common.forms.baseForm.services.DefaultSupportCodeObject;

public class WcascmtServices extends DefaultSupportCodeObject {

	public WcascmtServices(ISupportCodeContainer container) {
		super(container);
	}

	public WcascmtTask getTask() {
		return (WcascmtTask) super.getContainer();
	}

	public WcascmtModel getFormModel() {
		return getTask().getModel();
	}

	// TODO: put your services here

}