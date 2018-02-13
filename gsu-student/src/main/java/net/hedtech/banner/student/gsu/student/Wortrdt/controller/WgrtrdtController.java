package net.hedtech.banner.student.gsu.student.Wortrdt.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.general.common.libraries.Goqolib.services.GCodeClass;
import morphis.foundations.core.appsupportlib.runtime.action.*;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import morphis.foundations.core.types.NBool;
import morphis.foundations.core.types.NDate;
import morphis.foundations.core.types.NNumber;
import morphis.foundations.core.types.NString;
import morphis.foundations.core.util.Ref;
import morphis.foundations.flavors.forms.appsupportlib.runtime.action.AfterValueChangedTrigger;

import static morphis.foundations.core.types.Types.*;
import static morphis.foundations.core.util.globals.Globals.setGlobal;
import static net.hedtech.general.common.forms.services.BaseTaskServices.executeAction;

import morphis.core.utils.behavior.annotations.*;
import morphis.foundations.core.appdatalayer.data.*;
import morphis.foundations.core.appdatalayer.events.BeforeQuery;
import morphis.foundations.core.appdatalayer.events.QueryEvent;
import morphis.foundations.core.appsupportlib.exceptions.ApplicationException;
import morphis.foundations.core.appsupportlib.model.IDBBusinessObject;
import net.hedtech.banner.student.gsu.student.Wortrdt.WortrdtTask;
import net.hedtech.banner.student.gsu.student.Wortrdt.model.*;
import net.hedtech.banner.student.gsu.student.Wpatstp.model.WpattsdAdapter;
import net.hedtech.banner.student.gsu.student.Wtvsrvy.model.WtvsrvyAdapter;
import net.hedtech.general.common.dbservices.GNls;

import static morphis.foundations.core.appsupportlib.Globals.getGlobal;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.nextBlock;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.setBlockWhereClause;
import static morphis.foundations.core.appsupportlib.runtime.MessageServices.errorMessage;
import morphis.foundations.core.appsupportlib.Lib;
import morphis.foundations.core.appsupportlib.runtime.*;
import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;
import morphis.foundations.core.appdatalayer.events.BeforeRowInsert;
import morphis.foundations.core.appdatalayer.events.AfterQuery;
import morphis.foundations.core.appdatalayer.events.BeforeRowUpdate;
import morphis.foundations.core.appdatalayer.events.RowInsert;
import morphis.foundations.core.appdatalayer.events.RowUpdate;

public class WgrtrdtController extends DefaultBlockController {
	
	private GCodeClass getGCodeClass() {
		return (net.hedtech.general.common.libraries.Goqolib.services.GCodeClass) this.getTask().getTaskPart("GOQOLIB")
				.getSupportCodeManager().getPackage("G$_CODE_CLASS");
	}

	public WgrtrdtController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WortrdtTask getTask() {
		return (WortrdtTask) super.getTask();
	}

	public WortrdtModel getFormModel() {
		return getTask().getModel();
	}

	@After
	@ActionTrigger(action="PRE-BLOCK", function=KeyFunction.BLOCK_IN)
	public void wgrtrdt_blockIn()
	{
		//TODO to be filled by the user
	}
	
	@BeforeQuery
	public void wgrtrdt_BeforeQuery(QueryEvent args) {
		
		WgrtrdtAdapter WgrtrdtElement = (WgrtrdtAdapter)this.getFormModel().getWgrtrdt().getRowAdapter(true);
		setBlockWhereClause("WGRTRDT", "WHERE WGRTRDT_TERM_CODE = :STVTERM_CODE");
		((IDBBusinessObject) args.getSource()).getSelectCommandParams().add(DbManager.getDataBaseFactory()
				.createDataParameter("STVTERM_CODE", this.getFormModel().getKeyBlock().getStvtermCode()));
}

