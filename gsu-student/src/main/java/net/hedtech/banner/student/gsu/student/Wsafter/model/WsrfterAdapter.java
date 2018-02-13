package net.hedtech.banner.student.gsu.student.Wsafter.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class WsrfterAdapter extends BaseRowAdapter {

	public WsrfterAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NString getWsrfterTermCode() {
		NString v = new NString((String)this.getValue("WSRFTER_TERM_CODE"));
		return v;
	}
	
	public void setWsrfterTermCode(NString value) {
		this.setValue("WSRFTER_TERM_CODE", value.getValue());
	}

	public NString getWsrfterFgrpCode() {
		NString v = new NString((String)this.getValue("WSRFTER_FGRP_CODE"));
		return v;
	}
	
	public void setWsrfterFgrpCode(NString value) {
		this.setValue("WSRFTER_FGRP_CODE", value.getValue());
	}

	public NString getWsrfterLevlCode() {
		NString v = new NString((String)this.getValue("WSRFTER_LEVL_CODE"));
		return v;
	}
	
	public void setWsrfterLevlCode(NString value) {
		this.setValue("WSRFTER_LEVL_CODE", value.getValue());
	}

	public NDate getWsrfterStartDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WSRFTER_START_DATE"));
		return v;
	}
	
	public void setWsrfterStartDate(NDate value) {
		this.setValue("WSRFTER_START_DATE", value.getValue());
	}

	public NDate getWsrfterEndDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WSRFTER_END_DATE"));
		return v;
	}
	
	public void setWsrfterEndDate(NDate value) {
		this.setValue("WSRFTER_END_DATE", value.getValue());
	}

	public NDate getWsrfterActivityDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WSRFTER_ACTIVITY_DATE"));
		return v;
	}
	
	public void setWsrfterActivityDate(NDate value) {
		this.setValue("WSRFTER_ACTIVITY_DATE", value.getValue());
	}

	public NString getWsrfterUserId() {
		NString v = new NString((String)this.getValue("WSRFTER_USER_ID"));
		return v;
	}
	
	public void setWsrfterUserId(NString value) {
		this.setValue("WSRFTER_USER_ID", value.getValue());
	}

	
	public NString getFgrpDesc() {
		NString v = new NString((String) this.getValue("FGRP_DESC"));
		return v;
	}

	public void setFgrpDesc(NString value) {
		this.setValue("FGRP_DESC", value.getValue());
	}

	public java.sql.RowId getROWID() {
		return (java.sql.RowId) this.getValue("ROWID");
	}}