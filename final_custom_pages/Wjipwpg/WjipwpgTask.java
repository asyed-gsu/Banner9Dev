package net.hedtech.banner.student.gsu.student.Wjipwpg;

import java.util.Hashtable;
import net.hedtech.general.common.forms.BaseTask;

public class WjipwpgTask extends BaseTask {
	public WjipwpgTask(String taskName) {
		super(taskName);
	}
	
	public WjipwpgTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.student.gsu.student.Wjipwpg.model.WjipwpgModel getModel() {
		return (net.hedtech.banner.student.gsu.student.Wjipwpg.model.WjipwpgModel)super.getModel();
	}
	
	public net.hedtech.banner.student.gsu.student.Wjipwpg.services.WjipwpgServices getServices() {
		return (net.hedtech.banner.student.gsu.student.Wjipwpg.services.WjipwpgServices)getSupportCodeManager().getServices();
	}
	
	// Attached Libraries
	
	public net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices getGoqrpls() {
		return (net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices)getSupportCodeManager().getLibrary("GOQRPLS");
	}
}
