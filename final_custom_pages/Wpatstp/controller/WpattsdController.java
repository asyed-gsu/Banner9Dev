package net.hedtech.banner.student.gsu.student.Wpatstp.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import morphis.foundations.core.appsupportlib.runtime.action.*;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import morphis.foundations.core.types.NBool;
import morphis.foundations.core.types.NDate;
import static morphis.foundations.core.appsupportlib.Globals.*;

import static morphis.foundations.core.types.Types.*;
import static morphis.foundations.core.util.globals.Globals.setGlobal;

import morphis.core.utils.behavior.annotations.*;
import morphis.foundations.core.appdatalayer.data.*;
import morphis.foundations.core.appsupportlib.exceptions.ApplicationException;
import morphis.foundations.core.appsupportlib.model.IDBBusinessObject;
import net.hedtech.banner.student.gsu.student.Wpatstp.WpatstpTask;
import net.hedtech.banner.student.gsu.student.Wpatstp.model.*;
import net.hedtech.general.common.dbservices.GNls;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.setBlockWhereClause;
import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;
import morphis.foundations.core.appdatalayer.events.BeforeRowInsert;
import morphis.foundations.core.appdatalayer.events.QueryEvent;
import morphis.foundations.core.appdatalayer.events.AfterRowUpdate;
import morphis.foundations.core.appdatalayer.events.BeforeQuery;
import morphis.foundations.core.appsupportlib.runtime.action.ActionTrigger;
import morphis.foundations.core.appsupportlib.runtime.action.ValidationTrigger;

public class WpattsdController extends DefaultBlockController {

	public WpattsdController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WpatstpTask getTask() {
		return (WpatstpTask) super.getTask();
	}

	public WpatstpModel getFormModel() {
		return getTask().getModel();
	}

	@After
	@ActionTrigger(action="PRE-BLOCK", function=KeyFunction.BLOCK_IN)
	public void wpattsd_blockIn()
	{
		//TODO to be filled by the user
	}

	@BeforeRowInsert
	public void wpattsd_BeforeRowInsert(RowAdapterEvent args) {
		WpattsdAdapter WpattsdElement = (WpattsdAdapter)args.getRow();
		WpattsdElement.setWpattsdActivityDate(NDate.getNow());
		WpattsdElement.setWpattsdUserId(getGlobal("CURRENT_USER"));
	}

	@AfterRowUpdate
	public void wpattsd_AfterRowUpdate(RowAdapterEvent args) {
		WpattsdAdapter WpattsdElement = (WpattsdAdapter)args.getRow();
		WpattsdElement.setWpattsdActivityDate(NDate.getNow());
		WpattsdElement.setWpattsdUserId(getGlobal("CURRENT_USER"));
	}
	
	@BeforeQuery
	public void wpattsd_BeforeQuery(QueryEvent args) {
		
		WpattsdAdapter WpattsdElement = (WpattsdAdapter)this.getFormModel().getWpattsd().getRowAdapter(true);
		setBlockWhereClause("WPATTSD", "WHERE WPATTSD_PIDM = :PIDM");
		((IDBBusinessObject) args.getSource()).getSelectCommandParams().add(DbManager.getDataBaseFactory()
				.createDataParameter("PIDM", this.getFormModel().getKeyBlock().getPidm()));
		
}
	
	/*
	 * BEGIN
   G$_CHECK_QUERY_MODE ;
--
   DECLARE
      CURSOR PTI_CURSOR IS
         SELECT STVterm_code
         FROM   STVterm
         WHERE  STVterm_CODE = :wpattsd_term_CODE_eff;
   BEGIN
      OPEN PTI_CURSOR ;
      FETCH PTI_CURSOR INTO :hold_term_code;
      G$_CHECK_VALUE (PTI_CURSOR%NOTFOUND,
 G$_NLS.Get('WPATSTP-0006', 'FORM','*ERROR* Invalid code; press LIST for valid codes') , TRUE);
      CLOSE PTI_CURSOR;
   END ;
--
   :GLOBAL.QUERY_MODE := '0' ;
EXCEPTION
   WHEN FORM_TRIGGER_FAILURE THEN
      :GLOBAL.QUERY_MODE := '0' ;
      RAISE FORM_TRIGGER_FAILURE ;
END ;*/

	@ValidationTrigger(item = "WPATTSD_TERM_CODE_EFF")
	public void wpattsd_term_code_eff_validation() {
		WpattsdAdapter WpattsdElement = (WpattsdAdapter)this.getFormModel().getWpattsd().getRowAdapter(true);
		if(WpattsdElement == null){
			return;
		}
		
		int rowCount = 0;
		if(WpattsdElement.getWpattsdTermCodeEff().isNull()){
			return;
		}
		try{
		getTask().getGoqrpls().gCheckQueryMode();
		
		String sqlptiCursor = "SELECT stvterm_code "
         + " FROM   stvterm "
         + " WHERE  stvterm_CODE = :wpattsd_term_CODE_eff ";
		
		DataCursor ptiCursor = new DataCursor(sqlptiCursor);
		ptiCursor.addParameter("wpattsd_term_CODE_eff", WpattsdElement.getWpattsdTermCodeEff() );
		ptiCursor.open();
		ResultSet ptiCursorResults = ptiCursor.fetchInto();
		if(ptiCursorResults != null){
	WpattsdElement.setHoldTermCode(ptiCursorResults.getStr(0));
		}
		getTask().getGoqrpls().gCheckValue(ptiCursor.notFound(), GNls.Fget(toStr("WPATSTP-0006"), toStr("FORM"),toStr("*ERROR* Invalid code; press LIST for valid codes")),  toBool(NBool.True));
		
		if ( ptiCursor.notFound() )
		{
			throw new ApplicationException();
		}
		ptiCursor.close();
		setGlobal("QUERY_MODE", toStr("0"));
		}
		catch(ApplicationException e){
			setGlobal("QUERY_MODE", toStr("0"));
			throw new ApplicationException();
			
		}
	}
	
