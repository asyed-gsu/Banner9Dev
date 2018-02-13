package net.hedtech.banner.student.gsu.student.Wsaopti.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.general.common.libraries.Goqolib.services.GIdClass;
import net.hedtech.banner.student.gsu.student.Wsaopti.WsaoptiTask;
import net.hedtech.banner.student.gsu.student.Wsaopti.model.WsaoptiModel;
import morphis.foundations.core.appsupportlib.runtime.action.*;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import morphis.foundations.core.types.NBool;
import morphis.foundations.core.types.NNumber;
import morphis.foundations.core.types.NString;
import morphis.foundations.core.util.Ref;

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

/*	private GIdClass getGIdClass() {
		return (net.hedtech.general.common.libraries.Goqolib.services.GIdClass) this.getTask().getTaskPart("GOQOLIB").getSupportCodeManager().getPackage("G$_ID_CLASS");
	}*/
	
	public KeyBlockController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WsaoptiTask getTask() {
		return (WsaoptiTask) super.getTask();
	}

	public WsaoptiModel getFormModel() {
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
		
			getTask().getGoqrpls().gCheckValue(!(!getFormModel().getKeyBlock().getPidm().isNull() && !getFormModel().getKeyBlock().getId().isNull()), GNls.Fget(toStr("WSAOPTI-0004"), toStr("FORM"), toStr("*ERROR* A valid ID must be entered before proceeding.")), toBool(NBool.True), toBool(NBool.True));
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
	
/*	@ActionTrigger(action="POST-CHANGE", item="ID")
	public void id_PostChange()
	{
		
		getGIdClass().postChange();
	}*/
	
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
			ptiCursor.open();
			ResultSet ptiCursorResults = ptiCursor.fetchInto();
			if (ptiCursorResults != null) {
				this.getFormModel().getKeyBlock().setPidm(ptiCursorResults.getNumber(0));	
				this.getFormModel().getKeyBlock().setStudentName(ptiCursorResults.getStr(1));
			}

			getTask().getGoqrpls().gCheckValue(toBool(ptiCursor.notFound()),
					GNls.Fget(toStr("WSAOPTI-0001"), toStr("FORM"),
							toStr("*ERROR* Invalid ID; press LIST for valid codes")),
					toBool(NBool.True));
		} finally {
			ptiCursor.close();
		}
		
		
	}	
}