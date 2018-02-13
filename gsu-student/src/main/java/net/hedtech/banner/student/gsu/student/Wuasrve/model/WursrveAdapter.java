package net.hedtech.banner.student.gsu.student.Wuasrve.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class WursrveAdapter extends BaseRowAdapter {

	public WursrveAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NNumber getWursrveSrvyId() {
		NNumber v = new NNumber((java.math.BigDecimal)this.getValue("WURSRVE_SRVY_ID"));
		return v;
	}
	
	public void setWursrveSrvyId(NNumber value) {
		this.setValue("WURSRVE_SRVY_ID", value.getValue());
	}

	public NString getWursrveSrvyTermCode() {
		NString v = new NString((String)this.getValue("WURSRVE_SRVY_TERM_CODE"));
		return v;
	}
	
	public void setWursrveSrvyTermCode(NString value) {
		this.setValue("WURSRVE_SRVY_TERM_CODE", value.getValue());
	}

	public NString getWursrveCrn() {
		NString v = new NString((String)this.getValue("WURSRVE_CRN"));
		return v;
	}
	
	public void setWursrveCrn(NString value) {
		this.setValue("WURSRVE_CRN", value.getValue());
	}

	public NString getWursrveExceptInd() {
		NString v = new NString((String)this.getValue("WURSRVE_EXCEPT_IND"));
		return v;
	}
	
	public void setWursrveExceptInd(NString value) {
		this.setValue("WURSRVE_EXCEPT_IND", value.getValue());
	}

	public NDate getWursrveActivityDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WURSRVE_ACTIVITY_DATE"));
		return v;
	}
	
	public void setWursrveActivityDate(NDate value) {
		this.setValue("WURSRVE_ACTIVITY_DATE", value.getValue());
	}

	
	public NString getPtrmCode() {
		NString v = new NString((String) this.getValue("PTRM_CODE"));
		return v;
	}

	public void setPtrmCode(NString value) {
		this.setValue("PTRM_CODE", value.getValue());
	}

	public NString getSubjCode() {
		NString v = new NString((String) this.getValue("SUBJ_CODE"));
		return v;
	}

	public void setSubjCode(NString value) {
		this.setValue("SUBJ_CODE", value.getValue());
	}

	public NString getCrseNumb() {
		NString v = new NString((String) this.getValue("CRSE_NUMB"));
		return v;
	}

	public void setCrseNumb(NString value) {
		this.setValue("CRSE_NUMB", value.getValue());
	}

	public java.sql.RowId getROWID() {
		return (java.sql.RowId) this.getValue("ROWID");
	}}