package net.hedtech.banner.student.gsu.student.Worsfrm;

import java.util.Hashtable;
import net.hedtech.general.common.forms.BaseTask;

public class WorsfrmTask extends BaseTask {
	public WorsfrmTask(String taskName) {
		super(taskName);
	}
	
	public WorsfrmTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.student.gsu.student.Worsfrm.model.WorsfrmModel getModel() {
		return (net.hedtech.banner.student.gsu.student.Worsfrm.model.WorsfrmModel)super.getModel();
	}
	
	public net.hedtech.banner.student.gsu.student.Worsfrm.services.WorsfrmServices getServices() {
		return (net.hedtech.banner.student.gsu.student.Worsfrm.services.WorsfrmServices)getSupportCodeManager().getServices();
	}
	
	// Attached Libraries
	
	public net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices getGoqrpls() {
		return (net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices)getSupportCodeManager().getLibrary("GOQRPLS");
	}
}
