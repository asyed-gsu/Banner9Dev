package net.hedtech.banner.student.gsu.student.Wharprp.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.general.gsu.common.dbservices.Wwskrprp;
import net.hedtech.banner.student.gsu.student.Wharprp.WharprpTask;
import morphis.foundations.core.appsupportlib.runtime.action.*;
import morphis.foundations.core.appsupportlib.ui.KeyFunction;
import morphis.foundations.core.types.NNumber;
import morphis.foundations.core.types.NString;
import morphis.foundations.core.util.Ref;
import morphis.foundations.core.util.logging.ILogger;
import morphis.foundations.core.util.logging.LoggerFactory;


import morphis.core.utils.behavior.annotations.*;
import morphis.foundations.core.appdatalayer.data.*;
import morphis.foundations.core.appsupportlib.model.IDBBusinessObject;
//import net.hedtech.general.common.dbservices.WwskrprpTest;

/*import static morphis.foundations.core.appsupportlib.runtime.BlockServices.nextBlock;
import static morphis.foundations.core.appsupportlib.runtime.MessageServices.errorMessage;
import morphis.foundations.core.appsupportlib.Lib;
import morphis.foundations.core.appsupportlib.runtime.*;
*/import net.hedtech.banner.student.gsu.student.Wharprp.model.*;
import morphis.foundations.core.appdatalayer.events.AfterQuery;
import morphis.foundations.core.appdatalayer.events.BeforeQuery;
import morphis.foundations.core.appdatalayer.events.QueryEvent;
import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;

public class WhvrprpController extends DefaultBlockController {

	private static ILogger logger = LoggerFactory.getInstance(WhvrprpController.class);
	
	public WhvrprpController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WharprpTask getTask() {
		return (WharprpTask) super.getTask();
	}

	public WharprpModel getFormModel() {
		return getTask().getModel();
	}

	@After
	@ActionTrigger(action="PRE-BLOCK", function=KeyFunction.BLOCK_IN)
	public void whvrprp_blockIn()
	{
		//TODO to be filled by the user
	}

	@BeforeQuery
	public void whvrprp_BeforeQuery(QueryEvent args) {
		((IDBBusinessObject)args.getSource()).getSelectCommandParams().add((DbManager.getDataBaseFactory().createDataParameter("PIDM",this.getFormModel().getKeyBlock().getPidm())));
		
		populateRepeatToRepalceSummary();
	}
	
	/*
	  -- MOD #0001 Begin
		declare
		  old_message_level number;
		-- MOD #0001 End
		BEGIN
		wwskrprp.p_count(:pidm, :sum_tot.w_taken, :sum_tot.w_remain);
		--MOD #0001 end;
		
		  --MOD #0001 Begin
		  old_message_level := :system.message_level;
		  :system.message_level := 20; -- suppresses most errors
		  --MOD #0001 End
		  
		  NEXT_BLOCK;
		  EXECUTE_QUERY;
		  NEXT_BLOCK;
		  EXECUTE_QUERY;
		
		-- MOD #0001 Begin
		  :system.message_level := old_message_level;   
		end;
		-- MOD #0001 End
	 * 
	 * */
	@AfterQuery
	public void whvrprp_AfterQuery(RowAdapterEvent rowAdapterEvent) {
		populateRepeatToRepalceSummary();
	}
	
	
	private void populateRepeatToRepalceSummary(){
		Ref<NNumber> w_taken_out = null, w_remain_out = null;
		
		if(this.getFormModel().getKeyBlock().getPidm() != null)
		{
			SumTot sumTot = this.getFormModel().getSumTot();
			
			w_taken_out = new Ref<NNumber>(NNumber.getNull());
			w_remain_out = new Ref<NNumber>();
			
			Wwskrprp.pPCount(this.getFormModel().getKeyBlock().getPidm(), w_taken_out, w_remain_out);
			
			NString approved = NString.parse(w_taken_out.getValue().toString());
			NString remain = NString.parse(w_remain_out.getValue().toString());
			
			sumTot.setWApproved(approved);
			sumTot.setWRemain(remain);
		}
	}
	
}