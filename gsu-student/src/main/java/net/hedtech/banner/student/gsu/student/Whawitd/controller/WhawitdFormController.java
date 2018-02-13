package net.hedtech.banner.student.gsu.student.Whawitd.controller;

import morphis.foundations.core.appsupportlib.runtime.ITask;
import net.hedtech.general.common.forms.controller.DefaultFormController;
import morphis.foundations.core.appsupportlib.runtime.action.ActionTrigger;
import morphis.foundations.core.appsupportlib.runtime.control.IBlockController;

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
import net.hedtech.banner.student.gsu.student.Whawitd.WhawitdTask;
import net.hedtech.banner.student.gsu.student.Whawitd.model.WhawitdModel;
import net.hedtech.general.common.dbservices.GNls;
import net.hedtech.general.common.libraries.Goqolib.services.GFormClass;
import net.hedtech.general.common.libraries.Goqolib.services.*;

public class WhawitdFormController extends DefaultFormController {

	public WhawitdFormController(ITask task) {
		super(task);
	}

	@Override
	public WhawitdTask getTask() {
		return (WhawitdTask) super.getTask();
	}

	public WhawitdModel getFormModel() {
		return getTask().getModel();
	}

	private GFormClass getGFormClass() {
		return (GFormClass) this.getTask().getTaskPart("GOQOLIB").getSupportCodeManager().getPackage("G$_FORM_CLASS");
	}

	private GApplFormClass getGApplFormClass() {
		return (GApplFormClass) this.getTask().getTaskPart("GOQOLIB").getSupportCodeManager()
				.getPackage("G$_APPL_FORM_CLASS");
	}

	@ActionTrigger(action = "G$_VERIFY_ACCESS")
	public void Whawitd_GVerifyAccess() {
		getGFormClass().gVerifyAccess();
	}

	@ActionTrigger(action = "G$_REVOKE_ACCESS")
	public void Whawitd_GRevokeAccess() {

		getGFormClass().gRevokeAccess();
	}

	@TaskStartedPre
	public void Whawitd_TaskStartedPre(EventObject args) {
		getGFormClass().taskStartedPre(args);
	}

	@ActionTrigger(action = "PRE_FORM_TRG")
	public void Whawitd_PreFormTrg() {
		getGFormClass().preFormTrg();
	}

	@TaskEnded
	public void Whawitd_TaskEnded(EventObject args) {
		getGFormClass().taskEnded(args);
	}

	@ActionTrigger(action = "POST_FORM_TRG")
	public void Whawitd_PostFormTrg() {
		getGFormClass().postFormTrg();
	}

	@ActionTrigger(action = "PRE-BLOCK", function = KeyFunction.BLOCK_IN)
	@Before
	public void Whawitd_blockIn() {
		getGFormClass().blockIn();
	}

	@ActionTrigger(action = "PRE_BLOCK_TRG")
	public void Whawitd_PreBlockTrg() {
		getGFormClass().preBlockTrg();
	}

	@ActionTrigger(action = "POST-BLOCK", function = KeyFunction.BLOCK_OUT)
	@Before
	public void Whawitd_blockOut() {
		getGFormClass().blockOut();
	}

	@ActionTrigger(action = "POST_BLOCK_TRG")
	public void Whawitd_PostBlockTrg() {
		getGFormClass().postBlockTrg();
	}

	@BeforeCommit
	public void Whawitd_BeforeCommit(CancelEvent args) {
		getGFormClass().beforeCommit(args);
	}

	@ActionTrigger(action = "PRE_COMMIT_TRG")
	public void Whawitd_PreCommitTrg() {
		getGFormClass().preCommitTrg();
	}

	@OnError
	public void Whawitd_OnError(EventObject args) {

		getGFormClass().onError(args);
	}

	@OnRollback
	public void Whawitd_OnRollback(EventObject args) {
		getGFormClass().onRollback();
	}

	@ActionTrigger(action = "ON_ROLLBACK_TRG")
	public void Whawitd_OnRollbackTrg() {
		getGFormClass().onRollbackTrg();
	}

	@ActionTrigger(action = "ON-SELECT")
	public void Whawitd_OnSelect() {
		getGFormClass().onSelect();
	}

