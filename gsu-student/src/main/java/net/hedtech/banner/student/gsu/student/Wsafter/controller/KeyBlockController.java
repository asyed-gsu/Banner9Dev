package net.hedtech.banner.student.gsu.student.Wsafter.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.general.common.libraries.Goqolib.services.GCodeClass;
import net.hedtech.banner.student.gsu.student.Wsafter.WsafterTask;
import net.hedtech.banner.student.gsu.student.Wsafter.model.WsafterModel;
import morphis.foundations.core.appsupportlib.runtime.action.*;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import static morphis.foundations.core.types.Types.*;
import static net.hedtech.general.common.forms.services.BaseTaskServices.executeAction;

import morphis.core.utils.behavior.annotations.*;
import morphis.foundations.core.appdatalayer.data.*;
import morphis.foundations.core.appsupportlib.exceptions.ApplicationException;
import net.hedtech.general.common.dbservices.GNls;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.nextBlock;
import static morphis.foundations.core.appsupportlib.runtime.MessageServices.errorMessage;
import morphis.foundations.core.appsupportlib.Lib;
import morphis.foundations.core.appsupportlib.runtime.*;

public class KeyBlockController extends DefaultBlockController {

	private GCodeClass getGCodeClass() {
		return (net.hedtech.general.common.libraries.Goqolib.services.GCodeClass) this.getTask().getTaskPart("GOQOLIB").getSupportCodeManager().getPackage("G$_CODE_CLASS");
	}
	
	public KeyBlockController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WsafterTask getTask() {
		return (WsafterTask) super.getTask();
	}

	public WsafterModel getFormModel() {
		return getTask().getModel();
	}

	@ActionTrigger(action="KEY-NXTBLK", function=KeyFunction.NEXT_BLOCK)
	public void keyBlock_NextBlock()
	{
		nextBlock();
	}

	@ActionTrigger(action="POST-BLOCK", function=KeyFunction.BLOCK_OUT)
	public void keyBlock_blockOut()
	{
		getFormModel().getButtonControlBlock().setCheckKeys(toStr("Y"));
	}
	
	@ActionTrigger(action="G$_SEARCH_PARAMETERS", item="TERM_CODE")
	public void termCode_GSearchParameters()
	{
		
		getGCodeClass().gSearchParameters();
	}
	

	@ActionTrigger(action="G$_SEARCH_OPTIONS", item="TERM_CODE")
	public void termCode_GSearchOptions()
	{
		
			executeAction(KeyFunction.LIST_VALUES);
		}	
}