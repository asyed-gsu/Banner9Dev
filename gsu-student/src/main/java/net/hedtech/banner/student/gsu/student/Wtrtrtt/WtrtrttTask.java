package net.hedtech.banner.student.gsu.student.Wtrtrtt;

import java.util.Hashtable;
import net.hedtech.general.common.forms.BaseTask;

public class WtrtrttTask extends BaseTask {
	public WtrtrttTask(String taskName) {
		super(taskName);
	}
	
	public WtrtrttTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.student.gsu.student.Wtrtrtt.model.WtrtrttModel getModel() {
		return (net.hedtech.banner.student.gsu.student.Wtrtrtt.model.WtrtrttModel)super.getModel();
	}
	
	public net.hedtech.banner.student.gsu.student.Wtrtrtt.services.WtrtrttServices getServices() {
		return (net.hedtech.banner.student.gsu.student.Wtrtrtt.services.WtrtrttServices)getSupportCodeManager().getServices();
	}
	
	// Attached Libraries
	
	public net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices getGoqrpls() {
		return (net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices)getSupportCodeManager().getLibrary("GOQRPLS");
	}
}
