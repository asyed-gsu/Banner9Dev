package net.hedtech.banner.student.gsu.student.Wharprp.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class ShrtcknAdapter extends BaseRowAdapter {

	public ShrtcknAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NNumber getShrtcknPidm() {
		NNumber v = new NNumber((java.math.BigDecimal)this.getValue("SHRTCKN_PIDM"));
		return v;
	}
	
	public void setShrtcknPidm(NNumber value) {
		this.setValue("SHRTCKN_PIDM", value.getValue());
	}

	public NString getShrtcknTermCode() {
		NString v = new NString((String)this.getValue("SHRTCKN_TERM_CODE"));
		return v;
	}
	
	public void setShrtcknTermCode(NString value) {
		this.setValue("SHRTCKN_TERM_CODE", value.getValue());
	}

	public NString getShrtcknCrn() {
		NString v = new NString((String)this.getValue("SHRTCKN_CRN"));
		return v;
	}
	
	public void setShrtcknCrn(NString value) {
		this.setValue("SHRTCKN_CRN", value.getValue());
	}

	public NString getShrtcknSubjCode() {
		NString v = new NString((String)this.getValue("SHRTCKN_SUBJ_CODE"));
		return v;
	}
	
	public void setShrtcknSubjCode(NString value) {
		this.setValue("SHRTCKN_SUBJ_CODE", value.getValue());
	}

	public NString getShrtcknCrseNumb() {
		NString v = new NString((String)this.getValue("SHRTCKN_CRSE_NUMB"));
		return v;
	}
	
	public void setShrtcknCrseNumb(NString value) {
		this.setValue("SHRTCKN_CRSE_NUMB", value.getValue());
	}

	
	public java.sql.RowId getROWID() {
		return (java.sql.RowId) this.getValue("ROWID");
	}}