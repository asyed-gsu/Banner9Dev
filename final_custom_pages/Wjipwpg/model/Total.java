package net.hedtech.banner.student.gsu.student.Wjipwpg.model;

import morphis.foundations.core.appsupportlib.model.SimpleBusinessObject;
import morphis.foundations.core.appsupportlib.model.configuration.SimpleBusinessObjectConfiguration;
import morphis.foundations.core.types.*;
import static morphis.foundations.core.types.Types.*;

public class Total extends morphis.foundations.flavors.forms.appsupportlib.model.SimpleBusinessObject {

	public Total() {
		super();
	}

	public Total(SimpleBusinessObjectConfiguration configuration, String name) {
		super(configuration, name);
	}
	
	public NNumber getTotalHrs() {
		NNumber v = new NNumber((java.math.BigDecimal)super.getValue("TOTAL_HRS"));
		return v;
	}
	
	public void setTotalHrs(NNumber value) {
		super.setValue("TOTAL_HRS", value.getValue());
	}

	public NNumber getTotalAmt() {
		NNumber v = new NNumber((java.math.BigDecimal)super.getValue("TOTAL_AMT"));
		return v;
	}
	
	public void setTotalAmt(NNumber value) {
		super.setValue("TOTAL_AMT", value.getValue());
	}
		
}