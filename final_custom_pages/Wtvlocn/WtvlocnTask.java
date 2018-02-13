package net.hedtech.banner.student.gsu.student.Wtvlocn;

import java.util.Hashtable;
import net.hedtech.general.common.forms.BaseTask;

public class WtvlocnTask extends BaseTask {
	public WtvlocnTask(String taskName) {
		super(taskName);
	}
	
	public WtvlocnTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.student.gsu.student.Wtvlocn.model.WtvlocnModel getModel() {
		return (net.hedtech.banner.student.gsu.student.Wtvlocn.model.WtvlocnModel)super.getModel();
	}
	
	public net.hedtech.banner.student.gsu.student.Wtvlocn.services.WtvlocnServices getServices() {
		return (net.hedtech.banner.student.gsu.student.Wtvlocn.services.WtvlocnServices)getSupportCodeManager().getServices();
	}
	
	// Attached Libraries
	
	public net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices getGoqrpls() {
		return (net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices)getSupportCodeManager().getLibrary("GOQRPLS");
	}
}
