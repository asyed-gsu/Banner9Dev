package net.hedtech.banner.student.gsu.student.Woalocn.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.general.common.libraries.Goqolib.services.GCodeClass;
import net.hedtech.general.common.libraries.Goqolib.services.GKeyBlockClass;
import net.hedtech.banner.student.gsu.student.Woalocn.WoalocnTask;
import net.hedtech.banner.student.gsu.student.Woalocn.model.WoalocnModel;
import net.hedtech.banner.student.gsu.student.Woalocn.model.WorlocnAdapter;
import morphis.foundations.core.appsupportlib.runtime.action.*;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import morphis.foundations.core.types.NBool;
import morphis.foundations.core.types.NString;

import static morphis.foundations.core.types.Types.*;
import static morphis.foundations.core.util.globals.Globals.setGlobal;
import static net.hedtech.general.common.forms.services.BaseTaskServices.executeAction;

import morphis.core.utils.behavior.annotations.*;
import morphis.foundations.core.appdatalayer.data.*;
import morphis.foundations.core.appsupportlib.exceptions.ApplicationException;
import net.hedtech.general.common.dbservices.GNls;

import static morphis.foundations.core.appsupportlib.Globals.getGlobal;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.nextBlock;
import static morphis.foundations.core.appsupportlib.runtime.MessageServices.errorMessage;
import morphis.foundations.core.appsupportlib.Lib;
import morphis.foundations.core.appsupportlib.runtime.*;
import morphis.foundations.core.appsupportlib.runtime.action.ActionTrigger;
import morphis.foundations.core.appsupportlib.runtime.action.ValidationTrigger;
import static morphis.foundations.core.appsupportlib.runtime.TaskServices.executeQuery; 

public class KeyBlockController extends DefaultBlockController {

	private GKeyBlockClass getGKeyBlockClass() {
		return (net.hedtech.general.common.libraries.Goqolib.services.GKeyBlockClass) this.getTask().getTaskPart("GOQOLIB").getSupportCodeManager().getPackage("G$_KEY_BLOCK_CLASS");
	}
	
	private GCodeClass getGCodeClass() {
		return (net.hedtech.general.common.libraries.Goqolib.services.GCodeClass) this.getTask().getTaskPart("GOQOLIB").getSupportCodeManager().getPackage("G$_CODE_CLASS");
	}
	
	public KeyBlockController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WoalocnTask getTask() {
		return (WoalocnTask) super.getTask();
	}

	public WoalocnModel getFormModel() {
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

	@ActionTrigger(action="G$_SEARCH_PARAMETERS", item="LOCN_CODE")
	public void locnCode_GSearchParameters()
	{
		
		getGCodeClass().gSearchParameters();
	}
	

	@ActionTrigger(action="G$_SEARCH_OPTIONS", item="LOCN_CODE")
	public void locnCode_GSearchOptions()
	{
		
			executeAction(KeyFunction.LIST_VALUES);
		}

	@ValidationTrigger(item = "LOCN_CODE")
	public void locn_code_validation() {
	
		if (getFormModel().getKeyBlock().getLocnCode() != null) {

			int rowCount = 0;

			try {

					NString ptiIntoTemp = NString.getNull();
					String sqlptiCursor = "SELECT WTVLOCN_CODE " + " FROM WTVLOCN "
							+ " WHERE WTVLOCN_CODE = :LOCN_CODE ";
					DataCursor ptiCursor = new DataCursor(sqlptiCursor);
					try {
						// Setting query parameters
						ptiCursor.addParameter("LOCN_CODE", getFormModel().getKeyBlock().getLocnCode());
						ptiCursor.open();
						ResultSet ptiCursorResults = ptiCursor.fetchInto();
						if (ptiCursorResults != null) {
							ptiIntoTemp = ptiCursorResults.getStr(0);
						}

						getTask().getGoqrpls().gCheckValue(toBool(ptiCursor.notFound()),
								GNls.Fget(toStr("WOALOCN-0003"), toStr("FORM"),
										toStr("*ERROR* Invalid Location Code; press LIST for valid codes")),
								toBool(NBool.True));
					} finally {
						ptiCursor.close();
					}

			} catch (ApplicationException e) {
				setGlobal("QUERY_MODE", toStr("0"));
				throw new ApplicationException();
			}
		}		
	}
	
}