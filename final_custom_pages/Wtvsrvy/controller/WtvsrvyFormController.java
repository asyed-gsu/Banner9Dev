package net.hedtech.banner.student.gsu.student.Wtvsrvy.controller;

import morphis.foundations.core.appsupportlib.runtime.ITask;
import net.hedtech.general.common.forms.controller.DefaultFormController;
import morphis.foundations.core.appsupportlib.runtime.action.ActionTrigger;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import static morphis.foundations.core.types.Types.*;
import morphis.foundations.core.types.*;
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
import net.hedtech.banner.student.gsu.student.Wtvsrvy.WtvsrvyTask;
import net.hedtech.banner.student.gsu.student.Wtvsrvy.model.WtvsrvyAdapter;
import net.hedtech.banner.student.gsu.student.Wtvsrvy.model.WtvsrvyModel;
import net.hedtech.general.common.libraries.Goqolib.services.GFormClass;
import net.hedtech.general.common.libraries.Goqolib.services.GValFormClass;

public class WtvsrvyFormController extends DefaultFormController {

	public WtvsrvyFormController(ITask task) {
		super(task);
	}

	@Override
	public WtvsrvyTask getTask() {
		return (WtvsrvyTask) super.getTask();
	}

	public WtvsrvyModel getFormModel() {
		return getTask().getModel();
	}

	private GFormClass getGFormClass() {
		return (GFormClass) this.getTask().getTaskPart("GOQOLIB").getSupportCodeManager().getPackage("G$_FORM_CLASS");
	}	

	private GValFormClass getGValFormClass() {
		return (GValFormClass) this.getTask().getTaskPart("GOQOLIB").getSupportCodeManager().getPackage("G$_VAL_FORM_CLASS");
	}	

	@ActionTrigger(action="G$_VERIFY_ACCESS")
	public void Wtvsrvy_GVerifyAccess()
	{
		getGFormClass().gVerifyAccess();
	}

	@ActionTrigger(action="G$_REVOKE_ACCESS")
	public void Wtvsrvy_GRevokeAccess()
	{
		getGFormClass().gRevokeAccess();
	}
	
	@TaskStartedPre
	public void Wtvsrvy_TaskStartedPre(EventObject args)
	{
		getGFormClass().taskStartedPre(args);
	}

	@ActionTrigger(action="PRE_FORM_TRG")
	public void Wtvsrvy_PreFormTrg()
	{
		getGFormClass().preFormTrg();
	}
	
	@TaskEnded
	public void Wtvsrvy_TaskEnded(EventObject args)
	{
		getGFormClass().taskEnded(args);
	}

	@ActionTrigger(action="POST_FORM_TRG")
	public void Wtvsrvy_PostFormTrg()
	{
		getGFormClass().postFormTrg();
	}
	
	@ActionTrigger(action="PRE-BLOCK", function=KeyFunction.BLOCK_IN)
	@Before
	public void Wtvsrvy_BlockIn()
	{
		getGFormClass().blockIn();
	}


	@ActionTrigger(action="PRE_BLOCK_TRG")
	public void Wtvsrvy_PreBlockTrg()
	{
		getGFormClass().preBlockTrg();
	}
	

	@ActionTrigger(action="POST-BLOCK", function=KeyFunction.BLOCK_OUT)
	@Before
	public void Wtvsrvy_BlockOut()
	{
		getGFormClass().blockOut();
	}

	@ActionTrigger(action="POST_BLOCK_TRG")
	public void Wtvsrvy_PostBlockTrg()
	{
		getGFormClass().postBlockTrg();
	}
	
	@BeforeCommit
	public void Wtvsrvy_BeforeCommit(CancelEvent args)
	{
		
		getGFormClass().beforeCommit(args);
	}
	

	@ActionTrigger(action="PRE_COMMIT_TRG")
	public void Wtvsrvy_PreCommitTrg()
	{
		getGFormClass().preCommitTrg();
	}
	
	@OnError
	public void Wtvsrvy_OnError(EventObject args)
	{
		
		getGFormClass().onError(args);
	}
	
	@OnRollback
	public void Wtvsrvy_OnRollback(EventObject args)
	{
		
		getGFormClass().onRollback();
	}

	@ActionTrigger(action="ON_ROLLBACK_TRG")
	public void Wtvsrvy_OnRollbackTrg()
	{
		getGFormClass().onRollbackTrg();
	}
	
	@QueryExecute
	public void Wtvsrvy_QueryExecute(EventObject args)
	{
		getGFormClass().queryExecute(args);
	}

