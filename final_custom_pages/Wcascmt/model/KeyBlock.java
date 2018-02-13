package net.hedtech.banner.student.gsu.student.Wcascmt.model;

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
	
	public NString getKeyblockTermCode() {
		return toStr(super.getValue("KEYBLOCK_TERM_CODE"));
	}
	
	public void setKeyblockTermCode(NString value) {
		super.setValue("KEYBLOCK_TERM_CODE", value);
	}

	public NString getKeyblockTermDesc() {
		return toStr(super.getValue("KEYBLOCK_TERM_DESC"));
	}

	public void setKeyblockTermDesc(NString value) {
		super.setValue("KEYBLOCK_TERM_DESC", value);
	}

	public NString getKeyblockSubjCode() {
		return toStr(super.getValue("KEYBLOCK_SUBJ_CODE"));
	}

	public void setKeyblockSubjCode(NString value) {
		super.setValue("KEYBLOCK_SUBJ_CODE", value);
	}

	public NString getKeyblockSubjDesc() {
		return toStr(super.getValue("KEYBLOCK_SUBJ_DESC"));
	}

	public void setKeyblockSubjDesc(NString value) {
		super.setValue("KEYBLOCK_SUBJ_DESC", value);
	}

	public NNumber getHoldNumber1() {
		return toNumber(super.getValue("HOLD_NUMBER1"));
	}
	
	public void setHoldNumber1(NNumber value) {
		super.setValue("HOLD_NUMBER1", value);
	}
	
	public NNumber getHoldNumber2() {
		return toNumber(super.getValue("HOLD_NUMBER2"));
	}
	
	public void setHoldNumber2(NNumber value) {
		super.setValue("HOLD_NUMBER2", value);
	}
	

	public NString getResequenceInd() {
		return toStr(super.getValue("RESEQUENCE_IND"));
	}
	
	public void setResequenceInd(NString value) {
		super.setValue("RESEQUENCE_IND", value);
	}
	
}