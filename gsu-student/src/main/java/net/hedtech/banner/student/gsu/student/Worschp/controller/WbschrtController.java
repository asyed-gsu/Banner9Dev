package net.hedtech.banner.student.gsu.student.Worschp.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import morphis.foundations.core.appsupportlib.runtime.action.*;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import morphis.foundations.core.types.NBool;
import morphis.foundations.core.types.NNumber;
import morphis.foundations.core.types.NString;
import morphis.foundations.core.util.profile.UserProfileServices;

import static morphis.foundations.core.types.Types.*;
import morphis.core.utils.behavior.annotations.*;
import morphis.foundations.core.appdatalayer.data.*;
import morphis.foundations.core.appdatalayer.events.AfterQuery;
import morphis.foundations.core.appdatalayer.events.BeforeQuery;
import morphis.foundations.core.appdatalayer.events.QueryEvent;
import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;
import morphis.foundations.core.appsupportlib.exceptions.ApplicationException;
import morphis.foundations.core.appsupportlib.model.IDBBusinessObject;
import net.hedtech.banner.student.gsu.student.Worschp.WorschpTask;
import net.hedtech.banner.student.gsu.student.Worschp.model.*;
import net.hedtech.general.common.dbservices.GNls;

import static morphis.foundations.core.appsupportlib.Lib.toChar;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.nextBlock;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.setBlockWhereClause;
import static morphis.foundations.core.appsupportlib.runtime.MessageServices.errorMessage;
import morphis.foundations.core.appsupportlib.Lib;
import morphis.foundations.core.appsupportlib.runtime.*;

public class WbschrtController extends DefaultBlockController {

	public WbschrtController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WorschpTask getTask() {
		return (WorschpTask) super.getTask();
	}

	public WorschpModel getFormModel() {
		return getTask().getModel();
	}

	@After
	@ActionTrigger(action = "PRE-BLOCK", function = KeyFunction.BLOCK_IN)
	public void wbschrt_blockIn() {
		// TODO to be filled by the user
	}

	/*
	 * Original PL/SQL code code for TRIGGER WBSCHRT.POST-QUERY DECLARE PIDM
	 * NUMBER(8); FORM_PIDM NUMBER(8);
	 * 
	 * cursor get_student_name is Select spriden_pidm, spriden_id,
	 * spriden_last_name ||', '||spriden_first_name ||' '|| spriden_mi from
	 * spriden where spriden_pidm = :wbschrt_pidm and spriden_change_ind is
	 * null;
	 * 
	 * cursor get_acpt_date is select wbstfrm_pidm, min(wbstfrm_acpt_date) from
	 * wbstfrm, wbschrt where wbstfrm_schp_code = :key_schp_code and
	 * wbstfrm_term_code = :key_term_code and wbstfrm_pidm = wbschrt_pidm and
	 * wbstfrm_pidm = PIDM and wbstfrm_acpt_date is not null group by
	 * wbstfrm_pidm;
	 * 
	 * Begin
	 * 
	 * open get_student_name; Fetch get_student_name into PIDM, :spriden_id,
	 * :student_name; close get_student_name;
	 * 
	 * open get_acpt_date; Fetch get_acpt_date into FORM_PIDM, :ACCEPT_DATE; if
	 * get_acpt_date%NOTFOUND then :ACCEPT_DATE := ''; end if; close
	 * get_acpt_date;
	 * 
	 * END;
	 */
	/*
	 * <p> <b>Migration Comments</b> Generated from trigger: WBSCHRT.POST-QUERY
	 *
	 *
	 * </p>
	 * 
	 * @param args
	 */

