package net.hedtech.banner.student.gsu.student.Woalocn.model;

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
	
	public NString getLocnCode() {
		return toStr(super.getValue("LOCN_CODE"));
	}
	
	public void setLocnCode(NString value) {
		super.setValue("LOCN_CODE", value);
	}
}