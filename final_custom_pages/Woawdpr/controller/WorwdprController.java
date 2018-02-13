package net.hedtech.banner.student.gsu.student.Woawdpr.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import morphis.foundations.core.appsupportlib.runtime.action.*;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import morphis.foundations.core.types.NBool;
import morphis.foundations.core.types.NDate;
import morphis.foundations.core.types.NNumber;
import morphis.foundations.core.types.NString;
import morphis.foundations.flavors.forms.appsupportlib.runtime.action.AfterValueChangedTrigger;

import static morphis.foundations.core.types.Types.*;
import static morphis.foundations.core.util.globals.Globals.setGlobal;

import morphis.core.utils.behavior.annotations.*;
import morphis.foundations.core.appdatalayer.data.*;
import morphis.foundations.core.appsupportlib.exceptions.ApplicationException;
import morphis.foundations.core.appsupportlib.model.IDBBusinessObject;
import net.hedtech.banner.student.gsu.student.Woawdpr.WoawdprTask;
import net.hedtech.banner.student.gsu.student.Woawdpr.model.*;
import net.hedtech.banner.student.gsu.student.Worschp.model.WbschrtAdapter;
import net.hedtech.banner.student.gsu.student.Wpatstp.model.WpattsdAdapter;
import net.hedtech.general.common.dbservices.GNls;
import net.hedtech.general.common.dbservices.GbCommon;

import static morphis.foundations.core.appsupportlib.Globals.getGlobal;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.nextBlock;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.setBlockWhereClause;
import static morphis.foundations.core.appsupportlib.runtime.MessageServices.errorMessage;
import morphis.foundations.core.appsupportlib.Lib;
import morphis.foundations.core.appsupportlib.runtime.*;
import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;
import morphis.foundations.core.appdatalayer.events.BeforeRowInsert;
import morphis.foundations.core.appdatalayer.events.QueryEvent;
import morphis.foundations.core.appdatalayer.events.AfterQuery;
import morphis.foundations.core.appdatalayer.events.BeforeQuery;
import morphis.foundations.core.appsupportlib.runtime.action.ActionTrigger;

public class WorwdprController extends DefaultBlockController {

	public WorwdprController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WoawdprTask getTask() {
		return (WoawdprTask) super.getTask();
	}

	public WoawdprModel getFormModel() {
		return getTask().getModel();
	}

	@After
	@ActionTrigger(action="PRE-BLOCK", function=KeyFunction.BLOCK_IN)
	public void worwdpr_blockIn()
	{
		//TODO to be filled by the user
	}
	
	/* PRE-INSERT
	 * DECLARE
	 exists_pair  varchar2(1);

BEGIN
	 select distinct 'Y'
	 into exists_pair
	 from worwdpr
	 where worwdpr_term_code = :keybloc_term_code and
	       worwdpr_levl_code = :keybloc_levl_code and
	       ((worwdpr_subj_code_a = :worwdpr_subj_code_a and
	         worwdpr_crse_numb_a = :worwdpr_crse_numb_a) or
	        (worwdpr_subj_code_b = :worwdpr_subj_code_a and
	         worwdpr_crse_numb_b = :worwdpr_crse_numb_a));
	         
	  MESSAGE ( G$_NLS.Get('WORWDPR-0002', 'FORM','*ERROR* SUBJ-CRSE A already is part of other pair') );
    RAISE FORM_TRIGGER_FAILURE ;
	         
exception 
	 when NO_DATA_FOUND then
				Begin
					 select distinct 'Y'
					 into exists_pair
					 from worwdpr
					 where worwdpr_term_code = :keybloc_term_code and
					       worwdpr_levl_code = :keybloc_levl_code and
					       ((worwdpr_subj_code_a = :worwdpr_subj_code_b and
					         worwdpr_crse_numb_a = :worwdpr_crse_numb_b) or
					        (worwdpr_subj_code_b = :worwdpr_subj_code_b and
					         worwdpr_crse_numb_b = :worwdpr_crse_numb_b));
					  MESSAGE ( G$_NLS.Get('WORWDPR-0003', 'FORM','*ERROR* SUBJ-CRSE B already is part of other pair') );
				    RAISE FORM_TRIGGER_FAILURE ;	
        exception 
        	 when NO_DATA_FOUND then	 
							 :WORWDPR_ACTIVITY_DATE := SYSDATE ;
						   :WORWDPR_USER_ID := USER;
						   :WORWDPR_SEQ_NO := stuprd.worwdpr_seq_no.nextval;
        end;
end;
*/

