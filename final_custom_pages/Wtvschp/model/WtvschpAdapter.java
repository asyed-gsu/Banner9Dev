package net.hedtech.banner.student.gsu.student.Wtvschp.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class WtvschpAdapter extends BaseRowAdapter {

	public WtvschpAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NString getWtvschpCode() {
		NString v = new NString((String)this.getValue("WTVSCHP_CODE"));
		return v;
	}
	
	public void setWtvschpCode(NString value) {
		this.setValue("WTVSCHP_CODE", value.getValue());
	}

	public NString getWtvschpDesc() {
		NString v = new NString((String)this.getValue("WTVSCHP_DESC"));
		return v;
	}
	
	public void setWtvschpDesc(NString value) {
		this.setValue("WTVSCHP_DESC", value.getValue());
	}

	public NString getWtvschpType() {
		NString v = new NString((String)this.getValue("WTVSCHP_TYPE"));
		return v;
	}
	
	public void setWtvschpType(NString value) {
		this.setValue("WTVSCHP_TYPE", value.getValue());
	}

	public NNumber getWtvschpAmt() {
		NNumber v = new NNumber((java.math.BigDecimal)this.getValue("WTVSCHP_AMT"));
		return v;
	}
	
	public void setWtvschpAmt(NNumber value) {
		this.setValue("WTVSCHP_AMT", value.getValue());
	}

	public NNumber getWtvschpYears() {
		NNumber v = new NNumber((java.math.BigDecimal)this.getValue("WTVSCHP_YEARS"));
		return v;
	}
	
	public void setWtvschpYears(NNumber value) {
		this.setValue("WTVSCHP_YEARS", value.getValue());
	}

	public NString getWtvschpPrjctId() {
		NString v = new NString((String)this.getValue("WTVSCHP_PRJCT_ID"));
		return v;
	}
	
	public void setWtvschpPrjctId(NString value) {
		this.setValue("WTVSCHP_PRJCT_ID", value.getValue());
	}

	public NNumber getWtvschpSchpId() {
		NNumber v = new NNumber((java.math.BigDecimal)this.getValue("WTVSCHP_SCHP_ID"));
		return v;
	}
	
	public void setWtvschpSchpId(NNumber value) {
		this.setValue("WTVSCHP_SCHP_ID", value.getValue());
	}

	public NDate getWtvschpActivityDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WTVSCHP_ACTIVITY_DATE"));
		return v;
	}
	
	public void setWtvschpActivityDate(NDate value) {
		this.setValue("WTVSCHP_ACTIVITY_DATE", value.getValue());
	}

	public NString getWtvschpGpaReq() {
		NString v = new NString((String)this.getValue("WTVSCHP_GPA_REQ"));
		return v;
	}
	
	public void setWtvschpGpaReq(NString value) {
		this.setValue("WTVSCHP_GPA_REQ", value.getValue());
	}

	
	

	

	public NString getWtvschpDispRule() {
		NString v = new NString((String) this.getValue("WTVSCHP_DISP_RULE"));
		return v;
	}

	public void setWtvschpDispRule(NString value) {
		this.setValue("WTVSCHP_DISP_RULE", value.getValue());
	}

	public java.sql.RowId getROWID() {
		return (java.sql.RowId) this.getValue("ROWID");
	}}