	@QueryExecute
	public void Whawitd_QueryExecute(EventObject args) {

		getGFormClass().queryExecute(args);
	}

	@AfterCommit
	public void Whawitd_AfterCommit(EventObject args) {
		getGFormClass().afterCommit(args);
	}

	@ActionTrigger(action = "POST_FORMS_COMMIT_TRG")
	public void Whawitd_PostFormsCommitTrg() {
		getGFormClass().postFormsCommitTrg();
	}

	@ActionTrigger(action = "WHEN-BUTTON-PRESSED")
	public void Whawitd_buttonClick() {
		getGFormClass().click();
	}

	@ActionTrigger(action = "WHEN-NEW-BLOCK-INSTANCE", function = KeyFunction.BLOCK_CHANGE)
	@Before
	public void Whawitd_blockChange() {
		getGFormClass().blockChange();
	}

	@ActionTrigger(action = "WHEN-MOUSE-DOUBLECLICK")
	public void Whawitd_doubleClick() {

		getGFormClass().doubleClick();
	}

	@ActionTrigger(action = "WHEN-TIMER-EXPIRED")
	public void Whawitd_WhenTimerExpired(NString timerName) {

		getGFormClass().whenTimerExpired(timerName);
	}

	@ActionTrigger(action = "WHEN-WINDOW-ACTIVATED")
	public void Whawitd_WhenWindowActivated() {
		getGFormClass().whenWindowActivated();
	}

	@ActionTrigger(action = "WHEN_WINDOW_ACTIVATED_TRG")
	public void Whawitd_WhenWindowActivatedTrg() {

		getGFormClass().whenWindowActivatedTrg();
	}

	@ActionTrigger(action = "WHEN-WINDOW-CLOSED")
	public void Whawitd_WhenWindowClosed() {
		getGFormClass().whenWindowClosed();
	}

	@ActionTrigger(action = "KEY-HELP", function = KeyFunction.HELP)
	public void Whawitd_Help() {

		getGFormClass().help();
	}

	@ActionTrigger(action = "KEY-F0", function = KeyFunction.KEY_F0)
	public void Whawitd_F0() {

		getGFormClass().f0();
	}

	@ActionTrigger(action = "KEY-F2", function = KeyFunction.KEY_F2)
	public void Whawitd_F2() {

		getGFormClass().f2();
	}

	@ActionTrigger(action = "KEY-DOWN", function = KeyFunction.DOWN)
	public void Whawitd_MoveDown() {

		getGFormClass().moveDown();
	}

	@ActionTrigger(action = "KEY-UP", function = KeyFunction.UP)
	public void Whawitd_MoveUp() {

		getGFormClass().moveUp();
	}

	@ActionTrigger(action = "KEY-LISTVAL", function = KeyFunction.LIST_VALUES)
	public void Whawitd_ListValues() {

		getGFormClass().listValues();
	}

	@ActionTrigger(action = "KEY-MENU")
	public void Whawitd_KeyMenu() {

		getGFormClass().keyMenu();
	}

	@ActionTrigger(action = "KEY-NXTREC", function = KeyFunction.NEXT_RECORD)
	public void Whawitd_NextRecord() {

		getGFormClass().nextRecord();
	}

	@ActionTrigger(action = "KEY-PRVREC", function = KeyFunction.PREVIOUS_RECORD)
	public void Whawitd_PreviousRecord() {

		getGFormClass().previousRecord();
	}

	@ActionTrigger(action = "KEY-NXTSET")
	public void Whawitd_KeyNxtset() {

		getGFormClass().keyNxtset();
	}

	@ActionTrigger(action = "KEY-SCRUP")
	public void Whawitd_KeyScrup() {

		getGFormClass().keyScrup();
	}

	@ActionTrigger(action = "KEY-SCRDOWN")
	public void Whawitd_KeyScrdown() {

		getGFormClass().keyScrdown();
	}

	@ActionTrigger(action = "KEY-PRINT")
	public void Whawitd_KeyPrint() {

		getGFormClass().keyPrint();
	}

	@ActionTrigger(action = "KEY-ENTQRY", function = KeyFunction.SEARCH)
	public void Whawitd_Search() {

		getGFormClass().search();
	}

