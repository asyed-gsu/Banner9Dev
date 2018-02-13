package net.hedtech.banner.student.gsu.student.Woalocn.services;

import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import morphis.common.forms.baseForm.services.DefaultSupportCodeObject;
import net.hedtech.banner.student.gsu.student.Woalocn.WoalocnTask;
import net.hedtech.banner.student.gsu.student.Woalocn.model.WoalocnModel;

public class WoalocnServices extends DefaultSupportCodeObject {

	public WoalocnServices(ISupportCodeContainer container) {
		super(container);
	}

	public WoalocnTask getTask() {
		return (WoalocnTask) super.getContainer();
	}

	public WoalocnModel getFormModel() {
		return getTask().getModel();
	}

	// TODO: put your services here

}