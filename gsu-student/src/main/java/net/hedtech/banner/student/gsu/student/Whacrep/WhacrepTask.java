package net.hedtech.banner.student.gsu.student.Whacrep;

import java.util.Hashtable;
import net.hedtech.general.common.forms.BaseTask;

public class WhacrepTask extends BaseTask {
	public WhacrepTask(String taskName) {
		super(taskName);
	}
	
	public WhacrepTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.student.gsu.student.Whacrep.model.WhacrepModel getModel() {
		return (net.hedtech.banner.student.gsu.student.Whacrep.model.WhacrepModel)super.getModel();
	}
	
	public net.hedtech.banner.student.gsu.student.Whacrep.services.WhacrepServices getServices() {
		return (net.hedtech.banner.student.gsu.student.Whacrep.services.WhacrepServices)getSupportCodeManager().getServices();
	}
	
	// Attached Libraries
	
	public net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices getGoqrpls() {
		return (net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices)getSupportCodeManager().getLibrary("GOQRPLS");
	}
}
