package net.hedtech.banner.student.gsu.student.Wtrtrhl.services;

import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import morphis.common.forms.baseForm.services.DefaultSupportCodeObject;
import net.hedtech.banner.student.gsu.student.Wtrtrhl.WtrtrhlTask;
import net.hedtech.banner.student.gsu.student.Wtrtrhl.model.WtrtrhlModel;

public class WtrtrhlServices extends DefaultSupportCodeObject {

	public WtrtrhlServices(ISupportCodeContainer container) {
		super(container);
	}

	public WtrtrhlTask getTask() {
		return (WtrtrhlTask) super.getContainer();
	}

	public WtrtrhlModel getFormModel() {
		return getTask().getModel();
	}

	// TODO: put your services here

}