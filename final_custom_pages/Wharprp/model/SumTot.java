package net.hedtech.banner.student.gsu.student.Wharprp.model;

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
	
	public NString getWApproved() {
		return toStr(super.getValue("W_APPROVED"));
	}
	
	public void setWApproved(NString value) {
		super.setValue("W_APPROVED", value);
	}

	public NString getWRemain() {
		return toStr(super.getValue("W_REMAIN"));
	}
	
	public void setWRemain(NString value) {
		super.setValue("W_REMAIN", value);
	}
}