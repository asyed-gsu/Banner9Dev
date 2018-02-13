package net.hedtech.banner.student.gsu.student.Wcascmt.model;

import java.util.Hashtable;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.core.appsupportlib.runtime.*;
import morphis.foundations.core.appsupportlib.model.FormModel;

import net.hedtech.general.common.libraries.Goqolib.model.*;

public class WcascmtModel extends FormModel {
	
	public WcascmtModel(ITask task, Hashtable parameters) {
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
	
	public IDBBusinessObject getWcrscmt() {
		return (IDBBusinessObject) getBusinessObject("WCRSCMT");
	}
}