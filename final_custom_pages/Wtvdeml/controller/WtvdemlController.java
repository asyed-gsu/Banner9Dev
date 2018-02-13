package net.hedtech.banner.student.gsu.student.Wtvdeml.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import morphis.foundations.core.types.NDate;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Wtvdeml.WtvdemlTask;
import net.hedtech.banner.student.gsu.student.Wtvdeml.model.WtvdemlAdapter;
import net.hedtech.banner.student.gsu.student.Wtvdeml.model.WtvdemlModel;
import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;
import morphis.foundations.core.appdatalayer.events.BeforeRowInsert;
import morphis.foundations.core.appdatalayer.events.BeforeRowUpdate;

import static morphis.foundations.core.appsupportlib.runtime.TaskServices.getUser;
import static morphis.foundations.core.appsupportlib.Globals.getGlobal;


public class WtvdemlController extends DefaultBlockController {

	public WtvdemlController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WtvdemlTask getTask() {
		return (WtvdemlTask) super.getTask();
	}

	public WtvdemlModel getFormModel() {
		return getTask().getModel();
	}

	@BeforeRowInsert
	public void wtvdeml_BeforeRowInsert(RowAdapterEvent rowAdapterEvent) {
		
		System.out.println("\n***INSDIE WTVDEML_CONTROLLER BEFORE ROW INSERT\n");
		WtvdemlAdapter adapter = (WtvdemlAdapter) rowAdapterEvent.getRow();
		
		adapter.setWtvdemlUserId(getUser());
		adapter.setWtvdemlDataOrigin(getGlobal("DATA_ORIGIN"));
		adapter.setWtvdemlActivityDate(NDate.getNow());
		
		System.out.println("\n***END: WTVDEML_CONTROLLER INSERT DATA\n");
	}

	@BeforeRowUpdate
	public void wtvdeml_BeforeRowUpdate(RowAdapterEvent rowAdapterEvent) {
		
		System.out.println("***INSIDE WTVDEML_CONTROLLER BEFORE ROW UPDATE***");
		WtvdemlAdapter adapter = (WtvdemlAdapter) rowAdapterEvent.getRow();
		
		adapter.setWtvdemlUserId(getUser());
		adapter.setWtvdemlDataOrigin(getGlobal("DATA_ORIGIN"));
		adapter.setWtvdemlActivityDate(NDate.getNow());
		
		System.out.println("\n*** END: WTVDEML_CONTROLLER ROW UPDATE\n");
	}
}