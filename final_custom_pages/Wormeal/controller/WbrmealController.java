package net.hedtech.banner.student.gsu.student.Wormeal.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import morphis.foundations.core.appsupportlib.runtime.action.*;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import morphis.foundations.core.types.NDate;

import static morphis.foundations.core.types.Types.*;

import java.util.Date;

import morphis.core.utils.behavior.annotations.*;
import morphis.foundations.core.appdatalayer.data.*;
import morphis.foundations.core.appsupportlib.exceptions.ApplicationException;
import morphis.foundations.core.appsupportlib.model.IDBBusinessObject;
import net.hedtech.banner.student.gsu.student.Wormeal.WormealTask;
import net.hedtech.banner.student.gsu.student.Wormeal.model.*;
import net.hedtech.general.common.dbservices.GNls;

import static morphis.foundations.core.appsupportlib.Globals.getGlobal;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.nextBlock;
import static morphis.foundations.core.appsupportlib.runtime.MessageServices.errorMessage;
import morphis.foundations.core.appsupportlib.Lib;
import morphis.foundations.core.appsupportlib.runtime.*;
import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;
import morphis.foundations.core.appdatalayer.events.AfterQuery;
import morphis.foundations.core.appsupportlib.runtime.action.ValidationTrigger;
import morphis.foundations.core.appdatalayer.events.BeforeRowInsert;
import morphis.foundations.core.appdatalayer.events.BeforeRowUpdate;
import morphis.foundations.core.appdatalayer.events.BeforeQuery;
import morphis.foundations.core.appdatalayer.events.QueryEvent;
import morphis.foundations.core.appsupportlib.runtime.action.ActionTrigger;

public class WbrmealController extends DefaultBlockController {

	public WbrmealController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WormealTask getTask() {
		return (WormealTask) super.getTask();
	}

	public WormealModel getFormModel() {
		return getTask().getModel();
	}

	@After
	@ActionTrigger(action="PRE-BLOCK", function=KeyFunction.BLOCK_IN)
	public void wbrmeal_blockIn()
	{
		//TODO to be filled by the user
	}

	@AfterQuery
	public void wbrmeal_AfterQuery(RowAdapterEvent args) {
		WbrmealAdapter wbrmealElement = (WbrmealAdapter)args.getRow();
		
		String sqlwbrCursor = "SELECT SPRIDEN_LAST_NAME||','||SPRIDEN_FIRST_NAME || ' ' || SPRIDEN_MI as Name"
				+ "      , SPRIDEN_ID " +
				" FROM SPRIDEN " +
				" WHERE SPRIDEN_PIDM = :PIDM ";
		
		String sqlwbrCursorType = "SELECT WTRMEAL_TYPE" +
				" FROM WTRMEAL " +
				" WHERE WTRMEAL_ID = :ID ";
		
		
		
		DataCursor wbrCursor = new DataCursor(sqlwbrCursor);
		DataCursor wbrCursorType = new DataCursor(sqlwbrCursorType);
		
		try {
			wbrCursor.addParameter("PIDM",wbrmealElement.getWbrmealPidm());
			wbrCursorType.addParameter("ID",wbrmealElement.getWbrmealMealplanId());
			
			wbrCursor.open();
			wbrCursorType.open();
			
			ResultSet wbrCursorResults = wbrCursor.fetchInto();
			ResultSet wbrCursorResultsType = wbrCursorType.fetchInto();
			
			if ( wbrCursorResults != null ) {
				wbrmealElement.setWbrmealId(toStr(wbrCursorResults.getStr(1)));
				wbrmealElement.setWbrmealName(toStr(wbrCursorResults.getStr(0)));
			}
			
			if ( wbrCursorResultsType != null ) {
				wbrmealElement.setWbrmealMealPlanDesc(toStr(wbrCursorResultsType.getStr(0)));
			}
			
			if ( wbrCursor.notFound() )
			{
				return ;
			}
			if ( wbrCursorType.notFound() )
			{
				return ;
			}
		} finally {
			wbrCursor.close();
			wbrCursorType.close();
		}			
		
	}

	@ValidationTrigger(item = "WBRMEAL_ID")
	public void wbrmeal_id_validation() {
		WbrmealAdapter wbrmealElement = (WbrmealAdapter)this.getFormModel().getWbrmeal().getRowAdapter(true);
		
		String sqlwbrCursor = "SELECT SPRIDEN_LAST_NAME||','||SPRIDEN_FIRST_NAME || ' ' || SPRIDEN_MI as Name," +
		        " SPRIDEN_PIDM " +				
				" FROM SPRIDEN " +
				" WHERE SPRIDEN_ID = :STUD_ID ";
		DataCursor wbrCursor = new DataCursor(sqlwbrCursor);
		
		try {
			wbrCursor.addParameter("STUD_ID",wbrmealElement.getWbrmealId());
			
			wbrCursor.open();
			ResultSet wbrCursorResults = wbrCursor.fetchInto();
			if ( wbrCursorResults != null ) {
				wbrmealElement.setWbrmealName(toStr(wbrCursorResults.getStr(0)));
				wbrmealElement.setWbrmealPidm(toNumber(wbrCursorResults.getStr(1)));
			}
			if ( wbrCursor.notFound() )
			{ 
				wbrmealElement.setWbrmealName(toStr(null));
				wbrmealElement.setWbrmealPidm(null);
			}
		 }finally{
			wbrCursor.close();
		}
	}

	@BeforeRowInsert
	public void wbrmeal_BeforeRowInsert(RowAdapterEvent rowAdapterEvent) {
		WbrmealAdapter wbrmealElement = (WbrmealAdapter)this.getFormModel().getWbrmeal().getRowAdapter(true);
				
		wbrmealElement.setWbrmealActivityDate(NDate.getNow());
		wbrmealElement.setWbrmealEntryDate(NDate.getNow());
		wbrmealElement.setWbrmealUser(getGlobal("CURRENT_USER"));
		
		/*if (wbrmealElement.getWbrmealDropInd().isNull()){
			wbrmealElement.setWbrmealDropInd(toStr("N"));			
		} else {
			wbrmealElement.setWbrmealDropInd(toStr("Y"));
		}*/
	}
	
	@BeforeRowUpdate
	public void wbrmeal_BeforeRowUpdate(RowAdapterEvent rowAdapterEvent) {
		WbrmealAdapter wbrmealElement = (WbrmealAdapter)this.getFormModel().getWbrmeal().getRowAdapter(true);
		
		wbrmealElement.setWbrmealActivityDate(NDate.getNow());
		wbrmealElement.setWbrmealEntryDate(NDate.getNow());
		wbrmealElement.setWbrmealUser(getGlobal("CURRENT_USER"));
		
	/*	if (wbrmealElement.getWbrmealDropInd().isNull()){
			wbrmealElement.setWbrmealDropInd(toStr("N"));			
		} else {
			wbrmealElement.setWbrmealDropInd(toStr("Y"));
		}*/
	}

	@BeforeQuery
	public void wbrmeal_BeforeQuery(QueryEvent args) {
		((IDBBusinessObject)args.getSource()).getSelectCommandParams().add(DbManager.getDataBaseFactory().createDataParameter("TERM",this.getFormModel().getKeyBlock().getTerm()));
	}
		
	
	
	
	
}