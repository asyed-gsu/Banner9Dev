package net.hedtech.banner.student.gsu.student.Wcascmt.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class WcrscmtAdapter extends BaseRowAdapter {

	public WcrscmtAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NString getWcrscmtTermCode() {
		NString v = new NString((String)this.getValue("WCRSCMT_TERM_CODE"));
		return v;
	}
	
	public void setWcrscmtTermCode(NString value) {
		this.setValue("WCRSCMT_TERM_CODE", value.getValue());
	}

	public NString getWcrscmtSubjCode() {
		NString v = new NString((String)this.getValue("WCRSCMT_SUBJ_CODE"));
		return v;
	}
	
	public void setWcrscmtSubjCode(NString value) {
		this.setValue("WCRSCMT_SUBJ_CODE", value.getValue());
	}

	public NNumber getWcrscmtSeqno() {
		NNumber v = new NNumber((java.math.BigDecimal)this.getValue("WCRSCMT_SEQNO"));
		return v;
	}
	
	public void setWcrscmtSeqno(NNumber value) {
		this.setValue("WCRSCMT_SEQNO", value.getValue());
	}

	public NString getWcrscmtText() {
		NString v = new NString((String)this.getValue("WCRSCMT_TEXT"));
		return v;
	}
	
	public void setWcrscmtText(NString value) {
		this.setValue("WCRSCMT_TEXT", value.getValue());
	}

	public NDate getWcrscmtActivityDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WCRSCMT_ACTIVITY_DATE"));
		return v;
	}
	
	public void setWcrscmtActivityDate(NDate value) {
		this.setValue("WCRSCMT_ACTIVITY_DATE", value.getValue());
	}

	
	public java.sql.RowId getROWID() {
		return (java.sql.RowId) this.getValue("ROWID");
	}}