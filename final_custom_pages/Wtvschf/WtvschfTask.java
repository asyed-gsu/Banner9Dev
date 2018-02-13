package net.hedtech.banner.student.gsu.student.Wtvschf;

import java.util.Hashtable;
import net.hedtech.general.common.forms.BaseTask;

public class WtvschfTask extends BaseTask {
	public WtvschfTask(String taskName) {
		super(taskName);
	}
	
	public WtvschfTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.student.gsu.student.Wtvschf.model.WtvschfModel getModel() {
		return (net.hedtech.banner.student.gsu.student.Wtvschf.model.WtvschfModel)super.getModel();
	}
	
	public net.hedtech.banner.student.gsu.student.Wtvschf.services.WtvschfServices getServices() {
		return (net.hedtech.banner.student.gsu.student.Wtvschf.services.WtvschfServices)getSupportCodeManager().getServices();
	}
	
	// Attached Libraries
	
	public net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices getGoqrpls() {
		return (net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices)getSupportCodeManager().getLibrary("GOQRPLS");
	}
}
