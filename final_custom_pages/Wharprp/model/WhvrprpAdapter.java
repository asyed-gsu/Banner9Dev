package net.hedtech.banner.student.gsu.student.Wharprp.model;

import java.util.Date;
import java.math.BigDecimal;
import org.jdesktop.databuffer.DataRow;
//import morphis.foundations.core.appdatalayer.data.BaseRowAdapter;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.flavors.forms.appdatalayer.data.BaseRowAdapter;

public class WhvrprpAdapter extends BaseRowAdapter {

	public WhvrprpAdapter(DataRow row, IDBBusinessObject businessObject) {
		super(row, businessObject);
	}
	
	//Data Columns
	
	public NNumber getWhvrprpPidm() {
		NNumber v = new NNumber((java.math.BigDecimal)this.getValue("WHVRPRP_PIDM"));
		return v;
	}
	
	public void setWhvrprpPidm(NNumber value) {
		this.setValue("WHVRPRP_PIDM", value.getValue());
	}

	public NString getWhvrprpTermCode() {
		NString v = new NString((String)this.getValue("WHVRPRP_TERM_CODE"));
		return v;
	}
	
	public void setWhvrprpTermCode(NString value) {
		this.setValue("WHVRPRP_TERM_CODE", value.getValue());
	}

	public NString getWhvrprpCrn() {
		NString v = new NString((String)this.getValue("WHVRPRP_CRN"));
		return v;
	}
	
	public void setWhvrprpCrn(NString value) {
		this.setValue("WHVRPRP_CRN", value.getValue());
	}

	public NString getWhvrprpSubjCode() {
		NString v = new NString((String)this.getValue("WHVRPRP_SUBJ_CODE"));
		return v;
	}
	
	public void setWhvrprpSubjCode(NString value) {
		this.setValue("WHVRPRP_SUBJ_CODE", value.getValue());
	}

	public NString getWhvrprpCrseNumb() {
		NString v = new NString((String)this.getValue("WHVRPRP_CRSE_NUMB"));
		return v;
	}
	
	public void setWhvrprpCrseNumb(NString value) {
		this.setValue("WHVRPRP_CRSE_NUMB", value.getValue());
	}

	public NString getWhvrprpGrdeCodeFinal() {
		NString v = new NString((String)this.getValue("WHVRPRP_GRDE_CODE_FINAL"));
		return v;
	}
	
	public void setWhvrprpGrdeCodeFinal(NString value) {
		this.setValue("WHVRPRP_GRDE_CODE_FINAL", value.getValue());
	}

	
	public java.sql.RowId getROWID() {
		return (java.sql.RowId) this.getValue("ROWID");
	}}