package net.hedtech.banner.student.gsu.student.Wtrtrtt.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.dbservices.GNls;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.general.common.libraries.Goqolib.services.GCodeClass;
import net.hedtech.general.common.libraries.Goqolib.services.GKeyBlockClass;
import morphis.foundations.core.appdatalayer.data.DataCursor;
import morphis.foundations.core.appdatalayer.data.ResultSet;
import morphis.foundations.core.appsupportlib.exceptions.ApplicationException;
import morphis.foundations.core.appsupportlib.runtime.action.*;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import morphis.foundations.core.types.NBool;
import morphis.foundations.core.types.NString;

import static morphis.foundations.core.appsupportlib.runtime.MessageServices.errorMessage;
import static morphis.foundations.core.appsupportlib.runtime.TaskServices.executeQuery;
import static morphis.foundations.core.types.Types.toBool;
import static morphis.foundations.core.types.Types.toStr;
import static net.hedtech.general.common.forms.services.BaseTaskServices.executeAction;

import net.hedtech.banner.student.gsu.student.Wtrtrtt.WtrtrttTask;
import net.hedtech.banner.student.gsu.student.Wtrtrtt.model.WtrtrttModel;
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
	public WtrtrttTask getTask() {
		return (WtrtrttTask) super.getTask();
	}

	public WtrtrttModel getFormModel() {
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
		/*
		getGKeyBlockClass().nextBlock();*/
		
		executeAction("CHECK_KEYS");
		getTask().getGoqrpls().gCheckFailure();
		executeAction("CHECK_LABL_TPRT");
		getTask().getGoqrpls().gCheckFailure();
		/*executeQuery();*/
		getGKeyBlockClass().nextBlock();

	}

	@ActionTrigger(action = "KEY-PRVBLK", function = KeyFunction.PREVIOUS_BLOCK)
	public void keyBlock_PreviousBlock() {
		getGKeyBlockClass().previousBlock();
	}
	
	@ActionTrigger(action="WHEN-NEW-ITEM-INSTANCE", item="KEYBLOCK_LABL_CODE", function=KeyFunction.ITEM_CHANGE)
	public void keyblockLablCode_itemChange()
	{
		
		getGCodeClass().itemChange();
		
	}
	
	@ActionTrigger(action="WHEN-NEW-ITEM-INSTANCE", item="KEYBLOCK_TPRT_CODE", function=KeyFunction.ITEM_CHANGE)
	public void keyblockTprtCode_itemChange()
	{
		
		getGCodeClass().itemChange();
		
	}
	
	
	@ActionTrigger(action = "G$_SEARCH_PARAMETERS", item = "KEYBLOCK_LABL_CODE")
	public void keyblockLABLCode_GSearchParameters() {

		getGCodeClass().gSearchParameters();
	}
	
	
	@ActionTrigger(action = "G$_SEARCH_PARAMETERS", item = "KEYBLOCK_TPRT_CODE")
	public void keyblockTprtCode_GSearchParameters() {

		getGCodeClass().gSearchParameters();
	}
	
	

	@ActionTrigger(action = "G$_SEARCH_OPTIONS", item = "KEYBLOCK_LABL_CODE")
	public void keyblockLablCode_GSearchOptions() {

		executeAction(KeyFunction.LIST_VALUES);
	}
	

	@ActionTrigger(action = "G$_SEARCH_OPTIONS", item = "KEYBLOCK_TPRT_CODE")
	public void keyblockTprtCode_GSearchOptions() {

		executeAction(KeyFunction.LIST_VALUES);
	}

	
	@ActionTrigger(action="KEY-NEXT-ITEM", item="KEYBLOCK_LABL_CODE", function=KeyFunction.NEXT_ITEM)
	public void keyblockLablCode_keyNexItem()
	{
		
			getTask().getGoqrpls().getGSearch().codeKeyNextItem();	
			
	}
	

	@ActionTrigger(action="KEY-NEXT-ITEM", item="KEYBLOCK_TPRT_CODE", function=KeyFunction.NEXT_ITEM)
	public void keyblockTprtCode_keyNexItem()
	{
		
			getTask().getGoqrpls().getGSearch().codeKeyNextItem();	
			
	}
	
	
	@ActionTrigger(action="POST-TEXT-ITEM", item="KEYBLOCK_LABL_CODE", function=KeyFunction.ITEM_OUT)
	public void keyblockLablCode_itemOut()
	{	
		getGCodeClass().itemOut();
		}
		
	@ActionTrigger(action="POST-TEXT-ITEM", item="KEYBLOCK_TPRT_CODE", function=KeyFunction.ITEM_OUT)
	public void keyblockTprtCode_itemOut()
	{	
		getGCodeClass().itemOut();
		}
	
	
	
	@ActionTrigger(action="WHEN-MOUSE-DOUBLECLICK", item="KEYBLOCK_LABL_CODE")
	public void keyblockLablCode_doubleClick()
	{
		
		getGCodeClass().doubleClick();
	}

	@ActionTrigger(action="WHEN-MOUSE-DOUBLECLICK", item="KEYBLOCK_TPRT_CODE")
	public void keyblockTprtCode_doubleClick()
	{
		
		getGCodeClass().doubleClick();
	}

	
	
	@ActionTrigger(item = "KEYBLOCK_LABL_CODE", action = "POST-CHANGE")
	public void keyblock_labl_code_PostChange() {
		int rowCount = 0;
		if(this.getFormModel().getKeyBlock().getKeyblockLablCode().isNull())
								
return;
		{
			String sqlptiCursor = "SELECT WTRTRTT_TPRT_CODE" +
" FROM WTRTRTT " +
" WHERE WTRTRTT_LABL_CODE = :KEYBLOCK_LABL_CODE ";
			DataCursor ptiCursor = new DataCursor(sqlptiCursor);
			try {
				//Setting query parameters
				ptiCursor.addParameter("KEYBLOCK_LABL_CODE", getFormModel().getKeyBlock().getKeyblockLablCode());
				ptiCursor.open();
				ResultSet ptiCursorResults = ptiCursor.fetchInto();
				if ( ptiCursorResults != null ) {
					getFormModel().getKeyBlock().setKeyblockTprtCode(ptiCursorResults.getStr(0));
				}
			}
			finally{
				ptiCursor.close();
			}
		}
		
	}



	@ValidationTrigger(item = "KEYBLOCK_LABL_CODE")
    public void keyblock_labl_code_validation(){
		this.keyblock_labl_code_PostChange();
	}

		
	
	@ActionTrigger(action = "CHECK_LABL_TPRT")
	public void checklabltprt() {
		NString vwtvtrtgcode = NString.getNull();
		String sqlptiCursor = "SELECT WTRTRTT_TPRT_CODE" +
        " FROM WTRTRTT " +
        " WHERE WTRTRTT_LABL_CODE = :KEYBLOCK_LABL_CODE ";
		DataCursor ptiCursor = new DataCursor(sqlptiCursor);
		try {
			// Setting query parameters
			ptiCursor.addParameter("KEYBLOCK_LABL_CODE", getFormModel().getKeyBlock().getKeyblockLablCode());
			ptiCursor.open();
			ResultSet ptiCursorResults = ptiCursor.fetchInto();
			
			if (ptiCursorResults != null) {
				vwtvtrtgcode = ptiCursorResults.getStr(0);
			}
			if (ptiCursor.found() && (vwtvtrtgcode.notEquals(this.getFormModel().getKeyBlock().getKeyblockTprtCode()) ))
			{
											
			errorMessage(GNls.Fget(toStr("WTRTRTT-0001"), toStr("FORM"),toStr("*ERROR* Invalid Code; press LIST for valid codes")));
			throw new ApplicationException();
			} 
			ptiCursor.close();
			
		} 
		finally {
		  ptiCursor.close();
}		

		}
		
	


/*	@ActionTrigger(action="POST-CHANGE", item="KEYBLOCK_LABL_CODE")
	public void keyblockLablCode_PostChange()
	{
		
			int rowCount = 0;
			if(this.getFormModel().getKeyBlock().getKeyblockLablCode().isNull())
									
	return;
			{
				String sqlptiCursor = "SELECT WTRTRTT_TPRT_CODE" +
" FROM WTRTRTT " +
" WHERE WTRTRTT_LABL_CODE = :KEYBLOCK_LABL_CODE ";
				DataCursor ptiCursor = new DataCursor(sqlptiCursor);
				try {
					//Setting query parameters
					ptiCursor.addParameter("KEYBLOCK_LABL_CODE", getFormModel().getKeyBlock().getKeyblockLablCode());
					ptiCursor.open();
					ResultSet ptiCursorResults = ptiCursor.fetchInto();
					if ( ptiCursorResults != null ) {
						getFormModel().getKeyBlock().setKeyblockTprtCode(ptiCursorResults.getStr(0));
					}
				}
				finally{
					ptiCursor.close();
				}
			}
		}*/
	
}