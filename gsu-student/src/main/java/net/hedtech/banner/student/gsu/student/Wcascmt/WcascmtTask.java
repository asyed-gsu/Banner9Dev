package net.hedtech.banner.student.gsu.student.Wcascmt;

import java.util.Hashtable;
import net.hedtech.general.common.forms.BaseTask;

public class WcascmtTask extends BaseTask {
	public WcascmtTask(String taskName) {
		super(taskName);
	}
	
	public WcascmtTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.student.gsu.student.Wcascmt.model.WcascmtModel getModel() {
		return (net.hedtech.banner.student.gsu.student.Wcascmt.model.WcascmtModel)super.getModel();
	}
	
	public net.hedtech.banner.student.gsu.student.Wcascmt.services.WcascmtServices getServices() {
		return (net.hedtech.banner.student.gsu.student.Wcascmt.services.WcascmtServices)getSupportCodeManager().getServices();
	}
	
	// Attached Libraries
	
	public net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices getGoqrpls() {
		return (net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices)getSupportCodeManager().getLibrary("GOQRPLS");
	}
}
