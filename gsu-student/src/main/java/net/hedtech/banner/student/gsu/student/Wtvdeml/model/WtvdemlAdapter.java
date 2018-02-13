package net.hedtech.banner.student.gsu.student.Wtvdeml.model;

import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class WtvdemlAdapter extends BaseRowAdapter {
	
	public WtvdemlAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NString getWtvdemlCode() {
		NString v = new NString((String)this.getValue("WTVDEML_CODE"));
		return v;
	}
	
	public void setWtvdemlCode(NString value) {
		this.setValue("WTVDEML_CODE", value.getValue());
	}

	public NString getWtvdemlDesc() {
		NString v = new NString((String)this.getValue("WTVDEML_DESC"));
		return v;
	}
	
	public void setWtvdemlDesc(NString value) {
		this.setValue("WTVDEML_DESC", value.getValue());
	}

	public NString getWtvdemlCollCode() {
		NString v = new NString((String)this.getValue("WTVDEML_COLL_CODE"));
		return v;
	}
	
	public void setWtvdemlCollCode(NString value) {
		this.setValue("WTVDEML_COLL_CODE", value.getValue());
	}

	public NString getWtvdemlDeptCode() {
		NString v = new NString((String)this.getValue("WTVDEML_DEPT_CODE"));
		return v;
	}
	
	public void setWtvdemlDeptCode(NString value) {
		this.setValue("WTVDEML_DEPT_CODE", value.getValue());
	}

	public NDate getWtvdemlActivityDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WTVDEML_ACTIVITY_DATE"));
		return v;
	}
	
	public void setWtvdemlActivityDate(NDate value) {
		this.setValue("WTVDEML_ACTIVITY_DATE", value.getValue());
	}

	public NString getWtvdemlUserId() {
		NString v = new NString((String)this.getValue("WTVDEML_USER_ID"));
		System.out.println("*** WTVADAPER GET USER ID: " + v + "<- USER ID");
		return v;
	}
	
	public void setWtvdemlUserId(NString value) {
		this.setValue("WTVDEML_USER_ID", value.getValue());
	}

	public NString getWtvdemlDataOrigin() {
		NString v = new NString((String)this.getValue("WTVDEML_DATA_ORIGIN"));
		return v;
	}
	
	public void setWtvdemlDataOrigin(NString value) {
		this.setValue("WTVDEML_DATA_ORIGIN", value.getValue());
	}

	public NNumber getWtvdemlSurrogateId() {
		NNumber v = new NNumber((java.math.BigDecimal)this.getValue("WTVDEML_SURROGATE_ID"));
		return v;
	}
	
	public void setWtvdemlSurrogateId(NNumber value) {
		this.setValue("WTVDEML_SURROGATE_ID", value.getValue());
	}

	public NNumber getWtvdemlVersion() {
		NNumber v = new NNumber((java.math.BigDecimal)this.getValue("WTVDEML_VERSION"));
		return v;
	}
	
	public void setWtvdemlVersion(NNumber value) {
		this.setValue("WTVDEML_VERSION", value.getValue());
	}

	public NString getWtvdemlVpdiCode() {
		NString v = new NString((String)this.getValue("WTVDEML_VPDI_CODE"));
		return v;
	}
	
	public void setWtvdemlVpdiCode(NString value) {
		this.setValue("WTVDEML_VPDI_CODE", value.getValue());
	}

	
	public java.sql.RowId getROWID() {
		return (java.sql.RowId) this.getValue("ROWID");
	}}