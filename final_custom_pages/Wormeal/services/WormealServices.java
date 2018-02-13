package net.hedtech.banner.student.gsu.student.Wormeal.services;

import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import net.hedtech.banner.student.gsu.student.Wormeal.WormealTask;
import net.hedtech.banner.student.gsu.student.Wormeal.model.WormealModel;
import morphis.common.forms.baseForm.services.DefaultSupportCodeObject;

public class WormealServices extends DefaultSupportCodeObject {

	public WormealServices(ISupportCodeContainer container) {
		super(container);
	}

	public WormealTask getTask() {
		return (WormealTask) super.getContainer();
	}

	public WormealModel getFormModel() {
		return getTask().getModel();
	}

	// TODO: put your services here

}