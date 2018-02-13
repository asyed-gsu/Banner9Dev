package net.hedtech.banner.student.gsu.student.Woalocn;

import java.util.Hashtable;
import net.hedtech.general.common.forms.BaseTask;

public class WoalocnTask extends BaseTask {
	public WoalocnTask(String taskName) {
		super(taskName);
	}
	
	public WoalocnTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.student.gsu.student.Woalocn.model.WoalocnModel getModel() {
		return (net.hedtech.banner.student.gsu.student.Woalocn.model.WoalocnModel)super.getModel();
	}
	
	public net.hedtech.banner.student.gsu.student.Woalocn.services.WoalocnServices getServices() {
		return (net.hedtech.banner.student.gsu.student.Woalocn.services.WoalocnServices)getSupportCodeManager().getServices();
	}
	
	// Attached Libraries
	
	public net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices getGoqrpls() {
		return (net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices)getSupportCodeManager().getLibrary("GOQRPLS");
	}
}
