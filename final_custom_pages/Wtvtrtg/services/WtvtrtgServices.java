package net.hedtech.banner.student.gsu.student.Wtvtrtg.services;

import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import morphis.common.forms.baseForm.services.DefaultSupportCodeObject;
import net.hedtech.banner.student.gsu.student.Wtvtrtg.model.WtvtrtgModel;
import net.hedtech.banner.student.gsu.student.Wtvtrtg.WtvtrtgTask;

public class WtvtrtgServices extends DefaultSupportCodeObject {

	public WtvtrtgServices(ISupportCodeContainer container) {
		super(container);
	}

	public WtvtrtgTask getTask() {
		return (WtvtrtgTask) super.getContainer();
	}

	public WtvtrtgModel getFormModel() {
		return getTask().getModel();
	}

	// TODO: put your services here

}