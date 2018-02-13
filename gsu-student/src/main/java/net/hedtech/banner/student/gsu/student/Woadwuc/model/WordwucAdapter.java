package net.hedtech.banner.student.gsu.student.Woadwuc.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class WordwucAdapter extends BaseRowAdapter {

	public WordwucAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NNumber getWordwucPidm() {
		NNumber v = new NNumber((java.math.BigDecimal)this.getValue("WORDWUC_PIDM"));
		return v;
	}
	
	public void setWordwucPidm(NNumber value) {
		this.setValue("WORDWUC_PIDM", value.getValue());
	}

	public NString getWordwucUserClass() {
		NString v = new NString((String)this.getValue("WORDWUC_USER_CLASS"));
		return v;
	}
	
	public void setWordwucUserClass(NString value) {
		this.setValue("WORDWUC_USER_CLASS", value.getValue());
	}

	public NDate getWordwucActivityDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WORDWUC_ACTIVITY_DATE"));
		return v;
	}
	
	public void setWordwucActivityDate(NDate value) {
		this.setValue("WORDWUC_ACTIVITY_DATE", value.getValue());
	}

	public NString getWordwucUser() {
		NString v = new NString((String)this.getValue("WORDWUC_USER"));
		return v;
	}
	
	public void setWordwucUser(NString value) {
		this.setValue("WORDWUC_USER", value.getValue());
	}
	
	public void setId(NString value){
		this.setValue("ID", value.getValue());
	}


	public NString getId(){
		NString v = new NString((String)this.getValue("ID"));
		return v;
	}


	public void setNname(NString value){
		this.setValue("NAME", value.getValue());
	}


	public NString getNname(){
		NString v = new NString((String)this.getValue("NAME"));
		return v;
	}
	
	public void setConfidInfo(NString value){
		this.setValue("CONFID_INFO", value.getValue());
	}


	public NString getConfidInfo(){
		NString v = new NString((String)this.getValue("CONFID_INFO"));
		return v;
	}


	
	
	public void setDeceasedInd(NString value){
		this.setValue("DECEASED_IND", value.getValue());
	}


	public NString getDeceasedInd(){
		NString v = new NString((String)this.getValue("DECEASED_IND"));
		return v;
	}


	
	public java.sql.RowId getROWID() {
		return (java.sql.RowId) this.getValue("ROWID");
	}}