	@AfterCommit
	public void Wtvsrvy_AfterCommit(EventObject args)
	{
		getGFormClass().afterCommit(args);
	}
	
	@ActionTrigger(action="POST_FORMS_COMMIT_TRG")
	public void Wtvsrvy_PostFormsCommitTrg()
	{
		getGFormClass().postFormsCommitTrg();
	}
	
	@ActionTrigger(action="WHEN-BUTTON-PRESSED")
	public void Wtvsrvy_Click()
	{
		getGFormClass().click();
	}
	
	@TaskStarted
	public void Wtvsrvy_TaskStarted(EventObject args)
	{
		getGFormClass().taskStarted(args);
	}
	
	@ActionTrigger(action="WHEN-NEW-BLOCK-INSTANCE", function=KeyFunction.BLOCK_CHANGE)
	@Before
	public void Wtvsrvy_BlockChange()
	{
		getGFormClass().blockChange();
	}

	@ActionTrigger(action="WHEN_NEW_BLOCK_INSTANCE_TRG")
	public void Wtvsrvy_WhenNewBlockInstanceTrg()
	{
		getGFormClass().whenNewBlockInstanceTrg();
	}

	@ActionTrigger(action="WHEN-MOUSE-DOUBLECLICK")
	public void Wtvsrvy_WhenMouseDoubleclick()
	{
		getGFormClass().whenMouseDoubleclick();
	}
	
	@ActionTrigger(action="WHEN-TIMER-EXPIRED")
	public void Wtvsrvy_WhenTimerExpired(NString args)
	{
		getGFormClass().whenTimerExpired(args);
	}

	@ActionTrigger(action="WHEN-WINDOW-ACTIVATED")
	public void Wtvsrvy_WhenWindowActivated()
	{
		getGFormClass().whenWindowActivated();
	}

	@ActionTrigger(action="WHEN_WINDOW_ACTIVATED_TRG")
	public void Wtvsrvy_WhenWindowActivatedTrg()
	{
		getGFormClass().whenWindowActivatedTrg();
	}

	@ActionTrigger(action="WHEN-WINDOW-CLOSED")
	public void Wtvsrvy_WhenWindowClosed()
	{
		getGFormClass().whenWindowClosed();
	}
	
	@ActionTrigger(action="KEY-CLRFRM", function=KeyFunction.CLEAR_FORM)
	public void Wtvsrvy_ClearTask()
	{
		getGFormClass().clearTask();
	}
	
	@ActionTrigger(action="KEY-HELP", function=KeyFunction.HELP)
	public void Wtvsrvy_Help()
	{
		getGFormClass().help();
	}
	
	@ActionTrigger(action="KEY-F0", function=KeyFunction.KEY_F0)
	public void Wtvsrvy_F0()
	{
		getGFormClass().f0();
	}

	@ActionTrigger(action="KEY-F2", function=KeyFunction.KEY_F2)
	public void Wtvsrvy_F2()
	{
		getGFormClass().f2();
	}

	@ActionTrigger(action="KEY-DOWN", function=KeyFunction.DOWN)
	public void Wtvsrvy_MoveDown()
	{
		getGFormClass().moveDown();
	}

	@ActionTrigger(action="KEY-UP", function=KeyFunction.UP)
	public void Wtvsrvy_MoveUp()
	{
		getGFormClass().moveUp();
	}
	
	@ActionTrigger(action="KEY-LISTVAL", function=KeyFunction.LIST_VALUES)
	public void Wtvsrvy_ListValues()
	{
		getGFormClass().listValues();
	}

	@ActionTrigger(action="KEY-MENU")
	public void Wtvsrvy_KeyMenu()
	{
		getGFormClass().keyMenu();
	}
	
	@ActionTrigger(action="KEY-NXTBLK", function=KeyFunction.NEXT_BLOCK)
	public void Wtvsrvy_NextBlock()
	{
		getGFormClass().nextBlock();
	}

	@ActionTrigger(action="KEY-PRVBLK", function=KeyFunction.PREVIOUS_BLOCK)
	public void Wtvsrvy_PreviousBlock()
	{
		getGFormClass().previousBlock();
	}

	@ActionTrigger(action="KEY-NXTREC", function=KeyFunction.NEXT_RECORD)
	public void Wtvsrvy_NextRecord()
	{
		getGFormClass().nextRecord();
	}

	@ActionTrigger(action="KEY-PRVREC", function=KeyFunction.PREVIOUS_RECORD)
	public void Wtvsrvy_PreviousRecord()
	{
		getGFormClass().previousRecord();
	}

