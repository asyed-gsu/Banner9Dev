package net.hedtech.banner.student.gsu.student.Wtrtrtt.model;

import morphis.foundations.core.appsupportlib.model.SimpleBusinessObject;
import morphis.foundations.core.appsupportlib.model.configuration.SimpleBusinessObjectConfiguration;
import morphis.foundations.core.types.*;
import static morphis.foundations.core.types.Types.*;

public class KeyBlock extends morphis.foundations.flavors.forms.appsupportlib.model.SimpleBusinessObject {

	public KeyBlock() {
		super();
	}

	public KeyBlock(SimpleBusinessObjectConfiguration configuration, String name) {
		super(configuration, name);
	}
	
	public NString getKeyblockLablCode() {
		return toStr(super.getValue("KEYBLOCK_LABL_CODE"));
	}
	
	public void setKeyblockLablCode(NString value) {
		super.setValue("KEYBLOCK_LABL_CODE", value);
	}

	public NString getKeyblockTprtCode() {
		return toStr(super.getValue("KEYBLOCK_TPRT_CODE"));
	}

	public void setKeyblockTprtCode(NString value) {
		super.setValue("KEYBLOCK_TPRT_CODE", value);
	}
}