package net.hedtech.banner.student.gsu.student.Wtvtrtg;

import java.util.Hashtable;
import net.hedtech.general.common.forms.BaseTask;

public class WtvtrtgTask extends BaseTask {
	public WtvtrtgTask(String taskName) {
		super(taskName);
	}
	
	public WtvtrtgTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.student.gsu.student.Wtvtrtg.model.WtvtrtgModel getModel() {
		return (net.hedtech.banner.student.gsu.student.Wtvtrtg.model.WtvtrtgModel)super.getModel();
	}
	
	public net.hedtech.banner.student.gsu.student.Wtvtrtg.services.WtvtrtgServices getServices() {
		return (net.hedtech.banner.student.gsu.student.Wtvtrtg.services.WtvtrtgServices)getSupportCodeManager().getServices();
	}
	
	// Attached Libraries
	
	public net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices getGoqrpls() {
		return (net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices)getSupportCodeManager().getLibrary("GOQRPLS");
	}
}
