package net.hedtech.banner.student.gsu.student.Woawdpr;

import java.util.Hashtable;
import net.hedtech.general.common.forms.BaseTask;

public class WoawdprTask extends BaseTask {
	public WoawdprTask(String taskName) {
		super(taskName);
	}
	
	public WoawdprTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.student.gsu.student.Woawdpr.model.WoawdprModel getModel() {
		return (net.hedtech.banner.student.gsu.student.Woawdpr.model.WoawdprModel)super.getModel();
	}
	
	public net.hedtech.banner.student.gsu.student.Woawdpr.services.WoawdprServices getServices() {
		return (net.hedtech.banner.student.gsu.student.Woawdpr.services.WoawdprServices)getSupportCodeManager().getServices();
	}
	
	// Attached Libraries
	
	public net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices getGoqrpls() {
		return (net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices)getSupportCodeManager().getLibrary("GOQRPLS");
	}
}
