package net.hedtech.banner.student.gsu.student.Whacrep.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import morphis.foundations.core.types.NDate;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Whacrep.WhacrepTask;
import net.hedtech.banner.student.gsu.student.Whacrep.model.WhacrepModel;
import net.hedtech.banner.student.gsu.student.Whacrep.model.WhbcrepAdapter;
import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;
import morphis.foundations.core.appdatalayer.events.BeforeRowInsert;
import morphis.foundations.core.appdatalayer.events.BeforeRowUpdate;

public class WhbcrepController extends DefaultBlockController {

	public WhbcrepController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WhacrepTask getTask() {
		return (WhacrepTask) super.getTask();
	}

	public WhacrepModel getFormModel() {
		return getTask().getModel();
	}

	@BeforeRowInsert
	public void whbcrep_BeforeRowInsert(RowAdapterEvent rowAdapterEvent) {
		WhbcrepAdapter whbcrepAdapter = (WhbcrepAdapter)rowAdapterEvent.getRow();
		whbcrepAdapter.setWhbcrepActivityDate(NDate.getNow());
	}

	@BeforeRowUpdate
	public void whbcrep_BeforeRowUpdate(RowAdapterEvent rowAdapterEvent) {
		WhbcrepAdapter whbcrepAdapter = (WhbcrepAdapter) rowAdapterEvent.getRow();
		whbcrepAdapter.setWhbcrepActivityDate(NDate.getNow());
	}
	
}