package net.hedtech.banner.student.gsu.student.Whawitd;

import java.util.Hashtable;
import net.hedtech.general.common.forms.BaseTask;

public class WhawitdTask extends BaseTask {
	public WhawitdTask(String taskName) {
		super(taskName);
	}
	
	public WhawitdTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.student.gsu.student.Whawitd.model.WhawitdModel getModel() {
		return (net.hedtech.banner.student.gsu.student.Whawitd.model.WhawitdModel)super.getModel();
	}
	
	public net.hedtech.banner.student.gsu.student.Whawitd.services.WhawitdServices getServices() {
		return (net.hedtech.banner.student.gsu.student.Whawitd.services.WhawitdServices)getSupportCodeManager().getServices();
	}
	
	// Attached Libraries
	
	public net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices getGoqrpls() {
		return (net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices)getSupportCodeManager().getLibrary("GOQRPLS");
	}
}
