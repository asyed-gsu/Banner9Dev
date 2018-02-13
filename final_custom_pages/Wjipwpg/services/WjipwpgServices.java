package net.hedtech.banner.student.gsu.student.Wjipwpg.services;

import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import morphis.common.forms.baseForm.services.DefaultSupportCodeObject;
import net.hedtech.banner.student.gsu.student.Wjipwpg.WjipwpgTask;
import net.hedtech.banner.student.gsu.student.Wjipwpg.model.WjipwpgModel;

public class WjipwpgServices extends DefaultSupportCodeObject {

	public WjipwpgServices(ISupportCodeContainer container) {
		super(container);
	}

	public WjipwpgTask getTask() {
		return (WjipwpgTask) super.getContainer();
	}

	public WjipwpgModel getFormModel() {
		return getTask().getModel();
	}

	// TODO: put your services here

}