	@ActionTrigger(action = "KEY-EXEQRY", function = KeyFunction.EXECUTE_QUERY)
	public void Whawitd_ExecuteQuery() {

		getGFormClass().executeQuery();
	}

	@ActionTrigger(action = "KEY-EXIT", function = KeyFunction.EXIT)
	public void Whawitd_Exit() {

		getGFormClass().exit();
	}

	@ActionTrigger(action = "KEY_EXIT_TRG")
	public void Whawitd_KeyExitTrg() {

		getTask().getGoqrpls().gDetermineEraseGlobal();
	}

	@ActionTrigger(action = "KEY-NXTKEY")
	public void Whawitd_KeyNxtkey() {

		getGFormClass().keyNxtkey();
	}

	@ActionTrigger(action = "KEY_NXTKEY_TRG")
	public void Whawitd_KeyNxtkeyTrg() {

		getGFormClass().keyNxtkeyTrg();
	}

	@ActionTrigger(action = "LIST_VALUES_COPY")
	public void Whawitd_ListValuesCopy() {

		getGFormClass().listValuesCopy();
	}

	@ActionTrigger(action = "LOAD_FORM_HEADER")
	public void Whawitd_LoadFormHeader() {

		getGFormClass().loadFormHeader();
	}

	@ActionTrigger(action = "INVALID_OPTION_MSG")
	public void Whawitd_InvalidOptionMsg() {

		getGFormClass().invalidOptionMsg();
	}

	@ActionTrigger(action = "CHECK_KEYS")
	public void Whawitd_CheckKeys() {
	}

	@ActionTrigger(action = "WHEN-NEW-RECORD-INSTANCE", function = KeyFunction.RECORD_CHANGE)
	@Before
	public void Whawitd_recordChange() {

		getGApplFormClass().recordChange();
	}

	@ActionTrigger(action = "LOAD_CURRENT_RELEASE")
	public void Whawitd_LoadCurrentRelease() {
		getGFormClass().loadCurrentRelease();
	}

	@ActionTrigger(action = "WHEN_NEW_BLOCK_INSTANCE_TRG")
	public void Whawitd_WhenNewBlockInstanceTrg() {
		if (getFormModel().getButtonControlBlock().getCheckKeys().equals("Y")) {
			getFormModel().getButtonControlBlock().setCheckKeys(toStr("N"));
			goBlock(toStr("KEY_BLOCK"));
			executeAction("CHECK_KEYS");
			getTask().getGoqrpls().gCheckFailure();
			
			nextBlock();

			getFormModel().getButtonControlBlock().setCheckKeys(toStr("N"));
			executeAction("DISABLE_KEYS");
			getTask().getGoqrpls().gCheckFailure();
		}
	}

	@ActionTrigger(action = "UPDATE_ACTIVITY")
	public void Whawitd_UpdateActivity() {

		getGFormClass().updateActivity();
	}

	@ActionTrigger(action = "SAVE_KEYS")
	public void Whawitd_SaveKeys() {
		setGlobal("ID", toStr(getFormModel().getKeyBlock().getId()));
	}

	@ActionTrigger(action = "GLOBAL_COPY")
	public void Whawitd_GlobalCopy() {
		getFormModel().getKeyBlock().setId(new NString(getGlobal("ID").toString()));
	}

	@ActionTrigger(action = "ENABLE_KEYS")
	public void Whawitd_EnableKeys() {
		getGFormClass().enableKeys();

	}

	@ActionTrigger(action = "DISABLE_KEYS")
	public void Whawitd_DisableKeys() {
		getGFormClass().disableKeys();

	}

	@TaskStarted
	public void Whawitd_TaskStarted(EventObject args) {

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

	@ActionTrigger(action = "KEY-PRVBLK", function = KeyFunction.PREVIOUS_BLOCK)
	public void Whawitd_PreviousBlock() {
		getGFormClass().previousBlock();
	}

	@ActionTrigger(action = "KEY-NXTBLK", function = KeyFunction.NEXT_BLOCK)
	public void Whawitd_NextBlock() {
		getGFormClass().nextBlock();
	}

	@ActionTrigger(action = "KEY-CLRFRM", function = KeyFunction.CLEAR_FORM)
	public void Whawitd_ClearTask() {
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

	

}