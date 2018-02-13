package net.hedtech.banner.student.gsu.student.Wtvsrvg.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import morphis.foundations.core.types.NDate;
import net.hedtech.banner.student.gsu.student.Wtvsrvg.WtvsrvgTask;
import net.hedtech.banner.student.gsu.student.Wtvsrvg.model.WtvsrvgAdapter;
import net.hedtech.banner.student.gsu.student.Wtvsrvg.model.WtvsrvgModel;
import net.hedtech.banner.student.gsu.student.Wtvsrvy.model.WtvsrvyAdapter;
import net.hedtech.general.common.dbservices.GDate;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;
import morphis.foundations.core.appdatalayer.events.RowUpdate;

import static morphis.foundations.core.appsupportlib.Lib.toDate;
import static morphis.foundations.core.types.Types.*;

import morphis.foundations.core.appdatalayer.data.DataCommand;
import morphis.foundations.core.appdatalayer.events.BeforeRowInsert;
import morphis.foundations.core.appdatalayer.events.BeforeRowUpdate;

public class WtvsrvgController extends DefaultBlockController {

	public WtvsrvgController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WtvsrvgTask getTask() {
		return (WtvsrvgTask) super.getTask();
	}

	public WtvsrvgModel getFormModel() {
		return getTask().getModel();
	}
	
	


	@BeforeRowInsert
	public void wtvsrvg_BeforeRowInsert(RowAdapterEvent args) {
		WtvsrvgAdapter wtvsrvgElement = (WtvsrvgAdapter) args.getRow();
		wtvsrvgElement.setWtvsrvgActivityDate(NDate.getNow());
	}

	@BeforeRowUpdate
	public void wtvsrvg_BeforeRowUpdate(RowAdapterEvent args) {
		WtvsrvgAdapter wtvsrvgElement = (WtvsrvgAdapter) args.getRow();
		wtvsrvgElement.setWtvsrvgActivityDate(NDate.getNow());
	}
	
	
	@RowUpdate
	public void wtvsrvg_RowUpdate(RowAdapterEvent args) {
		WtvsrvgAdapter wtvsrvgElement = (WtvsrvgAdapter)args.getRow();
		int rowCount =0;
		String sql = "UPDATE WTVSRVG "
					+ " SET WTVSRVG_DESC = :WTVSRVG_DESC, "
					+ " WTVSRVG_ACTIVITY_DATE = TO_DATE(:CURRENT_DATE,'DD-MON-YYYY') "
					+ " WHERE 	WTVSRVG_CODE = :WTVSRVG_CODE ";
		DataCommand command = new DataCommand(sql);
		//Setting query parameters
		command.addParameter("WTVSRVG_DESC", wtvsrvgElement.getWtvsrvgDesc());
		command.addParameter("CURRENT_DATE", NDate.getNow());
		command.addParameter("WTVSRVG_CODE", wtvsrvgElement.getWtvsrvgCode());
		rowCount = command.execute();
		
	}
	
}