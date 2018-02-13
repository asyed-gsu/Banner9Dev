package net.hedtech.banner.student.gsu.student.Wcascmt.controller;

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
import net.hedtech.banner.student.gsu.student.Wcascmt.WcascmtTask;
import net.hedtech.banner.student.gsu.student.Wcascmt.model.WcascmtModel;
import net.hedtech.general.common.dbservices.GNls;
import net.hedtech.general.common.libraries.Goqolib.services.GFormClass;
import net.hedtech.general.common.libraries.Goqolib.services.*;

public class WcascmtFormController extends DefaultFormController {

	public WcascmtFormController(ITask task) {
		super(task);
	}

	@Override
	public WcascmtTask getTask() {
		return (WcascmtTask) super.getTask();
	}

	public WcascmtModel getFormModel() {
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
	public void Wcascmt_GVerifyAccess() {
		getGFormClass().gVerifyAccess();
	}

	@ActionTrigger(action = "G$_REVOKE_ACCESS")
	public void Wcascmt_GRevokeAccess() {

		getGFormClass().gRevokeAccess();
	}

	@TaskStartedPre
	public void Wcascmt_TaskStartedPre(EventObject args) {
		getGFormClass().taskStartedPre(args);
	}

	@ActionTrigger(action = "PRE_FORM_TRG")
	public void Wcascmt_PreFormTrg() {
		getGFormClass().preFormTrg();
	}

	@TaskEnded
	public void Wcascmt_TaskEnded(EventObject args) {
		getGFormClass().taskEnded(args);
	}

	@ActionTrigger(action = "POST_FORM_TRG")
	public void Wcascmt_PostFormTrg() {
		getGFormClass().postFormTrg();
	}

	@ActionTrigger(action = "PRE-BLOCK", function = KeyFunction.BLOCK_IN)
	@Before
	public void Wcascmt_blockIn() {
		getGFormClass().blockIn();
	}

	@ActionTrigger(action = "PRE_BLOCK_TRG")
	public void Wcascmt_PreBlockTrg() {
		getGFormClass().preBlockTrg();
	}

	@ActionTrigger(action = "POST-BLOCK", function = KeyFunction.BLOCK_OUT)
	@Before
	public void Wcascmt_blockOut() {
		getGFormClass().blockOut();
	}

	@ActionTrigger(action = "POST_BLOCK_TRG")
	public void Wcascmt_PostBlockTrg() {
		getGFormClass().postBlockTrg();
	}

	@BeforeCommit
	public void Wcascmt_BeforeCommit(CancelEvent args) {
		getGFormClass().beforeCommit(args);
	}

	@ActionTrigger(action = "PRE_COMMIT_TRG")
	public void Wcascmt_PreCommitTrg() {
		getGFormClass().preCommitTrg();
	}

	@BeforeRowInsert
	public void Wcascmt_BeforeRowInsert(RowAdapterEvent args) {

		getGFormClass().beforeRowInsert(args);
	}

	@BeforeRowUpdate
	public void Wcascmt_BeforeRowUpdate(RowAdapterEvent args) {

		getGFormClass().beforeRowUpdate(args);
	}

	@OnError
	public void Wcascmt_OnError(EventObject args) {

		getGFormClass().onError(args);
	}

	@OnRollback
	public void Wcascmt_OnRollback(EventObject args) {
		getGFormClass().onRollback();
	}

	@ActionTrigger(action = "ON_ROLLBACK_TRG")
	public void Wcascmt_OnRollbackTrg() {
		getGFormClass().onRollbackTrg();
	}

	@QueryExecute
	public void Wcascmt_QueryExecute(EventObject args) {

		getGFormClass().queryExecute(args);
	}

	@AfterCommit
	public void Wcascmt_AfterCommit(EventObject args) {
		getGFormClass().afterCommit(args);
	}

	@ActionTrigger(action = "POST_FORMS_COMMIT_TRG")
	public void Wcascmt_PostFormsCommitTrg() {
		getGFormClass().postFormsCommitTrg();
	}

	@ActionTrigger(action = "WHEN-BUTTON-PRESSED")
	public void Wcascmt_buttonClick() {
		getGFormClass().click();
	}

	@ActionTrigger(action = "WHEN-NEW-BLOCK-INSTANCE", function = KeyFunction.BLOCK_CHANGE)
	@Before
	public void Wcascmt_blockChange() {
		getGFormClass().blockChange();
	}

	@ActionTrigger(action = "WHEN-MOUSE-DOUBLECLICK")
	public void Wcascmt_doubleClick() {

		getGFormClass().doubleClick();
	}

	@ActionTrigger(action = "WHEN-TIMER-EXPIRED")
	public void Wcascmt_WhenTimerExpired(NString timerName) {

		getGFormClass().whenTimerExpired(timerName);
	}

	@ActionTrigger(action = "WHEN-WINDOW-ACTIVATED")
	public void Wcascmt_WhenWindowActivated() {
		getGFormClass().whenWindowActivated();
	}

	@ActionTrigger(action = "WHEN_WINDOW_ACTIVATED_TRG")
	public void Wcascmt_WhenWindowActivatedTrg() {

		getGFormClass().whenWindowActivatedTrg();
	}

	@ActionTrigger(action = "WHEN-WINDOW-CLOSED")
	public void Wcascmt_WhenWindowClosed() {
		getGFormClass().whenWindowClosed();
	}

	@ActionTrigger(action = "KEY-HELP", function = KeyFunction.HELP)
	public void Wcascmt_Help() {

		getGFormClass().help();
	}

	@ActionTrigger(action = "KEY-F0", function = KeyFunction.KEY_F0)
	public void Wcascmt_F0() {

		getGFormClass().f0();
	}

	@ActionTrigger(action = "KEY-F2", function = KeyFunction.KEY_F2)
	public void Wcascmt_F2() {

		getGFormClass().f2();
	}

	@ActionTrigger(action = "KEY-DOWN", function = KeyFunction.DOWN)
	public void Wcascmt_MoveDown() {

		getGFormClass().moveDown();
	}

	@ActionTrigger(action = "KEY-UP", function = KeyFunction.UP)
	public void Wcascmt_MoveUp() {

		getGFormClass().moveUp();
	}

	@ActionTrigger(action = "KEY-LISTVAL", function = KeyFunction.LIST_VALUES)
	public void Wcascmt_ListValues() {

		getGFormClass().listValues();
	}

	@ActionTrigger(action = "KEY-MENU")
	public void Wcascmt_KeyMenu() {

		getGFormClass().keyMenu();
	}

	@ActionTrigger(action = "KEY-NXTREC", function = KeyFunction.NEXT_RECORD)
	public void Wcascmt_NextRecord() {

		getGFormClass().nextRecord();
	}

	@ActionTrigger(action = "KEY-PRVREC", function = KeyFunction.PREVIOUS_RECORD)
	public void Wcascmt_PreviousRecord() {

		getGFormClass().previousRecord();
	}

	@ActionTrigger(action = "KEY-NXTSET")
	public void Wcascmt_KeyNxtset() {

		getGFormClass().keyNxtset();
	}

	@ActionTrigger(action = "KEY-SCRUP")
	public void Wcascmt_KeyScrup() {

		getGFormClass().keyScrup();
	}

	@ActionTrigger(action = "KEY-SCRDOWN")
	public void Wcascmt_KeyScrdown() {

		getGFormClass().keyScrdown();
	}

	@ActionTrigger(action = "KEY-PRINT")
	public void Wcascmt_KeyPrint() {

		getGFormClass().keyPrint();
	}

	@ActionTrigger(action = "KEY-ENTQRY", function = KeyFunction.SEARCH)
	public void Wcascmt_Search() {

		getGFormClass().search();
	}

	@ActionTrigger(action = "KEY-EXEQRY", function = KeyFunction.EXECUTE_QUERY)
	public void Wcascmt_ExecuteQuery() {

		getGFormClass().executeQuery();
	}

	@ActionTrigger(action = "KEY-EXIT", function = KeyFunction.EXIT)
	public void Wcascmt_Exit() {

		getGFormClass().exit();
	}

	@ActionTrigger(action = "KEY_EXIT_TRG")
	public void Wcascmt_KeyExitTrg() {

		getTask().getGoqrpls().gDetermineEraseGlobal();
	}

	@ActionTrigger(action = "KEY-NXTKEY")
	public void Wcascmt_KeyNxtkey() {

		getGFormClass().keyNxtkey();
	}

	@ActionTrigger(action = "KEY_NXTKEY_TRG")
	public void Wcascmt_KeyNxtkeyTrg() {

		getGFormClass().keyNxtkeyTrg();
	}

	@ActionTrigger(action = "LIST_VALUES_COPY")
	public void Wcascmt_ListValuesCopy() {

		getGFormClass().listValuesCopy();
	}

	@ActionTrigger(action = "LOAD_FORM_HEADER")
	public void Wcascmt_LoadFormHeader() {

		getGFormClass().loadFormHeader();
	}

	@ActionTrigger(action = "INVALID_OPTION_MSG")
	public void Wcascmt_InvalidOptionMsg() {

		getGFormClass().invalidOptionMsg();
	}

	@ActionTrigger(action = "UPDATE_ACTIVITY")
	public void Wcascmt_UpdateActivity() {

		getGFormClass().updateActivity();
	}

	@ActionTrigger(action = "CHECK_KEYS")
	public void Wcascmt_CheckKeys() {

	}

	@ActionTrigger(action = "WHEN-NEW-RECORD-INSTANCE", function = KeyFunction.RECORD_CHANGE)
	@Before
	public void Wcascmt_recordChange() {

		getGApplFormClass().recordChange();
	}

	@ActionTrigger(action = "LOAD_CURRENT_RELEASE")
	public void Wcascmt_LoadCurrentRelease() {
		getGFormClass().loadCurrentRelease();
	}

	@ActionTrigger(action = "WHEN_NEW_BLOCK_INSTANCE_TRG")
	public void Wcascmt_WhenNewBlockInstanceTrg() {
		if (getFormModel().getButtonControlBlock().getCheckKeys().equals("Y")) {
			getFormModel().getButtonControlBlock().setCheckKeys(toStr("N"));
			goBlock(toStr("KEY_BLOCK"));
			getTask().getGoqrpls().gCheckValue(
					!(getFormModel().getKeyBlock().getKeyblockTermCode().isNotNull()
							&& getFormModel().getKeyBlock().getKeyblockSubjCode().isNotNull()),
					toStr("*ERROR* Valid term, subject, and course must be entered."), toBool(NBool.True),
					toBool(NBool.True));
			getTask().getGoqrpls().gCheckFailure();

			nextBlock();
			executeQuery();

			getFormModel().getButtonControlBlock().setCheckKeys(toStr("N"));
			executeAction("DISABLE_KEYS");
			getTask().getGoqrpls().gCheckFailure();
		}
	}

	@TaskStarted
	public void Wcascmt_TaskStarted(EventObject args) {

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
	public void Wcascmt_SaveKeys() {
		setGlobal("KEYBLOCK_TERM_CODE", getFormModel().getKeyBlock().getKeyblockTermCode());
		setGlobal("KEYBLOCK_SUBJ_CODE", getFormModel().getKeyBlock().getKeyblockSubjCode());
	}
	
	@ActionTrigger(action = "INVALID_FUNCTION_MSG")
	public void Wcascmt_InvalidFunctionMsg() {
		try{
		errorMessage("*ERROR* Invalid function; press SHOW KEYS for valid functions.");
		throw new ApplicationException();
	}
		catch(ApplicationException e){
			throw new ApplicationException();
		}
	}

	@ActionTrigger(action = "GLOBAL_COPY")
	public void Wcascmt_GlobalCopy() {
		getFormModel().getKeyBlock().setKeyblockTermCode(getGlobal("KEYBLOCK_TERM_CODE"));
		getFormModel().getKeyBlock().setKeyblockSubjCode(getGlobal("KEYBLOCK_SUBJ_CODE"));

	}

	/*
	 * IF GET_ITEM_PROPERTY('KEY_TERM_CODE',ENABLED) = 'FALSE' THEN
	 * SET_ITEM_PROPERTY('KEY_TERM_CODE',ENABLED,PROPERTY_ON);
	 * SET_ITEM_PROPERTY('KEY_TERM_CODE',NAVIGABLE,PROPERTY_ON);
	 * SET_ITEM_PROPERTY('KEY_TERM_CODE',REQUIRED,PROPERTY_ON); END IF; IF
	 * GET_ITEM_PROPERTY('KEY_SUBJ',ENABLED) = 'FALSE' THEN
	 * SET_ITEM_PROPERTY('KEY_SUBJ',ENABLED,PROPERTY_ON);
	 * SET_ITEM_PROPERTY('KEY_SUBJ',NAVIGABLE,PROPERTY_ON);
	 * SET_ITEM_PROPERTY('KEY_SUBJ',REQUIRED,PROPERTY_ON); END IF;
	 */

	@ActionTrigger(action = "ENABLE_KEYS")
	public void Wcascmt_EnableKeys() {

		if (getItemEnabled("KEYBLOCK_TERM_CODE").equals("FALSE")) {
			setItemEnabled("KEYBLOCK_TERM_CODE", true);
			setItemNavigable("KEYBLOCK_TERM_CODE", true);
			setItemRequired("KEYBLOCK_TERM_CODE", true);
		}

		if (getItemEnabled("KEYBLOCK_SUBJ_CODE").equals("FALSE")) {
			setItemEnabled("KEYBLOCK_SUBJ_CODE", true);
			setItemNavigable("KEYBLOCK_SUBJ_CODE", true);
			setItemRequired("KEYBLOCK_SUBJ_CODE", true);
		}

	}

	/*
	 * SET_ITEM_PROPERTY('KEY_TERM_CODE',ENABLED,PROPERTY_OFF);
	 * SET_ITEM_PROPERTY('KEY_SUBJ',ENABLED,PROPERTY_OFF);
	 */

	@ActionTrigger(action = "DISABLE_KEYS")
	public void Wcascmt_DisableKeys() {
		setItemEnabled("KEYBLOCK_TERM_CODE", false);
		setItemEnabled("KEYBLOCK_SUBJ_CODE", false);

	}

	/*
	 * EXECUTE_TRIGGER( 'INVALID_FUNCTION_MSG' ) ; G$_CHECK_FAILURE ;
	 */

	@ActionTrigger(action = "KEY-PRVBLK", function = KeyFunction.PREVIOUS_BLOCK)
	public void Wcascmt_PreviousBlock() {
		executeAction("INVALID_FUNCTION_MSG");
		getTask().getGoqrpls().gCheckFailure();
	}

	@ActionTrigger(action = "KEY-NXTBLK", function = KeyFunction.NEXT_BLOCK)
	public void Wcascmt_NextBlock() {
		executeAction("INVALID_FUNCTION_MSG");
		getTask().getGoqrpls().gCheckFailure();
	}

	@ActionTrigger(action = "KEY-CLRFRM", function = KeyFunction.CLEAR_FORM)
	public void Wcascmt_ClearTask() {
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