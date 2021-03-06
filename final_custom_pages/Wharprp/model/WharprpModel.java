package net.hedtech.banner.student.gsu.student.Wharprp.model;

import java.util.Hashtable;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.core.appsupportlib.runtime.*;
import morphis.foundations.core.appsupportlib.model.FormModel;

import net.hedtech.general.common.libraries.Goqolib.model.*;

public class WharprpModel extends FormModel {
	
	public WharprpModel(ITask task, Hashtable parameters) {
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

	public SumTot getSumTot() {
		return (SumTot) getBusinessObject("SUM_TOT");
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
	
	public IDBBusinessObject getWhvrprp() {
		return (IDBBusinessObject) getBusinessObject("WHVRPRP");
	}

	public IDBBusinessObject getGSdisp() {
		return (IDBBusinessObject) getBusinessObject("G$_SDISP");
	}

	public IDBBusinessObject getShrtckn() {
		return (IDBBusinessObject) getBusinessObject("SHRTCKN");
	}
}