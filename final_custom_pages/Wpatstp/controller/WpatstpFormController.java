package net.hedtech.banner.student.gsu.student.Wpatstp.controller;

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
import net.hedtech.banner.student.gsu.student.Wpatstp.WpatstpTask;
import net.hedtech.banner.student.gsu.student.Wpatstp.model.WpatstpModel;
import net.hedtech.general.common.dbservices.GNls;
import net.hedtech.general.common.libraries.Goqolib.services.GFormClass;
import net.hedtech.general.common.libraries.Goqolib.services.*;

public class WpatstpFormController extends DefaultFormController {

	public WpatstpFormController(ITask task) {
		super(task);
	}

	@Override
	public WpatstpTask getTask() {
		return (WpatstpTask) super.getTask();
	}

	public WpatstpModel getFormModel() {
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
	public void Wpatstp_GVerifyAccess() {
		getGFormClass().gVerifyAccess();
	}

	@ActionTrigger(action = "G$_REVOKE_ACCESS")
	public void Wpatstp_GRevokeAccess() {

		getGFormClass().gRevokeAccess();
	}

	@TaskStartedPre
	public void Wpatstp_TaskStartedPre(EventObject args) {
		getGFormClass().taskStartedPre(args);
	}

	@ActionTrigger(action = "PRE_FORM_TRG")
	public void Wpatstp_PreFormTrg() {
		getGFormClass().preFormTrg();
	}

	@TaskEnded
	public void Wpatstp_TaskEnded(EventObject args) {
		getGFormClass().taskEnded(args);
	}

	@ActionTrigger(action = "POST_FORM_TRG")
	public void Wpatstp_PostFormTrg() {
		getGFormClass().postFormTrg();
	}

	@ActionTrigger(action = "PRE-BLOCK", function = KeyFunction.BLOCK_IN)
	@Before
	public void Wpatstp_blockIn() {
		getGFormClass().blockIn();
	}

	@ActionTrigger(action = "PRE_BLOCK_TRG")
	public void Wpatstp_PreBlockTrg() {
		getGFormClass().preBlockTrg();
	}

	@ActionTrigger(action = "POST-BLOCK", function = KeyFunction.BLOCK_OUT)
	@Before
	public void Wpatstp_blockOut() {
		getGFormClass().blockOut();
	}

	@ActionTrigger(action = "POST_BLOCK_TRG")
	public void Wpatstp_PostBlockTrg() {
		getGFormClass().postBlockTrg();
	}

	@BeforeCommit
	public void Wpatstp_BeforeCommit(CancelEvent args) {
		getGFormClass().beforeCommit(args);
	}

	@ActionTrigger(action = "PRE_COMMIT_TRG")
	public void Wpatstp_PreCommitTrg() {
		getGFormClass().preCommitTrg();
	}

	@BeforeRowInsert
	public void Wpatstp_BeforeRowInsert(RowAdapterEvent args) {

		getGFormClass().beforeRowInsert(args);
	}

	@OnError
	public void Wpatstp_OnError(EventObject args) {

		getGFormClass().onError(args);
	}

	@OnRollback
	public void Wpatstp_OnRollback(EventObject args) {
		getGFormClass().onRollback();
	}

	@ActionTrigger(action = "ON_ROLLBACK_TRG")
	public void Wpatstp_OnRollbackTrg() {
		getGFormClass().onRollbackTrg();
	}

	@QueryExecute
	public void Wpatstp_QueryExecute(EventObject args) {

		getGFormClass().queryExecute(args);
	}

	@AfterCommit
	public void Wpatstp_AfterCommit(EventObject args) {
		getGFormClass().afterCommit(args);
	}

	@ActionTrigger(action = "POST_FORMS_COMMIT_TRG")
	public void Wpatstp_PostFormsCommitTrg() {
		getGFormClass().postFormsCommitTrg();
	}

	@ActionTrigger(action = "WHEN-BUTTON-PRESSED")
	public void Wpatstp_buttonClick() {
		getGFormClass().click();
	}

	@ActionTrigger(action = "WHEN-NEW-BLOCK-INSTANCE", function = KeyFunction.BLOCK_CHANGE)
	@Before
	public void Wpatstp_blockChange() {
		getGFormClass().blockChange();
	}

	@ActionTrigger(action = "WHEN-MOUSE-DOUBLECLICK")
	public void Wpatstp_doubleClick() {

		getGFormClass().doubleClick();
	}

	@ActionTrigger(action = "WHEN-TIMER-EXPIRED")
	public void Wpatstp_WhenTimerExpired(NString timerName) {

		getGFormClass().whenTimerExpired(timerName);
	}

	@ActionTrigger(action = "WHEN-WINDOW-ACTIVATED")
	public void Wpatstp_WhenWindowActivated() {
		getGFormClass().whenWindowActivated();
	}

	@ActionTrigger(action = "WHEN_WINDOW_ACTIVATED_TRG")
	public void Wpatstp_WhenWindowActivatedTrg() {

		getGFormClass().whenWindowActivatedTrg();
	}

	@ActionTrigger(action = "WHEN-WINDOW-CLOSED")
	public void Wpatstp_WhenWindowClosed() {
		getGFormClass().whenWindowClosed();
	}

	@ActionTrigger(action = "KEY-HELP", function = KeyFunction.HELP)
	public void Wpatstp_Help() {

		getGFormClass().help();
	}

	@ActionTrigger(action = "KEY-F0", function = KeyFunction.KEY_F0)
	public void Wpatstp_F0() {

		getGFormClass().f0();
	}

	@ActionTrigger(action = "KEY-F2", function = KeyFunction.KEY_F2)
	public void Wpatstp_F2() {

		getGFormClass().f2();
	}

	@ActionTrigger(action = "KEY-DOWN", function = KeyFunction.DOWN)
	public void Wpatstp_MoveDown() {

		getGFormClass().moveDown();
	}

	@ActionTrigger(action = "KEY-UP", function = KeyFunction.UP)
	public void Wpatstp_MoveUp() {

		getGFormClass().moveUp();
	}

	@ActionTrigger(action = "KEY-LISTVAL", function = KeyFunction.LIST_VALUES)
	public void Wpatstp_ListValues() {

		getGFormClass().listValues();
	}

	@ActionTrigger(action = "KEY-MENU")
	public void Wpatstp_KeyMenu() {

		getGFormClass().keyMenu();
	}

	@ActionTrigger(action = "KEY-PRVBLK", function = KeyFunction.PREVIOUS_BLOCK)
	public void Wpatstp_PreviousBlock() {
		getGFormClass().previousBlock();
	}

	@ActionTrigger(action = "KEY-NXTREC", function = KeyFunction.NEXT_RECORD)
	public void Wpatstp_NextRecord() {

		getGFormClass().nextRecord();
	}

	@ActionTrigger(action = "KEY-PRVREC", function = KeyFunction.PREVIOUS_RECORD)
	public void Wpatstp_PreviousRecord() {

		getGFormClass().previousRecord();
	}

	@ActionTrigger(action = "KEY-NXTSET")
	public void Wpatstp_KeyNxtset() {

		getGFormClass().keyNxtset();
	}

	@ActionTrigger(action = "KEY-SCRDOWN")
	public void Wpatstp_KeyScrdown() {

		getGFormClass().keyScrdown();
	}

	@ActionTrigger(action = "KEY-PRINT")
	public void Wpatstp_KeyPrint() {

		getGFormClass().keyPrint();
	}

	@ActionTrigger(action = "KEY-ENTQRY", function = KeyFunction.SEARCH)
	public void Wpatstp_Search() {

		getGFormClass().search();
	}

	@ActionTrigger(action = "KEY-EXEQRY", function = KeyFunction.EXECUTE_QUERY)
	public void Wpatstp_ExecuteQuery() {

		getGFormClass().executeQuery();
	}

	@ActionTrigger(action = "KEY-EXIT", function = KeyFunction.EXIT)
	public void Wpatstp_Exit() {

		getGFormClass().exit();
	}

	@ActionTrigger(action = "KEY-NXTKEY")
	public void Wpatstp_KeyNxtkey() {

		getGFormClass().keyNxtkey();
	}

	@ActionTrigger(action = "KEY_NXTKEY_TRG")
	public void Wpatstp_KeyNxtkeyTrg() {

		getGFormClass().keyNxtkeyTrg();
	}

	@ActionTrigger(action = "LIST_VALUES_COPY")
	public void Wpatstp_ListValuesCopy() {

		getGFormClass().listValuesCopy();
	}

	@ActionTrigger(action = "LOAD_FORM_HEADER")
	public void Wpatstp_LoadFormHeader() {

		getGFormClass().loadFormHeader();
	}

	@ActionTrigger(action = "INVALID_OPTION_MSG")
	public void Wpatstp_InvalidOptionMsg() {

		getGFormClass().invalidOptionMsg();
	}

	@ActionTrigger(action = "UPDATE_ACTIVITY")
	public void Wpatstp_UpdateActivity() {

		getGFormClass().updateActivity();
	}

	@ActionTrigger(action = "CHECK_KEYS")
	public void Wpatstp_CheckKeys() {
	}

	@ActionTrigger(action = "WHEN-NEW-RECORD-INSTANCE", function = KeyFunction.RECORD_CHANGE)
	@Before
	public void Worschp_recordChange() {

		getGApplFormClass().recordChange();
	}

	@ActionTrigger(action = "LOAD_CURRENT_RELEASE")
	public void Wpatstp_LoadCurrentRelease() {
		//getFormModel().getFormHeader().setCurrentRelease(toStr("8.5"));
		getGFormClass().loadCurrentRelease();
	}

	@ActionTrigger(action = "WHEN_NEW_BLOCK_INSTANCE_TRG")
	public void Wpatstp_WhenNewBlockInstanceTrg() {
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

	@ActionTrigger(action = "SAVE_KEYS")
	public void Wpatstp_SaveKeys() {
		setGlobal("ID", getFormModel().getKeyBlock().getId());
	}

	/*
	 * Original PL/SQL code code for TRIGGER WPATSTP.MENU_TRIGGER
	 * <multilinecomment>******************************************
	 * /******************************************* Code modified by the Forms
	 * Migration Assistant 20-Nov-2003 06:30 PM
	 *******************************************/
	/*
	 * null ; -- BLOCK_MENU ; -- IF :SYSTEM.CURRENT_BLOCK = 'KEY_BLOCK' THEN
	 * EXECUTE_TRIGGER( 'SAVE_KEYS' ) ; G$_CHECK_FAILURE ; CLEAR_FORM ;
	 * G$_CHECK_FAILURE ; EXECUTE_TRIGGER( 'LOAD_FORM_HEADER' ) ;
	 * G$_CHECK_FAILURE ; NEXT_BLOCK ; EXECUTE_TRIGGER( 'GLOBAL_COPY' ) ;
	 * G$_CHECK_FAILURE ; ELSE EXECUTE_QUERY ; END IF ;
	 * 
	 */
	/*
	 * <p> <b>Migration Comments</b> Generated from trigger:
	 * WPATSTP.MENU_TRIGGER
	 *
	 *
	 * </p>
	 */
	@ActionTrigger(action = "MENU_TRIGGER")
	public void Wpatstp_MenuTrigger() {

		if (getCurrentBlock().equals("KEY_BLOCK")) {

			executeAction("SAVE_KEYS");
			getTask().getGoqrpls().gCheckFailure();
			clearTask();
			getTask().getGoqrpls().gCheckFailure();
			executeAction("LOAD_FORM_HEADER");
			getTask().getGoqrpls().gCheckFailure();
			nextBlock();
			executeAction("GLOBAL_COPY");
			getTask().getGoqrpls().gCheckFailure();
		} else {
			executeQuery();
		}
	}

	/*
	 * Original PL/SQL code code for TRIGGER WPATSTP.INVALID_FUNCTION_MSG NULL ;
	 * MESSAGE( G$_NLS.Get('SOAHOLD-0001', 'FORM','*ERROR* Invalid function;
	 * press SHOW KEYS for valid functions.') ) ;
	 */
	/*
	 * <p> <b>Migration Comments</b> Generated from trigger:
	 * WPATSTP.INVALID_FUNCTION_MSG
	 *
	 *
	 * </p>
	 */
	@ActionTrigger(action = "INVALID_FUNCTION_MSG")
	public void Wpatstp_InvalidFunctionMsg() {

		errorMessage(GNls.Fget(toStr("SOAHOLD-0001"), toStr("FORM"),
				toStr("*ERROR* Invalid function; press SHOW KEYS for valid functions.")));
	}

	/*
	 * Original PL/SQL code code for TRIGGER WPATSTP.GLOBAL_COPY :KEY_BLOCK.ID
	 * := :GLOBAL.KEY_IDNO ; -- IF :KEY_BLOCK.ID IS NOT NULL THEN NEXT_FIELD ;
	 * END IF ;
	 * 
	 */
	/*
	 * <p> <b>Migration Comments</b> Generated from trigger: WPATSTP.GLOBAL_COPY
	 *
	 *
	 * </p>
	 */
	@ActionTrigger(action = "GLOBAL_COPY")
	public void Wpatstp_GlobalCopy() {

		getFormModel().getKeyBlock().setId(getGlobal("ID"));
		//
		if (getFormModel().getKeyBlock().getId().isNotNull()) {

			nextItem();
		}
	}
	
	/* Original PL/SQL code code for TRIGGER WPATSTP.DISABLE_KEYS
	  SET_ITEM_PROPERTY('ID',ENABLED,PROPERTY_OFF);
   SET_ITEM_PROPERTY('ID_LBT',ENABLED,PROPERTY_OFF);

	*/
	/*
	 *<p>
	 *<b>Migration Comments</b>
	 * Generated from trigger:
	 * WPATSTP.DISABLE_KEYS
	 *
	 *
	 *</p>
	*/

	@ActionTrigger(action = "DISABLE_KEYS")
	public void Wpatstp_DisableKeys() {
		setItemEnabled("ID", true);
		setItemEnabled("ID_LBT", true);
			}

	/* Original PL/SQL code code for TRIGGER WPATSTP.ENABLE_KEYS
	 IF GET_ITEM_PROPERTY('ID',ENABLED) = 'FALSE' THEN
   SET_ITEM_PROPERTY('ID',ENABLED,PROPERTY_ON);
   SET_ITEM_PROPERTY('ID',NAVIGABLE,PROPERTY_ON);
END IF;
IF GET_ITEM_PROPERTY('ID_LBT',ENABLED) = 'FALSE' THEN
   SET_ITEM_PROPERTY('ID_LBT',ENABLED,PROPERTY_ON);
END IF;

	*/
	/*
	 *<p>
	 *<b>Migration Comments</b>
	 * Generated from trigger:
	 * WPATSTP.ENABLE_KEYS
	 *
	 *
	 *</p>
	*/
	@ActionTrigger(action="ENABLE_KEYS")
	public void Wpatstp_EnableKeys()
	{
		
			if ( getItemEnabled("ID").equals("FALSE") )
			{
				setItemEnabled("ID", true);
				setItemNavigable("ID", true);
			}
			if ( getItemEnabled("ID_LBT").equals("FALSE") )
			{
				setItemEnabled("ID_LBT", true);
				
			}
		}
	
	
	/* Original PL/SQL code code for TRIGGER WPATSTP.WHEN-NEW-FORM-INSTANCE
	   G$_SET_WIN_PROPERTY ;
--
   EXECUTE_TRIGGER( 'LOAD_FORM_HEADER' ) ;
   G$_CHECK_FAILURE ;
   CLEAR_BLOCK ;
   EXECUTE_TRIGGER( 'GLOBAL_COPY' ) ;
   G$_CHECK_FAILURE ;
G$_SET_INST_PROPERTY;
	*/
	/*
	 *<p>
	 *<b>Migration Comments</b>
	 * Generated from trigger:
	 * WPATSTP.WHEN-NEW-FORM-INSTANCE
	 *
	 *
	 *</p>
	 * @param args
	*/
	@TaskStarted
	public void Wpatstp_TaskStarted(EventObject args)
	{
		executeAction("LOAD_FORM_HEADER");
		getTask().getGoqrpls().gCheckFailure();
		clearBlock();
		executeAction("GLOBAL_COPY");
		getTask().getGoqrpls().gCheckFailure();
			getTask().getGoqrpls().gSetInstProperty();
		}

	@ActionTrigger(action = "KEY-NXTBLK", function = KeyFunction.NEXT_BLOCK)
	public void Wpatstp_NextBlock() {
		getGFormClass().nextBlock();
	}
	

	/* Original PL/SQL code code for TRIGGER WPATSTP.FORM_KEY_MENU
EXECUTE_TRIGGER( 'MENU_TRIGGER' ) ;
G$_CHECK_FAILURE ;
	*/
	/*
	 *<p>
	 *<b>Migration Comments</b>
	 * Generated from trigger:
	 * WPATSTP.FORM_KEY_MENU
	 *
	 *
	 *</p>
	*/
	@ActionTrigger(action="FORM_KEY_MENU")
	public void Wpatstp_FormKeyMenu()
	{
		
			executeAction("MENU_TRIGGER");
			getTask().getGoqrpls().gCheckFailure();
		}

	@ActionTrigger(action = "KEY-CLRFRM", function = KeyFunction.CLEAR_FORM)
	public void Wpatstp_ClearTask() {
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
		getTask().getGoqrpls().gSetInstProperty();
	}

	

	@ActionTrigger(action = "ON-SELECT")
	public void Wpatstp_OnSelect() {
		getGFormClass().onSelect();
	}
	
	@ActionTrigger(action = "GOTO_FORM")
	public void Wpatstp_GoToForm() {
		setGlobal("KEY_IDNO", getFormModel().getKeyBlock().getId());
		setGlobal("SECRFRM",getGlobal("GUROPTM_NAME1"));
		executeAction("G$_REVOKE_ACCESS");
		getTask().getGoqrpls().gCheckFailure();
		getTask().getGoqrpls().gSecuredFormCall(getGlobal("CURRENT_USER"),getGlobal("SECRFRM"),toStr(""));
	}

}