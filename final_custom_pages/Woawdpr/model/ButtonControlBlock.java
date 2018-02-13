package net.hedtech.banner.student.gsu.student.Woawdpr.model;

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

	public NString getKeyblocTermCodeLbt() {
		return toStr(super.getValue("KEYBLOC_TERM_CODE_LBT"));
	}

	public void setKeyblocTermCodeLbt(NString value) {
		super.setValue("KEYBLOC_TERM_CODE_LBT", value);
	}

	public NString getKeyblocLevlCodeLbt() {
		return toStr(super.getValue("KEYBLOC_LEVL_CODE_LBT"));
	}

	public void setKeyblocLevlCodeLbt(NString value) {
		super.setValue("KEYBLOC_LEVL_CODE_LBT", value);
	}
}