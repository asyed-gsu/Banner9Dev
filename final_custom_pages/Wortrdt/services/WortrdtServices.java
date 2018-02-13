package net.hedtech.banner.student.gsu.student.Wortrdt.services;

import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import net.hedtech.banner.student.gsu.student.Wortrdt.WortrdtTask;
import net.hedtech.banner.student.gsu.student.Wortrdt.model.WortrdtModel;
import morphis.common.forms.baseForm.services.DefaultSupportCodeObject;

public class WortrdtServices extends DefaultSupportCodeObject {

	public WortrdtServices(ISupportCodeContainer container) {
		super(container);
	}

	public WortrdtTask getTask() {
		return (WortrdtTask) super.getContainer();
	}

	public WortrdtModel getFormModel() {
		return getTask().getModel();
	}

	// TODO: put your services here

}