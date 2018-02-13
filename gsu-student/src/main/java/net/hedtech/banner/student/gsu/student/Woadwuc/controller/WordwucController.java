package net.hedtech.banner.student.gsu.student.Woadwuc.controller;

import java.util.*;

import org.jdesktop.databuffer.DataRow.DataRowStatus;

import morphis.foundations.core.appdatalayer.*;
import morphis.foundations.core.appdatalayer.data.*;
import morphis.foundations.core.appdatalayer.events.*;
import morphis.foundations.core.types.*;
import morphis.foundations.core.appsupportlib.*;
import morphis.foundations.core.appsupportlib.exceptions.*;
import morphis.foundations.core.appsupportlib.model.*;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import morphis.foundations.core.appsupportlib.util.*;
import morphis.foundations.core.appsupportlib.runtime.*;
import morphis.foundations.core.appsupportlib.runtime.control.*;
import morphis.foundations.core.appsupportlib.runtime.events.*;
import morphis.foundations.core.appsupportlib.runtime.web.message.OutputMessage.OutputMessageUserResponse;
import morphis.foundations.core.appsupportlib.runtime.controlsModel.*;
import morphis.foundations.core.appsupportlib.runtime.controlsModel.items.*;
import morphis.foundations.core.appsupportlib.runtime.controlsModel.lovs.*;
import morphis.foundations.core.appsupportlib.runtime.controlsModel.containers.*;
import morphis.foundations.core.appsupportlib.runtime.controlsModel.alerts.*;
import morphis.foundations.core.appsupportlib.runtime.action.*;
import static net.hedtech.general.common.forms.services.BaseTaskServices.*;
import static morphis.foundations.core.appsupportlib.runtime.ItemServices.*;
import static morphis.foundations.core.appsupportlib.runtime.BlockServices.*;
import static morphis.foundations.core.appsupportlib.runtime.ViewServices.*;
import static morphis.foundations.core.appsupportlib.runtime.MessageServices.*;
import static morphis.foundations.core.appsupportlib.runtime.ValueSetServices.*;
import static morphis.foundations.core.appsupportlib.runtime.LovServices.*;
import static morphis.foundations.core.appsupportlib.runtime.ListServices.*;
import static morphis.foundations.core.appsupportlib.runtime.TreeServices.*;
import static morphis.foundations.core.appsupportlib.Math.*;
import static morphis.foundations.core.appsupportlib.Lib.*;
import static morphis.foundations.core.appsupportlib.Globals.*;
import static morphis.foundations.core.types.Types.*;
import morphis.foundations.core.util.*;
import net.hedtech.general.common.dbservices.*;
import net.hedtech.general.common.dbservices.dbtypes.*;
import net.hedtech.general.common.libraries.Goqrpls.*;
import net.hedtech.general.common.libraries.Goqwflw.*;
import net.hedtech.general.common.libraries.Eoqrpls.*;
import net.hedtech.banner.student.gsu.student.Woadwuc.WoadwucTask;
import net.hedtech.banner.student.gsu.student.Woadwuc.model.WoadwucModel;
import net.hedtech.banner.student.gsu.student.Woadwuc.model.WordwucAdapter;
import net.hedtech.general.common.libraries.Goqolib.services.GIdClass;	
import net.hedtech.general.common.libraries.Goqolib.services.GNameClass;	
		
import net.hedtech.general.common.forms.controller.DefaultBlockController;

public class WordwucController extends DefaultBlockController {

	private GIdClass getGIdClass() {
		return (net.hedtech.general.common.libraries.Goqolib.services.GIdClass) this.getTask().getTaskPart("goqolib").getSupportCodeManager().getPackage("G$_ID_CLASS");
	}	
	private GNameClass getGNameClass() {
		return (net.hedtech.general.common.libraries.Goqolib.services.GNameClass) this.getTask().getTaskPart("goqolib").getSupportCodeManager().getPackage("G$_NAME_CLASS");
	}	

	
	public WordwucController(IFormController parentController, String name) 
	{
		super(parentController, name);
	}
		
		
		
	@Override
	public WoadwucTask getTask() {
		return (WoadwucTask) super.getTask();
	}

	public WoadwucModel getFormModel() {
		return getTask().getModel();
	}
		
			
	

		@AfterQuery
		public void Wordwuc_AfterQuery(RowAdapterEvent args)
		{
				WordwucAdapter wordwucElement = (WordwucAdapter)args.getRow();

				
						Ref<NString> pId_ref = new Ref<NString>(wordwucElement.getId());
						getTask().getGoqrpls().gSelSpridenIdName(wordwucElement.getWordwucPidm(), toStr("NAME"), toStr("Y"), pId_ref);
						wordwucElement.setId(pId_ref.val);
						getTask().getGoqrpls().gCheckValue(toBool(wordwucElement.getId().isNull()), GNls.Fget(toStr("WOADWUC-0001"), toStr("FORM"), toStr("*ERROR* ID not found; Press LIST to go to name search.")), toBool(NBool.True));
						
			}

		
		
