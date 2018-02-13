package net.hedtech.banner.student.gsu.student.Wtrtrtt.model;

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
	
	public NString getKeyblockLablCodeLbt() {
		return toStr(super.getValue("KEYBLOCK_LABL_CODE_LBT"));
	}

	public void setKeyblockLablCodeLbt(NString value) {
		super.setValue("KEYBLOCK_LABL_CODE_LBT", value);
	}
}