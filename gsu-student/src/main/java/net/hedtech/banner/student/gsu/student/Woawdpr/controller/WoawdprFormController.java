package net.hedtech.banner.student.gsu.student.Woawdpr.controller;

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
import net.hedtech.banner.student.gsu.student.Woawdpr.WoawdprTask;
import net.hedtech.banner.student.gsu.student.Woawdpr.model.WoawdprModel;
import net.hedtech.general.common.dbservices.GNls;
import net.hedtech.general.common.libraries.Goqolib.services.GFormClass;
import net.hedtech.general.common.libraries.Goqolib.services.*;

public class WoawdprFormController extends DefaultFormController {

	public WoawdprFormController(ITask task) {
		super(task);
	}

	@Override
	public WoawdprTask getTask() {
		return (WoawdprTask) super.getTask();
	}

	public WoawdprModel getFormModel() {
		return getTask().getModel();
	}

	private GFormClass getGFormClass() {
		return (GFormClass) this.getTask().getTaskPart("GOQOLIB").getSupportCodeManager().getPackage("G$_FORM_CLASS");
	}

	private GApplFormClass getGApplFormClass() {
		return (GApplFormClass) this.getTask().getTaskPart("GOQOLIB").getSupportCodeManager()
				.getPackage("G$_APPL_FORM_CLASS");
	}

	@ActionTrigger(action = "ENABLE_KEYS")
	public void Woawdpr_EnableKeys() {

	}

