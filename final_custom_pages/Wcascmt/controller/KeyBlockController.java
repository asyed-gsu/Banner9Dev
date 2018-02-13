package net.hedtech.banner.student.gsu.student.Wcascmt.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.general.common.libraries.Goqolib.services.GCodeClass;
import net.hedtech.general.common.libraries.Goqolib.services.GKeyBlockClass;
import morphis.foundations.core.appsupportlib.runtime.action.*;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import morphis.foundations.core.types.NBool;
import morphis.foundations.core.types.NString;

import static morphis.foundations.core.types.Types.*;
import static net.hedtech.general.common.forms.services.BaseTaskServices.executeAction;

import morphis.core.utils.behavior.annotations.*;
import morphis.foundations.core.appdatalayer.data.*;
import morphis.foundations.core.appsupportlib.exceptions.ApplicationException;
import net.hedtech.banner.student.gsu.student.Wcascmt.WcascmtTask;
import net.hedtech.banner.student.gsu.student.Wcascmt.model.WcascmtModel;
import net.hedtech.general.common.dbservices.GNls;

import static morphis.foundations.core.appsupportlib.Globals.getGlobal;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.nextBlock;
import static morphis.foundations.core.appsupportlib.runtime.MessageServices.errorMessage;
import morphis.foundations.core.appsupportlib.Lib;
import morphis.foundations.core.appsupportlib.runtime.*;
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
	public WcascmtTask getTask() {
		return (WcascmtTask) super.getTask();
	}

	public WcascmtModel getFormModel() {
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
	
	@ActionTrigger(action = "KEY-NXTBLK", function = KeyFunction.NEXT_BLOCK)
	public void keyBlock_NextBlock() {
		getGKeyBlockClass().nextBlock();

	}

	@ActionTrigger(action = "KEY-PRVBLK", function = KeyFunction.PREVIOUS_BLOCK)
	public void keyBlock_PreviousBlock() {
		getGKeyBlockClass().previousBlock();
	}
	
	@ActionTrigger(action = "KEY-DUP-ITEM")
	public void keyBlock_KeyDupItem() {

		executeAction("INVALID_FUNCTION_MSG");
		getTask().getGoqrpls().gCheckFailure();
	}
	
	@ActionTrigger(action = "KEY-DUPREC")
	public void keyBlock_KeyDuprec() {

		executeAction("INVALID_FUNCTION_MSG");
		getTask().getGoqrpls().gCheckFailure();
	}
	
	@ActionTrigger(action = "CRN_COPY")
	public void keyBlock_CrnCopy() {

		getFormModel().getKeyBlock().setKeyblockTermCode(getGlobal("KEYBLOCK_TERM_CODE"));
	}
	
	@ActionTrigger(action="WHEN-MOUSE-DOUBLECLICK", item="KEYBLOCK_TERM_CODE")
	public void keyblock_TermCode_doubleClick()
	{
		
		getGCodeClass().doubleClick();
	}
	
	/*
	 *    DECLARE
      PTI_INTO_TEMP        VARCHAR2(255);
      CURSOR PTI_CURSOR IS
         SELECT 'X'
         FROM   STVTERM
         WHERE  STVTERM_CODE = :KEY_TERM_CODE ;
   BEGIN
      OPEN PTI_CURSOR ;
      FETCH PTI_CURSOR INTO PTI_INTO_TEMP ;
      G$_CHECK_VALUE (PTI_CURSOR%NOTFOUND,
'*ERROR* Invalid code; press LIST for valid code', TRUE);
   END ;
	 */

	@ActionTrigger(item = "KEYBLOCK_TERM_CODE", action = "keyblock_term_code_postChange")
	public void keyblock_term_code_postChange() {
		
			NString PtiIntoTemp = NString.getNull();
		
			String ptiCursorSql = " SELECT 'X' "
         + " FROM   STVTERM "
         + " WHERE  STVTERM_CODE = :KEYBLOCK_TERM_CODE";
			
			DataCursor ptiCursor = new DataCursor(ptiCursorSql);
			
			try{
				ptiCursor.addParameter("KEYBLOCK_TERM_CODE", this.getFormModel().getKeyBlock().getKeyblockTermCode());
				ptiCursor.open();
			
			ResultSet ptiCursorResults = ptiCursor.fetchInto();
			if(ptiCursorResults != null){
				PtiIntoTemp = ptiCursorResults.getStr(0);
				getTask().getGoqrpls().gCheckValue(ptiCursor.notFound(), toStr("*ERROR* Invalid code; press LIST for valid code") , toBool(NBool.True));
			}
			}finally{
				ptiCursor.close();
			}
		}
	
	@ActionTrigger(action="WHEN-MOUSE-DOUBLECLICK", item="KEYBLOCK_SUBJ_CODE")
	public void keyblock_SubjCode_doubleClick()
	{
		
		getGCodeClass().doubleClick();
	}
	
	/*
	 *       DECLARE
      CURSOR PTI_CURSOR IS
         SELECT STVSUBJ_DESC
         FROM   STVSUBJ
         WHERE  STVSUBJ_CODE = :KEY_SUBJ ;
   BEGIN
      OPEN PTI_CURSOR ;
      FETCH PTI_CURSOR INTO :SUBJ_DESCRIPTION ;
      G$_CHECK_VALUE (PTI_CURSOR%NOTFOUND,
'*ERROR* Invalid code, press LIST for valid codes.', TRUE);
   END ;
	 */

	@ActionTrigger(item = "KEYBLOCK_SUBJ_CODE", action = "keyblock_subj_code_postChange")
	public void keyblock_subj_code_postChange() {
		
			NString PtiIntoTemp = NString.getNull();
		
			String ptiCursorSql = "  SELECT STVSUBJ_DESC "
        + " FROM   STVSUBJ "
        + " WHERE  STVSUBJ_CODE = :KEYBLOCK_SUBJ_CODE";
			
			DataCursor ptiCursor = new DataCursor(ptiCursorSql);
			
			try{
				ptiCursor.addParameter("KEYBLOCK_SUBJ_CODE", this.getFormModel().getKeyBlock().getKeyblockSubjCode());
				ptiCursor.open();
			
			ResultSet ptiCursorResults = ptiCursor.fetchInto();
			if(ptiCursorResults != null){
				PtiIntoTemp = ptiCursorResults.getStr(0);
				getTask().getGoqrpls().gCheckValue(ptiCursor.notFound(), toStr("*ERROR* Invalid code, press LIST for valid codes.") , toBool(NBool.True));
			}
			}finally{
				ptiCursor.close();
			}
		}
	
	@ActionTrigger(item = "KEYBLOCK_SUBJ_DESC", action="WHEN-NEW-ITEM-INSTANCE", function=KeyFunction.ITEM_CHANGE)
	public void keyblock_subjCode_itemChange()
	{
		getGCodeClass().itemChange();
	}

	
}