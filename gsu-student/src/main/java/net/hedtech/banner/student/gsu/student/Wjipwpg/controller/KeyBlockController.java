package net.hedtech.banner.student.gsu.student.Wjipwpg.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Wjipwpg.WjipwpgTask;
import net.hedtech.banner.student.gsu.student.Wjipwpg.model.WjipwpgModel;
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
import static morphis.foundations.core.appsupportlib.runtime.ItemServices.nextItem;
import static morphis.foundations.core.appsupportlib.runtime.MessageServices.errorMessage;
import morphis.foundations.core.appsupportlib.Lib;
import morphis.foundations.core.appsupportlib.runtime.*;

public class KeyBlockController extends DefaultBlockController {

	public KeyBlockController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WjipwpgTask getTask() {
		return (WjipwpgTask) super.getTask();
	}

	public WjipwpgModel getFormModel() {
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
	
    /* added the following controllers */
	@ActionTrigger(action="CHECK_KEYS")
	public void keyBlock_CheckKeys()
	{
		
			getTask().getGoqrpls().gCheckValue(!(!getFormModel().getKeyBlock().getPidm().isNull() && !getFormModel().getKeyBlock().getId().isNull()), GNls.Fget(toStr("WJIPWPG-0004"), toStr("FORM"), toStr("*ERROR* A valid ID must be entered before proceeding.")), toBool(NBool.True), toBool(NBool.True));
	}
	
	@ActionTrigger(action="KEY-LISTVAL", item="ID", function=KeyFunction.LIST_VALUES)
	public void id_ListValues()
	{
		
			getTask().getGoqrpls().gCopyFldAttr();
			setGlobal("SECRFRM", toStr("SOAIDEN"));
			executeAction("G$_REVOKE_ACCESS");
			getTask().getGoqrpls().gCheckFailure();
			getTask().getGoqrpls().gSecuredFormCall(getGlobal("CURRENT_USER"), getGlobal("SECRFRM"), toStr("QUERY"));
			getTask().getGoqrpls().gResetGlobal();
			// 
			if ( !getGlobal("VALUE").isNull() )
			{
				executeAction("LIST_VALUES_COPY");
				getTask().getGoqrpls().gCheckFailure();
			}
			// 
			getTask().getGoqrpls().gCheckValue(((getFormModel().getKeyBlock().getId().isNull())), toStr(null), toBool(NBool.True), toBool(NBool.True));
			// 
			nextItem();
	}
	
	@ValidationTrigger(item="ID")
	public void id_validate()
	{
		
		NString ptiIntoTemp = NString.getNull();
		String sqlptiCursor = "SELECT spriden_pidm, spriden_last_name||', '||spriden_first_name FROM spriden "
				+ " WHERE spriden_id = :ID and spriden_change_ind is null ";
		DataCursor ptiCursor = new DataCursor(sqlptiCursor);
		try {
			// Setting query parameters
			ptiCursor.addParameter("ID", this.getFormModel().getKeyBlock().getId());
			System.out.println(this.getFormModel().getKeyBlock().getId());		
			ptiCursor.open();
			ResultSet ptiCursorResults = ptiCursor.fetchInto();
			if (ptiCursorResults != null) {
				System.out.println(ptiCursorResults.getNumber(0));	
				System.out.println(ptiCursorResults.getStr(1));				
				this.getFormModel().getKeyBlock().setPidm(ptiCursorResults.getNumber(0));	
				this.getFormModel().getKeyBlock().setStudentName(ptiCursorResults.getStr(1));
			}

			getTask().getGoqrpls().gCheckValue(toBool(ptiCursor.notFound()),
					GNls.Fget(toStr("WJIPWPG-0001"), toStr("FORM"),
							toStr("*ERROR* Invalid ID; press LIST for valid codes")),
					toBool(NBool.True));
		} finally {
			ptiCursor.close();
		}
		
		
	}	
	
	
}