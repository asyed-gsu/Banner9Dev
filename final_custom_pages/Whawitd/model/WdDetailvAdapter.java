package net.hedtech.banner.student.gsu.student.Whawitd.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class WdDetailvAdapter extends BaseRowAdapter {

	public WdDetailvAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NNumber getWdDetailvPidm() {
		NNumber v = new NNumber((java.math.BigDecimal)this.getValue("WD_DETAILV_PIDM"));
		return v;
	}
	
	public void setWdDetailvPidm(NNumber value) {
		this.setValue("WD_DETAILV_PIDM", value.getValue());
	}

	public NString getWdDetailvTermCode() {
		NString v = new NString((String)this.getValue("WD_DETAILV_TERM_CODE"));
		return v;
	}
	
	public void setWdDetailvTermCode(NString value) {
		this.setValue("WD_DETAILV_TERM_CODE", value.getValue());
	}

	public NString getWdDetailvCrn() {
		NString v = new NString((String)this.getValue("WD_DETAILV_CRN"));
		return v;
	}
	
	public void setWdDetailvCrn(NString value) {
		this.setValue("WD_DETAILV_CRN", value.getValue());
	}

	public NString getWdDetailvSubjCode() {
		NString v = new NString((String)this.getValue("WD_DETAILV_SUBJ_CODE"));
		return v;
	}
	
	public void setWdDetailvSubjCode(NString value) {
		this.setValue("WD_DETAILV_SUBJ_CODE", value.getValue());
	}

	public NString getWdDetailvCrseNumb() {
		NString v = new NString((String)this.getValue("WD_DETAILV_CRSE_NUMB"));
		return v;
	}
	
	public void setWdDetailvCrseNumb(NString value) {
		this.setValue("WD_DETAILV_CRSE_NUMB", value.getValue());
	}

	public NString getWdDetailvRstsCode() {
		NString v = new NString((String)this.getValue("WD_DETAILV_RSTS_CODE"));
		return v;
	}
	
	public void setWdDetailvRstsCode(NString value) {
		this.setValue("WD_DETAILV_RSTS_CODE", value.getValue());
	}

	public NDate getWdDetailvRstsDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WD_DETAILV_RSTS_DATE"));
		return v;
	}
	
	public void setWdDetailvRstsDate(NDate value) {
		this.setValue("WD_DETAILV_RSTS_DATE", value.getValue());
	}

	
	public NString getWdDetailvLevlCode() {
		NString v = new NString((String) this.getValue("WD_DETAILV_LEVL_CODE"));
		return v;
	}

	public void setWdDetailvLevlCode(NString value) {
		this.setValue("WD_DETAILV_LEVL_CODE", value.getValue());
	}

	public java.sql.RowId getROWID() {
		return (java.sql.RowId) this.getValue("ROWID");
	}}