		@BeforeRowInsert
		public void Wordwuc_BeforeRowInsert(RowAdapterEvent args)
		{
			
				WordwucAdapter WordwucElement = (WordwucAdapter)args.getRow();


				if ( WordwucElement.getId().isNull() )
				{
					errorMessage(GNls.Fget(toStr("WOADWUC-0003"), toStr("FORM"), toStr("*ERROR* Must enter Banner ID before COMMIT.")));
					throw new ApplicationException();
				}
				
				String sql1 = "SELECT SPRIDEN_PIDM " +
	" FROM SPRIDEN " +
	" WHERE SPRIDEN_CHANGE_IND IS NULL AND SPRIDEN_ID = :WORDWUC_ID ";
				DataCommand command1 = new DataCommand(sql1);
				//Setting query parameters
				command1.addParameter("WORDWUC_ID", WordwucElement.getId());
				ResultSet results1 = command1.executeQuery();
				if ( results1.hasData() ) {
					WordwucElement.setWordwucPidm(results1.getNumber(0));
				}
				
				WordwucElement.setWordwucActivityDate(toDate(getFormModel().getFormHeader().getCurrentDate(), GDate.getNlsDateFormat()));
				WordwucElement.setWordwucUser(getGlobal("CURRENT_USER"));
			}

		
		

		@BeforeRowUpdate
		public void Wordwuc_BeforeRowUpdate(RowAdapterEvent args)
		{
			
				WordwucAdapter WordwucElement = (WordwucAdapter)args.getRow();


				if ( WordwucElement.getId().isNull() )
				{
					errorMessage(GNls.Fget(toStr("WOADWUC-0006"), toStr("FORM"), toStr("*ERROR* Must enter Banner ID before COMMIT.")));
					throw new ApplicationException();
				}
				// 
				WordwucElement.setWordwucActivityDate(toDate(getFormModel().getFormHeader().getCurrentDate(), GDate.getNlsDateFormat()));
				WordwucElement.setWordwucUser(getGlobal("CURRENT_USER"));
			}

		

		@ActionTrigger(action="QUERY_ID")
		public void Wordwuc_QueryId(QueryEvent args)
		{
			SelectionCriteria lvSpridenCrit = new SelectionCriteria();
			
			lvSpridenCrit.add("SPRIDEN_ID", args.getCriteria().get("ID"));

			List<IDbDataParameter> paramList = new ArrayList<IDbDataParameter>();
			NString lvSpridenStmt = toStr(lvSpridenCrit.createWhereClause((IDataModel)args.getSource(), paramList));

			((IDataModel)args.getSource()).getSelectCommandParams().addAll(paramList);
			
			setBlockWhereClause("WORDWUC", "WORDWUC_PIDM IN \n                  (SELECT SPRIDEN_PIDM \n		   						 FROM   SPRIDEN \n                   WHERE  SPRIDEN_CHANGE_IND IS NULL\n                   AND   " + lvSpridenStmt + ")");
		}

		
	

		@BeforeQuery
		public void Wordwuc_BeforeQuery(QueryEvent args)
		{
			
				WordwucAdapter WordwucElement = (WordwucAdapter)this.getFormModel().getWordwuc().getRowAdapter(true);


				if ( !WordwucElement.getId().isNull() )
				{
					executeAction("QUERY_ID", null, null, false, args);
				}
				else
					setBlockWhereClause(getTriggerBlock(), "");
			}

	

		@ActionTrigger(action="PRE-TEXT-ITEM", item="ID", function=KeyFunction.ITEM_IN)
		public void id_itemIn()
		{
			
				getGIdClass().itemIn();
			}

		

		@ActionTrigger(action="KEY-NEXT-ITEM", item="ID", function=KeyFunction.NEXT_ITEM)
		public void id_keyNexItem()
		{
			
				getGIdClass().keyNexItem();
			}

		
		