	@BeforeRowInsert
	public void worwdpr_BeforeRowInsert(RowAdapterEvent args) {
		
		WorwdprAdapter worwdprElement = (WorwdprAdapter) args.getRow();
		if(worwdprElement == null){
			return;
		}
		
		NString existsPair= NString.getNull();
		try{
		String sql = "select distinct 'Y' "
	+ "from worwdpr "
	+ "where worwdpr_term_code = :keybloc_term_code and "
	+ "worwdpr_levl_code = :keybloc_levl_code and "
	+ "((worwdpr_subj_code_a = :worwdpr_subj_code_a and "
	+ "worwdpr_crse_numb_a = :worwdpr_crse_numb_a) or "
	+ "(worwdpr_subj_code_b = :worwdpr_subj_code_a and "
	+ "worwdpr_crse_numb_b = :worwdpr_crse_numb_a))";
		
		DataCommand sqlCommand = new DataCommand(sql);
		
			sqlCommand.addParameter("keybloc_term_code" , this.getFormModel().getKeyBlock().getKeyblocTermCode());
			sqlCommand.addParameter("keybloc_levl_code", this.getFormModel().getKeyBlock().getKeyblocLevlCode());
			sqlCommand.addParameter("worwdpr_subj_code_a" , worwdprElement.getWorwdprSubjCodeA());
			sqlCommand.addParameter("worwdpr_crse_numb_a", worwdprElement.getWorwdprCrseNumbA());
		ResultSet getSqlResult = sqlCommand.executeQuery();
		if(getSqlResult.hasData()){
			existsPair = getSqlResult.getStr(0);
		}
		getSqlResult.close();
		errorMessage(GNls.Fget(toStr("WORWDPR-0003"), toStr("FORM"), toStr("*ERROR* SUBJ-CRSE B already is part of other pair.")));
		throw new ApplicationException();
		}
		catch(NoDataFoundException e){
			try{
				String sql1 = "select distinct 'Y' "
			+ "from worwdpr "
					+ "where worwdpr_term_code = :keybloc_term_code and "
					+ "worwdpr_levl_code = :keybloc_levl_code and "
					+ "((worwdpr_subj_code_a = :worwdpr_subj_code_b and "
					+ "worwdpr_crse_numb_a = :worwdpr_crse_numb_b) or "
					+ "(worwdpr_subj_code_b = :worwdpr_subj_code_b and "
					+ "worwdpr_crse_numb_b = :worwdpr_crse_numb_b))";
			
			DataCommand sqlCommand1 = new DataCommand(sql1);
			
			sqlCommand1.addParameter("keybloc_term_code" , this.getFormModel().getKeyBlock().getKeyblocTermCode());
			sqlCommand1.addParameter("keybloc_levl_code", this.getFormModel().getKeyBlock().getKeyblocLevlCode());
			sqlCommand1.addParameter("worwdpr_subj_code_b" , worwdprElement.getWorwdprSubjCodeB());
			sqlCommand1.addParameter("worwdpr_crse_numb_b", worwdprElement.getWorwdprCrseNumbB());
		ResultSet getSqlResult1 = sqlCommand1.executeQuery();
		if(getSqlResult1.hasData()){
			existsPair = getSqlResult1.getStr(0);
		}
		getSqlResult1.close();
		errorMessage(GNls.Fget(toStr("WORWDPR-0003"), toStr("FORM"), toStr("*ERROR* SUBJ-CRSE B already is part of other pair")));
		throw new ApplicationException();
		}
	catch(NoDataFoundException e1){
		
		   worwdprElement.setWorwdprActivityDate(NDate.getNow());
		   worwdprElement.setWorwdprUserId(GbCommon.fSctUser());
		   worwdprElement.setWorwdprSeqNo(getNextVal());
		   
	}}}
	
