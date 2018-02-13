package net.hedtech.banner.student.gsu.student.Whacrep.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class WhbcrepAdapter extends BaseRowAdapter {

	public WhbcrepAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NString getWhbcrepSubjCode() {
		NString v = new NString((String)this.getValue("WHBCREP_SUBJ_CODE"));
		return v;
	}
	
	public void setWhbcrepSubjCode(NString value) {
		this.setValue("WHBCREP_SUBJ_CODE", value.getValue());
	}

	public NString getWhbcrepCrseNumb() {
		NString v = new NString((String)this.getValue("WHBCREP_CRSE_NUMB"));
		return v;
	}
	
	public void setWhbcrepCrseNumb(NString value) {
		this.setValue("WHBCREP_CRSE_NUMB", value.getValue());
	}

	public NDate getWhbcrepActivityDate() {
		NDate v = new NDate((java.util.Date)this.getValue("WHBCREP_ACTIVITY_DATE"));
		return v;
	}
	
	public void setWhbcrepActivityDate(NDate value) {
		this.setValue("WHBCREP_ACTIVITY_DATE", value.getValue());
	}

	
	public java.sql.RowId getROWID() {
		return (java.sql.RowId) this.getValue("ROWID");
	}}