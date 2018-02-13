package net.hedtech.banner.student.gsu.student.Wortrdt;

import java.util.Hashtable;
import net.hedtech.general.common.forms.BaseTask;

public class WortrdtTask extends BaseTask {
	public WortrdtTask(String taskName) {
		super(taskName);
	}
	
	public WortrdtTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.student.gsu.student.Wortrdt.model.WortrdtModel getModel() {
		return (net.hedtech.banner.student.gsu.student.Wortrdt.model.WortrdtModel)super.getModel();
	}
	
	public net.hedtech.banner.student.gsu.student.Wortrdt.services.WortrdtServices getServices() {
		return (net.hedtech.banner.student.gsu.student.Wortrdt.services.WortrdtServices)getSupportCodeManager().getServices();
	}
	
	// Attached Libraries
	
	public net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices getGoqrpls() {
		return (net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices)getSupportCodeManager().getLibrary("GOQRPLS");
	}
	
	public net.hedtech.general.common.libraries.Soqrpls.SoqrplsServices getSoqrpls() {
		return (net.hedtech.general.common.libraries.Soqrpls.SoqrplsServices)getSupportCodeManager().getLibrary("SOQRPLS");
	}
}
