package net.hedtech.banner.student.gsu.student.Wtvschf.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import morphis.foundations.core.types.NDate;
import net.hedtech.banner.student.gsu.student.Wtvschf.WtvschfTask;
import net.hedtech.banner.student.gsu.student.Wtvschf.model.WtvschfAdapter;
import net.hedtech.banner.student.gsu.student.Wtvschf.model.WtvschfModel;
import net.hedtech.banner.student.gsu.student.Wtvschp.model.WtvschpAdapter;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;
import morphis.foundations.core.appdatalayer.events.RowUpdate;
import morphis.foundations.core.appdatalayer.data.DataCommand;
import morphis.foundations.core.appdatalayer.events.BeforeRowInsert;
import morphis.foundations.core.appdatalayer.events.BeforeRowUpdate;

public class WtvschfController extends DefaultBlockController {

	public WtvschfController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WtvschfTask getTask() {
		return (WtvschfTask) super.getTask();
	}

	public WtvschfModel getFormModel() {
		return getTask().getModel();
	}

	@BeforeRowUpdate
	public void wtvschf_BeforeRowUpdate(RowAdapterEvent args) {
		
		WtvschfAdapter wtvschfElement = (WtvschfAdapter) args.getRow();
		wtvschfElement.setWtvschfActivityDate(NDate.getNow());
	}
	
	@BeforeRowInsert
	public void wtvschf_BeforeRowInsert(RowAdapterEvent args) {
		
		WtvschfAdapter wtvschfElement = (WtvschfAdapter) args.getRow();
		wtvschfElement.setWtvschfActivityDate(NDate.getNow());
	}
	
	@RowUpdate
	public void wtvschf_RowUpdate(RowAdapterEvent args) {
		WtvschfAdapter wtvschfElement = (WtvschfAdapter)args.getRow();
		int rowCount =0;
		String sql = "UPDATE WTVSCHF "
					+ "SET WTVSCHF_CODE = :WTVSCHF_CODE, "
					+ " WTVSCHF_DESC = :WTVSCHF_DESC, "
					+ " WTVSCHF_FREQUENCY = :WTVSCHF_FREQUENCY, "    
					+ " WTVSCHF_ACTIVITY_DATE = TO_DATE(:CURRENT_DATE,G$_DATE.GET_NLS_DATE_FORMAT) "
					+ " WHERE WTVSCHF_CODE =:WTVSCHF_CODE ";
		DataCommand command = new DataCommand(sql);
		//Setting query parameters
		command.addParameter("WTVSCHF_CODE", wtvschfElement.getWtvschfCode());
		command.addParameter("WTVSCHF_DESC", wtvschfElement.getWtvschfDesc());
		command.addParameter("WTVSCHF_FREQUENCY", wtvschfElement.getWtvschfFrequency());
		command.addParameter("CURRENT_DATE", NDate.getNow());
		command.addParameter("WTVSCHF_CODE", wtvschfElement.getWtvschfCode());
		rowCount = command.execute();
		
	}
	
}