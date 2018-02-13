package net.hedtech.banner.student.gsu.student.Wjipwpg.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class WjrpwpgAdapter extends BaseRowAdapter {

	public WjrpwpgAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NString getWjrpwpgAidyCode() {
		NString v = new NString((String)this.getValue("WJRPWPG_AIDY_CODE"));
		return v;
	}
	
	public void setWjrpwpgAidyCode(NString value) {
		this.setValue("WJRPWPG_AIDY_CODE", value.getValue());
	}

	public NNumber getWjrpwpgPidm() {
		NNumber v = new NNumber((java.math.BigDecimal)this.getValue("WJRPWPG_PIDM"));
		return v;
	}
	
	public void setWjrpwpgPidm(NNumber value) {
		this.setValue("WJRPWPG_PIDM", value.getValue());
	}

	public NString getWjrpwpgPosn() {
		NString v = new NString((String)this.getValue("WJRPWPG_POSN"));
		return v;
	}
	
	public void setWjrpwpgPosn(NString value) {
		this.setValue("WJRPWPG_POSN", value.getValue());
	}

	public NString getWjrpwpgSuff() {
		NString v = new NString((String)this.getValue("WJRPWPG_SUFF"));
		return v;
	}
	
	public void setWjrpwpgSuff(NString value) {
		this.setValue("WJRPWPG_SUFF", value.getValue());
	}

	public NDate getWjrpwpgPayEndDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WJRPWPG_PAY_END_DATE"));
		return v;
	}
	
	public void setWjrpwpgPayEndDate(NDate value) {
		this.setValue("WJRPWPG_PAY_END_DATE", value.getValue());
	}

	public NNumber getWjrpwpgHrs() {
		NNumber v = new NNumber((java.math.BigDecimal)this.getValue("WJRPWPG_HRS"));
		return v;
	}
	
	public void setWjrpwpgHrs(NNumber value) {
		this.setValue("WJRPWPG_HRS", value.getValue());
	}

	public NNumber getWjrpwpgRate() {
		NNumber v = new NNumber((java.math.BigDecimal)this.getValue("WJRPWPG_RATE"));
		return v;
	}
	
	public void setWjrpwpgRate(NNumber value) {
		this.setValue("WJRPWPG_RATE", value.getValue());
	}

	public NNumber getWjrpwpgAmt() {
		NNumber v = new NNumber((java.math.BigDecimal)this.getValue("WJRPWPG_AMT"));
		return v;
	}
	
	public void setWjrpwpgAmt(NNumber value) {
		this.setValue("WJRPWPG_AMT", value.getValue());
	}

	public NString getWjrpwpgPeriod() {
		NString v = new NString((String)this.getValue("WJRPWPG_PERIOD"));
		return v;
	}
	
	public void setWjrpwpgPeriod(NString value) {
		this.setValue("WJRPWPG_PERIOD", value.getValue());
	}

	
	public NString getDisplayPlaceCde() {
		NString v = new NString((String) this.getValue("DISPLAY_PLACE_CDE"));
		return v;
	}

	public void setDisplayPlaceCde(NString value) {
		this.setValue("DISPLAY_PLACE_CDE", value.getValue());
	}

	public NString getDisplayFundCode() {
		NString v = new NString((String) this.getValue("DISPLAY_FUND_CODE"));
		return v;
	}

	public void setDisplayFundCode(NString value) {
		this.setValue("DISPLAY_FUND_CODE", value.getValue());
	}

	public java.sql.RowId getROWID() {
		return (java.sql.RowId) this.getValue("ROWID");
	}}