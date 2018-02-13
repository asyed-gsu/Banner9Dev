package net.hedtech.banner.student.gsu.student.Wtvooct.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class WtvooctAdapter extends BaseRowAdapter {

	public WtvooctAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NString getWtvooctCode() {
		NString v = new NString((String)this.getValue("WTVOOCT_CODE"));
		return v;
	}
	
	public void setWtvooctCode(NString value) {
		this.setValue("WTVOOCT_CODE", value.getValue());
	}

	public NString getWtvooctDesc() {
		NString v = new NString((String)this.getValue("WTVOOCT_DESC"));
		return v;
	}
	
	public void setWtvooctDesc(NString value) {
		this.setValue("WTVOOCT_DESC", value.getValue());
	}

	public NNumber getWtvooctCompletionRank() {
		NNumber v = new NNumber((java.math.BigDecimal)this.getValue("WTVOOCT_COMPLETION_RANK"));
		return v;
	}
	
	public void setWtvooctCompletionRank(NNumber value) {
		this.setValue("WTVOOCT_COMPLETION_RANK", value.getValue());
	}

	public NString getWtvooctManualInd() {
		NString v = new NString((String)this.getValue("WTVOOCT_MANUAL_IND"));
		return v;
	}
	
	public void setWtvooctManualInd(NString value) {
		this.setValue("WTVOOCT_MANUAL_IND", value.getValue());
	}

	public NString getWtvooctStatusInd() {
		NString v = new NString((String)this.getValue("WTVOOCT_STATUS_IND"));
		return v;
	}
	
	public void setWtvooctStatusInd(NString value) {
		this.setValue("WTVOOCT_STATUS_IND", value.getValue());
	}

	public NDate getWtvooctActivityDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WTVOOCT_ACTIVITY_DATE"));
		return v;
	}
	
	public void setWtvooctActivityDate(NDate value) {
		this.setValue("WTVOOCT_ACTIVITY_DATE", value.getValue());
	}

	public NString getWtvooctUserId() {
		NString v = new NString((String)this.getValue("WTVOOCT_USER_ID"));
		return v;
	}
	
	public void setWtvooctUserId(NString value) {
		this.setValue("WTVOOCT_USER_ID", value.getValue());
	}

	
	public java.sql.RowId getROWID() {
		return (java.sql.RowId) this.getValue("ROWID");
	}}