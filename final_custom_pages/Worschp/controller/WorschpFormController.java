package net.hedtech.banner.student.gsu.student.Worschp.controller;

import morphis.foundations.core.appsupportlib.runtime.ITask;
import net.hedtech.general.common.forms.controller.DefaultFormController;
import morphis.foundations.core.appsupportlib.runtime.action.ActionTrigger;
import static morphis.foundations.core.appsupportlib.Globals.*;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import static morphis.foundations.core.types.Types.*;
import static morphis.foundations.core.util.globals.Globals.setGlobal;
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
import net.hedtech.banner.student.gsu.student.Worschp.WorschpTask;
import net.hedtech.banner.student.gsu.student.Worschp.model.WorschpModel;
import net.hedtech.general.common.dbservices.GNls;
import net.hedtech.general.common.libraries.Goqolib.services.GFormClass;
import net.hedtech.general.common.libraries.Goqolib.services.*;

public class WorschpFormController extends DefaultFormController {

	public WorschpFormController(ITask task) {
		super(task);
	}

	@Override
	public WorschpTask getTask() {
		return (WorschpTask) super.getTask();
	}

	public WorschpModel getFormModel() {
		return getTask().getModel();
	}

	private GFormClass getGFormClass() {
		return (GFormClass) this.getTask().getTaskPart("GOQOLIB").getSupportCodeManager().getPackage("G$_FORM_CLASS");
	}	

	private GApplFormClass getGApplFormClass() {
		return (GApplFormClass) this.getTask().getTaskPart("GOQOLIB").getSupportCodeManager().getPackage("G$_APPL_FORM_CLASS");
	}
	

	@ActionTrigger(action="WHEN_NEW_BLOCK_INSTANCE_TRG")
	public void Worschp_WhenNewBlockInstanceTrg()
	{	
		if ( getFormModel().getButtonControlBlock().getCheckKeys().equals("Y") )
		{
			getFormModel().getButtonControlBlock().setCheckKeys(toStr("N"));
			goBlock(toStr("KEY_BLOCK"));
			executeAction("CHECK_KEYS");
			getTask().getGoqrpls().gCheckFailure();
			
			nextBlock();
			executeQuery();

			getFormModel().getButtonControlBlock().setCheckKeys(toStr("N"));
			executeAction("DISABLE_KEYS");
			getTask().getGoqrpls().gCheckFailure();
		}
	}

	@ActionTrigger(action="LOAD_CURRENT_RELEASE")
	public void Worschp_LoadCurrentRelease()
	{	
		getFormModel().getFormHeader().setCurrentRelease(toStr("8.5"));
	}

	@ActionTrigger(action="KEY-CLRFRM", function=KeyFunction.CLEAR_FORM)
	public void Worschp_ClearTask()
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
	public void Worschp_NextBlock()
	{
		getGFormClass().nextBlock();
	}

	@ActionTrigger(action="ON-SELECT")
	public void Worschp_OnSelect()
	{
		getGFormClass().onSelect();
	}

	@ActionTrigger(action="KEY-PRVBLK", function=KeyFunction.PREVIOUS_BLOCK)
	public void Worschp_PreviousBlock()
	{
		getGFormClass().previousBlock();
	}
	
	@ActionTrigger(action="LIST_VALUES_COPY")
	public void Worschp_ListValuesCopy()
	{
		
		getGFormClass().listValuesCopy();
	}
	
	@ActionTrigger(action="LOAD_FORM_HEADER")
	public void Worschp_LoadFormHeader()
	{
		
		getGFormClass().loadFormHeader();
	}
	
	@ActionTrigger(action="INVALID_OPTION_MSG")
	public void Worschp_InvalidOptionMsg()
	{
		
		getGFormClass().invalidOptionMsg();
	}
	
	@ActionTrigger(action="UPDATE_ACTIVITY")
	public void Worschp_UpdateActivity()
	{
		
		getGFormClass().updateActivity();
	}
	
	@ActionTrigger(action="WHEN-NEW-RECORD-INSTANCE", function=KeyFunction.RECORD_CHANGE)
	@Before
	public void Worschp_recordChange()
	{
		
		getGApplFormClass().recordChange();
	}
	
	
	@ActionTrigger(action="KEY-NXTREC", function=KeyFunction.NEXT_RECORD)
	public void Worschp_NextRecord()
	{
		
		getGFormClass().nextRecord();
	}
	
	@ActionTrigger(action="KEY-PRVREC", function=KeyFunction.PREVIOUS_RECORD)
	public void Worschp_PreviousRecord()
	{
		
		getGFormClass().previousRecord();
	}
	
