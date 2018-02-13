package net.hedtech.banner.student.gsu.student.Woadwuc;

import java.util.Hashtable;
import net.hedtech.general.common.forms.BaseTask;

public class WoadwucTask extends BaseTask {
	public WoadwucTask(String taskName) {
		super(taskName);
	}
	
	public WoadwucTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.student.gsu.student.Woadwuc.model.WoadwucModel getModel() {
		return (net.hedtech.banner.student.gsu.student.Woadwuc.model.WoadwucModel)super.getModel();
	}
	
	public net.hedtech.banner.student.gsu.student.Woadwuc.services.WoadwucServices getServices() {
		return (net.hedtech.banner.student.gsu.student.Woadwuc.services.WoadwucServices)getSupportCodeManager().getServices();
	}
	
	// Attached Libraries
	
	public net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices getGoqrpls() {
		return (net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices)getSupportCodeManager().getLibrary("GOQRPLS");
	}
}
