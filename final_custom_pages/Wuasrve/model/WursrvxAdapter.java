package net.hedtech.banner.student.gsu.student.Wuasrve.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class WursrvxAdapter extends BaseRowAdapter {

	public WursrvxAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NNumber getWursrvxSrvyId() {
		NNumber v = new NNumber((java.math.BigDecimal)this.getValue("WURSRVX_SRVY_ID"));
		return v;
	}
	
	public void setWursrvxSrvyId(NNumber value) {
		this.setValue("WURSRVX_SRVY_ID", value.getValue());
	}

	public NString getWursrvxSrvyTermCode() {
		NString v = new NString((String)this.getValue("WURSRVX_SRVY_TERM_CODE"));
		return v;
	}
	
	public void setWursrvxSrvyTermCode(NString value) {
		this.setValue("WURSRVX_SRVY_TERM_CODE", value.getValue());
	}

	public NString getWursrvxCrn() {
		NString v = new NString((String)this.getValue("WURSRVX_CRN"));
		return v;
	}
	
	public void setWursrvxCrn(NString value) {
		this.setValue("WURSRVX_CRN", value.getValue());
	}

	public NString getWursrvxGroupCode() {
		NString v = new NString((String)this.getValue("WURSRVX_GROUP_CODE"));
		return v;
	}
	
	public void setWursrvxGroupCode(NString value) {
		this.setValue("WURSRVX_GROUP_CODE", value.getValue());
	}

	public NDate getWursrvxActivityDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WURSRVX_ACTIVITY_DATE"));
		return v;
	}
	
	public void setWursrvxActivityDate(NDate value) {
		this.setValue("WURSRVX_ACTIVITY_DATE", value.getValue());
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