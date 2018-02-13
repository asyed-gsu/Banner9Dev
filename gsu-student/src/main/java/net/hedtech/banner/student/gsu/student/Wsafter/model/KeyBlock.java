package net.hedtech.banner.student.gsu.student.Wsafter.model;

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
	
	public NString getTermCode() {
		return toStr(super.getValue("TERM_CODE"));
	}
	
	public void setTermCode(NString value) {
		super.setValue("TERM_CODE", value);
	}
}