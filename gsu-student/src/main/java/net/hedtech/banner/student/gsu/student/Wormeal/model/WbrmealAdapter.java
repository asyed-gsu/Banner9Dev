package net.hedtech.banner.student.gsu.student.Wormeal.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class WbrmealAdapter extends BaseRowAdapter {

	public WbrmealAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NNumber getWbrmealPidm() {
		NNumber v = new NNumber((java.math.BigDecimal)this.getValue("WBRMEAL_PIDM"));
		return v;
	}
	
	public void setWbrmealPidm(NNumber value) {
		this.setValue("WBRMEAL_PIDM", value.getValue());
	}

	public NString getWbrmealTerm() {
		NString v = new NString((String)this.getValue("WBRMEAL_TERM"));
		return v;
	}
	
	public void setWbrmealTerm(NString value) {
		this.setValue("WBRMEAL_TERM", value.getValue());
	}

	public NString getWbrmealIso() {
		NString v = new NString((String)this.getValue("WBRMEAL_ISO"));
		return v;
	}
	
	public void setWbrmealIso(NString value) {
		this.setValue("WBRMEAL_ISO", value.getValue());
	}

	public NNumber getWbrmealMealplanId() {
		NNumber v = new NNumber((java.math.BigDecimal)this.getValue("WBRMEAL_MEALPLAN_ID"));
		return v;
	}
	
	public void setWbrmealMealplanId(NNumber value) {
		this.setValue("WBRMEAL_MEALPLAN_ID", value.getValue());
	}

	public NNumber getWbrmealMealplanAmt() {
		NNumber v = new NNumber((java.math.BigDecimal)this.getValue("WBRMEAL_MEALPLAN_AMT"));
		return v;
	}
	
	public void setWbrmealMealplanAmt(NNumber value) {
		this.setValue("WBRMEAL_MEALPLAN_AMT", value.getValue());
	}

	public NString getWbrmealDropInd() {
		NString v = new NString((String)this.getValue("WBRMEAL_DROP_IND"));
		return v;
	}
	
	public void setWbrmealDropInd(NString value) {
		this.setValue("WBRMEAL_DROP_IND", value.getValue());
	}

	public NDate getWbrmealEntryDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WBRMEAL_ENTRY_DATE"));
		return v;
	}
	
	public void setWbrmealEntryDate(NDate value) {
		this.setValue("WBRMEAL_ENTRY_DATE", value.getValue());
	}

	public NDate getWbrmealPostDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WBRMEAL_POST_DATE"));
		return v;
	}
	
	public void setWbrmealPostDate(NDate value) {
		this.setValue("WBRMEAL_POST_DATE", value.getValue());
	}

	public NString getWbrmealAcdmYrInd() {
		NString v = new NString((String)this.getValue("WBRMEAL_ACDM_YR_IND"));
		return v;
	}
	
	public void setWbrmealAcdmYrInd(NString value) {
		this.setValue("WBRMEAL_ACDM_YR_IND", value.getValue());
	}

	public NDate getWbrmealActivityDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WBRMEAL_ACTIVITY_DATE"));
		return v;
	}
	
	public void setWbrmealActivityDate(NDate value) {
		this.setValue("WBRMEAL_ACTIVITY_DATE", value.getValue());
	}

	public NString getWbrmealUser() {
		NString v = new NString((String)this.getValue("WBRMEAL_USER"));
		return v;
	}
	
	public void setWbrmealUser(NString value) {
		this.setValue("WBRMEAL_USER", value.getValue());
	}

	public NString getWbrmealComments() {
		NString v = new NString((String)this.getValue("WBRMEAL_COMMENTS"));
		return v;
	}
	
	public void setWbrmealComments(NString value) {
		this.setValue("WBRMEAL_COMMENTS", value.getValue());
	}

	
	public NString getWbrmealId() {
		NString v = new NString((String) this.getValue("WBRMEAL_ID"));
		return v;
	}

	public void setWbrmealId(NString value) {
		this.setValue("WBRMEAL_ID", value.getValue());
	}

	public NString getWbrmealName() {
		NString v = new NString((String) this.getValue("WBRMEAL_NAME"));
		return v;
	}

	public void setWbrmealName(NString value) {
		this.setValue("WBRMEAL_NAME", value.getValue());
	}

	public NString getWbrmealMealPlanDesc() {
		NString v = new NString((String) this.getValue("WBRMEAL_MEALPLAN_DESC"));
		return v;
	}

	public void setWbrmealMealPlanDesc(NString value) {
		this.setValue("WBRMEAL_MEALPLAN_DESC", value.getValue());
	}

	public java.sql.RowId getROWID() {
		return (java.sql.RowId) this.getValue("ROWID");
	}}