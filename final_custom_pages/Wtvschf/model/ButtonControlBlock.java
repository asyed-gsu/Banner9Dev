package net.hedtech.banner.student.gsu.student.Wtvschf.model;

import morphis.foundations.core.appsupportlib.model.SimpleBusinessObject;
import morphis.foundations.core.appsupportlib.model.configuration.SimpleBusinessObjectConfiguration;
import morphis.foundations.core.types.*;
import static morphis.foundations.core.types.Types.*;

public class ButtonControlBlock extends morphis.foundations.flavors.forms.appsupportlib.model.SimpleBusinessObject {

	public ButtonControlBlock() {
		super();
	}

	public ButtonControlBlock(SimpleBusinessObjectConfiguration configuration, String name) {
		super(configuration, name);
	}
	
	public NString getStvadmr1RollbackBtn() {
		return toStr(super.getValue("STVADMR_1_ROLLBACK_BTN"));
	}
	
	public void setStvadmr1RollbackBtn(NString value) {
		super.setValue("STVADMR_1_ROLLBACK_BTN", value);
	}

	public NString getStvadmr1SaveBtn() {
		return toStr(super.getValue("STVADMR_1_SAVE_BTN"));
	}
	
	public void setStvadmr1SaveBtn(NString value) {
		super.setValue("STVADMR_1_SAVE_BTN", value);
	}

	public NString getStvadmr1ExitBtn() {
		return toStr(super.getValue("STVADMR_1_EXIT_BTN"));
	}
	
	public void setStvadmr1ExitBtn(NString value) {
		super.setValue("STVADMR_1_EXIT_BTN", value);
	}

	public NString getStvadmr1ExitvalueBtn() {
		return toStr(super.getValue("STVADMR_1_EXITVALUE_BTN"));
	}
	
	public void setStvadmr1ExitvalueBtn(NString value) {
		super.setValue("STVADMR_1_EXITVALUE_BTN", value);
	}
}