	@AfterQuery
	public void wbschrt_AfterQuery(RowAdapterEvent args) {

		WbschrtAdapter wbschrtElement = (WbschrtAdapter) args.getRow();
		NString PIDM = NString.getNull();
		NString formPidm = NString.getNull();

		String sqlgetStudentName = "SELECT spriden_pidm, spriden_id, spriden_last_name ||', '||spriden_first_name ||' '|| spriden_mi "
				+ "from spriden where spriden_pidm = :wbschrt_pidm and spriden_change_ind is null";

		String sqlgetAcptDate = "select wbstfrm_pidm, min(wbstfrm_acpt_date) from wbstfrm, wbschrt"
				+ " where wbstfrm_schp_code = :key_schp_code and"
				+ " wbstfrm_term_code = :key_term_code and wbstfrm_pidm = wbschrt_pidm and wbstfrm_pidm = :PIDM"
				+ " and wbstfrm_acpt_date is not null group by wbstfrm_pidm";

		DataCursor getStudentNameCursor = new DataCursor(sqlgetStudentName);
		try {

			getStudentNameCursor.addParameter("wbschrt_pidm", wbschrtElement.getWbschrtPidm());
			getStudentNameCursor.open();
			ResultSet getStudentNameResult = getStudentNameCursor.fetchInto();
			if (getStudentNameResult != null) {
				PIDM = getStudentNameResult.getStr(0);
				wbschrtElement.setSpridenId(getStudentNameResult.getStr(1));
				wbschrtElement.setStudentName(getStudentNameResult.getStr(2));

			}
			getTask().getGoqrpls().gCheckValue(getStudentNameCursor.notFound(), GNls.Fget(toStr("WBSCHRT-0001"),
					toStr("FORM"), toStr("*ERROR* Invalid code, press LIST for valid codes.")), toBool(NBool.True));

		} finally {
			getStudentNameCursor.close();
		}

		DataCursor getAcptDateCursor = new DataCursor(sqlgetAcptDate);
		try {
			getAcptDateCursor.addParameter("key_schp_code", this.getFormModel().getKeyBlock().getSchpCode());
			getAcptDateCursor.addParameter("key_term_code", this.getFormModel().getKeyBlock().getTermCode());
			getAcptDateCursor.addParameter("PIDM", wbschrtElement.getWbschrtPidm());
			getAcptDateCursor.open();
			ResultSet getAcptDateCursorResult = getAcptDateCursor.fetchInto();
			if (getAcptDateCursorResult != null) {
				wbschrtElement.setAcceptDate(getAcptDateCursorResult.getStr(1));
			}
		} finally {
			getAcptDateCursor.close();
		}

	}

	/*
	 * Select spriden_last_name ||', '||spriden_first_name ||' '|| spriden_mi
	 * into :student_name from spriden where spriden_id = :spriden_id and
	 * spriden_change_ind is null;
	 */

	@ActionTrigger(action = "KEY-NXTBLK", item = "STUDENT_NAME")
	public void wbschrt_NextBlock() {
		WbschrtAdapter wbschrtElement = (WbschrtAdapter) this.getFormModel().getWbschrt().getRowAdapter(true);

		String str = "Select spriden_last_name ||', '||spriden_first_name ||' '|| spriden_mi "
				+ "from spriden where spriden_id = :spriden_id " + "and spriden_change_ind is null ";

		DataCursor strCursor = new DataCursor(str);
		try {
			strCursor.addParameter("spriden_id", wbschrtElement.getSpridenId());
			strCursor.open();
			ResultSet strCursorResult = strCursor.fetchInto();
			if (strCursorResult != null) {
				wbschrtElement.setStudentName(strCursorResult.getStr(0));
			}
		} finally {
			strCursor.close();
		}
	}

	@BeforeQuery
	public void wbschrt_BeforeQuery(QueryEvent args) {
		// F2J_WARNING : Query Parameters initialization. Make sure that all the
		// query parameters are properly initialized
		WbschrtAdapter wbschrtElement = (WbschrtAdapter) this.getFormModel().getWbschrt().getRowAdapter();
		setBlockWhereClause("WBSCHRT", "WHERE wbschrt_term_code_eff = :term_code AND wbschrt_schp_code = :schp_code");
		((IDBBusinessObject) args.getSource()).getSelectCommandParams().add(DbManager.getDataBaseFactory()
				.createDataParameter("term_code", this.getFormModel().getKeyBlock().getTermCode()));
		((IDBBusinessObject) args.getSource()).getSelectCommandParams().add(DbManager.getDataBaseFactory()
				.createDataParameter("schp_code", this.getFormModel().getKeyBlock().getSchpCode()));

	}

}