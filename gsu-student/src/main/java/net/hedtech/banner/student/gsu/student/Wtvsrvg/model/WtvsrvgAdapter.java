package net.hedtech.banner.student.gsu.student.Wtvsrvg.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class WtvsrvgAdapter extends BaseRowAdapter {

	public WtvsrvgAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NString getWtvsrvgCode() {
		NString v = new NString((String)this.getValue("WTVSRVG_CODE"));
		return v;
	}
	
	public void setWtvsrvgCode(NString value) {
		this.setValue("WTVSRVG_CODE", value.getValue());
	}

	public NString getWtvsrvgDesc() {
		NString v = new NString((String)this.getValue("WTVSRVG_DESC"));
		return v;
	}
	
	public void setWtvsrvgDesc(NString value) {
		this.setValue("WTVSRVG_DESC", value.getValue());
	}

	public NDate getWtvsrvgActivityDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WTVSRVG_ACTIVITY_DATE"));
		return v;
	}
	
	public void setWtvsrvgActivityDate(NDate value) {
		this.setValue("WTVSRVG_ACTIVITY_DATE", value.getValue());
	}

	
	public java.sql.RowId getROWID() {
		return (java.sql.RowId) this.getValue("ROWID");
	}}