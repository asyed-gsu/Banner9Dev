package net.hedtech.banner.student.gsu.student.Worschp.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class WbschrtAdapter extends BaseRowAdapter {

	public WbschrtAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NString getWbschrtPidm() {
		NString v = new NString((String)this.getValue("WBSCHRT_PIDM"));
		return v;
	}
	
	public void setWbschrtPidm(NString value) {
		this.setValue("WBSCHRT_PIDM", value.getValue());
	}

	public NString getWbschrtSchpCode() {
		NString v = new NString((String)this.getValue("WBSCHRT_SCHP_CODE"));
		return v;
	}
	
	public void setWbschrtSchpCode(NString value) {
		this.setValue("WBSCHRT_SCHP_CODE", value.getValue());
	}

	public NString getWbschrtTermCodeEff() {
		NString v = new NString((String)this.getValue("WBSCHRT_TERM_CODE_EFF"));
		return v;
	}
	
	public void setWbschrtTermCodeEff(NString value) {
		this.setValue("WBSCHRT_TERM_CODE_EFF", value.getValue());
	}

	public NDate getWbschrtAssignDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WBSCHRT_ASSIGN_DATE"));
		return v;
	}
	
	public void setWbschrtAssignDate(NDate value) {
		this.setValue("WBSCHRT_ASSIGN_DATE", value.getValue());
	}

	public NString getWbschrtNotes() {
		NString v = new NString((String)this.getValue("WBSCHRT_NOTES"));
		return v;
	}
	
	public void setWbschrtNotes(NString value) {
		this.setValue("WBSCHRT_NOTES", value.getValue());
	}
	
	public NString getSpridenId() {
		NString v = new NString((String) this.getValue("SPRIDEN_ID"));
		return v;
	}

	public void setSpridenId(NString value) {
		this.setValue("SPRIDEN_ID", value.getValue());
	}

	public NString getStudentName() {
		NString v = new NString((String) this.getValue("STUDENT_NAME"));
		return v;
	}

	public void setStudentName(NString value) {
		this.setValue("STUDENT_NAME", value.getValue());
	}

	public NString getAcceptDate() {
		NString v = new NString((String) this.getValue("ACCEPT_DATE"));
		return v;
	}

	public void setAcceptDate(NString value) {
		this.setValue("ACCEPT_DATE", value.getValue());
	}

	public NString getWbschrtValid() {
		NString v = new NString((java.lang.String) this.getValue("WBSCHRT_VALID"));
		return v;
	}

	public void setWbschrtValid(NString value) {
		this.setValue("WBSCHRT_VALID", value.getValue());
	}

	public java.sql.RowId getROWID() {
		return (java.sql.RowId) this.getValue("ROWID");
	}}