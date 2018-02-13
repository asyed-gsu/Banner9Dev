package net.hedtech.banner.student.gsu.student.Wtvlocn.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class WtvlocnAdapter extends BaseRowAdapter {

	public WtvlocnAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NString getWtvlocnCode() {
		NString v = new NString((String)this.getValue("WTVLOCN_CODE"));
		return v;
	}
	
	public void setWtvlocnCode(NString value) {
		this.setValue("WTVLOCN_CODE", value.getValue());
	}

	public NString getWtvlocnDesc() {
		NString v = new NString((String)this.getValue("WTVLOCN_DESC"));
		return v;
	}
	
	public void setWtvlocnDesc(NString value) {
		this.setValue("WTVLOCN_DESC", value.getValue());
	}

	public NDate getWtvlocnActivityDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WTVLOCN_ACTIVITY_DATE"));
		return v;
	}
	
	public void setWtvlocnActivityDate(NDate value) {
		this.setValue("WTVLOCN_ACTIVITY_DATE", value.getValue());
	}

	public NString getWtvlocnUserId() {
		NString v = new NString((String)this.getValue("WTVLOCN_USER_ID"));
		return v;
	}
	
	public void setWtvlocnUserId(NString value) {
		this.setValue("WTVLOCN_USER_ID", value.getValue());
	}

	
	public java.sql.RowId getROWID() {
		return (java.sql.RowId) this.getValue("ROWID");
	}}