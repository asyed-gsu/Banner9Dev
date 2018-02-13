package net.hedtech.banner.student.gsu.student.Wuasrve;

import java.util.Hashtable;
import net.hedtech.general.common.forms.BaseTask;

public class WuasrveTask extends BaseTask {
	public WuasrveTask(String taskName) {
		super(taskName);
	}
	
	public WuasrveTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.student.gsu.student.Wuasrve.model.WuasrveModel getModel() {
		return (net.hedtech.banner.student.gsu.student.Wuasrve.model.WuasrveModel)super.getModel();
	}
	
	public net.hedtech.banner.student.gsu.student.Wuasrve.services.WuasrveServices getServices() {
		return (net.hedtech.banner.student.gsu.student.Wuasrve.services.WuasrveServices)getSupportCodeManager().getServices();
	}
	
	// Attached Libraries
	
	public net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices getGoqrpls() {
		return (net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices)getSupportCodeManager().getLibrary("GOQRPLS");
	}
}