	/*
	 BEGIN
  G$_CHECK_QUERY_MODE ;
--
  DECLARE
     CURSOR PTI_CURSOR IS
        SELECT sgrsatt_atts_code
        FROM   sgrsatt
        WHERE  sgrsatt_atts_CODE = :wpattsd_perm_atts_code;
  BEGIN
     OPEN PTI_CURSOR ;
     FETCH PTI_CURSOR INTO :hold_atts_code;
     G$_CHECK_VALUE (PTI_CURSOR%NOTFOUND,
G$_NLS.Get('WPATSTP-0005', 'FORM','*ERROR* Attribute must be on student record.') , TRUE);
     CLOSE PTI_CURSOR;
  END ;
--
  DECLARE
     CURSOR PTI_CURSOR IS
        SELECT stvatts_desc
        FROM   stvatts
        WHERE  stvatts_CODE = :wpattsd_perm_atts_code;
  BEGIN
     OPEN PTI_CURSOR ;
     FETCH PTI_CURSOR INTO :hold_desc;
     G$_CHECK_VALUE (PTI_CURSOR%NOTFOUND,
        G$_NLS.Get('WPATSTP-0007', 'FORM','*ERROR* Attribute not valid.') , TRUE);
     G$_CHECK_VALUE (NOT (substr(:hold_desc,1,2) = 'P:'),
        G$_NLS.Get('WPATSTP-0008', 'FORM','*ERROR* Must be a permanent attribute.') 
        , TRUE, TRUE);
        
     CLOSE PTI_CURSOR;
  END ;
--
  :GLOBAL.QUERY_MODE := '0' ;
EXCEPTION
  WHEN FORM_TRIGGER_FAILURE THEN
     :GLOBAL.QUERY_MODE := '0' ;
     RAISE FORM_TRIGGER_FAILURE ;
END ;
	*/
	
	@ValidationTrigger(item = "WPATTSD_PERM_ATTS_CODE")
	public void wpattsd_perm_atts_code_validation() {
		WpattsdAdapter WpattsdElement = (WpattsdAdapter)this.getFormModel().getWpattsd().getRowAdapter(true);
		if(WpattsdElement == null){
			return;
		}
		
		int rowCount = 0;
		if(WpattsdElement.getWpattsdPermAttsCode().isNull()){
			return;
		}
		try{
		getTask().getGoqrpls().gCheckQueryMode();
		
		String sqlptiCursor = " SELECT sgrsatt_atts_code "
         + " FROM   sgrsatt "
        + " WHERE  sgrsatt_atts_CODE = :wpattsd_perm_atts_code";
		
		DataCursor ptiCursor = new DataCursor(sqlptiCursor);
		ptiCursor.addParameter("wpattsd_perm_atts_code", WpattsdElement.getWpattsdPermAttsCode() );
		ptiCursor.open();
		ResultSet ptiCursorResults = ptiCursor.fetchInto();
		if(ptiCursorResults != null){
	WpattsdElement.setHoldAttsCode(ptiCursorResults.getStr(0));
		}
		getTask().getGoqrpls().gCheckValue(ptiCursor.notFound(), GNls.Fget(toStr("WPATSTP-0005"), toStr("FORM"),toStr("*ERROR* Attribute must be on student record.")),  toBool(NBool.True));
		
		ptiCursor.close();
		
		String sqlptiCursor1 = "SELECT stvatts_desc "
        + " FROM   stvatts " 
         + " WHERE  stvatts_CODE = :wpattsd_perm_atts_code";
				
				DataCursor ptiCursor1 = new DataCursor(sqlptiCursor1);
				ptiCursor.addParameter("wpattsd_perm_atts_code", WpattsdElement.getWpattsdPermAttsCode() );
				ptiCursor.open();
				ResultSet ptiCursorResults1 = ptiCursor.fetchInto();
				if(ptiCursorResults != null){
			WpattsdElement.setHoldDesc(ptiCursorResults.getStr(0));
				}
				getTask().getGoqrpls().gCheckValue(ptiCursor.notFound(), GNls.Fget(toStr("WPATSTP-0007"), toStr("FORM"),toStr("*ERROR* Attribute not valid.")),  toBool(NBool.True));
				getTask().getGoqrpls().gCheckValue((WpattsdElement.getHoldDesc().substring(1, 2) != "P"), GNls.Fget(toStr("WPATSTP-0008"), toStr("FORM"),toStr("*ERROR* Must be a permanent attribute.")),  toBool(NBool.True), toBool(NBool.True));
				
				ptiCursor1.close();
		
		setGlobal("QUERY_MODE", toStr("0"));
		}
		catch(ApplicationException e){
			setGlobal("QUERY_MODE", toStr("0"));
			throw new ApplicationException();
			
		}
	}

	
}