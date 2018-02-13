package net.hedtech.banner.student.gsu.student.Wtvfgrp;

import java.util.Hashtable;
import net.hedtech.general.common.forms.BaseTask;

public class WtvfgrpTask extends BaseTask {
	public WtvfgrpTask(String taskName) {
		super(taskName);
	}
	
	public WtvfgrpTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.student.gsu.student.Wtvfgrp.model.WtvfgrpModel getModel() {
		return (net.hedtech.banner.student.gsu.student.Wtvfgrp.model.WtvfgrpModel)super.getModel();
	}
	
	public net.hedtech.banner.student.gsu.student.Wtvfgrp.services.WtvfgrpServices getServices() {
		return (net.hedtech.banner.student.gsu.student.Wtvfgrp.services.WtvfgrpServices)getSupportCodeManager().getServices();
	}
	
	// Attached Libraries
	
	public net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices getGoqrpls() {
		return (net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices)getSupportCodeManager().getLibrary("GOQRPLS");
	}
}
