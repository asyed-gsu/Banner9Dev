package net.hedtech.banner.student.gsu.student.Wcascmt.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.dbservices.GNls;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import morphis.foundations.core.appsupportlib.runtime.action.*;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import morphis.foundations.core.types.NBool;
import morphis.foundations.core.types.NDate;
import morphis.foundations.core.types.NString;

import static morphis.foundations.core.types.Types.*;

import morphis.core.utils.behavior.annotations.*;
import morphis.foundations.core.appdatalayer.data.*;
import morphis.foundations.core.appdatalayer.events.BeforeQuery;
import morphis.foundations.core.appdatalayer.events.QueryEvent;
import morphis.foundations.core.appsupportlib.model.IDBBusinessObject;
import net.hedtech.banner.student.gsu.student.Wcascmt.WcascmtTask;
import net.hedtech.banner.student.gsu.student.Wcascmt.model.*;

import static morphis.foundations.core.appsupportlib.Lib.isNull;
import static morphis.foundations.core.appsupportlib.Lib.trunc;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.createRecord;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.nextRecord;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.previousRecord;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.setBlockWhereClause;
import static morphis.foundations.core.appsupportlib.runtime.MessageServices.errorMessage;
import static morphis.foundations.core.appsupportlib.runtime.TaskServices.commitTask;
import static morphis.foundations.core.appsupportlib.runtime.TaskServices.executeAction;

import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;
import morphis.foundations.core.appdatalayer.events.BeforeRowInsert;
import morphis.foundations.core.appdatalayer.events.AfterRowUpdate;

public class WcrscmtController extends DefaultBlockController {

	public WcrscmtController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WcascmtTask getTask() {
		return (WcascmtTask) super.getTask();
	}

	public WcascmtModel getFormModel() {
		return getTask().getModel();
	}

	@After
	@ActionTrigger(action="PRE-BLOCK", function=KeyFunction.BLOCK_IN)
	public void wcrscmt_blockIn()
	{
		//TODO to be filled by the user
	}
	
	@BeforeQuery
	public void wcrscmt_BeforeQuery(QueryEvent args) {
		// F2J_WARNING : Query Parameters initialization. Make sure that all the
		// query parameters are properly initialized
		setBlockWhereClause("WBSCHRT", "WHERE wcrscmt_term_code = :key_term_code AND wbschrt_schp_code = :key_subj");
		((IDBBusinessObject) args.getSource()).getSelectCommandParams().add(DbManager.getDataBaseFactory()
				.createDataParameter("key_term_code", this.getFormModel().getKeyBlock().getKeyblockTermCode()));
		((IDBBusinessObject) args.getSource()).getSelectCommandParams().add(DbManager.getDataBaseFactory()
				.createDataParameter("key_subj", this.getFormModel().getKeyBlock().getKeyblockSubjCode()));
}
	
	/*
	 *    DECLARE
      PTI_INTO_TEMP        VARCHAR2(255);
      CURSOR PTI_CURSOR IS
         SELECT 'X'
         FROM   WCRSCMT
         WHERE  WCRSCMT_TERM_CODE = :WCRSCMT_TERM_CODE
           AND  WCRSCMT_SUBJ_CODE = :WCRSCMT_SUBJ_CODE
           AND  WCRSCMT_SEQNO = :WCRSCMT_SEQNO
           AND  :RESEQUENCE_IND IS NULL ;
   BEGIN
      OPEN PTI_CURSOR ;
      FETCH PTI_CURSOR INTO PTI_INTO_TEMP ;
      G$_CHECK_VALUE (PTI_CURSOR%FOUND,
'*ERROR* Press COUNT QUERY HITS to resequence comments.', TRUE);
   END ;
--
   IF G$_NCHK((:WCRSCMT_SEQNO IS NOT NULL)) THEN
      RETURN ;
   END IF ;
--
   << NUMBER_NEW_ROWS >>
   DECLARE
      CURSOR PTI_CURSOR IS
         SELECT NVL(MAX(WCRSCMT_SEQNO), 0) + 1
         FROM   WCRSCMT
         WHERE  WCRSCMT_TERM_CODE = :WCRSCMT_TERM_CODE
           AND  WCRSCMT_SUBJ_CODE = :WCRSCMT_SUBJ_CODE ;
   BEGIN
      OPEN PTI_CURSOR ;
      FETCH PTI_CURSOR INTO :WCRSCMT_SEQNO ;
      G$_CHECK_VALUE (PTI_CURSOR%NOTFOUND, NULL, TRUE);
   END ; */
	
