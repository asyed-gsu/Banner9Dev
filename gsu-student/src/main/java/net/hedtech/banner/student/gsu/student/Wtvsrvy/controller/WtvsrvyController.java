package net.hedtech.banner.student.gsu.student.Wtvsrvy.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import morphis.foundations.core.types.NDate;
import net.hedtech.banner.student.gsu.student.Wtvsrvy.WtvsrvyTask;
import net.hedtech.banner.student.gsu.student.Wtvsrvy.model.WtvsrvyAdapter;
import net.hedtech.banner.student.gsu.student.Wtvsrvy.model.WtvsrvyModel;
import net.hedtech.general.common.dbservices.GDate;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;
import morphis.foundations.core.appdatalayer.data.DataCommand;
import morphis.foundations.core.appdatalayer.events.BeforeRowInsert;
import morphis.foundations.core.appdatalayer.events.BeforeRowUpdate;

import static morphis.foundations.core.appsupportlib.Lib.toDate;
import static morphis.foundations.core.types.Types.*;
import morphis.foundations.core.appdatalayer.events.RowUpdate;

public class WtvsrvyController extends DefaultBlockController {

	public WtvsrvyController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WtvsrvyTask getTask() {
		return (WtvsrvyTask) super.getTask();
	}

	public WtvsrvyModel getFormModel() {
		return getTask().getModel();
	}

	@BeforeRowInsert
	public void wtvsrvy_BeforeRowInsert(RowAdapterEvent args) {
		WtvsrvyAdapter wtvsrvyElement = (WtvsrvyAdapter)args.getRow();
		wtvsrvyElement.setWtvsrvyActivityDate(NDate.getNow());
		wtvsrvyElement.setWtvsrvyType(toStr("SEIP"));
				
	}

	@BeforeRowUpdate
	public void wtvsrvy_BeforeRowUpdate(RowAdapterEvent args) {
		WtvsrvyAdapter wtvsrvyElement = (WtvsrvyAdapter)args.getRow();
		wtvsrvyElement.setWtvsrvyActivityDate(NDate.getNow());
		wtvsrvyElement.setWtvsrvyType(toStr("SEIP"));
	}

	@RowUpdate
	public void wtvsrvy_RowUpdate(RowAdapterEvent args) {
		WtvsrvyAdapter wtvsrvyElement = (WtvsrvyAdapter)args.getRow();
		int rowCount =0;
		String sql = "UPDATE WTVSRVY "
                   + " SET 	WTVSRVY_DESC = :WTVSRVY_DESC, "
                   + " WTVSRVY_TYPE = :WTVSRVY_TYPE, "
     		       + " WTVSRVY_ACTIVITY_DATE = TO_DATE(:CURRENT_DATE,'DD-MON-YYYY') "
                   + " WHERE 	WTVSRVY_CODE = :WTVSRVY_CODE ";
		DataCommand command = new DataCommand(sql);
		//Setting query parameters
		command.addParameter("WTVSRVY_DESC", wtvsrvyElement.getWtvsrvyDesc());
		command.addParameter("WTVSRVY_TYPE", wtvsrvyElement.getWtvsrvyType());
		command.addParameter("CURRENT_DATE", NDate.getNow());
		command.addParameter("WTVSRVY_CODE", wtvsrvyElement.getWtvsrvyCode());
		rowCount = command.execute();
		
	}
	
	
	
}