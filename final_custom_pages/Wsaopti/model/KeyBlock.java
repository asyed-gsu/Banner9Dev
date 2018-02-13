package net.hedtech.banner.student.gsu.student.Wsaopti.model;

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
	
	public NNumber getPidm() {
		return toNumber(super.getValue("PIDM"));
	}
	
	public void setPidm(NNumber value) {
		super.setValue("PIDM", value);
	}

	public NString getTermCode() {
		return toStr(super.getValue("TERM_CODE"));
	}
	
	public void setTermCode(NString value) {
		super.setValue("TERM_CODE", value);
	}

	public NString getId() {
		return toStr(super.getValue("ID"));
	}
	
	public void setId(NString value) {
		super.setValue("ID", value);
	}

	public NString getStudentName() {
		return toStr(super.getValue("STUDENT_NAME"));
	}
	
	public void setStudentName(NString value) {
		super.setValue("STUDENT_NAME", value);
	}

	

	

	

	
}