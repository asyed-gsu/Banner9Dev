package net.hedtech.banner.student.gsu.student.Wortrdt.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class WgrtrdtAdapter extends BaseRowAdapter {

	public WgrtrdtAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NString getWgrtrdtTermCode() {
		NString v = new NString((String)this.getValue("WGRTRDT_TERM_CODE"));
		return v;
	}
	
	public void setWgrtrdtTermCode(NString value) {
		this.setValue("WGRTRDT_TERM_CODE", value.getValue());
	}

	public NString getWgrtrdtTrmeCode() {
		NString v = new NString((String)this.getValue("WGRTRDT_TRME_CODE"));
		return v;
	}
	
	public void setWgrtrdtTrmeCode(NString value) {
		this.setValue("WGRTRDT_TRME_CODE", value.getValue());
	}

	public NString getWgrtrdtPtrmCode() {
		NString v = new NString((String)this.getValue("WGRTRDT_PTRM_CODE"));
		return v;
	}
	
	public void setWgrtrdtPtrmCode(NString value) {
		this.setValue("WGRTRDT_PTRM_CODE", value.getValue());
	}

	public NDate getWgrtrdtBeginDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WGRTRDT_BEGIN_DATE"));
		return v;
	}
	
	public void setWgrtrdtBeginDate(NDate value) {
		this.setValue("WGRTRDT_BEGIN_DATE", value.getValue());
	}

	public NDate getWgrtrdtEndDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WGRTRDT_END_DATE"));
		return v;
	}
	
	public void setWgrtrdtEndDate(NDate value) {
		this.setValue("WGRTRDT_END_DATE", value.getValue());
	}

	public NString getWgrtrdtUser() {
		NString v = new NString((String)this.getValue("WGRTRDT_USER"));
		return v;
	}
	
	public void setWgrtrdtUser(NString value) {
		this.setValue("WGRTRDT_USER", value.getValue());
	}

	public NDate getWgrtrdtActivityDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WGRTRDT_ACTIVITY_DATE"));
		return v;
	}
	
	public void setWgrtrdtActivityDate(NDate value) {
		this.setValue("WGRTRDT_ACTIVITY_DATE", value.getValue());
	}

	
	public NString getWtvtrmeDescription() {
		NString v = new NString((String) this.getValue("WTVTRME_DESCRIPTION"));
		return v;
	}

	public void setWtvtrmeDescription(NString value) {
		this.setValue("WTVTRME_DESCRIPTION", value.getValue());
	}

	public NString getStvptrmDescription() {
		NString v = new NString((String) this.getValue("STVPTRM_DESCRIPTION"));
		return v;
	}

	public void setStvptrmDescription(NString value) {
		this.setValue("STVPTRM_DESCRIPTION", value.getValue());
	}

	public NString getUpdateInd() {
		NString v = new NString((String) this.getValue("UPDATE_IND"));
		return v;
	}

	public void setUpdateInd(NString value) {
		this.setValue("UPDATE_IND", value.getValue());
	}

	public java.sql.RowId getROWID() {
		return (java.sql.RowId) this.getValue("ROWID");
	}}