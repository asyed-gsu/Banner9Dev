package net.hedtech.banner.student.gsu.student.Worschp.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.general.common.libraries.Goqolib.services.GCodeClass;
import net.hedtech.general.common.libraries.Goqolib.services.GKeyBlockClass;
import morphis.foundations.core.appsupportlib.runtime.action.*;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import static morphis.foundations.core.types.Types.*;
import static net.hedtech.general.common.forms.services.BaseTaskServices.executeAction;

import morphis.core.utils.behavior.annotations.*;
import morphis.foundations.core.appdatalayer.data.*;
import morphis.foundations.core.appsupportlib.exceptions.ApplicationException;
import net.hedtech.banner.student.gsu.student.Worschp.WorschpTask;
import net.hedtech.banner.student.gsu.student.Worschp.model.WorschpModel;
import net.hedtech.general.common.dbservices.GNls;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.nextBlock;
import static morphis.foundations.core.appsupportlib.runtime.ItemServices.nextItem;
import static morphis.foundations.core.appsupportlib.runtime.MessageServices.errorMessage;
import static morphis.foundations.core.appsupportlib.runtime.MessageServices.message;
import static morphis.foundations.core.appsupportlib.runtime.TaskServices.goBlock;

import morphis.foundations.core.appsupportlib.Lib;
import morphis.foundations.core.appsupportlib.runtime.*;

public class KeyBlockController extends DefaultBlockController {

	private GKeyBlockClass getGKeyBlockClass() {
		return (net.hedtech.general.common.libraries.Goqolib.services.GKeyBlockClass) this.getTask()
				.getTaskPart("GOQOLIB").getSupportCodeManager().getPackage("G$_KEY_BLOCK_CLASS");
	}

	private GCodeClass getGCodeClass() {
		return (net.hedtech.general.common.libraries.Goqolib.services.GCodeClass) this.getTask().getTaskPart("GOQOLIB")
				.getSupportCodeManager().getPackage("G$_CODE_CLASS");
	}

	public KeyBlockController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WorschpTask getTask() {
		return (WorschpTask) super.getTask();
	}

	public WorschpModel getFormModel() {
		return getTask().getModel();
	}

	@ActionTrigger(action = "KEY-COMMIT", function = KeyFunction.SAVE)
	public void keyBlock_Save() {

		getGKeyBlockClass().save();
	}

	@ActionTrigger(action = "KEY-UP", function = KeyFunction.UP)
	public void keyBlock_MoveUp() {

		getGKeyBlockClass().moveUp();
	}

	@ActionTrigger(action = "KEY-DOWN", function = KeyFunction.DOWN)
	public void keyBlock_MoveDown() {

		getGKeyBlockClass().moveDown();
	}

	@ActionTrigger(action = "KEY-CREREC", function = KeyFunction.CREATE_RECORD)
	public void keyBlock_CreateRecord() {

		getGKeyBlockClass().createRecord();
	}

	@ActionTrigger(action = "KEY-DELREC", function = KeyFunction.DELETE_RECORD)
	public void keyBlock_DeleteRecord() {

		getGKeyBlockClass().deleteRecord();
	}

	@ActionTrigger(action = "KEY-ENTQRY", function = KeyFunction.SEARCH)
	public void keyBlock_Search() {

		getGKeyBlockClass().search();
	}

	@ActionTrigger(action = "KEY-EXEQRY", function = KeyFunction.EXECUTE_QUERY)
	public void keyBlock_ExecuteQuery() {

		getGKeyBlockClass().executeQuery();
	}

	@ActionTrigger(action = "KEY-NXTREC", function = KeyFunction.NEXT_RECORD)
	public void keyBlock_NextRecord() {

		getGKeyBlockClass().nextRecord();
	}

	@ActionTrigger(action = "KEY-NXTSET")
	public void keyBlock_KeyNxtset() {

		getGKeyBlockClass().keyNxtset();
	}

	@ActionTrigger(action = "KEY-PRVREC", function = KeyFunction.PREVIOUS_RECORD)
	public void keyBlock_PreviousRecord() {

		getGKeyBlockClass().previousRecord();
	}
	
	@ActionTrigger(action="POST-BLOCK", function=KeyFunction.BLOCK_OUT)
	public void keyBlock_blockOut()
	{
		
		getGKeyBlockClass().blockOut();
	}
	
	@ActionTrigger(action = "KEY-NXTBLK", function = KeyFunction.NEXT_BLOCK)
	public void keyBlock_NextBlock() {
		getGKeyBlockClass().nextBlock();

	}

	@ActionTrigger(action = "KEY-PRVBLK", function = KeyFunction.PREVIOUS_BLOCK)
	public void keyBlock_PreviousBlock() {
		getGKeyBlockClass().previousBlock();
	}
	
	@ActionTrigger(action="WHEN-NEW-ITEM-INSTANCE", item="TERM_CODE", function=KeyFunction.ITEM_CHANGE)
	public void termCode_itemChange()
	{
		
		getGCodeClass().itemChange();
	}
	
	@ActionTrigger(action = "G$_SEARCH_PARAMETERS", item = "TERM_CODE")
	public void termCode_GSearchParameters() {

		getGCodeClass().gSearchParameters();
	}

	@ActionTrigger(action = "G$_SEARCH_OPTIONS", item = "TERM_CODE")
	public void termCode_GSearchOptions() {

		executeAction(KeyFunction.LIST_VALUES);
	}
	

	@ActionTrigger(action="KEY-NEXT-ITEM", item="TERM_CODE", function=KeyFunction.NEXT_ITEM)
	public void termCode_keyNexItem()
	{
		
			getTask().getGoqrpls().getGSearch().codeKeyNextItem();
			
	}
	

	@ActionTrigger(action="POST-TEXT-ITEM", item="TERM_CODE", function=KeyFunction.ITEM_OUT)
	public void termCode_itemOut()
	{
		
		getGCodeClass().itemOut();
			
		}
	
	@ActionTrigger(action="WHEN-MOUSE-DOUBLECLICK", item="TERM_CODE")
	public void termCode_doubleClick()
	{
		
		getGCodeClass().doubleClick();
	}
	
	@ActionTrigger(action = "G$_SEARCH_PARAMETERS", item = "SCHP_CODE")
	public void schpCode_GSearchParameters() {

		getGCodeClass().gSearchParameters();
	}
	
	@ActionTrigger(action="WHEN-NEW-ITEM-INSTANCE", item="SCHP_CODE", function=KeyFunction.ITEM_CHANGE)
	public void schpCode_itemChange()
	{
		
		getGCodeClass().itemChange();
	}

	@ActionTrigger(action = "G$_SEARCH_OPTIONS", item = "SCHP_CODE")
	public void schpCode_GSearchOptions() {

		executeAction(KeyFunction.LIST_VALUES);
	}
	
	@ActionTrigger(action="KEY-NEXT-ITEM", item="SCHP_CODE", function=KeyFunction.NEXT_ITEM)
	public void schpCode_keyNexItem()
	{
		
			getTask().getGoqrpls().getGSearch().codeKeyNextItem();
			
		}
	
	@ActionTrigger(action="POST-TEXT-ITEM", item="SCHP_CODE", function=KeyFunction.ITEM_OUT)
	public void schpCode_itemOut()
	{
		
		getGCodeClass().itemOut();
			
		}
	
	@ActionTrigger(action="WHEN-MOUSE-DOUBLECLICK", item="SCHP_CODE")
	public void schpCode_doubleClick()
	{
		
		getGCodeClass().doubleClick();
	}
	

}