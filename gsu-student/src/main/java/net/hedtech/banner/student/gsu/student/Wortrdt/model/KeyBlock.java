package net.hedtech.banner.student.gsu.student.Wortrdt.model;

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
	
	public NString getStvtermCode() {
		return toStr(super.getValue("STVTERM_CODE"));
	}
	
	public void setStvtermCode(NString value) {
		super.setValue("STVTERM_CODE", value);
	}
	
	public NString getStvtermCodeLbt() {
		return toStr(super.getValue("STVTERM_CODE_LBT"));
	}

	public void setStvtermCodeLbt(NString value) {
		super.setValue("STVTERM_CODE_LBT", value);
	}
	

	public NString getStvtermDesc() {
		return toStr(super.getValue("STVTERM_DESC"));
	}

	public void setStvtermDesc(NString value) {
		super.setValue("STVTERM_DESC", value);
	}
	
}