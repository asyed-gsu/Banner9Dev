package net.hedtech.banner.student.gsu.student.Wtvschf.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class WtvschfAdapter extends BaseRowAdapter {

	public WtvschfAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NString getWtvschfCode() {
		NString v = new NString((String)this.getValue("WTVSCHF_CODE"));
		return v;
	}
	
	public void setWtvschfCode(NString value) {
		this.setValue("WTVSCHF_CODE", value.getValue());
	}

	public NString getWtvschfDesc() {
		NString v = new NString((String)this.getValue("WTVSCHF_DESC"));
		return v;
	}
	
	public void setWtvschfDesc(NString value) {
		this.setValue("WTVSCHF_DESC", value.getValue());
	}

	public NDate getWtvschfActivityDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WTVSCHF_ACTIVITY_DATE"));
		return v;
	}
	
	public void setWtvschfActivityDate(NDate value) {
		this.setValue("WTVSCHF_ACTIVITY_DATE", value.getValue());
	}

	public NString getWtvschfFrequency() {
		NString v = new NString((String)this.getValue("WTVSCHF_FREQUENCY"));
		return v;
	}
	
	public void setWtvschfFrequency(NString value) {
		this.setValue("WTVSCHF_FREQUENCY", value.getValue());
	}

	
	public java.sql.RowId getROWID() {
		return (java.sql.RowId) this.getValue("ROWID");
	}}