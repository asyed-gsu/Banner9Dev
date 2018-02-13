package net.hedtech.banner.student.gsu.student.Wtvschp.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import morphis.foundations.core.types.NDate;
import net.hedtech.banner.student.gsu.student.Wtvschp.WtvschpTask;
import net.hedtech.banner.student.gsu.student.Wtvschp.model.WtvschpAdapter;
import net.hedtech.banner.student.gsu.student.Wtvschp.model.WtvschpModel;
import net.hedtech.banner.student.gsu.student.Wtvsrvg.model.WtvsrvgAdapter;
import net.hedtech.general.common.dbservices.GDate;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;
import morphis.foundations.core.appdatalayer.events.RowUpdate;
import static morphis.foundations.core.types.Types.*;

import static morphis.foundations.core.appsupportlib.Lib.toDate;

import morphis.foundations.core.appdatalayer.data.DataCommand;
import morphis.foundations.core.appdatalayer.events.BeforeRowInsert;
import morphis.foundations.core.appdatalayer.events.BeforeRowUpdate;

public class WtvschpController extends DefaultBlockController {

	public WtvschpController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WtvschpTask getTask() {
		return (WtvschpTask) super.getTask();
	}

	public WtvschpModel getFormModel() {
		return getTask().getModel();
	}

	@BeforeRowInsert
	public void wtvschp_BeforeRowInsert(RowAdapterEvent args) {
		WtvschpAdapter wtvschpElement = (WtvschpAdapter) args.getRow();
		wtvschpElement.setWtvschpDispRule(toStr("TEST_RULE"));
		wtvschpElement.setWtvschpActivityDate(NDate.getNow());
	}

	@BeforeRowUpdate
	public void wtvschp_BeforeRowUpdate(RowAdapterEvent args) {
		WtvschpAdapter wtvschpElement = (WtvschpAdapter) args.getRow();
		wtvschpElement.setWtvschpActivityDate(NDate.getNow());
	}
	
	@RowUpdate
	public void wtvschp_RowUpdate(RowAdapterEvent args) {
		WtvschpAdapter wtvschpElement = (WtvschpAdapter)args.getRow();
		int rowCount =0;
		String sql = "UPDATE WTVSCHP "
                  + " SET WTVSCHP_CODE = :WTVSCHP_CODE, "
                  + " WTVSCHP_DESC = :WTVSCHP_DESC, "    
                  + " WTVSCHP_TYPE = :WTVSCHP_TYPE, "
                  + " WTVSCHP_AMT = :WTVSCHP_AMT, "
                  + " WTVSCHP_YEARS = :WTVSCHP_YEARS, "
                  + " WTVSCHP_PRJCT_ID = :WTVSCHP_PRJCT_ID, "
                  + " WTVSCHP_SCHP_ID = :WTVSCHP_SCHP_ID, "
                  + " WTVSCHP_GPA_REQ = :WTVSCHP_GPA_REQ, "
                  + " WTVSCHP_ACTIVITY_DATE = TO_DATE(:CURRENT_DATE,G$_DATE.GET_NLS_DATE_FORMAT) "
                  + " WHERE WTVSCHP_CODE =:WTVSCHP_CODE ";
		DataCommand command = new DataCommand(sql);
		//Setting query parameters
		command.addParameter("WTVSCHP_CODE", wtvschpElement.getWtvschpCode());
		command.addParameter("WTVSCHP_DESC", wtvschpElement.getWtvschpDesc());
		command.addParameter("WTVSCHP_TYPE", wtvschpElement.getWtvschpType());
		command.addParameter("WTVSCHP_AMT", wtvschpElement.getWtvschpAmt());
		command.addParameter("WTVSCHP_YEARS", wtvschpElement.getWtvschpYears());
		command.addParameter("WTVSCHP_PRJCT_ID", wtvschpElement.getWtvschpPrjctId());
		command.addParameter("WTVSCHP_SCHP_ID", wtvschpElement.getWtvschpSchpId());
		command.addParameter("WTVSCHP_GPA_REQ", wtvschpElement.getWtvschpGpaReq());
		command.addParameter("CURRENT_DATE", NDate.getNow());
		command.addParameter("WTVSCHP_CODE", wtvschpElement.getWtvschpCode());
		rowCount = command.execute();
		
	}
	
	
}