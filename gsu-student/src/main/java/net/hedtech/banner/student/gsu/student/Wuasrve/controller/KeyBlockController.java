package net.hedtech.banner.student.gsu.student.Wuasrve.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.general.common.libraries.Goqolib.services.GCodeClass;
import net.hedtech.banner.student.gsu.student.Wuasrve.WuasrveTask;
import net.hedtech.banner.student.gsu.student.Wuasrve.model.WuasrveModel;
import net.hedtech.banner.student.gsu.student.Wuasrve.model.WursrveAdapter;
import morphis.foundations.core.appsupportlib.runtime.action.*;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import morphis.foundations.core.types.NBool;
import morphis.foundations.core.types.NString;

import static morphis.foundations.core.types.Types.*;
import static morphis.foundations.core.util.globals.Globals.setGlobal;
import static net.hedtech.general.common.forms.services.BaseTaskServices.*;
import static net.hedtech.general.common.forms.services.BaseTaskServices.executeAction;

import morphis.core.utils.behavior.annotations.*;
import morphis.foundations.core.appdatalayer.data.*;
import morphis.foundations.core.appsupportlib.exceptions.ApplicationException;
import net.hedtech.general.common.dbservices.GNls;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.nextBlock;
import static morphis.foundations.core.appsupportlib.runtime.MessageServices.errorMessage;
import static morphis.foundations.core.appsupportlib.runtime.TaskServices.executeQuery;

import morphis.foundations.core.appsupportlib.Lib;
import morphis.foundations.core.appsupportlib.runtime.*;

public class KeyBlockController extends DefaultBlockController {

	public KeyBlockController(IFormController parentController, String name) {
		super(parentController, name);
	}

	// added this class
	private GCodeClass getGCodeClass() {
		return (net.hedtech.general.common.libraries.Goqolib.services.GCodeClass) this.getTask().getTaskPart("GOQOLIB").getSupportCodeManager().getPackage("G$_CODE_CLASS");
	}

	@Override
	public WuasrveTask getTask() {
		return (WuasrveTask) super.getTask();
	}

	public WuasrveModel getFormModel() {
		return getTask().getModel();
	}

	// Modified the following trigger to include the code in Banner 8 - KEY-NXTBLK 
	/*
	   DECLARE
	      CURSOR PTI_CURSOR IS
	         SELECT WUBSRVY_ID
	         FROM   WUBSRVY
	         WHERE  WUBSRVY_CODE = :KEY_SRVY
	           AND  :KEY_TERM_CODE BETWEEN WUBSRVY_TERM_CODE_START AND WUBSRVY_TERM_CODE_END ;
	   BEGIN
	      OPEN PTI_CURSOR ;
	      FETCH PTI_CURSOR INTO :KEY_SRVY_ID ;
	      G$_CHECK_VALUE (PTI_CURSOR%NOTFOUND, '*ERROR* Invalid term' ||
	         ' for survey, press LIST for valid' ||
	         ' codes.', TRUE);
	   END ;
	   
	  NEXT_BLOCK ;
	*/	
	@ActionTrigger(action="KEY-NXTBLK", function=KeyFunction.NEXT_BLOCK)
	public void keyBlock_NextBlock()
	{
		NString ptiIntoTemp= NString.getNull();
		String sqlptiCursor = "SELECT WUBSRVY_ID " +
             "FROM   WUBSRVY " +
             "WHERE  WUBSRVY_CODE = :KEY_SRVY " +
             "   AND  :KEY_TERM_CODE BETWEEN WUBSRVY_TERM_CODE_START AND WUBSRVY_TERM_CODE_END";

		DataCursor ptiCursor = new DataCursor(sqlptiCursor);
		try {
			//Setting query parameters
			ptiCursor.addParameter("KEY_SRVY", this.getFormModel().getKeyBlock().getSrvyCode());
			ptiCursor.addParameter("KEY_TERM_CODE", this.getFormModel().getKeyBlock().getTermCode());

			//F2J_WARNING : Make sure that the method "Close" is being called over the variable ptiCursor.
			ptiCursor.open();
			ResultSet ptiCursorResults = ptiCursor.fetchInto();
			if ( ptiCursorResults != null ) {
				ptiIntoTemp = ptiCursorResults.getStr(0);
				this.getFormModel().getKeyBlock().setSrvyId(ptiIntoTemp);
			}
			getTask().getGoqrpls().gCheckValue(ptiCursor.notFound(), toStr("*ERROR* Invalid term for survey, press LIST for valid codes.."), toBool(NBool.True));
		}
		finally{
			ptiCursor.close();
		}	
		
		getTask().getGoqrpls().gCheckFailure();		
		nextBlock();
		executeQuery();
		nextBlock();
		executeQuery();
		goBlock(toStr("WURSRVE"));
		
	}

	@ActionTrigger(action="POST-BLOCK", function=KeyFunction.BLOCK_OUT)
	public void keyBlock_blockOut()
	{
		getFormModel().getButtonControlBlock().setCheckKeys(toStr("Y"));
	}

	//Added triggers below
	@ActionTrigger(action="KEY-PRVBLK", function=KeyFunction.PREVIOUS_BLOCK)
	public void keyBlock_PrevBlock()
	{
		NString ptiIntoTemp= NString.getNull();
		String sqlptiCursor = "SELECT WUBSRVY_ID " +
             "FROM   WUBSRVY " +
             "WHERE  WUBSRVY_CODE = :KEY_SRVY " +
             "   AND  :KEY_TERM_CODE BETWEEN WUBSRVY_TERM_CODE_START AND WUBSRVY_TERM_CODE_END";

		DataCursor ptiCursor = new DataCursor(sqlptiCursor);
		try {
			//Setting query parameters
			ptiCursor.addParameter("KEY_SRVY", this.getFormModel().getKeyBlock().getSrvyCode());
			ptiCursor.addParameter("KEY_TERM_CODE", this.getFormModel().getKeyBlock().getTermCode());

			//F2J_WARNING : Make sure that the method "Close" is being called over the variable ptiCursor.
			ptiCursor.open();
			ResultSet ptiCursorResults = ptiCursor.fetchInto();
			if ( ptiCursorResults != null ) {
				ptiIntoTemp = ptiCursorResults.getStr(0);
			}
			getTask().getGoqrpls().gCheckValue(ptiCursor.notFound(), toStr("*ERROR* Invalid term for survey, press LIST for valid codes.."), toBool(NBool.True));
		}
		finally{
			ptiCursor.close();
		}	
		
		getTask().getGoqrpls().gCheckFailure();		
		nextBlock();
		executeQuery();
		nextBlock();
		executeQuery();
		goBlock(toStr("WURSRVE"));
		
	}	
	
	@ActionTrigger(action="G$_SEARCH_PARAMETERS", item="SRVY_CODE")
	public void srvyCode_GSearchParameters()
	{
		
		getGCodeClass().gSearchParameters();
	}
	

	@ActionTrigger(action="G$_SEARCH_OPTIONS", item="SRVY_CODE")
	public void srvyCode_GSearchOptions()
	{
		
			executeAction(KeyFunction.LIST_VALUES);
	}

	
	
}