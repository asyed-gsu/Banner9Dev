package net.hedtech.banner.student.gsu.student.Wganadv;

import java.util.Hashtable;
import net.hedtech.general.common.forms.BaseTask;

public class WganadvTask extends BaseTask {
	public WganadvTask(String taskName) {
		super(taskName);
	}
	
	public WganadvTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.student.gsu.student.Wganadv.model.WganadvModel getModel() {
		return (net.hedtech.banner.student.gsu.student.Wganadv.model.WganadvModel)super.getModel();
	}
	
	public net.hedtech.banner.student.gsu.student.Wganadv.services.WganadvServices getServices() {
		return (net.hedtech.banner.student.gsu.student.Wganadv.services.WganadvServices)getSupportCodeManager().getServices();
	}
	
	// Attached Libraries
	
	public net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices getGoqrpls() {
		return (net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices)getSupportCodeManager().getLibrary("GOQRPLS");
	}
}
