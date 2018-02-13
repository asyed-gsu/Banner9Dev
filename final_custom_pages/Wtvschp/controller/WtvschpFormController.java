package net.hedtech.banner.student.gsu.student.Wtvschp.controller;

import morphis.foundations.core.appsupportlib.runtime.ITask;
import net.hedtech.general.common.forms.controller.DefaultFormController;
import morphis.foundations.core.appsupportlib.runtime.action.ActionTrigger;
import static morphis.foundations.core.appsupportlib.Globals.*;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import static morphis.foundations.core.types.Types.*;
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
import net.hedtech.banner.student.gsu.student.Wtvschp.WtvschpTask;
import net.hedtech.banner.student.gsu.student.Wtvschp.model.WtvschpModel;
import net.hedtech.general.common.dbservices.GNls;
import net.hedtech.general.common.libraries.Goqolib.services.GFormClass;
import net.hedtech.general.common.libraries.Goqolib.services.*;
import net.hedtech.general.common.libraries.Goqolib.services.GValFormClass;

public class WtvschpFormController extends DefaultFormController {

	public WtvschpFormController(ITask task) {
		super(task);
	}

	@Override
	public WtvschpTask getTask() {
		return (WtvschpTask) super.getTask();
	}

	public WtvschpModel getFormModel() {
		return getTask().getModel();
	}

	private GFormClass getGFormClass() {
		return (GFormClass) this.getTask().getTaskPart("GOQOLIB").getSupportCodeManager().getPackage("G$_FORM_CLASS");
	}	

	private GValFormClass getGValFormClass() {
		return (GValFormClass) this.getTask().getTaskPart("GOQOLIB").getSupportCodeManager().getPackage("G$_VAL_FORM_CLASS");
	}	

	@ActionTrigger(action="G$_VERIFY_ACCESS")
	public void Wtvschp_GVerifyAccess()
	{
		getGFormClass().gVerifyAccess();
	}

	@ActionTrigger(action="G$_REVOKE_ACCESS")
	public void Wtvschp_GRevokeAccess()
	{
		getGFormClass().gRevokeAccess();
	}

	@ActionTrigger(action="PRE_FORM_TRG")
	public void Wtvschp_PreFormTrg()
	{
		getGFormClass().preFormTrg();
	}

	@ActionTrigger(action="POST_FORM_TRG")
	public void Wtvschp_PostFormTrg()
	{
		getGFormClass().postFormTrg();
	}

	@ActionTrigger(action="PRE_BLOCK_TRG")
	public void Wtvschp_PreBlockTrg()
	{
		getGFormClass().preBlockTrg();
	}

	@ActionTrigger(action="POST_BLOCK_TRG")
	public void Wtvschp_PostBlockTrg()
	{
		getGFormClass().postBlockTrg();
	}

	@ActionTrigger(action="PRE_COMMIT_TRG")
	public void Wtvschp_PreCommitTrg()
	{
		getGFormClass().preCommitTrg();
	}

	@ActionTrigger(action="ON_ROLLBACK_TRG")
	public void Wtvschp_OnRollbackTrg()
	{
		getGFormClass().onRollbackTrg();
	}

	@ActionTrigger(action="POST_FORMS_COMMIT_TRG")
	public void Wtvschp_PostFormsCommitTrg()
	{
		getGFormClass().postFormsCommitTrg();
	}

	@ActionTrigger(action="WHEN_NEW_BLOCK_INSTANCE_TRG")
	public void Wtvschp_WhenNewBlockInstanceTrg()
	{
		getGFormClass().whenNewBlockInstanceTrg();
	}

	@ActionTrigger(action="WHEN-MOUSE-DOUBLECLICK")
	public void Wtvschp_WhenMouseDoubleclick()
	{
		getGFormClass().whenMouseDoubleclick();
	}

	@ActionTrigger(action="WHEN-WINDOW-ACTIVATED")
	public void Wtvschp_WhenWindowActivated()
	{
		getGFormClass().whenWindowActivated();
	}

	@ActionTrigger(action="WHEN_WINDOW_ACTIVATED_TRG")
	public void Wtvschp_WhenWindowActivatedTrg()
	{
		getGFormClass().whenWindowActivatedTrg();
	}

