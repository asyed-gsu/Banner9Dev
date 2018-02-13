package net.hedtech.banner.student.gsu.student.Worapts.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class WoraptsAdapter extends BaseRowAdapter {

	public WoraptsAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NString getWoraptsApTesc() {
		NString v = new NString((String)this.getValue("WORAPTS_AP_TESC"));
		return v;
	}
	
	public void setWoraptsApTesc(NString value) {
		this.setValue("WORAPTS_AP_TESC", value.getValue());
	}

	public NString getWoraptsApTtile() {
		NString v = new NString((String)this.getValue("WORAPTS_AP_TTILE"));
		return v;
	}
	
	public void setWoraptsApTtile(NString value) {
		this.setValue("WORAPTS_AP_TTILE", value.getValue());
	}

	public NString getWoraptsApScore() {
		NString v = new NString((String)this.getValue("WORAPTS_AP_SCORE"));
		return v;
	}
	
	public void setWoraptsApScore(NString value) {
		this.setValue("WORAPTS_AP_SCORE", value.getValue());
	}

	public NString getWoraptsGsuSubj() {
		NString v = new NString((String)this.getValue("WORAPTS_GSU_SUBJ"));
		return v;
	}
	
	public void setWoraptsGsuSubj(NString value) {
		this.setValue("WORAPTS_GSU_SUBJ", value.getValue());
	}

	public NString getWoraptsGsuCrseNumb() {
		NString v = new NString((String)this.getValue("WORAPTS_GSU_CRSE_NUMB"));
		return v;
	}
	
	public void setWoraptsGsuCrseNumb(NString value) {
		this.setValue("WORAPTS_GSU_CRSE_NUMB", value.getValue());
	}

	public NString getWoraptsGsuTitle() {
		NString v = new NString((String)this.getValue("WORAPTS_GSU_TITLE"));
		return v;
	}
	
	public void setWoraptsGsuTitle(NString value) {
		this.setValue("WORAPTS_GSU_TITLE", value.getValue());
	}

	public NString getWoraptsGsuHrs() {
		NString v = new NString((String)this.getValue("WORAPTS_GSU_HRS"));
		return v;
	}
	
	public void setWoraptsGsuHrs(NString value) {
		this.setValue("WORAPTS_GSU_HRS", value.getValue());
	}

	
	public java.sql.RowId getROWID() {
		return (java.sql.RowId) this.getValue("ROWID");
	}}