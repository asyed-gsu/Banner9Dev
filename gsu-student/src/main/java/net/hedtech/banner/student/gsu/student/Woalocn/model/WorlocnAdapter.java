package net.hedtech.banner.student.gsu.student.Woalocn.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class WorlocnAdapter extends BaseRowAdapter {

	public WorlocnAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NString getWorlocnLocnCode() {
		NString v = new NString((String)this.getValue("WORLOCN_LOCN_CODE"));
		return v;
	}
	
	public void setWorlocnLocnCode(NString value) {
		this.setValue("WORLOCN_LOCN_CODE", value.getValue());
	}

	public NString getWorlocnTprtCode() {
		NString v = new NString((String)this.getValue("WORLOCN_TPRT_CODE"));
		return v;
	}
	
	public void setWorlocnTprtCode(NString value) {
		this.setValue("WORLOCN_TPRT_CODE", value.getValue());
	}

	public NString getWorlocnOfficialInd() {
		NString v = new NString((String)this.getValue("WORLOCN_OFFICIAL_IND"));
		return v;
	}
	
	public void setWorlocnOfficialInd(NString value) {
		this.setValue("WORLOCN_OFFICIAL_IND", value.getValue());
	}

	public NString getWorlocnPrntCode() {
		NString v = new NString((String)this.getValue("WORLOCN_PRNT_CODE"));
		return v;
	}
	
	public void setWorlocnPrntCode(NString value) {
		this.setValue("WORLOCN_PRNT_CODE", value.getValue());
	}

	public NString getWorlocnUser() {
		NString v = new NString((String)this.getValue("WORLOCN_USER"));
		return v;
	}
	
	public void setWorlocnUser(NString value) {
		this.setValue("WORLOCN_USER", value.getValue());
	}

	public NDate getWorlocnActivityDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WORLOCN_ACTIVITY_DATE"));
		return v;
	}
	
	public void setWorlocnActivityDate(NDate value) {
		this.setValue("WORLOCN_ACTIVITY_DATE", value.getValue());
	}

	
	public java.sql.RowId getROWID() {
		return (java.sql.RowId) this.getValue("ROWID");
	}}