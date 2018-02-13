package net.hedtech.banner.student.gsu.student.Whawitd.services;

import morphis.foundations.core.appdatalayer.data.DbManager;
import morphis.foundations.core.appdatalayer.data.IDataCommand;
import morphis.foundations.core.appsupportlib.runtime.ISupportCodeContainer;
import morphis.foundations.core.types.NNumber;
import morphis.foundations.core.types.NString;
import morphis.foundations.core.util.Ref;
import net.hedtech.banner.student.gsu.student.Whawitd.WhawitdTask;
import net.hedtech.banner.student.gsu.student.Whawitd.model.WhawitdModel;
import morphis.common.forms.baseForm.services.DefaultSupportCodeObject;

public class WhawitdServices extends DefaultSupportCodeObject {

	public WhawitdServices(ISupportCodeContainer container) {
		super(container);
	}

	public WhawitdTask getTask() {
		return (WhawitdTask) super.getContainer();
	}

	public WhawitdModel getFormModel() {
		return getTask().getModel();
	}

	public void pPWdProcess(NNumber pidm, NString levelCode, NString type, NString startTerm, NString endTerm)
	{
		
		NNumber taken, term2, term1, remain;
		
		IDataCommand cmd = DbManager.getDataAccessFactory().createDataCommand("WWCKWITD.P_WD_PROCESS", DbManager.getDataBaseFactory());
		
		cmd.addParameter("@P_PIDM_IN", pidm);
		cmd.addParameter("@P_LEVL", levelCode);
		cmd.addParameter("@P_TYPE", type);
		cmd.addParameter("@P_START_TERM", startTerm);
		cmd.addParameter("@P_END_TERM", endTerm);
		cmd.addParameter("@P_TAKEN_COUNT", NNumber.class);
		cmd.addParameter("@P_REMAINING_COUNT", NNumber.class);
		cmd.addParameter("@P_TERM_1_SKIP", NNumber.class);
		cmd.addParameter("@P_TERM_2_SKIP", NNumber.class);
		
		cmd.execute();

		taken = cmd.getParameterValue("@P_TAKEN_COUNT", NNumber.class);
		remain = cmd.getParameterValue("@P_REMAINING_COUNT", NNumber.class);
		term1 = cmd.getParameterValue("@P_TERM_1_SKIP", NNumber.class);
		term2 = cmd.getParameterValue("@P_TERM_2_SKIP", NNumber.class);
		
		getFormModel().getSumTot().setWTaken(NString.parse(taken.toString()));
		getFormModel().getSumTot().setWRemain(NString.parse(remain.toString()));
		getFormModel().getSumTot().setTerm1(NString.parse(term1.toString()));
		getFormModel().getSumTot().setTerm2(NString.parse(term2.toString()));
			
	}
	
	public static NString fGetGtvsdaxWdstterm(NString levlCode) {
		
		IDataCommand cmd = DbManager.getDataAccessFactory().createDataCommand("WWCKWITD.F_GET_GTVSDAX_WDSTTERM", DbManager.getDataBaseFactory());
		
		cmd.addReturnParameter(NNumber.class);
		cmd.addParameter("@KEYBLOC_LEVL_CODE", levlCode);
			
		cmd.execute();

		return cmd.getReturnValue(NString.class);

	}

}