	@ActionTrigger(action="KEY-NXTSET")
	public void Wtvsrvy_KeyNxtset()
	{
		getGFormClass().keyNxtset();
	}

	@ActionTrigger(action="KEY-SCRUP")
	public void Wtvsrvy_KeyScrup()
	{
		getGFormClass().keyScrup();
	}

	@ActionTrigger(action="KEY-SCRDOWN")
	public void Wtvsrvy_KeyScrdown()
	{
		getGFormClass().keyScrdown();
	}

	@ActionTrigger(action="KEY-PRINT")
	public void Wtvsrvy_KeyPrint()
	{
		getGFormClass().keyPrint();
	}
	
	@ActionTrigger(action="KEY-ENTQRY", function=KeyFunction.SEARCH)
	public void Wtvsrvy_Search()
	{
		getGFormClass().search();
	}

	@ActionTrigger(action="KEY-EXEQRY", function=KeyFunction.EXECUTE_QUERY)
	public void Wtvsrvy_ExecuteQuery()
	{
		getGFormClass().executeQuery();
	}

	@ActionTrigger(action="KEY_EXIT_TRG")
	public void Wtvsrvy_KeyExitTrg()
	{
		getGFormClass().keyExitTrg();
	}

	@ActionTrigger(action="KEY_NXTKEY_TRG")
	public void Wtvsrvy_KeyNxtkeyTrg()
	{
		getGFormClass().keyNxtkeyTrg();
	}

	@ActionTrigger(action="GLOBAL_COPY")
	public void Wtvsrvy_GlobalCopy()
	{
		getGFormClass().globalCopy();
	}

	@ActionTrigger(action="LIST_VALUES_COPY")
	public void Wtvsrvy_ListValuesCopy()
	{
		getGFormClass().listValuesCopy();
	}

	@ActionTrigger(action="LOAD_FORM_HEADER")
	public void Wtvsrvy_LoadFormHeader()
	{
		getGFormClass().loadFormHeader();
	}
	
	@ActionTrigger(action="SAVE_KEYS")
	public void Wtvsrvy_SaveKeys()
	{
		getGFormClass().saveKeys();
	}
	

	@ActionTrigger(action="ENABLE_KEYS")
	public void Wtvsrvy_EnableKeys()
	{
		getGFormClass().enableKeys();
	}

	@ActionTrigger(action="DISABLE_KEYS")
	public void Wtvsrvy_DisableKeys()
	{
		getGFormClass().disableKeys();
	}

	@ActionTrigger(action="INVALID_OPTION_MSG")
	public void Wtvsrvy_InvalidOptionMsg()
	{
		getGFormClass().invalidOptionMsg();
	}

	@ActionTrigger(action="UPDATE_ACTIVITY")
	public void Wtvsrvy_UpdateActivity()
	{
		getGFormClass().updateActivity();
	}
	
	@BeforeRowInsert
	public void Wtvsrvy_BeforeRowInsert(RowAdapterEvent args)
	{
		getGFormClass().beforeRowInsert(args);
	}
	
	@ActionTrigger(action="WHEN-NEW-RECORD-INSTANCE", function=KeyFunction.RECORD_CHANGE)
	public void Wtvsrvy_RecordChange()
	{
		getGValFormClass().recordChange();
	}
	
	@ActionTrigger(action="LOAD_CURRENT_RELEASE")
	public void Wtvsrvy_LoadCurrentRelease()
	{
		getGFormClass().loadCurrentRelease();
	}
	
	@ActionTrigger(action="INVALID_FUNCTION_MSG")
	public void Wtvsrvy_InvalidFunctionMsg()
	{
		errorMessage(toStr("*ERROR* Invalid function; press SHOW KEYS key for valid functions."));
	}
	
	@ActionTrigger(action="KEY-NXTKEY")
	public void Wtvsrvy_KeyNxtkey()
	{
		
		getGFormClass().keyNxtkey();
	}

	@ActionTrigger(action="KEY-EXIT", function=KeyFunction.EXIT)
	public void Wtvsrvy_Exit()
	{
		getGFormClass().exit();
	}

	@BeforeRowUpdate
	public void Wtvsrvy_BeforeRowUpdate(RowAdapterEvent args)
	{
		WtvsrvyAdapter wtvsrvyElement = (WtvsrvyAdapter)this.getFormModel().getWtvsrvy().getRowAdapter(true);
		if(wtvsrvyElement == null)
			return;
		wtvsrvyElement.setWtvsrvyActivityDate(toDate(getFormModel().getFormHeader().getCurrentDate()));
	}
	
	
}