	@BeforeRowInsert
	public void wgrtrdt_BeforeRowInsert(RowAdapterEvent args) {
		WgrtrdtAdapter WgrtrdtElement = (WgrtrdtAdapter)args.getRow();
		WgrtrdtElement.setUpdateInd(toStr("Y"));
		WgrtrdtElement.setWgrtrdtActivityDate(NDate.getNow());
		WgrtrdtElement.setWgrtrdtUser(getGlobal("CURRENT_USER"));
	}
	
	/*BEGIN
   DECLARE
      CURSOR PTI_CURSOR IS
         SELECT WTVTRME_DESCRIPTION
         FROM   WTVTRME
         WHERE  WTVTRME_EVENT_CODE = :WGRTRDT_TRME_CODE;
         
      CURSOR PTI_CURSOR2 IS
         SELECT STVPTRM_DESC
         FROM   SATURN.STVPTRM
         WHERE  STVPTRM_CODE = :WGRTRDT_PTRM_CODE;
   BEGIN
      OPEN PTI_CURSOR ;
      FETCH PTI_CURSOR INTO :WGRTRDT.WTVTRME_DESCRIPTION;
      G$_CHECK_VALUE (PTI_CURSOR%NOTFOUND,
 		 G$_NLS.Get('WGRTRDT-0015', 'FORM','*ERROR* Invalid code; press LIST for valid codes') , TRUE);
 		 
 		 IF :WGRTRDT_PTRM_CODE is not NULL THEN
 		     OPEN PTI_CURSOR2 ;
         FETCH PTI_CURSOR2 INTO :STVPTRM_DESCRIPTION;
         G$_CHECK_VALUE (PTI_CURSOR2%NOTFOUND,
 		     G$_NLS.Get('WGRTRDT-0015', 'FORM','*ERROR* Invalid code; press LIST for valid codes') , TRUE);
 		 END IF;
   END ;
  
  EXCEPTION
   WHEN FORM_TRIGGER_FAILURE THEN
      :GLOBAL.QUERY_MODE := '0' ;
      RAISE FORM_TRIGGER_FAILURE ;
END ;
   */

	@AfterQuery
	public void wgrtrdt_AfterQuery(RowAdapterEvent args) {
		
		
		WgrtrdtAdapter WgrtrdtElement = (WgrtrdtAdapter)this.getFormModel().getWgrtrdt().getRowAdapter(true);
		
		String ptiCursorSql = "SELECT WTVTRME_DESCRIPTION "
        + " FROM   WTVTRME"
        +" WHERE  WTVTRME_EVENT_CODE = :WGRTRDT_TRME_CODE";
		
		String ptiCursorSql1 = " SELECT STVPTRM_DESC "
        + " FROM   STVPTRM"
        + " WHERE  STVPTRM_CODE = :WGRTRDT_PTRM_CODE";
					
					DataCursor ptiCursor = new DataCursor(ptiCursorSql);
					
					DataCursor ptiCursor1 = new DataCursor(ptiCursorSql1);
					
					ptiCursor.addParameter("WGRTRDT_TRME_CODE", WgrtrdtElement.getWgrtrdtTrmeCode());
					ptiCursor.open();
					
					ptiCursor1.addParameter("WGRTRDT_PTRM_CODE", WgrtrdtElement.getWgrtrdtPtrmCode());
					ptiCursor1.open();
					
					try{
						
						if(ptiCursor.notFound()){
							throw new ApplicationException();
						}
					
					ResultSet ptiCursorResults = ptiCursor.fetchInto();
					
					if(ptiCursorResults != null){
						WgrtrdtElement.setWtvtrmeDescription(ptiCursorResults.getStr(0));
						getTask().getGoqrpls().gCheckValue(ptiCursor.notFound(), GNls.Fget("WGRTRDT-0015", "FORM","*ERROR* Invalid code; press LIST for valid codes.") , toBool(NBool.True));
					}
					
					if(ptiCursor1.notFound()){
						throw new ApplicationException();
					}
					
					ResultSet ptiCursorResults1 = ptiCursor1.fetchInto();
					
					if(ptiCursorResults1 != null){
						WgrtrdtElement.setStvptrmDescription(ptiCursorResults1.getStr(0));
						getTask().getGoqrpls().gCheckValue(ptiCursor.notFound(), GNls.Fget("WGRTRDT-0015", "FORM","*ERROR* Invalid code; press LIST for valid codes.") , toBool(NBool.True));
					
					}
					}
					catch(ApplicationException e){
						setGlobal("QUERY_MODE", toStr("0"));
						throw new ApplicationException();
					}
						
					finally{
						ptiCursor.close();
						ptiCursor1.close();
						
					}
	}

