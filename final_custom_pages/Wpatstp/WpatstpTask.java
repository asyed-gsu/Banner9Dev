package net.hedtech.banner.student.gsu.student.Wpatstp;

import java.util.Hashtable;
import net.hedtech.general.common.forms.BaseTask;

public class WpatstpTask extends BaseTask {
	public WpatstpTask(String taskName) {
		super(taskName);
	}
	
	public WpatstpTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.student.gsu.student.Wpatstp.model.WpatstpModel getModel() {
		return (net.hedtech.banner.student.gsu.student.Wpatstp.model.WpatstpModel)super.getModel();
	}
	
	public net.hedtech.banner.student.gsu.student.Wpatstp.services.WpatstpServices getServices() {
		return (net.hedtech.banner.student.gsu.student.Wpatstp.services.WpatstpServices)getSupportCodeManager().getServices();
	}
	
	// Attached Libraries
	
	public net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices getGoqrpls() {
		return (net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices)getSupportCodeManager().getLibrary("GOQRPLS");
	}
}