	@ActionTrigger(action = "WHEN_NEW_BLOCK_INSTANCE_TRG")
	public void Woawdpr_WhenNewBlockInstanceTrg() {
		if (getFormModel().getButtonControlBlock().getCheckKeys().equals("Y")) {
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

	@ActionTrigger(action = "LOAD_CURRENT_RELEASE")
	public void Woawdpr_LoadCurrentRelease() {
		getFormModel().getFormHeader().setCurrentRelease(toStr("8.5"));
	}

	@ActionTrigger(action = "KEY-CLRFRM", function = KeyFunction.CLEAR_FORM)
	public void Woawdpr_ClearTask() {
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

	@ActionTrigger(action = "KEY-NXTBLK", function = KeyFunction.NEXT_BLOCK)
	public void Woawdpr_NextBlock() {
		getGFormClass().nextBlock();
	}

	@ActionTrigger(action = "G$_VERIFY_ACCESS")
	public void Woawdpr_GVerifyAccess() {
		getGFormClass().gVerifyAccess();
	}

	@TaskStartedPre
	public void Woawdpr_TaskStartedPre(EventObject args) {
		getGFormClass().taskStartedPre(args);
	}

	@ActionTrigger(action = "PRE_FORM_TRG")
	public void Woawdpr_PreFormTrg() {
		getGFormClass().preFormTrg();
	}

	@TaskEnded
	public void Woawdpr_TaskEnded(EventObject args) {
		getGFormClass().taskEnded(args);
	}

	@ActionTrigger(action = "POST_FORM_TRG")
	public void Woawdpr_PostFormTrg() {
		getGFormClass().postFormTrg();
	}

	@ActionTrigger(action = "PRE-BLOCK", function = KeyFunction.BLOCK_IN)
	@Before
	public void Woawdpr_blockIn() {
		getGFormClass().blockIn();
	}

	@ActionTrigger(action = "PRE_BLOCK_TRG")
	public void Woawdpr_PreBlockTrg() {
		getGFormClass().preBlockTrg();
	}

	@ActionTrigger(action = "POST-BLOCK", function = KeyFunction.BLOCK_OUT)
	@Before
	public void Woawdpr_blockOut() {
		getGFormClass().blockOut();
	}

	@ActionTrigger(action = "POST_BLOCK_TRG")
	public void Woawdpr_PostBlockTrg() {
		getGFormClass().postBlockTrg();
	}

	@BeforeCommit
	public void Woawdpr_BeforeCommit(CancelEvent args) {
		getGFormClass().beforeCommit(args);
	}

	@ActionTrigger(action = "PRE_COMMIT_TRG")
	public void Woawdpr_PreCommitTrg() {
		getGFormClass().preCommitTrg();
	}

	@OnRollback
	public void Woawdpr_OnRollback(EventObject args) {
		getGFormClass().onRollback();
	}

	@ActionTrigger(action = "ON_ROLLBACK_TRG")
	public void Woawdpr_OnRollbackTrg() {
		getGFormClass().onRollbackTrg();
	}

	@ActionTrigger(action = "ON-SELECT")
	public void Woawdpr_OnSelect() {
		getGFormClass().onSelect();
	}

	@AfterCommit
	public void Woawdpr_AfterCommit(EventObject args) {
		getGFormClass().afterCommit(args);
	}

	@ActionTrigger(action = "POST_FORMS_COMMIT_TRG")
	public void Woawdpr_PostFormsCommitTrg() {
		getGFormClass().postFormsCommitTrg();
	}

	@ActionTrigger(action = "WHEN-BUTTON-PRESSED")
	public void Woawdpr_buttonClick() {
		getGFormClass().click();
	}

	@ActionTrigger(action = "WHEN-NEW-BLOCK-INSTANCE", function = KeyFunction.BLOCK_CHANGE)
	@Before
	public void Woawdpr_blockChange() {
		getGFormClass().blockChange();
	}

	@ActionTrigger(action = "WHEN-WINDOW-ACTIVATED")
	public void Woawdpr_WhenWindowActivated() {
		getGFormClass().whenWindowActivated();
	}

	@ActionTrigger(action = "WHEN-WINDOW-CLOSED")
	public void Woawdpr_WhenWindowClosed() {
		getGFormClass().whenWindowClosed();
	}

	@ActionTrigger(action = "KEY-PRVBLK", function = KeyFunction.PREVIOUS_BLOCK)
	public void Woawdpr_PreviousBlock() {
		getGFormClass().previousBlock();
	}

	@ActionTrigger(action = "KEY_EXIT_TRG")
	public void Woawdpr_KeyExitTrg() {

		getTask().getGoqrpls().gDetermineEraseGlobal();
	}

	@ActionTrigger(action = "LIST_VALUES_COPY")
	public void Woawdpr_ListValuesCopy() {

		getGFormClass().listValuesCopy();
	}

	@ActionTrigger(action = "LOAD_FORM_HEADER")
	public void Woawdpr_LoadFormHeader() {

		getGFormClass().loadFormHeader();
	}

	@ActionTrigger(action = "INVALID_OPTION_MSG")
	public void Woawdpr_InvalidOptionMsg() {

		getGFormClass().invalidOptionMsg();
	}

	@ActionTrigger(action = "UPDATE_ACTIVITY")
	public void Woawdpr_UpdateActivity() {

		getGFormClass().updateActivity();
	}

	@ActionTrigger(action = "WHEN-NEW-RECORD-INSTANCE", function = KeyFunction.RECORD_CHANGE)
	@Before
	public void Woawdpr_recordChange() {

		getGApplFormClass().recordChange();
	}

	@ActionTrigger(action = "KEY-LISTVAL", function = KeyFunction.LIST_VALUES)
	public void Woawdpr_ListValues() {

		getGFormClass().listValues();
	}

	@ActionTrigger(action = "KEY-MENU")
	public void Woawdpr_KeyMenu() {

		getGFormClass().keyMenu();
	}

	@ActionTrigger(action = "KEY-NXTREC", function = KeyFunction.NEXT_RECORD)
	public void Woawdpr_NextRecord() {

		getGFormClass().nextRecord();
	}

	@ActionTrigger(action = "KEY-PRVREC", function = KeyFunction.PREVIOUS_RECORD)
	public void Woawdpr_PreviousRecord() {

		getGFormClass().previousRecord();
	}

	@ActionTrigger(action = "KEY-NXTSET")
	public void Woawdpr_KeyNxtset() {

		getGFormClass().keyNxtset();
	}

	@ActionTrigger(action = "KEY-SCRDOWN")
	public void Woawdpr_KeyScrdown() {

		getGFormClass().keyScrdown();
	}

	@ActionTrigger(action = "KEY-PRINT")
	public void Woawdpr_KeyPrint() {

		getGFormClass().keyPrint();
	}

	@ActionTrigger(action = "KEY-ENTQRY", function = KeyFunction.SEARCH)
	public void Woawdpr_Search() {

		getGFormClass().search();
	}

	@ActionTrigger(action = "KEY-EXEQRY", function = KeyFunction.EXECUTE_QUERY)
	public void Woawdpr_ExecuteQuery() {

		getGFormClass().executeQuery();
	}

	@ActionTrigger(action = "KEY-EXIT", function = KeyFunction.EXIT)
	public void Woawdpr_Exit() {

		getGFormClass().exit();
	}

	@ActionTrigger(action = "KEY-NXTKEY")
	public void Woawdpr_KeyNxtkey() {

		getGFormClass().keyNxtkey();
	}

	@ActionTrigger(action = "KEY_NXTKEY_TRG")
	public void Woawdpr_KeyNxtkeyTrg() {

		getGFormClass().keyNxtkeyTrg();
	}

	@ActionTrigger(action = "G$_REVOKE_ACCESS")
	public void Woawdpr_GRevokeAccess() {

		getGFormClass().gRevokeAccess();
	}

	@BeforeRowInsert
	public void Woawdpr_BeforeRowInsert(RowAdapterEvent args) {

		getGFormClass().beforeRowInsert(args);
	}

	@BeforeRowUpdate
	public void Woawdpr_BeforeRowUpdate(RowAdapterEvent args) {

		getGFormClass().beforeRowUpdate(args);
	}

	@OnError
	public void Woawdpr_OnError(EventObject args) {

		getGFormClass().onError(args);
	}

	@QueryExecute
	public void Woawdpr_QueryExecute(EventObject args) {

		getGFormClass().queryExecute(args);
	}

	@ActionTrigger(action = "WHEN-MOUSE-DOUBLECLICK")
	public void Woawdpr_doubleClick() {

		getGFormClass().doubleClick();
	}

	@ActionTrigger(action = "WHEN-TIMER-EXPIRED")
	public void Woawdpr_WhenTimerExpired(NString timerName) {

		getGFormClass().whenTimerExpired(timerName);
	}

	@ActionTrigger(action = "WHEN_WINDOW_ACTIVATED_TRG")
	public void Woawdpr_WhenWindowActivatedTrg() {

		getGFormClass().whenWindowActivatedTrg();
	}

	@ActionTrigger(action = "KEY-HELP", function = KeyFunction.HELP)
	public void Woawdpr_Help() {

		getGFormClass().help();
	}

	@ActionTrigger(action = "KEY-F0", function = KeyFunction.KEY_F0)
	public void Woawdpr_F0() {

		getGFormClass().f0();
	}

	@ActionTrigger(action = "KEY-F2", function = KeyFunction.KEY_F2)
	public void Woawdpr_F2() {

		getGFormClass().f2();
	}

	@ActionTrigger(action = "KEY-DOWN", function = KeyFunction.DOWN)
	public void Woawdpr_MoveDown() {

		getGFormClass().moveDown();
	}

	@ActionTrigger(action = "KEY-UP", function = KeyFunction.UP)
	public void Woawdpr_MoveUp() {

		getGFormClass().moveUp();
	}

	@ActionTrigger(action = "CHECK_KEYS")
	public void Woawdpr_CheckKeys() {
	}

	@TaskStarted
	public void Woawdpr_TaskStarted(EventObject args) {

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

	@ActionTrigger(action = "SAVE_KEYS")
	public void Woawdpr_SaveKeys() {
		setGlobal("KEYBLOC_TERM_CODE", getFormModel().getKeyBlock().getKeyblocTermCode());
		setGlobal("KEYBLOC_LEVL_CODE", getFormModel().getKeyBlock().getKeyblocLevlCode());
	}

	@ActionTrigger(action = "GLOBAL_COPY")
	public void Woawdpr_GlobalCopy() {
		getFormModel().getKeyBlock().setKeyblocTermCode(getGlobal("KEYBLOC_TERM_CODE"));
		getFormModel().getKeyBlock().setKeyblocLevlCode(getGlobal("KEYBLOC_LEVL_CODE"));

	}

	@ActionTrigger(action = "DISABLE_KEYS")
	public void Woawdpr_DisableKeys() {

	}

	@ActionTrigger(action = "KEY_EXIT_TRG")
	public void Ssaexcl_KeyExitTrg() {

		getTask().getGoqrpls().gDetermineEraseGlobal();
	}
}