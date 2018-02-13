package net.hedtech.banner.student.gsu.student.Whawitd.controller;

import static morphis.foundations.core.appsupportlib.runtime.BlockServices.nextBlock;
import static morphis.foundations.core.appsupportlib.runtime.TaskServices.executeQuery;
import static morphis.foundations.core.types.Types.toStr;

import morphis.foundations.core.appdatalayer.data.DbManager;
import morphis.foundations.core.appdatalayer.events.AfterQuery;
import morphis.foundations.core.appdatalayer.events.BeforeQuery;
import morphis.foundations.core.appdatalayer.events.QueryEvent;
import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;
import morphis.foundations.core.appsupportlib.model.IDBBusinessObject;
import morphis.foundations.core.appsupportlib.runtime.action.ActionTrigger;
import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import morphis.foundations.core.types.NNumber;
import morphis.foundations.core.types.NString;
import morphis.foundations.core.util.Ref;
import net.hedtech.banner.student.gsu.student.Whawitd.WhawitdTask;
import net.hedtech.banner.student.gsu.student.Whawitd.model.SumTot;
import net.hedtech.banner.student.gsu.student.Whawitd.model.WhawitdModel;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Whawitd.services.*;

public class SumTotController extends DefaultBlockController {

	public SumTotController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WhawitdTask getTask() {
		return (WhawitdTask) super.getTask();
	}

	public WhawitdModel getFormModel() {
		return getTask().getModel();
	}
	
	@ActionTrigger(action = "WHEN_NEW_BLOCK_INSTANCE_TRG")
	public void Whawitd_WhenNewBlockInstanceTrigger(){
		
		NString levl = WhawitdServices.fGetGtvsdaxWdstterm(this.getFormModel().getKeyBlock().getKeyblckLevlCode());
		
		NString levl1 = this.getFormModel().getKeyBlock().getKeyblckLevlCode();
		
		System.out.println("TEST");
		
		getTask().getServices().pPWdProcess(this.getFormModel().getKeyBlock().getPidm(), levl1,
				toStr("S"),levl,toStr("999999"));
		
		nextBlock();
		executeQuery();
		
	}
	
	
}