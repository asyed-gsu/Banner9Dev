package net.hedtech.banner.student.gsu.student.Wtrtrhl.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class WtrtrhlAdapter extends BaseRowAdapter {

	public WtrtrhlAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NString getWtrtrhlTrtgCode() {
		NString v = new NString((String)this.getValue("WTRTRHL_TRTG_CODE"));
		return v;
	}
	
	public void setWtrtrhlTrtgCode(NString value) {
		this.setValue("WTRTRHL_TRTG_CODE", value.getValue());
	}

	public NString getWtrtrhlTrtgValue() {
		NString v = new NString((String)this.getValue("WTRTRHL_TRTG_VALUE"));
		return v;
	}
	
	public void setWtrtrhlTrtgValue(NString value) {
		this.setValue("WTRTRHL_TRTG_VALUE", value.getValue());
	}

	public NString getWtrtrhlHoldGrdeInd() {
		NString v = new NString((String)this.getValue("WTRTRHL_HOLD_GRDE_IND"));
		return v;
	}
	
	public void setWtrtrhlHoldGrdeInd(NString value) {
		this.setValue("WTRTRHL_HOLD_GRDE_IND", value.getValue());
	}

	public NString getWtrtrhlHoldDegrInd() {
		NString v = new NString((String)this.getValue("WTRTRHL_HOLD_DEGR_IND"));
		return v;
	}
	
	public void setWtrtrhlHoldDegrInd(NString value) {
		this.setValue("WTRTRHL_HOLD_DEGR_IND", value.getValue());
	}

	public NString getWtrtrhlCreateUser() {
		NString v = new NString((String)this.getValue("WTRTRHL_CREATE_USER"));
		return v;
	}
	
	public void setWtrtrhlCreateUser(NString value) {
		this.setValue("WTRTRHL_CREATE_USER", value.getValue());
	}

	public NDate getWtrtrhlCreateDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WTRTRHL_CREATE_DATE"));
		return v;
	}
	
	public void setWtrtrhlCreateDate(NDate value) {
		this.setValue("WTRTRHL_CREATE_DATE", value.getValue());
	}

	public NString getWtrtrhlUser() {
		NString v = new NString((String)this.getValue("WTRTRHL_USER"));
		return v;
	}
	
	public void setWtrtrhlUser(NString value) {
		this.setValue("WTRTRHL_USER", value.getValue());
	}

	public NDate getWtrtrhlActivityDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WTRTRHL_ACTIVITY_DATE"));
		return v;
	}
	
	public void setWtrtrhlActivityDate(NDate value) {
		this.setValue("WTRTRHL_ACTIVITY_DATE", value.getValue());
	}

	
	public java.sql.RowId getROWID() {
		return (java.sql.RowId) this.getValue("ROWID");
	}}