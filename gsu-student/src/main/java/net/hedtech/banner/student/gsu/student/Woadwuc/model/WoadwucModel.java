package net.hedtech.banner.student.gsu.student.Woadwuc.model;

import java.util.Hashtable;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.core.appsupportlib.runtime.*;
import morphis.foundations.core.appsupportlib.model.FormModel;

import net.hedtech.general.common.libraries.Goqolib.model.*;

public class WoadwucModel extends FormModel {
	
	public WoadwucModel(ITask task, Hashtable parameters) {
		super(task, parameters);
	}

	public FormHeader getFormHeader() {
		return (FormHeader) getBusinessObject("FORM_HEADER");
	}

	public GVpdiBlock getGVpdiBlock() {
		return (GVpdiBlock) getBusinessObject("G$_VPDI_BLOCK");
	}

	public GSdkey getGSdkey() {
		return (GSdkey) getBusinessObject("G$_SDKEY");
	}

	public GNavBlock getGNavBlock() {
		return (GNavBlock) getBusinessObject("G$_NAV_BLOCK");
	}

	public GExtendedSearchBlock getGExtendedSearchBlock() {
		return (GExtendedSearchBlock) getBusinessObject("G$_EXTENDED_SEARCH_BLOCK");
	}

	public GOptBlock getGOptBlock() {
		return (GOptBlock) getBusinessObject("G$_OPT_BLOCK");
	}
	
	public IDBBusinessObject getWordwuc() {
		return (IDBBusinessObject) getBusinessObject("WORDWUC");
	}

	public IDBBusinessObject getGSdisp() {
		return (IDBBusinessObject) getBusinessObject("G$_SDISP");
	}
}