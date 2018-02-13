package net.hedtech.banner.student.gsu.student.Worsfrm.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import morphis.foundations.core.types.NDate;
import net.hedtech.banner.student.gsu.student.Worsfrm.WorsfrmTask;
import net.hedtech.banner.student.gsu.student.Worsfrm.model.WbscfrmAdapter;
import net.hedtech.banner.student.gsu.student.Worsfrm.model.WorsfrmModel;
import net.hedtech.banner.student.gsu.student.Wtvsrvy.model.WtvsrvyAdapter;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;
import morphis.core.utils.behavior.annotations.After;
import morphis.foundations.core.appdatalayer.data.DataCommand;
import morphis.foundations.core.appdatalayer.events.AfterRowUpdate;
import morphis.foundations.core.appdatalayer.events.BeforeRowInsert;
import morphis.foundations.core.appdatalayer.events.BeforeRowUpdate;
import morphis.foundations.core.appdatalayer.events.RowUpdate;

public class WbscfrmController extends DefaultBlockController {

	public WbscfrmController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WorsfrmTask getTask() {
		return (WorsfrmTask) super.getTask();
	}

	public WorsfrmModel getFormModel() {
		return getTask().getModel();
	}

	@BeforeRowInsert
	public void wbscfrm_BeforeRowInsert(RowAdapterEvent args) {
		WbscfrmAdapter wbscfrmElement = (WbscfrmAdapter) args.getRow();
		wbscfrmElement.setWbscfrmActivityDate(NDate.getNow());
	}

	@BeforeRowUpdate
	public void wbscfrm_BeforeRowUpdate(RowAdapterEvent args) {
		WbscfrmAdapter wbscfrmElement = (WbscfrmAdapter) args.getRow();
		wbscfrmElement.setWbscfrmActivityDate(NDate.getNow());
	}

	@RowUpdate
	public void wbscfrm_RowUpdate(RowAdapterEvent args) {
		WbscfrmAdapter wbscfrmElement = (WbscfrmAdapter)args.getRow();
				String sqlupdate = "update wbscfrm "
				+ " SET WBSCFRM_SCHF_CODE = :WBSCFRM_SCHF_CODE, "
    +"WBSCFRM_SCHP_CODE = :WBSCFRM_SCHP_CODE, "    
     +"WBSCFRM_START_TERM = :WBSCFRM_START_TERM, "
    +"WBSCFRM_END_TERM = :WBSCFRM_END_TERM, "
    +"WBSCFRM_ASSIGN_DATE = :WBSCFRM_ASSIGN_DATE, "
     +"WBSCFRM_ACTIVITY_DATE = :CURRENT_DATE "  
 +"WHERE WBSCFRM_SCHF_CODE = :WBSCFRM_SCHF_CODE "
 +"AND WBSCFRM_SCHP_CODE = :WBSCFRM_SCHP_CODE ";
				DataCommand command = new DataCommand(sqlupdate);
				// Setting query parameters
				command.addParameter("WBSCFRM_SCHF_CODE", wbscfrmElement.getWbscfrmSchfCode());
				command.addParameter("WBSCFRM_SCHP_CODE", wbscfrmElement.getWbscfrmSchpCode());
				command.addParameter("WBSCFRM_START_TERM", wbscfrmElement.getWbscfrmStartTerm());
				command.addParameter("WBSCFRM_END_TERM", wbscfrmElement.getWbscfrmEndTerm());
				command.addParameter("WBSCFRM_ASSIGN_DATE", wbscfrmElement.getWbscfrmAssignDate());
				command.addParameter("CURRENT_DATE", NDate.getNow());
				int rowCount = command.execute();
				this.getLogger().debug(this, "After update row " + wbscfrmElement.getROWID() +
				" WBSCFRM_SCHF_CODE: " + wbscfrmElement.getWbscfrmSchfCode());
	}
	
}