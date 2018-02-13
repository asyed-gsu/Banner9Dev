package net.hedtech.banner.student.gsu.student.Wtvtrtg.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class WtvtrtgAdapter extends BaseRowAdapter {

	public WtvtrtgAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NString getWtvtrtgCode() {
		NString v = new NString((String)this.getValue("WTVTRTG_CODE"));
		return v;
	}
	
	//code in upper case
	public void setWtvtrtgCode(NString value) {
		this.setValue("WTVTRTG_CODE", value.getValue().toUpperCase());
	}

	public NString getWtvtrtgXpath() {
		NString v = new NString((String)this.getValue("WTVTRTG_XPATH"));
		return v;
	}
	
	public void setWtvtrtgXpath(NString value) {
		this.setValue("WTVTRTG_XPATH", value.getValue());
	}

	public NString getWtvtrtgCreateUser() {
		NString v = new NString((String)this.getValue("WTVTRTG_CREATE_USER"));
		return v;
	}
	
	public void setWtvtrtgCreateUser(NString value) {
		this.setValue("WTVTRTG_CREATE_USER", value.getValue());
	}

	public NDate getWtvtrtgCreateDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WTVTRTG_CREATE_DATE"));
		return v;
	}
	
	public void setWtvtrtgCreateDate(NDate value) {
		this.setValue("WTVTRTG_CREATE_DATE", value.getValue());
	}

	public NString getWtvtrtgUser() {
		NString v = new NString((String)this.getValue("WTVTRTG_USER"));
		return v;
	}
	
	public void setWtvtrtgUser(NString value) {
		this.setValue("WTVTRTG_USER", value.getValue());
	}

	public NDate getWtvtrtgActivityDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WTVTRTG_ACTIVITY_DATE"));
		return v;
	}
	
	public void setWtvtrtgActivityDate(NDate value) {
		this.setValue("WTVTRTG_ACTIVITY_DATE", value.getValue());
	}

	public NString getWtvtrtgDataOrigin() {
		NString v = new NString((String)this.getValue("WTVTRTG_DATA_ORIGIN"));
		return v;
	}
	
	public void setWtvtrtgDataOrigin(NString value) {
		this.setValue("WTVTRTG_DATA_ORIGIN", value.getValue());
	}

	
	public java.sql.RowId getROWID() {
		return (java.sql.RowId) this.getValue("ROWID");
	}}