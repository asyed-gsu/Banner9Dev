package net.hedtech.banner.student.gsu.student.Wganadv.services;

import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import morphis.common.forms.baseForm.services.DefaultSupportCodeObject;
import net.hedtech.banner.student.gsu.student.Wganadv.WganadvTask;
import net.hedtech.banner.student.gsu.student.Wganadv.model.WganadvModel;

public class WganadvServices extends DefaultSupportCodeObject {

	public WganadvServices(ISupportCodeContainer container) {
		super(container);
	}

	public WganadvTask getTask() {
		return (WganadvTask) super.getContainer();
	}

	public WganadvModel getFormModel() {
		return getTask().getModel();
	}

	// TODO: put your services here

}