	public NNumber getNextVal(){
		
		String sqlworwdprSeq = "SELECT STUPRD.WORWDPR_SEQ_NO.NEXTVAL FROM DUAL ";
		NNumber holdvar = NNumber.getNull();
		DataCursor worwdprSeq = new DataCursor(sqlworwdprSeq);
		
		worwdprSeq.open();
		ResultSet worwdprPkCResults = worwdprSeq.fetchInto();
		
		if(worwdprPkCResults != null){
			holdvar = worwdprPkCResults.getNumber(0);
		}
		
		return holdvar;
	}
		
	
	
	/*DECLARE

   CURSOR SCBCRSE_C IS
	   SELECT SCBCRSE_TITLE
	   FROM SCBCRSE
	   WHERE SCBCRSE_SUBJ_CODE = :WORWDPR_SUBJ_CODE_A AND
	         SCBCRSE_CRSE_NUMB = :WORWDPR_CRSE_NUMB_A AND
	         SCBCRSE_EFF_TERM = (SELECT MAX(SCBCRSE_EFF_TERM)
	                             FROM scbcrse
	                             WHERE SCBCRSE_SUBJ_CODE = :WORWDPR_SUBJ_CODE_A AND
	                                   SCBCRSE_CRSE_NUMB = :WORWDPR_CRSE_NUMB_A AND
	                                   SCBCRSE_EFF_TERM <= :KEYBLOC_TERM_CODE);

   CURSOR SCBCRSE_B_C IS
	   SELECT SCBCRSE_TITLE
	   FROM SCBCRSE
	   WHERE SCBCRSE_SUBJ_CODE = :WORWDPR_SUBJ_CODE_B AND
	         SCBCRSE_CRSE_NUMB = :WORWDPR_CRSE_NUMB_B AND
	         SCBCRSE_EFF_TERM = (SELECT MAX(SCBCRSE_EFF_TERM)
	                             FROM scbcrse
	                             WHERE SCBCRSE_SUBJ_CODE = :WORWDPR_SUBJ_CODE_B AND
	                                   SCBCRSE_CRSE_NUMB = :WORWDPR_CRSE_NUMB_B AND
	                                   SCBCRSE_EFF_TERM <= :KEYBLOC_TERM_CODE);   
BEGIN
   OPEN SCBCRSE_C;
   FETCH SCBCRSE_C INTO :COURSE_A_DESC;
   CLOSE SCBCRSE_C;
   
   OPEN SCBCRSE_B_C;
   FETCH SCBCRSE_B_C INTO :COURSE_B_DESC;
   CLOSE SCBCRSE_B_C;   
END ;*/

