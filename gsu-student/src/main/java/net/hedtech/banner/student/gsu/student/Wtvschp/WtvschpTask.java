package net.hedtech.banner.student.gsu.student.Wtvschp;

import java.util.Hashtable;
import net.hedtech.general.common.forms.BaseTask;

public class WtvschpTask extends BaseTask {
	public WtvschpTask(String taskName) {
		super(taskName);
	}
	
	public WtvschpTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.student.gsu.student.Wtvschp.model.WtvschpModel getModel() {
		return (net.hedtech.banner.student.gsu.student.Wtvschp.model.WtvschpModel)super.getModel();
	}
	
	public net.hedtech.banner.student.gsu.student.Wtvschp.services.WtvschpServices getServices() {
		return (net.hedtech.banner.student.gsu.student.Wtvschp.services.WtvschpServices)getSupportCodeManager().getServices();
	}
	
	// Attached Libraries
	
	public net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices getGoqrpls() {
		return (net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices)getSupportCodeManager().getLibrary("GOQRPLS");
	}
}
