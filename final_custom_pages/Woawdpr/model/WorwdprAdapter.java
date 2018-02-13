package net.hedtech.banner.student.gsu.student.Woawdpr.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class WorwdprAdapter extends BaseRowAdapter {

	public WorwdprAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NNumber getWorwdprSeqNo() {
		NNumber v = new NNumber((java.math.BigDecimal)this.getValue("WORWDPR_SEQ_NO"));
		return v;
	}
	
	public void setWorwdprSeqNo(NNumber value) {
		this.setValue("WORWDPR_SEQ_NO", value.getValue());
	}

	public NString getWorwdprTermCode() {
		NString v = new NString((String)this.getValue("WORWDPR_TERM_CODE"));
		return v;
	}
	
	public void setWorwdprTermCode(NString value) {
		this.setValue("WORWDPR_TERM_CODE", value.getValue());
	}

	public NString getWorwdprLevlCode() {
		NString v = new NString((String)this.getValue("WORWDPR_LEVL_CODE"));
		return v;
	}
	
	public void setWorwdprLevlCode(NString value) {
		this.setValue("WORWDPR_LEVL_CODE", value.getValue());
	}

	public NString getWorwdprSubjCodeA() {
		NString v = new NString((String)this.getValue("WORWDPR_SUBJ_CODE_A"));
		return v;
	}
	
	public void setWorwdprSubjCodeA(NString value) {
		this.setValue("WORWDPR_SUBJ_CODE_A", value.getValue());
	}

	public NString getWorwdprCrseNumbA() {
		NString v = new NString((String)this.getValue("WORWDPR_CRSE_NUMB_A"));
		return v;
	}
	
	public void setWorwdprCrseNumbA(NString value) {
		this.setValue("WORWDPR_CRSE_NUMB_A", value.getValue());
	}

	public NString getWorwdprSubjCodeB() {
		NString v = new NString((String)this.getValue("WORWDPR_SUBJ_CODE_B"));
		return v;
	}
	
	public void setWorwdprSubjCodeB(NString value) {
		this.setValue("WORWDPR_SUBJ_CODE_B", value.getValue());
	}

	public NString getWorwdprCrseNumbB() {
		NString v = new NString((String)this.getValue("WORWDPR_CRSE_NUMB_B"));
		return v;
	}
	
	public void setWorwdprCrseNumbB(NString value) {
		this.setValue("WORWDPR_CRSE_NUMB_B", value.getValue());
	}

	public NString getWorwdprUserId() {
		NString v = new NString((String)this.getValue("WORWDPR_USER_ID"));
		return v;
	}
	
	public void setWorwdprUserId(NString value) {
		this.setValue("WORWDPR_USER_ID", value.getValue());
	}

	public NDate getWorwdprActivityDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WORWDPR_ACTIVITY_DATE"));
		return v;
	}
	
	public void setWorwdprActivityDate(NDate value) {
		this.setValue("WORWDPR_ACTIVITY_DATE", value.getValue());
	}

	
	public NString getCourseADesc() {
		NString v = new NString((String) this.getValue("COURSE_A_DESC"));
		return v;
	}

	public void setCourseADesc(NString value) {
		this.setValue("COURSE_A_DESC", value.getValue());
	}

	public NString getCourseBDesc() {
		NString v = new NString((String) this.getValue("COURSE_B_DESC"));
		return v;
	}

	public void setCourseBDesc(NString value) {
		this.setValue("COURSE_B_DESC", value.getValue());
	}

	public java.sql.RowId getROWID() {
		return (java.sql.RowId) this.getValue("ROWID");
	}}