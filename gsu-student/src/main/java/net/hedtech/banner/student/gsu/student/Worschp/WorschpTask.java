package net.hedtech.banner.student.gsu.student.Worschp;

import java.util.Hashtable;
import net.hedtech.general.common.forms.BaseTask;

public class WorschpTask extends BaseTask {
	public WorschpTask(String taskName) {
		super(taskName);
	}
	
	public WorschpTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.student.gsu.student.Worschp.model.WorschpModel getModel() {
		return (net.hedtech.banner.student.gsu.student.Worschp.model.WorschpModel)super.getModel();
	}
	
	public net.hedtech.banner.student.gsu.student.Worschp.services.WorschpServices getServices() {
		return (net.hedtech.banner.student.gsu.student.Worschp.services.WorschpServices)getSupportCodeManager().getServices();
	}
	
	// Attached Libraries
	
	public net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices getGoqrpls() {
		return (net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices)getSupportCodeManager().getLibrary("GOQRPLS");
	}
}