	@ActionTrigger(action="WHEN-WINDOW-CLOSED")
	public void Wtvschp_WhenWindowClosed()
	{
		getGFormClass().whenWindowClosed();
	}

	@ActionTrigger(action="KEY-MENU")
	public void Wtvschp_KeyMenu()
	{
		getGFormClass().keyMenu();
	}

	@ActionTrigger(action="KEY-NXTSET")
	public void Wtvschp_KeyNxtset()
	{
		getGFormClass().keyNxtset();
	}

	@ActionTrigger(action="KEY-SCRUP")
	public void Wtvschp_KeyScrup()
	{
		getGFormClass().keyScrup();
	}

	@ActionTrigger(action="KEY-SCRDOWN")
	public void Wtvschp_KeyScrdown()
	{
		getGFormClass().keyScrdown();
	}

	@ActionTrigger(action="KEY-PRINT")
	public void Wtvschp_KeyPrint()
	{
		getGFormClass().keyPrint();
	}

	@ActionTrigger(action="KEY_EXIT_TRG")
	public void Wtvschp_KeyExitTrg()
	{
		getGFormClass().keyExitTrg();
	}

	@ActionTrigger(action="KEY-NXTKEY")
	public void Wtvschp_KeyNxtkey()
	{
		getGFormClass().keyNxtkey();
	}

	@ActionTrigger(action="KEY_NXTKEY_TRG")
	public void Wtvschp_KeyNxtkeyTrg()
	{
		getGFormClass().keyNxtkeyTrg();
	}

	@ActionTrigger(action="GLOBAL_COPY")
	public void Wtvschp_GlobalCopy()
	{
		getGFormClass().globalCopy();
	}

	@ActionTrigger(action="LIST_VALUES_COPY")
	public void Wtvschp_ListValuesCopy()
	{
		getGFormClass().listValuesCopy();
	}

	@ActionTrigger(action="LOAD_FORM_HEADER")
	public void Wtvschp_LoadFormHeader()
	{
		getGFormClass().loadFormHeader();
	}

	@ActionTrigger(action="LOAD_CURRENT_RELEASE")
	public void Wtvschp_LoadCurrentRelease()
	{
		getGFormClass().loadCurrentRelease();
	}

	@ActionTrigger(action="SAVE_KEYS")
	public void Wtvschp_SaveKeys()
	{
		getGFormClass().saveKeys();
	}

	@ActionTrigger(action="ENABLE_KEYS")
	public void Wtvschp_EnableKeys()
	{
		getGFormClass().enableKeys();
	}

	@ActionTrigger(action="DISABLE_KEYS")
	public void Wtvschp_DisableKeys()
	{
		getGFormClass().disableKeys();
	}

	@ActionTrigger(action="INVALID_OPTION_MSG")
	public void Wtvschp_InvalidOptionMsg()
	{
		getGFormClass().invalidOptionMsg();
	}

	@ActionTrigger(action="UPDATE_ACTIVITY")
	public void Wtvschp_UpdateActivity()
	{
		getGFormClass().updateActivity();
	}

	@ActionTrigger(action="KEY-HELP", function=KeyFunction.HELP)
	public void Wtvschp_Help()
	{
		getGFormClass().help();
	}

	@ActionTrigger(action="KEY-LISTVAL", function=KeyFunction.LIST_VALUES)
	public void Wtvschp_ListValues()
	{
		getGFormClass().listValues();
	}

	@ActionTrigger(action="KEY-NXTBLK", function=KeyFunction.NEXT_BLOCK)
	public void Wtvschp_NextBlock()
	{
		getGFormClass().nextBlock();
	}

	@ActionTrigger(action="KEY-PRVBLK", function=KeyFunction.PREVIOUS_BLOCK)
	public void Wtvschp_PreviousBlock()
	{
		getGFormClass().previousBlock();
	}

	@ActionTrigger(action="KEY-NXTREC", function=KeyFunction.NEXT_RECORD)
	public void Wtvschp_NextRecord()
	{
		getGFormClass().nextRecord();
	}

	@ActionTrigger(action="KEY-PRVREC", function=KeyFunction.PREVIOUS_RECORD)
	public void Wtvschp_PreviousRecord()
	{
		getGFormClass().previousRecord();
	}

