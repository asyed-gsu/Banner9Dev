package net.hedtech.banner.student.gsu.student.Wormeal;

import java.util.Hashtable;
import net.hedtech.general.common.forms.BaseTask;

public class WormealTask extends BaseTask {
	public WormealTask(String taskName) {
		super(taskName);
	}
	
	public WormealTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.student.gsu.student.Wormeal.model.WormealModel getModel() {
		return (net.hedtech.banner.student.gsu.student.Wormeal.model.WormealModel)super.getModel();
	}
	
	public net.hedtech.banner.student.gsu.student.Wormeal.services.WormealServices getServices() {
		return (net.hedtech.banner.student.gsu.student.Wormeal.services.WormealServices)getSupportCodeManager().getServices();
	}
	
	// Attached Libraries
	
	public net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices getGoqrpls() {
		return (net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices)getSupportCodeManager().getLibrary("GOQRPLS");
	}
}
