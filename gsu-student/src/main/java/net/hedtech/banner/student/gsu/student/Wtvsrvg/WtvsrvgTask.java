package net.hedtech.banner.student.gsu.student.Wtvsrvg;

import java.util.Hashtable;
import net.hedtech.general.common.forms.BaseTask;

public class WtvsrvgTask extends BaseTask {
	public WtvsrvgTask(String taskName) {
		super(taskName);
	}
	
	public WtvsrvgTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.student.gsu.student.Wtvsrvg.model.WtvsrvgModel getModel() {
		return (net.hedtech.banner.student.gsu.student.Wtvsrvg.model.WtvsrvgModel)super.getModel();
	}
	
	public net.hedtech.banner.student.gsu.student.Wtvsrvg.services.WtvsrvgServices getServices() {
		return (net.hedtech.banner.student.gsu.student.Wtvsrvg.services.WtvsrvgServices)getSupportCodeManager().getServices();
	}
	
	// Attached Libraries
	
	public net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices getGoqrpls() {
		return (net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices)getSupportCodeManager().getLibrary("GOQRPLS");
	}
}
