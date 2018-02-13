package net.hedtech.banner.student.gsu.student.Wtvooct.services;

import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import morphis.common.forms.baseForm.services.DefaultSupportCodeObject;
import net.hedtech.banner.student.gsu.student.Wtvooct.WtvooctTask;
import net.hedtech.banner.student.gsu.student.Wtvooct.model.WtvooctModel;

public class WtvooctServices extends DefaultSupportCodeObject {

	public WtvooctServices(ISupportCodeContainer container) {
		super(container);
	}

	public WtvooctTask getTask() {
		return (WtvooctTask) super.getContainer();
	}

	public WtvooctModel getFormModel() {
		return getTask().getModel();
	}

	// TODO: put your services here

}