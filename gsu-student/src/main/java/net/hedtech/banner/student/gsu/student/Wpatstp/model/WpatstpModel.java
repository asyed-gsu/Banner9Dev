package net.hedtech.banner.student.gsu.student.Wpatstp.model;

import java.util.Hashtable;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.core.appsupportlib.runtime.*;
import morphis.foundations.core.appsupportlib.model.FormModel;

import net.hedtech.general.common.libraries.Goqolib.model.*;

public class WpatstpModel extends FormModel {
	
	public WpatstpModel(ITask task, Hashtable parameters) {
		super(task, parameters);
	}

	public KeyBlock getKeyBlock() {
		return (KeyBlock) getBusinessObject("KEY_BLOCK");
	}

	public ButtonControlBlock getButtonControlBlock() {
		return (ButtonControlBlock) getBusinessObject("BUTTON_CONTROL_BLOCK");
	}

	public FormHeader getFormHeader() {
		return (FormHeader) getBusinessObject("FORM_HEADER");
	}

	public GSdkey getGSdkey() {
		return (GSdkey) getBusinessObject("G$_SDKEY");
	}

	public GVpdiBlock getGVpdiBlock() {
		return (GVpdiBlock) getBusinessObject("G$_VPDI_BLOCK");
	}

	public GNavBlock getGNavBlock() {
		return (GNavBlock) getBusinessObject("G$_NAV_BLOCK");
	}

	public GOptBlock getGOptBlock() {
		return (GOptBlock) getBusinessObject("G$_OPT_BLOCK");
	}

	public GExtendedSearchBlock getGExtendedSearchBlock() {
		return (GExtendedSearchBlock) getBusinessObject("G$_EXTENDED_SEARCH_BLOCK");
	}
	
	public IDBBusinessObject getWpattsd() {
		return (IDBBusinessObject) getBusinessObject("WPATTSD");
	}

	public IDBBusinessObject getGSdisp() {
		return (IDBBusinessObject) getBusinessObject("G$_SDISP");
	}
}