	@BeforeRowInsert
	public void wcrscmt_BeforeRowInsert(RowAdapterEvent args)
	{
		
		WcrscmtAdapter wcrscmtElement = (WcrscmtAdapter)args.getRow();


			int rowCount = 0;
			{
				NString ptiIntoTemp= NString.getNull();
				String sqlptiCursor = "SELECT 'X' " +
" FROM WCRSCMT " +
" WHERE WCRSCMT_TERM_CODE = :WCRSCMT_TERM_CODE AND WCRSCMT_SUBJ_CODE  = :WCRSCMT_SUBJ_CODE  AND WCRSCMT_SEQNO  = :WCRSCMT_SEQNO  AND :RESEQUENCE_IND IS NULL ";
				DataCursor ptiCursor = new DataCursor(sqlptiCursor);
				try {
					//Setting query parameters
					ptiCursor.addParameter("WCRSCMT_TERM_CODE", wcrscmtElement.getWcrscmtTermCode());
					ptiCursor.addParameter("WCRSCMT_SUBJ_CODE", wcrscmtElement.getWcrscmtSubjCode());
					ptiCursor.addParameter("WCRSCMT_SEQNO", wcrscmtElement.getWcrscmtSeqno());
					ptiCursor.addParameter("RESEQUENCE_IND", getFormModel().getKeyBlock().getResequenceInd());
					//F2J_WARNING : Make sure that the method "Close" is being called over the variable ptiCursor.
					ptiCursor.open();
					ResultSet ptiCursorResults = ptiCursor.fetchInto();
					if ( ptiCursorResults != null ) {
						ptiIntoTemp = ptiCursorResults.getStr(0);
					}
					if ( ptiCursor.found() )
					{
						errorMessage(GNls.Fget(toStr("WCASCMT-0044"), toStr("FORM"), toStr("*ERROR* Press COUNT QUERY HITS to resequence comments.")));
						return ;
					}
				}
				finally{
					ptiCursor.close();
				}
			}
			// 
			if ( wcrscmtElement.getWcrscmtSeqno().isNull() )
			{
//				 goto UPDATE_KEYS;
			
			 NUMBER_NEW_ROWS:;
			{
				String sqlptiCursor = "SELECT NVL(MAX(WCRSCMT_SEQNO), 0) + 1 "
				        + " FROM   WCRSCMT "
				        + " WHERE  WCRSCMT_TERM_CODE = :WCRSCMT_TERM_CODE "
				        + " AND  WCRSCMT_SUBJ_CODE = :WCRSCMT_SUBJ_CODE"
;
				DataCursor ptiCursor = new DataCursor(sqlptiCursor);
				try {
					ptiCursor.addParameter("WCRSCMT_TERM_CODE", wcrscmtElement.getWcrscmtTermCode());
					ptiCursor.addParameter("WCRSCMT_SUBJ_CODE", wcrscmtElement.getWcrscmtSubjCode());
					ptiCursor.open();
					ResultSet ptiCursorResults = ptiCursor.fetchInto();
					if ( ptiCursorResults != null ) {
						wcrscmtElement.setWcrscmtSeqno(ptiCursorResults.getNumber(0));
						wcrscmtElement.setWcrscmtTermCode(getFormModel().getKeyBlock().getKeyblockTermCode());
						wcrscmtElement.setWcrscmtSubjCode(getFormModel().getKeyBlock().getKeyblockSubjCode());
						wcrscmtElement.setWcrscmtActivityDate(NDate.getNow());
					}
					getTask().getGoqrpls().gCheckValue(toBool(ptiCursor.notFound()), toStr(null), toBool(NBool.True));
				}
				finally{
					ptiCursor.close();
				}
			}
			
			}
			
		}

	

