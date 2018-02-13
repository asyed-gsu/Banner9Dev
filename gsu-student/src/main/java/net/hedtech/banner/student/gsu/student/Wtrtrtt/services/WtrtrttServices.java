package net.hedtech.banner.student.gsu.student.Wtrtrtt.services;

import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import morphis.common.forms.baseForm.services.DefaultSupportCodeObject;
import net.hedtech.banner.student.gsu.student.Wtrtrtt.WtrtrttTask;
import net.hedtech.banner.student.gsu.student.Wtrtrtt.model.WtrtrttModel;

public class WtrtrttServices extends DefaultSupportCodeObject {

	public WtrtrttServices(ISupportCodeContainer container) {
		super(container);
	}

	public WtrtrttTask getTask() {
		return (WtrtrttTask) super.getContainer();
	}

	public WtrtrttModel getFormModel() {
		return getTask().getModel();
	}

	// TODO: put your services here

}