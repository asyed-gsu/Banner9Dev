package net.hedtech.banner.student.gsu.student.Wtrtrhl.model;

import java.util.Hashtable;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.core.appsupportlib.runtime.*;
import morphis.foundations.core.appsupportlib.model.FormModel;

import net.hedtech.general.common.libraries.Goqolib.model.*;

public class WtrtrhlModel extends FormModel {
	
	public WtrtrhlModel(ITask task, Hashtable parameters) {
		super(task, parameters);
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
	
	public IDBBusinessObject getWtrtrhl() {
		return (IDBBusinessObject) getBusinessObject("WTRTRHL");
	}

	public IDBBusinessObject getGSdisp() {
		return (IDBBusinessObject) getBusinessObject("G$_SDISP");
	}
}