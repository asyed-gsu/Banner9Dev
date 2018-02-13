package net.hedtech.banner.student.gsu.student.Woawdpr.model;

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
	
	public NString getKeyblocTermCode() {
		return toStr(super.getValue("KEYBLOC_TERM_CODE"));
	}
	
	public void setKeyblocTermCode(NString value) {
		super.setValue("KEYBLOC_TERM_CODE", value);
	}

	public NString getTermDesc() {
		return toStr(super.getValue("TERM_DESC"));
	}

	public void setTermDesc(NString value) {
		super.setValue("TERM_DESC", value);
	}

	public NString getKeyblocLevlCode() {
		return toStr(super.getValue("KEYBLOC_LEVL_CODE"));
	}

	public void setKeyblocLevlCode(NString value) {
		super.setValue("KEYBLOC_LEVL_CODE", value);
	}

	public NString getLevlDesc() {
		return toStr(super.getValue("LEVL_DESC"));
	}

	public void setLevlDesc(NString value) {
		super.setValue("LEVL_DESC", value);
	}
}