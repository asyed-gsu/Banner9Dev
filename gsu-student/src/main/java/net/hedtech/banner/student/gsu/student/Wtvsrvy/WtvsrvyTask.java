package net.hedtech.banner.student.gsu.student.Wtvsrvy;

import java.util.Hashtable;
import net.hedtech.general.common.forms.BaseTask;

public class WtvsrvyTask extends BaseTask {
	public WtvsrvyTask(String taskName) {
		super(taskName);
	}
	
	public WtvsrvyTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.student.gsu.student.Wtvsrvy.model.WtvsrvyModel getModel() {
		return (net.hedtech.banner.student.gsu.student.Wtvsrvy.model.WtvsrvyModel)super.getModel();
	}
	
	public net.hedtech.banner.student.gsu.student.Wtvsrvy.services.WtvsrvyServices getServices() {
		return (net.hedtech.banner.student.gsu.student.Wtvsrvy.services.WtvsrvyServices)getSupportCodeManager().getServices();
	}
	
	// Attached Libraries
	
	public net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices getGoqrpls() {
		return (net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices)getSupportCodeManager().getLibrary("GOQRPLS");
	}
}