	@ActionTrigger(action="KEY-NXTSET")
	public void Worschp_KeyNxtset()
	{
		
		getGFormClass().keyNxtset();
	}
	

	@ActionTrigger(action="KEY-SCRDOWN")
	public void Worschp_KeyScrdown()
	{
		
		getGFormClass().keyScrdown();
	}

	
	@ActionTrigger(action="KEY-PRINT")
	public void Worschp_KeyPrint()
	{
		
		getGFormClass().keyPrint();
	}

	@ActionTrigger(action="KEY-ENTQRY", function=KeyFunction.SEARCH)
	public void Worschp_Search()
	{
		
		getGFormClass().search();
	}

	
	@ActionTrigger(action="KEY-EXEQRY", function=KeyFunction.EXECUTE_QUERY)
	public void Worschp_ExecuteQuery()
	{
		
		getGFormClass().executeQuery();
	}

	
	@ActionTrigger(action="KEY-EXIT", function=KeyFunction.EXIT)
	public void Worschp_Exit()
	{
		
		getGFormClass().exit();
	}

	
	@ActionTrigger(action="KEY-NXTKEY")
	public void Worschp_KeyNxtkey()
	{
		
		getGFormClass().keyNxtkey();
	}

	
	@ActionTrigger(action="KEY_NXTKEY_TRG")
	public void Worschp_KeyNxtkeyTrg()
	{
		
		getGFormClass().keyNxtkeyTrg();
	}
	
	
	@ActionTrigger(action="G$_VERIFY_ACCESS")
	public void Worschp_GVerifyAccess()
	{
		getGFormClass().gVerifyAccess();
	}
	
	
	@ActionTrigger(action="G$_REVOKE_ACCESS")
	public void Worschp_GRevokeAccess()
	{
		
		getGFormClass().gRevokeAccess();
	}

	@TaskStartedPre
	public void Worschp_TaskStartedPre(EventObject args)
	{
		getGFormClass().taskStartedPre(args);
	}

	@ActionTrigger(action="PRE_FORM_TRG")
	public void Worschp_PreFormTrg()
	{
		getGFormClass().preFormTrg();
	}

	@TaskEnded
	public void Worschp_TaskEnded(EventObject args)
	{
		getGFormClass().taskEnded(args);
	}

	@ActionTrigger(action="POST_FORM_TRG")
	public void Worschp_PostFormTrg()
	{
		getGFormClass().postFormTrg();
	}

	@ActionTrigger(action="PRE-BLOCK", function=KeyFunction.BLOCK_IN)
	@Before
	public void Worschp_blockIn()
	{
		getGFormClass().blockIn();
	}

	@ActionTrigger(action="PRE_BLOCK_TRG")
	public void Worschp_PreBlockTrg()
	{
		getGFormClass().preBlockTrg();
	}

	@ActionTrigger(action="POST-BLOCK", function=KeyFunction.BLOCK_OUT)
	@Before
	public void Worschp_blockOut()
	{
		getGFormClass().blockOut();
	}

	@ActionTrigger(action="POST_BLOCK_TRG")
	public void Worschp_PostBlockTrg()
	{
		getGFormClass().postBlockTrg();
	}

	@BeforeCommit
	public void Worschp_BeforeCommit(CancelEvent args)
	{
		getGFormClass().beforeCommit(args);
	}

	@ActionTrigger(action="PRE_COMMIT_TRG")
	public void Worschp_PreCommitTrg()
	{
		getGFormClass().preCommitTrg();
	}
	
	
	@BeforeRowInsert
	public void Worschp_BeforeRowInsert(RowAdapterEvent args)
	{
		
		getGFormClass().beforeRowInsert(args);
	}

	
	@BeforeRowUpdate
	public void Worschp_BeforeRowUpdate(RowAdapterEvent args)
	{
		
		getGFormClass().beforeRowUpdate(args);
	}
	
	@OnError
	public void Worschp_OnError(EventObject args)
	{
		
		getGFormClass().onError(args);
	}

	@OnRollback
	public void Worschp_OnRollback(EventObject args)
	{
		getGFormClass().onRollback();
	}

	@ActionTrigger(action="ON_ROLLBACK_TRG")
	public void Worschp_OnRollbackTrg()
	{
		getGFormClass().onRollbackTrg();
	}

	
	@QueryExecute
	public void Worschp_QueryExecute(EventObject args)
	{
		
		getGFormClass().queryExecute(args);
	}

	@AfterCommit
	public void Worschp_AfterCommit(EventObject args)
	{
		getGFormClass().afterCommit(args);
	}

