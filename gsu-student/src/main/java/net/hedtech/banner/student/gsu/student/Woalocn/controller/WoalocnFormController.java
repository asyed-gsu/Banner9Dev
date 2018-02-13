package net.hedtech.banner.student.gsu.student.Woalocn.controller;

import morphis.foundations.core.appsupportlib.runtime.ITask;
import net.hedtech.general.common.forms.controller.DefaultFormController;
import net.hedtech.banner.student.gsu.student.Woalocn.WoalocnTask;
import net.hedtech.banner.student.gsu.student.Woalocn.model.WoalocnModel;
import morphis.foundations.core.appsupportlib.runtime.action.ActionTrigger;
import static morphis.foundations.core.appsupportlib.Globals.*;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import static morphis.foundations.core.types.Types.*;
import static net.hedtech.general.common.forms.services.BaseTaskServices.executeAction;

import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.exceptions.ApplicationException;
import static morphis.foundations.core.appsupportlib.runtime.TaskServices.*;
import static morphis.foundations.core.appsupportlib.runtime.ItemServices.*;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.*;
import static morphis.foundations.core.appsupportlib.runtime.MessageServices.*;
import java.util.EventObject;
import morphis.core.utils.behavior.annotations.Before;
import morphis.foundations.core.appdatalayer.events.BeforeRowInsert;
import morphis.foundations.core.appdatalayer.events.BeforeRowUpdate;
import morphis.foundations.core.appdatalayer.events.CancelEvent;
import morphis.foundations.core.appdatalayer.events.QueryExecute;
import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;
import morphis.foundations.core.appsupportlib.model.AfterCommit;
import morphis.foundations.core.appsupportlib.model.BeforeCommit;
import morphis.foundations.core.appsupportlib.model.OnRollback;
import morphis.foundations.core.appsupportlib.runtime.events.OnError;
import morphis.foundations.core.appsupportlib.runtime.events.TaskEnded;
import morphis.foundations.core.appsupportlib.runtime.events.TaskStarted;
import morphis.foundations.core.appsupportlib.runtime.events.TaskStartedPre;
import net.hedtech.general.common.dbservices.GNls;
import net.hedtech.general.common.libraries.Goqolib.services.GFormClass;
import net.hedtech.general.common.libraries.Goqolib.services.*;

public class WoalocnFormController extends DefaultFormController {

	public WoalocnFormController(ITask task) {
		super(task);
	}

	@Override
	public WoalocnTask getTask() {
		return (WoalocnTask) super.getTask();
	}

	public WoalocnModel getFormModel() {
		return getTask().getModel();
	}

	private GFormClass getGFormClass() {
		return (GFormClass) this.getTask().getTaskPart("GOQOLIB").getSupportCodeManager().getPackage("G$_FORM_CLASS");
	}	

	private GApplFormClass getGApplFormClass() {
		return (GApplFormClass) this.getTask().getTaskPart("GOQOLIB").getSupportCodeManager().getPackage("G$_APPL_FORM_CLASS");
	}	

	@ActionTrigger(action="SAVE_KEYS")
	public void Woalocn_SaveKeys()
	{
	}

	@ActionTrigger(action="GLOBAL_COPY")
	public void Woalocn_GlobalCopy()
	{
	}

	@ActionTrigger(action="CHECK_KEYS")
	public void Woalocn_CheckKeys()
	{
		if ( getFormModel().getKeyBlock().getLocnCode().isNull())
		{
			errorMessage(GNls.Fget(toStr("TASK-0000"), toStr("FORM"), toStr("*ERROR* The Location must be entered")));
			throw new ApplicationException();
		}
	}

	@ActionTrigger(action="DISABLE_KEYS")
	public void Woalocn_DisableKeys()
	{	
		setItemEnabled("LOCN_CODE", false);	
	}

	@ActionTrigger(action="ENABLE_KEYS")
	public void Woalocn_EnableKeys()
	{		
		setItemEnabled("LOCN_CODE", true);	
	}

	@ActionTrigger(action="WHEN_NEW_BLOCK_INSTANCE_TRG")
	public void Woalocn_WhenNewBlockInstanceTrg()
	{				
		if ( getFormModel().getButtonControlBlock().getCheckKeys().equals("Y") )
		{
			getFormModel().getButtonControlBlock().setCheckKeys(toStr("N"));
			goBlock(toStr("KEY_BLOCK"));
			executeAction("CHECK_KEYS");
			getTask().getGoqrpls().gCheckFailure();

			executeAction("DISABLE_KEYS");
			getTask().getGoqrpls().gCheckFailure();		
			nextBlock();
			executeQuery();
		}
	}

	@ActionTrigger(action="LOAD_CURRENT_RELEASE")
	public void Woalocn_LoadCurrentRelease()
	{	
/*		getFormModel().getFormHeader().setCurrentRelease(toStr("8.5"));*/
		getGFormClass().loadCurrentRelease();			
	}