	@AfterQuery
	public void worwdpr_AfterQuery(RowAdapterEvent args) {
		WorwdprAdapter worwdprElement = (WorwdprAdapter) args.getRow();
		String sqlScbcrscC = "SELECT SCBCRSE_TITLE "
	  + "FROM SCBCRSE "
	   + "WHERE SCBCRSE_SUBJ_CODE = :WORWDPR_SUBJ_CODE_A AND "
	         + "SCBCRSE_CRSE_NUMB = :WORWDPR_CRSE_NUMB_A AND "
	         + "SCBCRSE_EFF_TERM = (SELECT MAX(SCBCRSE_EFF_TERM) "
	                            +"FROM scbcrse "
	                             +"WHERE SCBCRSE_SUBJ_CODE = :WORWDPR_SUBJ_CODE_A AND "
	                                   +"SCBCRSE_CRSE_NUMB = :WORWDPR_CRSE_NUMB_A AND "
	                                   +"SCBCRSE_EFF_TERM <= :KEYBLOC_TERM_CODE)";
		
		String sqlScbcrseBc = "SELECT SCBCRSE_TITLE "
				  + "FROM SCBCRSE "
				   + "WHERE SCBCRSE_SUBJ_CODE = :WORWDPR_SUBJ_CODE_B AND "
				         + "SCBCRSE_CRSE_NUMB = :WORWDPR_CRSE_NUMB_B AND "
				         + "SCBCRSE_EFF_TERM = (SELECT MAX(SCBCRSE_EFF_TERM) "
				                            +"FROM scbcrse "
				                             +"WHERE SCBCRSE_SUBJ_CODE = :WORWDPR_SUBJ_CODE_B AND "
				                                   +"SCBCRSE_CRSE_NUMB = :WORWDPR_CRSE_NUMB_B AND "
				                                   +"SCBCRSE_EFF_TERM <= :KEYBLOC_TERM_CODE)";
						
		DataCursor ScbcrseBCursor = new DataCursor(sqlScbcrseBc);

			
			DataCursor sqlScbcrscCursor = new DataCursor(sqlScbcrscC);
			try{
			sqlScbcrscCursor.addParameter("WORWDPR_SUBJ_CODE_A", worwdprElement.getWorwdprSubjCodeA());
			sqlScbcrscCursor.addParameter("WORWDPR_CRSE_NUMB_A", worwdprElement.getWorwdprCrseNumbA());
			sqlScbcrscCursor.addParameter("KEYBLOC_TERM_CODE", this.getFormModel().getKeyBlock().getKeyblocTermCode());
			
			ScbcrseBCursor.addParameter("WORWDPR_SUBJ_CODE_B", worwdprElement.getWorwdprSubjCodeB());
			ScbcrseBCursor.addParameter("WORWDPR_CRSE_NUMB_B", worwdprElement.getWorwdprCrseNumbB());
			ScbcrseBCursor.addParameter("KEYBLOC_TERM_CODE", this.getFormModel().getKeyBlock().getKeyblocTermCode());
			
			sqlScbcrscCursor.open();
			ResultSet sqlScbcrscResult = sqlScbcrscCursor.fetchInto();
			
			worwdprElement.setCourseADesc(sqlScbcrscResult.getStr(0));
			
			ScbcrseBCursor.open();
			ResultSet sqlScbcrseBResult = ScbcrseBCursor.fetchInto();
			
			worwdprElement.setCourseBDesc(sqlScbcrseBResult.getStr(0));
		}
		finally{
			sqlScbcrscCursor.close();
			ScbcrseBCursor.close();
			
		}
	}
	/*G$_CHECK_QUERY_MODE;
IF :GLOBAL.QUERY_MODE = '1' THEN
    GOTO SKIP_CHECK;
END IF ;
DECLARE

   CURSOR SCBCRSE_C IS
	   SELECT SCBCRSE_TITLE
	   FROM SCBCRSE
	   WHERE SCBCRSE_SUBJ_CODE = :WORWDPR_SUBJ_CODE_A AND
	         SCBCRSE_CRSE_NUMB = :WORWDPR_CRSE_NUMB_A AND
	         SCBCRSE_EFF_TERM = (SELECT MAX(SCBCRSE_EFF_TERM)
	                             FROM scbcrse
	                             WHERE SCBCRSE_SUBJ_CODE = :WORWDPR_SUBJ_CODE_A AND
	                                   SCBCRSE_CRSE_NUMB = :WORWDPR_CRSE_NUMB_A AND
	                                   SCBCRSE_EFF_TERM <= :KEYBLOC_TERM_CODE) AND
	         SCBCRSE_CSTA_CODE = 'A';
   
BEGIN
   OPEN SCBCRSE_C;
   FETCH SCBCRSE_C INTO :COURSE_A_DESC;
   IF SCBCRSE_C%NOTFOUND THEN
      MESSAGE ( G$_NLS.Get('WORWDPR-0001', 'FORM','*ERROR* SUBJ-CRSE A not defined') );
      RAISE FORM_TRIGGER_FAILURE ;
   END IF ;
   CLOSE SCBCRSE_C;
END ;
<< SKIP_CHECK >>
    NULL ;*/

