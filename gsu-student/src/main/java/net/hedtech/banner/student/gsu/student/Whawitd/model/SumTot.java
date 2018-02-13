package net.hedtech.banner.student.gsu.student.Whawitd.model;

import morphis.foundations.core.appsupportlib.model.SimpleBusinessObject;
import morphis.foundations.core.appsupportlib.model.configuration.SimpleBusinessObjectConfiguration;
import morphis.foundations.core.types.*;
import static morphis.foundations.core.types.Types.*;

public class SumTot extends morphis.foundations.flavors.forms.appsupportlib.model.SimpleBusinessObject {

	public SumTot() {
		super();
	}

	public SumTot(SimpleBusinessObjectConfiguration configuration, String name) {
		super(configuration, name);
	}
	
	public NString getWTaken() {
		return toStr(super.getValue("W_TAKEN"));
	}
	
	public void setWTaken(NString value) {
		super.setValue("W_TAKEN", value);
	}

	public NString getWRemain() {
		return toStr(super.getValue("W_REMAIN"));
	}
	
	public void setWRemain(NString value) {
		super.setValue("W_REMAIN", value);
	}

	public NString getTerm1() {
		return toStr(super.getValue("TERM_1"));
	}
	
	public void setTerm1(NString value) {
		super.setValue("TERM_1", value);
	}

	public NString getTerm2() {
		return toStr(super.getValue("TERM_2"));
	}
	
	public void setTerm2(NString value) {
		super.setValue("TERM_2", value);
	}
}