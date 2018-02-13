package net.hedtech.banner.student.gsu.student.Wharprp.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Wharprp.WharprpTask;
import net.hedtech.banner.student.gsu.student.Wharprp.model.WharprpModel;
import morphis.foundations.core.appsupportlib.runtime.action.*;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import morphis.foundations.core.types.NBool;
import morphis.foundations.core.types.NNumber;
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
import morphis.foundations.core.appsupportlib.runtime.action.ActionTrigger;
import morphis.foundations.core.appsupportlib.runtime.action.ValidationTrigger;

public class KeyBlockController extends DefaultBlockController {

	public KeyBlockController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WharprpTask getTask() {
		return (WharprpTask) super.getTask();
	}

	public WharprpModel getFormModel() {
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
	
	@ActionTrigger(action = "CHECK_KEYS")
	public void keyBlock_CheckKeys() {

		getTask().getGoqrpls().gCheckValue(
				
				!(!getFormModel().getKeyBlock().getPidm().isNull() && !getFormModel().getKeyBlock().getId().isNull()),
				GNls.Fget(toStr("WHARPRP-0004"), toStr("FORM"),
						toStr("*ERROR* A valid ID must be entered before proceeding.")),
				toBool(NBool.True), toBool(NBool.True));
	}
	
	//this method brings up the screen and allow to choose ID from a drop down menu (SOAIDEN)
	@ActionTrigger(action="KEY-LISTVAL", item = "ID", function = KeyFunction.LIST_VALUES)
	public void id_KeyAction_list_values() {
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

	@ValidationTrigger(item = "ID")
	public void id_validation() {
		NString nsring = NString.getNull();
		String query = "SELECT spriden_pidm, spriden_last_name||', '||spriden_first_name FROM spriden "
				+ " WHERE spriden_id = :ID and spriden_change_ind is null ";
		
		DataCursor dataCursor = new DataCursor(query);
		
		try{
			dataCursor.addParameter("ID", this.getFormModel().getKeyBlock().getId());
			dataCursor.open();
			ResultSet resultSet = dataCursor.fetchInto();
			if(resultSet != null)
			{
				
				this.getFormModel().getKeyBlock().setPidm(resultSet.getNumber(0));
				this.getFormModel().getKeyBlock().setStudentName(resultSet.getStr(1));
			}
			
			getTask().getGoqrpls().gCheckValue(toBool(dataCursor.notFound()), GNls.Fget(toStr("WHARPRP-0001"),
					toStr("FORM"), toStr("*ERROR* Invalid ID; press LIST for valid codes")), toBool(NBool.True));
			
		}finally {
			dataCursor.close();
		}
	}
	
	/*@ValidationTrigger(item = "ID_LBT")*/
/*	@ValidationTrigger(item = "ID")
	public void id_lbt_validation() {
		
		NString nsring = NString.getNull();
		String query = "SELECT spriden_pidm, spriden_last_name||', '||spriden_first_name FROM spriden "
				+ " WHERE spriden_id = :ID and spriden_change_ind is null ";
		
		DataCursor dataCursor = new DataCursor(query);
		
		try{
			dataCursor.addParameter("ID", this.getFormModel().getKeyBlock().getId());
			dataCursor.open();
			ResultSet resultSet = dataCursor.fetchInto();
			if(resultSet != null)
			{
				NNumber pidm = resultSet.getNumber(0);
				NString studentName = NString.toStr(resultSet.getStr(1));
				
				this.getFormModel().getKeyBlock().setPidm(pidm);
				this.getFormModel().getKeyBlock().setStudentName(studentName);
			}
			
			getTask().getGoqrpls().gCheckValue(toBool(dataCursor.notFound()), GNls.Fget(toStr("WHARPRP-0001"),
					toStr("FORM"), toStr("*ERROR* Invalid ID; press LIST for valid codes")), toBool(NBool.True));
			
		}finally {
			dataCursor.close();
		}
		
	}*/
	
	
	
}