	@ActionTrigger(action="KEY-CLRFRM", function=KeyFunction.CLEAR_FORM)
	public void Woalocn_ClearTask()
	{	
			executeAction("SAVE_KEYS");
			getTask().getGoqrpls().gCheckFailure();
			executeAction("ENABLE_KEYS");
			getTask().getGoqrpls().gCheckFailure();
			
			clearTask();
			getTask().getGoqrpls().gCheckFailure();
			
			executeAction("LOAD_FORM_HEADER");
			getTask().getGoqrpls().gCheckFailure();
			executeAction("GLOBAL_COPY");
			getTask().getGoqrpls().gCheckFailure();
	}

	@ActionTrigger(action="KEY-NXTBLK", function=KeyFunction.NEXT_BLOCK)
	public void Woalocn_NextBlock()
	{
		getGFormClass().nextBlock();
	}

	@ActionTrigger(action="G$_VERIFY_ACCESS")
	public void Woalocn_GVerifyAccess()
	{
		getGFormClass().gVerifyAccess();
	}

	@TaskStartedPre
	public void Woalocn_TaskStartedPre(EventObject args)
	{
		getGFormClass().taskStartedPre(args);
	}

	@ActionTrigger(action="PRE_FORM_TRG")
	public void Woalocn_PreFormTrg()
	{
		getGFormClass().preFormTrg();
	}

	@TaskEnded
	public void Woalocn_TaskEnded(EventObject args)
	{
		getGFormClass().taskEnded(args);
	}

	@ActionTrigger(action="POST_FORM_TRG")
	public void Woalocn_PostFormTrg()
	{
		getGFormClass().postFormTrg();
	}

	@ActionTrigger(action="PRE-BLOCK", function=KeyFunction.BLOCK_IN)
	@Before
	public void Woalocn_blockIn()
	{
		getGFormClass().blockIn();
	}

	@ActionTrigger(action="PRE_BLOCK_TRG")
	public void Woalocn_PreBlockTrg()
	{
		getGFormClass().preBlockTrg();
	}

	@ActionTrigger(action="POST-BLOCK", function=KeyFunction.BLOCK_OUT)
	@Before
	public void Woalocn_blockOut()
	{
		getGFormClass().blockOut();
	}

	@ActionTrigger(action="POST_BLOCK_TRG")
	public void Woalocn_PostBlockTrg()
	{
		getGFormClass().postBlockTrg();
	}

	@BeforeCommit
	public void Woalocn_BeforeCommit(CancelEvent args)
	{
		getGFormClass().beforeCommit(args);
	}

	@ActionTrigger(action="PRE_COMMIT_TRG")
	public void Woalocn_PreCommitTrg()
	{
		getGFormClass().preCommitTrg();
	}

	@OnRollback
	public void Woalocn_OnRollback(EventObject args)
	{
		getGFormClass().onRollback();
	}

	@ActionTrigger(action="ON_ROLLBACK_TRG")
	public void Woalocn_OnRollbackTrg()
	{
		getGFormClass().onRollbackTrg();
	}

	@ActionTrigger(action="ON-SELECT")
	public void Woalocn_OnSelect()
	{
		getGFormClass().onSelect();
	}

	@AfterCommit
	public void Woalocn_AfterCommit(EventObject args)
	{
		getGFormClass().afterCommit(args);
	}

	@ActionTrigger(action="POST_FORMS_COMMIT_TRG")
	public void Woalocn_PostFormsCommitTrg()
	{
		getGFormClass().postFormsCommitTrg();
	}

	@ActionTrigger(action="WHEN-BUTTON-PRESSED")
	public void Woalocn_buttonClick()
	{
		getGFormClass().click();
	}

	@ActionTrigger(action="WHEN-NEW-BLOCK-INSTANCE", function=KeyFunction.BLOCK_CHANGE)
	@Before
	public void Woalocn_blockChange()
	{
		getGFormClass().blockChange();
	}

	@ActionTrigger(action="WHEN-WINDOW-ACTIVATED")
	public void Woalocn_WhenWindowActivated()
	{
		getGFormClass().whenWindowActivated();
	}

	@ActionTrigger(action="WHEN-WINDOW-CLOSED")
	public void Woalocn_WhenWindowClosed()
	{
		getGFormClass().whenWindowClosed();
	}

	@ActionTrigger(action="KEY-PRVBLK", function=KeyFunction.PREVIOUS_BLOCK)
	public void Woalocn_PreviousBlock()
	{
		getGFormClass().previousBlock();
	}
	
	@ActionTrigger(action="KEY-LISTVAL", function=KeyFunction.LIST_VALUES)
	public void Woalocn_ListValues()
	{
		
		getGFormClass().listValues();
	}
	
	@ActionTrigger(action="LIST_VALUES_COPY")
	public void Woalocn_ListValuesCopy()
	{
		
		getGFormClass().listValuesCopy();
	}
}