		@ActionTrigger(action="KEY-CQUERY", item="ID", function=KeyFunction.COUNT_QUERY)
		public void id_TotalResults()
		{

				WordwucAdapter WordwucElement = (WordwucAdapter)this.getFormModel().getWordwuc().getRowAdapter(true);

				if(WordwucElement!=null){
					//  54-1 add trigger to provide Option List Window display and
					//       access to GUIALTI form
					getTask().getGoqrpls().gCopyFldAttr();
					executeAction("G$_REVOKE_ACCESS");
					getTask().getGoqrpls().gCheckFailure();
					getTask().getGoqrpls().gSecuredFormCall(getGlobal("CURRENT_USER"), toStr("GUIALTI"), toStr(""));
					getTask().getGoqrpls().gResetGlobal();
					// 
					if ( !getGlobal("VALUE").isNull() )
					{
						WordwucElement.setId(getGlobal("VALUE"));
						nextItem();
						setGlobal("VALUE", toStr(""));
					}
				}
			}

		
	

		@ActionTrigger(action="POST-CHANGE", item="ID")
		public void id_PostChange()
		{
			
				getGIdClass().postChange();
			}

		
	

		@ValidationTrigger(item="ID")
		public void id_validate()
		{
			

				WordwucAdapter WordwucElement = (WordwucAdapter)this.getFormModel().getWordwuc().getRowAdapter(true);


				if (WordwucElement!=null) {
						this.id_PostChange();
						
						if ( getMode().equals("QUERY") )
						{
							return ;
						}
						// 
						if ( WordwucElement.getId().isNull() )
						{
							WordwucElement.setWordwucPidm(toNumber(""));
							WordwucElement.setNname(toStr(""));
							return ;
						}
						// 
						if ( WordwucElement.getWordwucPidm().isNull() )
						{
							Ref<NString> pId_ref = new Ref<NString>(WordwucElement.getId());
							Ref<NNumber> pPIdm_ref = new Ref<NNumber>(WordwucElement.getWordwucPidm());
							Ref<NString> pFullName_ref = new Ref<NString>(WordwucElement.getNname());
							Ref<NString> pConfidInd_ref = new Ref<NString>(WordwucElement.getConfidInfo());
							Ref<NString> pDcsdInd_ref = new Ref<NString>(WordwucElement.getDeceasedInd());
							getTask().getGoqrpls().gValidId(pId_ref, pPIdm_ref, pFullName_ref, pConfidInd_ref, pDcsdInd_ref);
							WordwucElement.setId(pId_ref.val);
							WordwucElement.setWordwucPidm(pPIdm_ref.val);
							WordwucElement.setNname(pFullName_ref.val);
							WordwucElement.setConfidInfo(pConfidInd_ref.val);
							WordwucElement.setDeceasedInd(pDcsdInd_ref.val);
						}
				}
			}
		
		@ActionTrigger(action="WHEN-BUTTON-PRESSED", item="ID")
		public void id_buttonClick()
		{
			
				//  54-1 add code to provide Option List Window display and
				//       access to GUIALTI form
				//  54-1 add code to provide Option List Window display and
				//       access to GUIALTI form
				goItem(toStr("WORDWUC.ID"));
				getTask().getGoqrpls().gKeyOptMenu(toStr("WORDWUC.ID"), GNls.Fget(toStr("WOADWUC-0010"), toStr("FORM"), toStr("Valid Banner ID (SOAIDEN)")), toStr("LIST_VALUES"), GNls.Fget(toStr("WOADWUC-0011"), toStr("FORM"), toStr("Alternate ID Search (GUIALTI)")), toStr("COUNT_QUERY"), toStr(""), toStr(""), toStr(""), toStr(""));
				getTask().getGoqrpls().gCheckFailure();
			}
		
	
		@ActionTrigger(action="KEY-LISTVAL", item="ID", function=KeyFunction.LIST_VALUES)
		public void id_ListValues()
		{
			

				WordwucAdapter WordwucElement = (WordwucAdapter)this.getFormModel().getWordwuc().getRowAdapter(true);

				if(WordwucElement!=null){
					getTask().getGoqrpls().gCopyFldAttr();
					executeAction("G$_REVOKE_ACCESS");
					getTask().getGoqrpls().gCheckFailure();
					setGlobal("RELATED_FORM_CALL", toStr("Y"));
					getTask().getGoqrpls().gSecuredFormCall(getGlobal("CURRENT_USER"), toStr("SOAIDEN"), toStr(""));
					getTask().getGoqrpls().gResetGlobal();
					// 
					if ( !getGlobal("VALUE").isNull() )
					{
						WordwucElement.setId(getGlobal("VALUE"));
						//this.wacsId_validate();
						nextItem();
						setGlobal("VALUE", toStr(""));
					}
				}
			}


		@ActionTrigger(action="KEY-NEXT-ITEM", item="NAME", function=KeyFunction.NEXT_ITEM)
		public void name_keyNexItem()
		{
			
				getGNameClass().keyNexItem();
			}

		
	
	
}


