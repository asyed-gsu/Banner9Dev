package net.hedtech.banner.student.gsu.student.Wtrtrhl;

import java.util.Hashtable;
import net.hedtech.general.common.forms.BaseTask;

public class WtrtrhlTask extends BaseTask {
	public WtrtrhlTask(String taskName) {
		super(taskName);
	}
	
	public WtrtrhlTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.student.gsu.student.Wtrtrhl.model.WtrtrhlModel getModel() {
		return (net.hedtech.banner.student.gsu.student.Wtrtrhl.model.WtrtrhlModel)super.getModel();
	}
	
	public net.hedtech.banner.student.gsu.student.Wtrtrhl.services.WtrtrhlServices getServices() {
		return (net.hedtech.banner.student.gsu.student.Wtrtrhl.services.WtrtrhlServices)getSupportCodeManager().getServices();
	}
	
	// Attached Libraries
	
	public net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices getGoqrpls() {
		return (net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices)getSupportCodeManager().getLibrary("GOQRPLS");
	}
}
