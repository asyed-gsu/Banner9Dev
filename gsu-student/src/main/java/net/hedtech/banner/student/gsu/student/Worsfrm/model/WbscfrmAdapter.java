package net.hedtech.banner.student.gsu.student.Worsfrm.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class WbscfrmAdapter extends BaseRowAdapter {

	public WbscfrmAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NString getWbscfrmSchfCode() {
		NString v = new NString((String)this.getValue("WBSCFRM_SCHF_CODE"));
		return v;
	}
	
	public void setWbscfrmSchfCode(NString value) {
		this.setValue("WBSCFRM_SCHF_CODE", value.getValue());
	}

	public NString getWbscfrmSchpCode() {
		NString v = new NString((String)this.getValue("WBSCFRM_SCHP_CODE"));
		return v;
	}
	
	public void setWbscfrmSchpCode(NString value) {
		this.setValue("WBSCFRM_SCHP_CODE", value.getValue());
	}

	public NString getWbscfrmStartTerm() {
		NString v = new NString((String)this.getValue("WBSCFRM_START_TERM"));
		return v;
	}
	
	public void setWbscfrmStartTerm(NString value) {
		this.setValue("WBSCFRM_START_TERM", value.getValue());
	}

	public NString getWbscfrmEndTerm() {
		NString v = new NString((String)this.getValue("WBSCFRM_END_TERM"));
		return v;
	}
	
	public void setWbscfrmEndTerm(NString value) {
		this.setValue("WBSCFRM_END_TERM", value.getValue());
	}

	public NDate getWbscfrmAssignDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WBSCFRM_ASSIGN_DATE"));
		return v;
	}
	
	public void setWbscfrmAssignDate(NDate value) {
		this.setValue("WBSCFRM_ASSIGN_DATE", value.getValue());
	}

	public NDate getWbscfrmActivityDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WBSCFRM_ACTIVITY_DATE"));
		return v;
	}
	
	public void setWbscfrmActivityDate(NDate value) {
		this.setValue("WBSCFRM_ACTIVITY_DATE", value.getValue());
	}

	
	public java.sql.RowId getROWID() {
		return (java.sql.RowId) this.getValue("ROWID");
	}}