	@AfterValueChangedTrigger( item="WORWDPR_CRSE_NUMB_A")
	public void worwdprCrseNumbAPostChange() {
		WorwdprAdapter worwdprElement = (WorwdprAdapter)this.getFormModel().getWorwdpr().getRowAdapter(true);
		if(worwdprElement == null){
			return;
		}
		
		int rowCount = 0;
		
		getTask().getGoqrpls().gCheckQueryMode();
		
		String sqlptiCursor = " SELECT SCBCRSE_TITLE "
	   + "FROM SCBCRSE "
	   + "WHERE SCBCRSE_SUBJ_CODE = :WORWDPR_SUBJ_CODE_A AND "
	         + "SCBCRSE_CRSE_NUMB = :WORWDPR_CRSE_NUMB_A AND "
	         + "SCBCRSE_EFF_TERM = (SELECT MAX(SCBCRSE_EFF_TERM) "
	                            +" FROM scbcrse "
	                             + "WHERE SCBCRSE_SUBJ_CODE = :WORWDPR_SUBJ_CODE_A AND "
	                                   + "SCBCRSE_CRSE_NUMB = :WORWDPR_CRSE_NUMB_A AND "
	                                   + "SCBCRSE_EFF_TERM <= :KEYBLOC_TERM_CODE) AND "
	         + "SCBCRSE_CSTA_CODE = 'A' ";
		
		try{
		
		DataCursor ptiCursor = new DataCursor(sqlptiCursor);
		ptiCursor.addParameter("WORWDPR_SUBJ_CODE_A", worwdprElement.getWorwdprSubjCodeA() );
		ptiCursor.addParameter("WORWDPR_CRSE_NUMB_A", worwdprElement.getWorwdprCrseNumbA() );
		ptiCursor.addParameter("KEYBLOC_TERM_CODE", getFormModel().getKeyBlock().getKeyblocTermCode() );
		ptiCursor.open();
		ResultSet ptiCursorResults = ptiCursor.fetchInto();
		if(ptiCursorResults != null){
			worwdprElement.setCourseADesc(ptiCursorResults.getStr(0));
		}
		getTask().getGoqrpls().gCheckValue(ptiCursor.notFound(), GNls.Fget(toStr("WORWDPR-0001"), toStr("FORM"),toStr("*ERROR* SUBJ-CRSE A not defined")),  toBool(NBool.True));
		
		if ( ptiCursor.notFound() )
		{
			throw new ApplicationException();
		}
		ptiCursor.close();
		}
		catch(ApplicationException e){
			throw new ApplicationException();
			
		}
	}
	
	/*G$_CHECK_QUERY_MODE;
IF :GLOBAL.QUERY_MODE = '1' THEN
    GOTO SKIP_CHECK;
END IF ;
DECLARE

   CURSOR SCBCRSE_C IS
	   SELECT SCBCRSE_TITLE
	   FROM SCBCRSE
	   WHERE SCBCRSE_SUBJ_CODE = :WORWDPR_SUBJ_CODE_B AND
	         SCBCRSE_CRSE_NUMB = :WORWDPR_CRSE_NUMB_B AND
	         SCBCRSE_EFF_TERM = (SELECT MAX(SCBCRSE_EFF_TERM)
	                             FROM scbcrse
	                             WHERE SCBCRSE_SUBJ_CODE = :WORWDPR_SUBJ_CODE_b AND
	                                   SCBCRSE_CRSE_NUMB = :WORWDPR_CRSE_NUMB_B AND
	                                   SCBCRSE_EFF_TERM <= :KEYBLOC_TERM_CODE) AND
	         SCBCRSE_CSTA_CODE = 'A';
   
BEGIN
   OPEN SCBCRSE_C;
   FETCH SCBCRSE_C INTO :COURSE_B_DESC;
   IF SCBCRSE_C%NOTFOUND THEN
      MESSAGE ( G$_NLS.Get('WORWDPR-0001', 'FORM','*ERROR* SUBJ-CRSE B not defined') );
      RAISE FORM_TRIGGER_FAILURE ;
   END IF ;
   CLOSE SCBCRSE_C;
END ;
<< SKIP_CHECK >>
    NULL ;*/
	
