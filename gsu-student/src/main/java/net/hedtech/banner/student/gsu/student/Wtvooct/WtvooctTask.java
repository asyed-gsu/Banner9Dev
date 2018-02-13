package net.hedtech.banner.student.gsu.student.Wtvooct;

import java.util.Hashtable;
import net.hedtech.general.common.forms.BaseTask;

public class WtvooctTask extends BaseTask {
	public WtvooctTask(String taskName) {
		super(taskName);
	}
	
	public WtvooctTask(String taskName, Hashtable sharedLibraries, Hashtable parameters) {
		super(taskName, sharedLibraries, parameters);
	}
	
	@Override
	public net.hedtech.banner.student.gsu.student.Wtvooct.model.WtvooctModel getModel() {
		return (net.hedtech.banner.student.gsu.student.Wtvooct.model.WtvooctModel)super.getModel();
	}
	
	public net.hedtech.banner.student.gsu.student.Wtvooct.services.WtvooctServices getServices() {
		return (net.hedtech.banner.student.gsu.student.Wtvooct.services.WtvooctServices)getSupportCodeManager().getServices();
	}
	
	// Package Accessors
	
	public net.hedtech.general.common.libraries.Goqolib.controller.GNavBlockController getGNavBlock() {
		return (net.hedtech.general.common.libraries.Goqolib.controller.GNavBlockController)getSupportCodeManager().getPackage("G$_NAV_BLOCK");
	}
	
	public net.hedtech.general.common.libraries.Goqolib.services.GKeyBlockClass getGKeyBlockClass() {
		return (net.hedtech.general.common.libraries.Goqolib.services.GKeyBlockClass)getSupportCodeManager().getPackage("G$_KEY_BLOCK_CLASS");
	}
	
	public net.hedtech.general.common.libraries.Goqolib.services.GIconBtnClass getGIconBtnClass() {
		return (net.hedtech.general.common.libraries.Goqolib.services.GIconBtnClass)getSupportCodeManager().getPackage("G$_ICON_BTN_CLASS");
	}
	
	public net.hedtech.general.common.libraries.Goqolib.controller.GVpdiBlockController getGVpdiBlock() {
		return (net.hedtech.general.common.libraries.Goqolib.controller.GVpdiBlockController)getSupportCodeManager().getPackage("G$_VPDI_BLOCK");
	}
	
	public net.hedtech.general.common.libraries.Goqolib.services.GDateClass getGDateClass() {
		return (net.hedtech.general.common.libraries.Goqolib.services.GDateClass)getSupportCodeManager().getPackage("G$_DATE_CLASS");
	}
	
	public net.hedtech.general.common.libraries.Goqolib.services.GFormClass getGFormClass() {
		return (net.hedtech.general.common.libraries.Goqolib.services.GFormClass)getSupportCodeManager().getPackage("G$_FORM_CLASS");
	}
	
	public net.hedtech.general.common.libraries.Goqolib.services.GValFormClass getGValFormClass() {
		return (net.hedtech.general.common.libraries.Goqolib.services.GValFormClass)getSupportCodeManager().getPackage("G$_VAL_FORM_CLASS");
	}
	
	public net.hedtech.general.common.libraries.Goqolib.services.GCodeClass getGCodeClass() {
		return (net.hedtech.general.common.libraries.Goqolib.services.GCodeClass)getSupportCodeManager().getPackage("G$_CODE_CLASS");
	}
	
	public net.hedtech.general.common.libraries.Goqolib.services.GApplFormClass getGApplFormClass() {
		return (net.hedtech.general.common.libraries.Goqolib.services.GApplFormClass)getSupportCodeManager().getPackage("G$_APPL_FORM_CLASS");
	}
	
	public net.hedtech.general.common.libraries.Goqolib.services.GInqFormClass getGInqFormClass() {
		return (net.hedtech.general.common.libraries.Goqolib.services.GInqFormClass)getSupportCodeManager().getPackage("G$_INQ_FORM_CLASS");
	}
	
	// Attached Libraries
	
	public net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices getGoqrpls() {
		return (net.hedtech.general.common.libraries.Goqrpls.GoqrplsServices)getSupportCodeManager().getLibrary("GOQRPLS");
	}
	
	public net.hedtech.general.common.libraries.Goqgmnu.GoqgmnuServices getGoqgmnu() {
		return (net.hedtech.general.common.libraries.Goqgmnu.GoqgmnuServices)getSupportCodeManager().getLibrary("GOQGMNU");
	}
	
	public net.hedtech.general.common.libraries.Goqwflw.GoqwflwServices getGoqwflw() {
		return (net.hedtech.general.common.libraries.Goqwflw.GoqwflwServices)getSupportCodeManager().getLibrary("GOQWFLW");
	}
	
	public net.hedtech.general.common.libraries.Eoqrpls.EoqrplsServices getEoqrpls() {
		return (net.hedtech.general.common.libraries.Eoqrpls.EoqrplsServices)getSupportCodeManager().getLibrary("EOQRPLS");
	}
}