	@BeforeRowUpdate
	public void wgrtrdt_BeforeRowUpdate(RowAdapterEvent args) {
		
		WgrtrdtAdapter WgrtrdtElement = (WgrtrdtAdapter)args.getRow();
		WgrtrdtElement.setUpdateInd(toStr("Y"));
		WgrtrdtElement.setWgrtrdtActivityDate(NDate.getNow());
		WgrtrdtElement.setWgrtrdtUser(getGlobal("CURRENT_USER"));
	}

	@AfterValueChangedTrigger( item="WGRTRDT_TRME_CODE")
	public void wgrtrdtTrmeCode_PostChange()
	{

WgrtrdtAdapter WgrtrdtElement = (WgrtrdtAdapter)this.getFormModel().getWgrtrdt().getRowAdapter(true);
		
		String ptiCursorSql = "SELECT WTVTRME_DESCRIPTION "
        + " FROM   WTVTRME"
        +" WHERE  WTVTRME_EVENT_CODE = :WGRTRDT_TRME_CODE";
					
					DataCursor ptiCursor = new DataCursor(ptiCursorSql);
					
					
					ptiCursor.addParameter("WGRTRDT_TRME_CODE", WgrtrdtElement.getWgrtrdtTrmeCode());
					ptiCursor.open();
					
					try{
						
						if(ptiCursor.notFound()){
							throw new ApplicationException();
						}
					
					ResultSet ptiCursorResults = ptiCursor.fetchInto();
					
					if(ptiCursorResults != null){
						WgrtrdtElement.setWtvtrmeDescription(ptiCursorResults.getStr(0));
						getTask().getGoqrpls().gCheckValue(ptiCursor.notFound(), GNls.Fget("WGRTRDT-0015", "FORM","*ERROR* Invalid code; press LIST for valid codes.") , toBool(NBool.True));
					}
				
					}
					catch(ApplicationException e){
						setGlobal("QUERY_MODE", toStr("0"));
						throw new ApplicationException();
					}
						
					finally{
						ptiCursor.close();
						
					}
	}
	
	@AfterValueChangedTrigger( item="WGRTRDT_PTRM_CODE")
	public void wgrtrdtPtrmCode_PostChange()
	{

WgrtrdtAdapter WgrtrdtElement = (WgrtrdtAdapter)this.getFormModel().getWgrtrdt().getRowAdapter(true);
		
String ptiCursorSql = " SELECT STVPTRM_DESC "
        + " FROM   STVPTRM"
        + " WHERE  STVPTRM_CODE = :WGRTRDT_PTRM_CODE";
					
					DataCursor ptiCursor = new DataCursor(ptiCursorSql);
					
					
					ptiCursor.addParameter("WGRTRDT_PTRM_CODE", WgrtrdtElement.getWgrtrdtPtrmCode());
					ptiCursor.open();
					
					try{
						
						if(ptiCursor.notFound()){
							throw new ApplicationException();
						}
					
					ResultSet ptiCursorResults = ptiCursor.fetchInto();
					
					if(ptiCursorResults != null){
						WgrtrdtElement.setStvptrmDescription(ptiCursorResults.getStr(0));
						getTask().getGoqrpls().gCheckValue(ptiCursor.notFound(), GNls.Fget("WGRTRDT-0015", "FORM","*ERROR* Invalid code; press LIST for valid codes.") , toBool(NBool.True));
					}
				
					}
					catch(ApplicationException e){
						setGlobal("QUERY_MODE", toStr("0"));
						throw new ApplicationException();
					}
						
					finally{
						ptiCursor.close();
						
					}
	}
	
	
	
}