	@ActionTrigger(action="KEY-ENTQRY", function=KeyFunction.SEARCH)
	public void Wtvschp_Search()
	{
		getGFormClass().search();
	}

	@ActionTrigger(action="KEY-EXEQRY", function=KeyFunction.EXECUTE_QUERY)
	public void Wtvschp_ExecuteQuery()
	{
		getGFormClass().executeQuery();
	}

	@ActionTrigger(action="KEY-EXIT", function=KeyFunction.EXIT)
	public void Wtvschp_Exit()
	{
		getGFormClass().exit();
	}

	@ActionTrigger(action="PRE-BLOCK", function=KeyFunction.BLOCK_IN)
	@Before
	public void Wtvschp_BlockIn()
	{
		getGFormClass().blockIn();
	}

	@ActionTrigger(action="POST-BLOCK", function=KeyFunction.BLOCK_OUT)
	@Before
	public void Wtvschp_BlockOut()
	{
		getGFormClass().blockOut();
	}

	@ActionTrigger(action="WHEN-NEW-BLOCK-INSTANCE", function=KeyFunction.BLOCK_CHANGE)
	@Before
	public void Wtvschp_BlockChange()
	{
		getGFormClass().blockChange();
	}

	@OnRollback
	public void Wtvschp_OnRollback(EventObject args)
	{
		getGFormClass().onRollback();
	}

	@AfterCommit
	public void Wtvschp_AfterCommit(EventObject args)
	{
		getGFormClass().afterCommit(args);
	}

	@TaskStartedPre
	public void Wtvschp_TaskStartedPre(EventObject args)
	{
		getGFormClass().taskStartedPre(args);
	}

	@TaskEnded
	public void Wtvschp_TaskEnded(EventObject args)
	{
		getGFormClass().taskEnded(args);
	}

	@QueryExecute
	public void Wtvschp_QueryExecute(EventObject args)
	{
		getGFormClass().queryExecute(args);
	}

	@TaskStarted
	public void Wtvschp_TaskStarted(EventObject args)
	{
		getGFormClass().taskStarted(args);
	}

	@OnError
	public void Wtvschp_OnError(EventObject args)
	{
		getGFormClass().onError(args);
	}

	@BeforeRowInsert
	public void Wtvschp_BeforeRowInsert(RowAdapterEvent args)
	{
		getGFormClass().beforeRowInsert(args);
	}

	@BeforeRowUpdate
	public void Wtvschp_BeforeRowUpdate(RowAdapterEvent args)
	{
		getGFormClass().beforeRowUpdate(args);
	}

	@BeforeCommit
	public void Wtvschp_BeforeCommit(CancelEvent args)
	{
		getGFormClass().beforeCommit(args);
	}

	@ActionTrigger(action="WHEN-BUTTON-PRESSED")
	public void Wtvschp_Click()
	{
		getGFormClass().click();
	}

	@ActionTrigger(action="WHEN-TIMER-EXPIRED")
	public void Wtvschp_WhenTimerExpired(NString args)
	{
		getGFormClass().whenTimerExpired(args);
	}

	@ActionTrigger(action="KEY-CLRFRM", function=KeyFunction.CLEAR_FORM)
	public void Wtvschp_ClearTask()
	{
		getGFormClass().clearTask();
	}

	@ActionTrigger(action="KEY-F0", function=KeyFunction.KEY_F0)
	public void Wtvschp_F0()
	{
		getGFormClass().f0();
	}

	@ActionTrigger(action="KEY-F2", function=KeyFunction.KEY_F2)
	public void Wtvschp_F2()
	{
		getGFormClass().f2();
	}

	@ActionTrigger(action="KEY-DOWN", function=KeyFunction.DOWN)
	public void Wtvschp_MoveDown()
	{
		getGFormClass().moveDown();
	}

	@ActionTrigger(action="KEY-UP", function=KeyFunction.UP)
	public void Wtvschp_MoveUp()
	{
		getGFormClass().moveUp();
	}

	@ActionTrigger(action="WHEN-NEW-RECORD-INSTANCE", function=KeyFunction.RECORD_CHANGE)
	public void Wtvschp_RecordChange()
	{
		getGValFormClass().recordChange();
	}
}