	@AfterValueChangedTrigger( item="WORWDPR_CRSE_NUMB_B")
	public void worwdprCrseNumbBPostChange() {
		
		WorwdprAdapter worwdprElement = (WorwdprAdapter)this.getFormModel().getWorwdpr().getRowAdapter(true);
		if(worwdprElement == null){
			return;
		}
		
		int rowCount = 0;
		
		getTask().getGoqrpls().gCheckQueryMode();
		
		String sqlptiCursor = "  SELECT SCBCRSE_TITLE "
	  + " FROM SCBCRSE "
	  + " WHERE SCBCRSE_SUBJ_CODE = :WORWDPR_SUBJ_CODE_B AND "
	      + " SCBCRSE_CRSE_NUMB = :WORWDPR_CRSE_NUMB_B AND "
	       + " SCBCRSE_EFF_TERM = (SELECT MAX(SCBCRSE_EFF_TERM) "
	                      + " FROM scbcrse "
	                        + " WHERE SCBCRSE_SUBJ_CODE = :WORWDPR_SUBJ_CODE_B AND "
	                             + " SCBCRSE_CRSE_NUMB = :WORWDPR_CRSE_NUMB_B AND "
	                               + " SCBCRSE_EFF_TERM <= :KEYBLOC_TERM_CODE) AND "
	        + " SCBCRSE_CSTA_CODE = 'A' ";
		
		try{
		
		DataCursor ptiCursor = new DataCursor(sqlptiCursor);
		ptiCursor.addParameter("WORWDPR_SUBJ_CODE_B", worwdprElement.getWorwdprSubjCodeB() );
		ptiCursor.addParameter("WORWDPR_CRSE_NUMB_B", worwdprElement.getWorwdprCrseNumbB() );
		ptiCursor.addParameter("KEYBLOC_TERM_CODE", getFormModel().getKeyBlock().getKeyblocTermCode() );
		ptiCursor.open();
		ResultSet ptiCursorResults = ptiCursor.fetchInto();
		if(ptiCursorResults != null){
			worwdprElement.setCourseBDesc(ptiCursorResults.getStr(0));
		}
		getTask().getGoqrpls().gCheckValue(ptiCursor.notFound(), GNls.Fget(toStr("WORWDPR-0001"), toStr("FORM"),toStr("*ERROR* SUBJ-CRSE B not defined")),  toBool(NBool.True));
		
		if ( ptiCursor.notFound() )
		{
			throw new ApplicationException();
		}
		ptiCursor.close();
		}
		catch(ApplicationException e){
			throw new ApplicationException();
			
		}
	}
	
	@BeforeQuery
	public void worwdpr_BeforeQuery(QueryEvent args) {
		WorwdprAdapter worwdprElement = (WorwdprAdapter) this.getFormModel().getWorwdpr().getRowAdapter();
		setBlockWhereClause("WORWDPR", "WHERE WORWDPR_TERM_CODE = :TERM_CODE and WORWDPR_LEVL_CODE = :LEVL_CODE");
		((IDBBusinessObject) args.getSource()).getSelectCommandParams().add(DbManager.getDataBaseFactory()
				.createDataParameter("TERM_CODE", this.getFormModel().getKeyBlock().getKeyblocTermCode()));
		((IDBBusinessObject) args.getSource()).getSelectCommandParams().add(DbManager.getDataBaseFactory()
				.createDataParameter("LEVL_CODE", this.getFormModel().getKeyBlock().getKeyblocLevlCode()));

	}
	
}