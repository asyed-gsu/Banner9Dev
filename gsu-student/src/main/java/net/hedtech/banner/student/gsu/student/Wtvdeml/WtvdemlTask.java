package net.hedtech.banner.student.gsu.student.Wtvdeml;

import java.util.Hashtable;
import net.hedtech.general.common.forms.BaseTask;

public class WtvdemlTask extends BaseTask {
	public WtvdemlTask(String taskName) {
		super(taskName);
	}
	
	public WtvdemlTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.student.gsu.student.Wtvdeml.model.WtvdemlModel getModel() {
		return (net.hedtech.banner.student.gsu.student.Wtvdeml.model.WtvdemlModel)super.getModel();
	}
	
	public net.hedtech.banner.student.gsu.student.Wtvdeml.services.WtvdemlServices getServices() {
		return (net.hedtech.banner.student.gsu.student.Wtvdeml.services.WtvdemlServices)getSupportCodeManager().getServices();
	}
	
	// Attached Libraries
	
	public net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices getGoqrpls() {
		return (net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices)getSupportCodeManager().getLibrary("GOQRPLS");
	}
}