	@ActionTrigger(action="POST_FORMS_COMMIT_TRG")
	public void Worschp_PostFormsCommitTrg()
	{
		getGFormClass().postFormsCommitTrg();
	}

	@ActionTrigger(action="WHEN-BUTTON-PRESSED")
	public void Worschp_buttonClick()
	{
		getGFormClass().click();
	}

	@ActionTrigger(action="WHEN-NEW-BLOCK-INSTANCE", function=KeyFunction.BLOCK_CHANGE)
	@Before
	public void Worschp_blockChange()
	{
		getGFormClass().blockChange();
	}
	
	@ActionTrigger(action="WHEN-MOUSE-DOUBLECLICK")
	public void Worschp_doubleClick()
	{
		
		getGFormClass().doubleClick();
	}
	
	@ActionTrigger(action="WHEN-TIMER-EXPIRED")
	public void Worschp_WhenTimerExpired(NString timerName)
	{
		
		getGFormClass().whenTimerExpired(timerName);
	}
	
	@ActionTrigger(action="WHEN-WINDOW-ACTIVATED")
	public void Worschp_WhenWindowActivated()
	{
		getGFormClass().whenWindowActivated();
	}
	
	@ActionTrigger(action="WHEN_WINDOW_ACTIVATED_TRG")
	public void Worschp_WhenWindowActivatedTrg()
	{
		
		getGFormClass().whenWindowActivatedTrg();
	}

	@ActionTrigger(action="WHEN-WINDOW-CLOSED")
	public void Worschp_WhenWindowClosed()
	{
		getGFormClass().whenWindowClosed();
	}
	
	@ActionTrigger(action="KEY-HELP", function=KeyFunction.HELP)
	public void Worschp_Help()
	{
		
		getGFormClass().help();
	}

	
	@ActionTrigger(action="KEY-F0", function=KeyFunction.KEY_F0)
	public void Worschp_F0()
	{
		
		getGFormClass().f0();
	}

	@ActionTrigger(action="KEY-F2", function=KeyFunction.KEY_F2)
	public void Worschp_F2()
	{
		
		getGFormClass().f2();
	}

	
	@ActionTrigger(action="KEY-DOWN", function=KeyFunction.DOWN)
	public void Worschp_MoveDown()
	{
		
		getGFormClass().moveDown();
	}

	
	@ActionTrigger(action="KEY-UP", function=KeyFunction.UP)
	public void Worschp_MoveUp()
	{
		
		getGFormClass().moveUp();
	}

	@ActionTrigger(action="KEY-LISTVAL", function=KeyFunction.LIST_VALUES)
	public void Worschp_ListValues()
	{
		
		getGFormClass().listValues();
	}
	
	@ActionTrigger(action="KEY-MENU")
	public void Worschp_KeyMenu()
	{
		
		getGFormClass().keyMenu();
	}

	@TaskStarted
	public void Worschp_TaskStarted(EventObject args)
	{
		
			setDefaultValue("", "GLOBAL.WF_ENABLED_IND");
			executeAction("LOAD_FORM_HEADER");
			getTask().getGoqrpls().gCheckFailure();
			getTask().getGoqrpls().gSetInstProperty();
			getTask().getGoqrpls().gSetWinProperty();
			executeAction("GLOBAL_COPY");
			getTask().getGoqrpls().gCheckFailure();
			executeAction("ENABLE_KEYS");
			getTask().getGoqrpls().gCheckFailure();
		}
	
	@ActionTrigger(action="SAVE_KEYS")
	public void Worschp_SaveKeys()
	{
		setGlobal("TERM_CODE", getFormModel().getKeyBlock().getTermCode());
		setGlobal("SCHP_CODE", getFormModel().getKeyBlock().getSchpCode());
	}
	

	@ActionTrigger(action="GLOBAL_COPY")
	public void Worschp_GlobalCopy()
	{
		getFormModel().getKeyBlock().setTermCode(getGlobal("TERM_CODE"));
		getFormModel().getKeyBlock().setSchpCode(getGlobal("SCHP_CODE"));
	
	}
	
	@ActionTrigger(action="ENABLE_KEYS")
	public void Worschp_EnableKeys()
	{		
		
	}
	
	@ActionTrigger(action="DISABLE_KEYS")
	public void Worschp_DisableKeys()
	{	
		
	}


	@ActionTrigger(action="KEY_EXIT_TRG")
	public void Worschp_KeyExitTrg()
	{
		
			getTask().getGoqrpls().gDetermineEraseGlobal();
		}

	
}