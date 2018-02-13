package net.hedtech.banner.student.gsu.student.Wsaopti;

import java.util.Hashtable;
import net.hedtech.general.common.forms.BaseTask;

public class WsaoptiTask extends BaseTask {
	public WsaoptiTask(String taskName) {
		super(taskName);
	}
	
	public WsaoptiTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.student.gsu.student.Wsaopti.model.WsaoptiModel getModel() {
		return (net.hedtech.banner.student.gsu.student.Wsaopti.model.WsaoptiModel)super.getModel();
	}
	
	public net.hedtech.banner.student.gsu.student.Wsaopti.services.WsaoptiServices getServices() {
		return (net.hedtech.banner.student.gsu.student.Wsaopti.services.WsaoptiServices)getSupportCodeManager().getServices();
	}
	
	// Attached Libraries
	
	public net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices getGoqrpls() {
		return (net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices)getSupportCodeManager().getLibrary("GOQRPLS");
	}
}
