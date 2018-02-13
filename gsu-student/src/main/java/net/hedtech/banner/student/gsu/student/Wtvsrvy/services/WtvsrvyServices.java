package net.hedtech.banner.student.gsu.student.Wtvsrvy.services;

import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import net.hedtech.banner.student.gsu.student.Wtvsrvy.WtvsrvyTask;
import net.hedtech.banner.student.gsu.student.Wtvsrvy.model.WtvsrvyModel;
import morphis.common.forms.baseForm.services.DefaultSupportCodeObject;

public class WtvsrvyServices extends DefaultSupportCodeObject {

	public WtvsrvyServices(ISupportCodeContainer container) {
		super(container);
	}

	public WtvsrvyTask getTask() {
		return (WtvsrvyTask) super.getContainer();
	}

	public WtvsrvyModel getFormModel() {
		return getTask().getModel();
	}

	// TODO: put your services here

}