package net.hedtech.banner.student.gsu.student.Wortrdt.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.general.common.libraries.Goqolib.services.GCodeClass;
import net.hedtech.general.common.libraries.Goqolib.services.GKeyBlockClass;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import morphis.foundations.core.types.NBool;

import static morphis.foundations.core.types.Types.*;
import static net.hedtech.general.common.forms.services.BaseTaskServices.executeAction;

import morphis.foundations.core.appdatalayer.data.*;
import net.hedtech.banner.student.gsu.student.Wortrdt.WortrdtTask;
import net.hedtech.banner.student.gsu.student.Wortrdt.model.WortrdtModel;
import net.hedtech.general.common.dbservices.GNls;
import morphis.foundations.core.appsupportlib.runtime.action.ActionTrigger;

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
	public WortrdtTask getTask() {
		return (WortrdtTask) super.getTask();
	}

	public WortrdtModel getFormModel() {
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
	
	@ActionTrigger(action="WHEN-NEW-ITEM-INSTANCE", item="STVTERM_CODE", function=KeyFunction.ITEM_CHANGE)
	public void stvtermCode_itemChange()
	{
		
		getGCodeClass().itemChange();
	}
	
	@ActionTrigger(action = "G$_SEARCH_PARAMETERS", item = "STVTERM_CODE")
	public void stvtermCode_GSearchParameters() {

		getGCodeClass().gSearchParameters();
	}

	@ActionTrigger(action = "G$_SEARCH_OPTIONS", item = "STVTERM_CODE")
	public void stvtermCode_GSearchOptions() {

		executeAction(KeyFunction.LIST_VALUES);
	}
	

	@ActionTrigger(action="KEY-NEXT-ITEM", item="STVTERM_CODE", function=KeyFunction.NEXT_ITEM)
	public void stvtermCode_keyNexItem()
	{
		
			getTask().getGoqrpls().getGSearch().codeKeyNextItem();
			
	}
	

	@ActionTrigger(action="POST-TEXT-ITEM", item="STVTERM_CODE", function=KeyFunction.ITEM_OUT)
	public void stvtermCode_itemOut()
	{
		
		getGCodeClass().itemOut();
			
		}
	
	@ActionTrigger(action="WHEN-MOUSE-DOUBLECLICK", item="STVTERM_CODE")
	public void stvtermCode_doubleClick()
	{
		
		getGCodeClass().doubleClick();
	}
	
	/*
	 *  DECLARE
      CURSOR PTI_CURSOR IS
         SELECT STVTERM_DESC
         FROM   STVTERM
         WHERE  STVTERM_CODE = :STVTERM_CODE ;
   BEGIN
      OPEN PTI_CURSOR ;
      FETCH PTI_CURSOR INTO :STVTERM_DESC ;
      G$_CHECK_VALUE (PTI_CURSOR%NOTFOUND,
          G$_NLS.Get('WORTRDT-0001', 'FORM','Invalid Term Code Entered.') , TRUE);
   END ;
	 */

	@ActionTrigger(item = "STVTERM_CODE", action = "stvterm_code_postChange")
	public void stvterm_code_postChange() {
		
	
			String ptiCursorSql = "SELECT STVTERM_DESC "
        + "FROM   STVTERM "
        + "WHERE  STVTERM_CODE = :STVTERM_CODE";
			
			DataCursor ptiCursor = new DataCursor(ptiCursorSql);
			
			try{
				ptiCursor.addParameter("STVTERM_CODE", this.getFormModel().getKeyBlock().getStvtermCode());
				ptiCursor.open();
			
			ResultSet ptiCursorResults = ptiCursor.fetchInto();
			if(ptiCursorResults != null){
				this.getFormModel().getKeyBlock().setStvtermDesc(ptiCursorResults.getStr(0));
				getTask().getGoqrpls().gCheckValue(ptiCursor.notFound(), GNls.Fget("WORTRDT-0001", "FORM","Invalid Term Code Entered.") , toBool(NBool.True));
			}
			}finally{
				ptiCursor.close();
			}
		}
	}
