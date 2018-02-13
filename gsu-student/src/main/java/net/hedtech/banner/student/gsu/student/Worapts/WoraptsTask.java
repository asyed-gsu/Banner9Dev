package net.hedtech.banner.student.gsu.student.Worapts;

import java.util.Hashtable;
import net.hedtech.general.common.forms.BaseTask;

public class WoraptsTask extends BaseTask {
	public WoraptsTask(String taskName) {
		super(taskName);
	}
	
	public WoraptsTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.student.gsu.student.Worapts.model.WoraptsModel getModel() {
		return (net.hedtech.banner.student.gsu.student.Worapts.model.WoraptsModel)super.getModel();
	}
	
	public net.hedtech.banner.student.gsu.student.Worapts.services.WoraptsServices getServices() {
		return (net.hedtech.banner.student.gsu.student.Worapts.services.WoraptsServices)getSupportCodeManager().getServices();
	}
	
	// Attached Libraries
	
	public net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices getGoqrpls() {
		return (net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices)getSupportCodeManager().getLibrary("GOQRPLS");
	}
}
