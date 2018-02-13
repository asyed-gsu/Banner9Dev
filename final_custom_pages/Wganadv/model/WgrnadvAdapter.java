package net.hedtech.banner.student.gsu.student.Wganadv.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class WgrnadvAdapter extends BaseRowAdapter {

	public WgrnadvAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NString getWgrnadvAdvisorEmail() {
		NString v = new NString((String)this.getValue("WGRNADV_ADVISOR_EMAIL"));
		return v;
	}
	
	public void setWgrnadvAdvisorEmail(NString value) {
		this.setValue("WGRNADV_ADVISOR_EMAIL", value.getValue());
	}

	public NDate getWgrnadvActivityDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WGRNADV_ACTIVITY_DATE"));
		return v;
	}
	
	public void setWgrnadvActivityDate(NDate value) {
		this.setValue("WGRNADV_ACTIVITY_DATE", value.getValue());
	}

	
	public java.sql.RowId getROWID() {
		return (java.sql.RowId) this.getValue("ROWID");
	}}