	@ActionTrigger(action="KEY-CQUERY", function=KeyFunction.COUNT_QUERY)
	public void wcrscmt_TotalResults()
	{
		
		WcrscmtAdapter wcrscmtElement = (WcrscmtAdapter)this.getFormModel().getWcrscmt().getRowAdapter(true);

			if(wcrscmtElement == null){
				return;
				}
	
			wcrscmtElement.setWcrscmtSeqno(trunc(wcrscmtElement.getWcrscmtSeqno().add(1), 0));
			getFormModel().getKeyBlock().setResequenceInd(toStr("Y"));
			boolean resequence = true;
			do {
				RESEQUENCE:;
					getFormModel().getKeyBlock().setHoldNumber1(wcrscmtElement.getWcrscmtSeqno());
				// 
				nextRecord();
				// 
				if ((!wcrscmtElement.getWcrscmtSeqno().isNull()))
				{
					wcrscmtElement.setWcrscmtSeqno(getFormModel().getKeyBlock().getHoldNumber1().add(1));
					wcrscmtElement.setWcrscmtTermCode(getFormModel().getKeyBlock().getKeyblockTermCode());
					wcrscmtElement.setWcrscmtSubjCode(getFormModel().getKeyBlock().getKeyblockSubjCode());
					wcrscmtElement.setWcrscmtActivityDate(NDate.getNow());
					
//					 goto RESEQUENCE;
				} 
				else {
					resequence = false;
				}
			} 
			while (resequence);
				COMMIT_RESEQUENCE:;
				commitTask();
				// 
				getFormModel().getKeyBlock().setResequenceInd(toStr(""));
		}

@ActionTrigger(action="KEY-CREREC", function=KeyFunction.CREATE_RECORD)
public void wcrscmt_CreateRecord()
{
	

	WcrscmtAdapter wcrscmtElement = (WcrscmtAdapter)this.getFormModel().getWcrscmt().getRowAdapter(true);
		
		if(wcrscmtElement==null)
			return;

		getFormModel().getKeyBlock().setHoldNumber1(isNull(wcrscmtElement.getWcrscmtSeqno(), 0));
		// 
		if ( !getFormModel().getKeyBlock().getHoldNumber1().equals("0") )
		{
		
		NORMAL_INSERT:;
		nextRecord();
		getFormModel().getKeyBlock().setHoldNumber2(wcrscmtElement.getWcrscmtSeqno());
		previousRecord();
		createRecord();
		wcrscmtElement.setWcrscmtSeqno(trunc((getFormModel().getKeyBlock().getHoldNumber2().add(getFormModel().getKeyBlock().getHoldNumber1())).divide(2), 8));
		wcrscmtElement.setWcrscmtTermCode(getFormModel().getKeyBlock().getKeyblockTermCode());
		wcrscmtElement.setWcrscmtSubjCode(getFormModel().getKeyBlock().getKeyblockSubjCode());
		wcrscmtElement.setWcrscmtActivityDate(NDate.getNow());
			
		}
		else{
		FIRST_OR_LAST:;
		createRecord();
		return;
		}
}

	@AfterRowUpdate
	public void wcrscmt_AfterRowUpdate(RowAdapterEvent args) {
		WcrscmtAdapter wcrscmtElement = (WcrscmtAdapter)args.getRow();
		wcrscmtElement.setWcrscmtActivityDate(NDate.getNow());
	}
}