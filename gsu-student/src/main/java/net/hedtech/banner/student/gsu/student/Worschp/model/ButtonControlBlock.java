package net.hedtech.banner.student.gsu.student.Worschp.model;

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
	
	public NString getCheckKeys() {
		return toStr(super.getValue("CHECK_KEYS"));
	}
	
	public void setCheckKeys(NString value) {
		super.setValue("CHECK_KEYS", value);
	}

	public NString getTermCodeLbt() {
		return toStr(super.getValue("TERM_CODE_LBT"));
	}

	public void setTermCodeLbt(NString value) {
		super.setValue("TERM_CODE_LBT", value);
	}

	public NString getSchpCodeLbt() {
		return toStr(super.getValue("SCHP_CODE_LBT"));
	}

	public void setSchpCodeLbt(NString value) {
		super.setValue("SCHP_CODE_LBT", value);
	}
}