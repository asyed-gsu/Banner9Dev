package net.hedtech.banner.student.gsu.student.Wtrtrtt.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class WtrtrttAdapter extends BaseRowAdapter {

	public WtrtrttAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NString getWtrtrttLablCode() {
		NString v = new NString((String)this.getValue("WTRTRTT_LABL_CODE"));
		return v;
	}
	
	public void setWtrtrttLablCode(NString value) {
		this.setValue("WTRTRTT_LABL_CODE", value.getValue());
	}

	public NString getWtrtrttTprtCode() {
		NString v = new NString((String)this.getValue("WTRTRTT_TPRT_CODE"));
		return v;
	}
	
	public void setWtrtrttTprtCode(NString value) {
		this.setValue("WTRTRTT_TPRT_CODE", value.getValue());
	}

	public NString getWtrtrttTrtgCode() {
		NString v = new NString((String)this.getValue("WTRTRTT_TRTG_CODE"));
		return v;
	}
	
	public void setWtrtrttTrtgCode(NString value) {
		this.setValue("WTRTRTT_TRTG_CODE", value.getValue());
	}

	public NString getWtrtrttTrtgValue() {
		NString v = new NString((String)this.getValue("WTRTRTT_TRTG_VALUE"));
		return v;
	}
	
	public void setWtrtrttTrtgValue(NString value) {
		this.setValue("WTRTRTT_TRTG_VALUE", value.getValue());
	}

	public NString getWtrtrttReqInd() {
		NString v = new NString((String)this.getValue("WTRTRTT_REQ_IND"));
		return v;
	}
	
	public void setWtrtrttReqInd(NString value) {
		this.setValue("WTRTRTT_REQ_IND", value.getValue());
	}

	public NString getWtrtrttCreateUser() {
		NString v = new NString((String)this.getValue("WTRTRTT_CREATE_USER"));
		return v;
	}
	
	public void setWtrtrttCreateUser(NString value) {
		this.setValue("WTRTRTT_CREATE_USER", value.getValue());
	}

	public NDate getWtrtrttCreateDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WTRTRTT_CREATE_DATE"));
		return v;
	}
	
	public void setWtrtrttCreateDate(NDate value) {
		this.setValue("WTRTRTT_CREATE_DATE", value.getValue());
	}

	public NString getWtrtrttUser() {
		NString v = new NString((String)this.getValue("WTRTRTT_USER"));
		return v;
	}
	
	public void setWtrtrttUser(NString value) {
		this.setValue("WTRTRTT_USER", value.getValue());
	}

	public NDate getWtrtrttActivityDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WTRTRTT_ACTIVITY_DATE"));
		return v;
	}
	
	public void setWtrtrttActivityDate(NDate value) {
		this.setValue("WTRTRTT_ACTIVITY_DATE", value.getValue());
	}

	public NString getWtrtrttDataOrigin() {
		NString v = new NString((String)this.getValue("WTRTRTT_DATA_ORIGIN"));
		return v;
	}
	
	public void setWtrtrttDataOrigin(NString value) {
		this.setValue("WTRTRTT_DATA_ORIGIN", value.getValue());
	}

	
	public java.sql.RowId getROWID() {
		return (java.sql.RowId) this.getValue("ROWID");
	}}