package net.hedtech.banner.student.gsu.student.Wpatstp.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class WpattsdAdapter extends BaseRowAdapter {

	public WpattsdAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NNumber getWpattsdPidm() {
		NNumber v = new NNumber((java.math.BigDecimal)this.getValue("WPATTSD_PIDM"));
		return v;
	}
	
	public void setWpattsdPidm(NNumber value) {
		this.setValue("WPATTSD_PIDM", value.getValue());
	}

	public NString getWpattsdTermCodeEff() {
		NString v = new NString((String)this.getValue("WPATTSD_TERM_CODE_EFF"));
		return v;
	}
	
	public void setWpattsdTermCodeEff(NString value) {
		this.setValue("WPATTSD_TERM_CODE_EFF", value.getValue());
	}

	public NString getWpattsdPermAttsCode() {
		NString v = new NString((String)this.getValue("WPATTSD_PERM_ATTS_CODE"));
		return v;
	}
	
	public void setWpattsdPermAttsCode(NString value) {
		this.setValue("WPATTSD_PERM_ATTS_CODE", value.getValue());
	}

	public NString getWpattsdUserId() {
		NString v = new NString((String)this.getValue("WPATTSD_USER_ID"));
		return v;
	}
	
	public void setWpattsdUserId(NString value) {
		this.setValue("WPATTSD_USER_ID", value.getValue());
	}

	public NDate getWpattsdActivityDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WPATTSD_ACTIVITY_DATE"));
		return v;
	}
	
	public void setWpattsdActivityDate(NDate value) {
		this.setValue("WPATTSD_ACTIVITY_DATE", value.getValue());
	}

	
	public NString getHoldDesc() {
		NString v = new NString((String) this.getValue("HOLD_DESC"));
		return v;
	}

	public void setHoldDesc(NString value) {
		this.setValue("HOLD_DESC", value.getValue());
	}

	public NString getHoldTermCode() {
		NString v = new NString((String) this.getValue("HOLD_TERM_CODE"));
		return v;
	}

	public void setHoldTermCode(NString value) {
		this.setValue("HOLD_TERM_CODE", value.getValue());
	}

	public NString getHoldAttsCode() {
		NString v = new NString((String) this.getValue("HOLD_ATTS_CODE"));
		return v;
	}

	public void setHoldAttsCode(NString value) {
		this.setValue("HOLD_ATTS_CODE", value.getValue());
	}

	public java.sql.RowId getROWID() {
		return (java.sql.RowId) this.getValue("ROWID");
	}}