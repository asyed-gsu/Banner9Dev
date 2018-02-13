package net.hedtech.banner.student.gsu.student.Wtvsrvy.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class WtvsrvyAdapter extends BaseRowAdapter {

	public WtvsrvyAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NString getWtvsrvyCode() {
		NString v = new NString((String)this.getValue("WTVSRVY_CODE"));
		return v;
	}
	
	public void setWtvsrvyCode(NString value) {
		this.setValue("WTVSRVY_CODE", value.getValue());
	}

	public NString getWtvsrvyDesc() {
		NString v = new NString((String)this.getValue("WTVSRVY_DESC"));
		return v;
	}
	
	public void setWtvsrvyDesc(NString value) {
		this.setValue("WTVSRVY_DESC", value.getValue());
	}

	public NString getWtvsrvyType() {
		NString v = new NString((String)this.getValue("WTVSRVY_TYPE"));
		return v;
	}
	
	public void setWtvsrvyType(NString value) {
		this.setValue("WTVSRVY_TYPE", value.getValue());
	}

	public NDate getWtvsrvyActivityDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WTVSRVY_ACTIVITY_DATE"));
		return v;
	}
	
	public void setWtvsrvyActivityDate(NDate value) {
		this.setValue("WTVSRVY_ACTIVITY_DATE", value.getValue());
	}

	
	public java.sql.RowId getROWID() {
		return (java.sql.RowId) this.getValue("ROWID");
	}}