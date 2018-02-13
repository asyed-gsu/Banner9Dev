package net.hedtech.banner.student.gsu.student.Wsafter;

import java.util.Hashtable;
import net.hedtech.general.common.forms.BaseTask;

public class WsafterTask extends BaseTask {
	public WsafterTask(String taskName) {
		super(taskName);
	}
	
	public WsafterTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.student.gsu.student.Wsafter.model.WsafterModel getModel() {
		return (net.hedtech.banner.student.gsu.student.Wsafter.model.WsafterModel)super.getModel();
	}
	
	public net.hedtech.banner.student.gsu.student.Wsafter.services.WsafterServices getServices() {
		return (net.hedtech.banner.student.gsu.student.Wsafter.services.WsafterServices)getSupportCodeManager().getServices();
	}
	
	// Attached Libraries
	
	public net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices getGoqrpls() {
		return (net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices)getSupportCodeManager().getLibrary("GOQRPLS");
	}
}
