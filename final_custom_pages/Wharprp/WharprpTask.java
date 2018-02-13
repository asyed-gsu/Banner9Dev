package net.hedtech.banner.student.gsu.student.Wharprp;

import java.util.Hashtable;

import net.hedtech.banner.student.gsu.student.Wharprp.services.WharprpServices;
import net.hedtech.general.common.forms.BaseTask;

public class WharprpTask extends BaseTask {
	public WharprpTask(String taskName) {
		super(taskName);
	}
	
	public WharprpTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.student.gsu.student.Wharprp.model.WharprpModel getModel() {
		return (net.hedtech.banner.student.gsu.student.Wharprp.model.WharprpModel)super.getModel();
	}
	
	public net.hedtech.banner.student.gsu.student.Wharprp.services.WharprpServices getServices() {
		return (WharprpServices)getSupportCodeManager().getServices();
	}
	
	// Attached Libraries
	
	public net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices getGoqrpls() {
		return (net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices)getSupportCodeManager().getLibrary("GOQRPLS");
	}
}
