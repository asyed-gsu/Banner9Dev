package net.hedtech.banner.student.gsu.student.Wtvfgrp.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class WtvfgrpAdapter extends BaseRowAdapter {

	public WtvfgrpAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NString getWtvfgrpCode() {
		NString v = new NString((String)this.getValue("WTVFGRP_CODE"));
		return v;
	}
	
	public void setWtvfgrpCode(NString value) {
		this.setValue("WTVFGRP_CODE", value.getValue());
	}

	public NString getWtvfgrpLevlCode() {
		NString v = new NString((String)this.getValue("WTVFGRP_LEVL_CODE"));
		return v;
	}
	
	public void setWtvfgrpLevlCode(NString value) {
		this.setValue("WTVFGRP_LEVL_CODE", value.getValue());
	}

	public NString getWtvfgrpDesc() {
		NString v = new NString((String)this.getValue("WTVFGRP_DESC"));
		return v;
	}
	
	public void setWtvfgrpDesc(NString value) {
		this.setValue("WTVFGRP_DESC", value.getValue());
	}

	public NDate getWtvfgrpActivityDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WTVFGRP_ACTIVITY_DATE"));
		return v;
	}
	
	public void setWtvfgrpActivityDate(NDate value) {
		this.setValue("WTVFGRP_ACTIVITY_DATE", value.getValue());
	}

	public NString getWtvfgrpUserId() {
		NString v = new NString((String)this.getValue("WTVFGRP_USER_ID"));
		return v;
	}
	
	public void setWtvfgrpUserId(NString value) {
		this.setValue("WTVFGRP_USER_ID", value.getValue());
	}

	
	public java.sql.RowId getROWID() {
		return (java.sql.RowId) this.getValue("ROWID");
	}}