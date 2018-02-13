package net.hedtech.banner.student.gsu.student.Wsaopti.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class WsroptiAdapter extends BaseRowAdapter {

	public WsroptiAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NNumber getWsroptiPidm() {
		NNumber v = new NNumber((java.math.BigDecimal)this.getValue("WSROPTI_PIDM"));
		return v;
	}
	
	public void setWsroptiPidm(NNumber value) {
		this.setValue("WSROPTI_PIDM", value.getValue());
	}

	public NNumber getWsroptiSeq() {
		NNumber v = new NNumber((java.math.BigDecimal)this.getValue("WSROPTI_SEQ"));
		return v;
	}
	
	public void setWsroptiSeq(NNumber value) {
		this.setValue("WSROPTI_SEQ", value.getValue());
	}

	public NString getWsroptiTermCode() {
		NString v = new NString((String)this.getValue("WSROPTI_TERM_CODE"));
		return v;
	}
	
	public void setWsroptiTermCode(NString value) {
		this.setValue("WSROPTI_TERM_CODE", value.getValue());
	}

	public NString getWsroptiFgrpCode() {
		NString v = new NString((String)this.getValue("WSROPTI_FGRP_CODE"));
		return v;
	}
	
	public void setWsroptiFgrpCode(NString value) {
		this.setValue("WSROPTI_FGRP_CODE", value.getValue());
	}

	public NString getWsroptiLevlCode() {
		NString v = new NString((String)this.getValue("WSROPTI_LEVL_CODE"));
		return v;
	}
	
	public void setWsroptiLevlCode(NString value) {
		this.setValue("WSROPTI_LEVL_CODE", value.getValue());
	}

	public NString getWsroptiOption() {
		NString v = new NString((String)this.getValue("WSROPTI_OPTION"));
		return v;
	}
	
	public void setWsroptiOption(NString value) {
		this.setValue("WSROPTI_OPTION", value.getValue());
	}

	public NDate getWsroptiActivityDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WSROPTI_ACTIVITY_DATE"));
		return v;
	}
	
	public void setWsroptiActivityDate(NDate value) {
		this.setValue("WSROPTI_ACTIVITY_DATE", value.getValue());
	}

	public NString getWsroptiUserId() {
		NString v = new NString((String)this.getValue("WSROPTI_USER_ID"));
		return v;
	}
	
	public void setWsroptiUserId(NString value) {
		this.setValue("WSROPTI_USER_ID", value.getValue());
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