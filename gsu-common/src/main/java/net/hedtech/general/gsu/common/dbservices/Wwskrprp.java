package net.hedtech.general.gsu.common.dbservices;

import morphis.foundations.core.appdatalayer.data.DbManager;
import morphis.foundations.core.appdatalayer.data.IDataCommand;
import morphis.foundations.core.types.NNumber;
import morphis.foundations.core.util.Ref;

public class Wwskrprp{

/*	WWSKRPRP PACKAGE: 
 * create or replace PACKAGE wwskrprp
AS

-- FILE NAME..: wwskrprp.pkg
-- RELEASE....: 8.2.0.0
-- OBJECT NAME: wwskrprp
-- PRODUCT....: GSUWEB
-- PURPOSE....: To display retake courses history.
-- BY   ......: Franklin Wang
-- PROJECT ...: Limit course retake
-- DATE ......: August 3, 2011
--
-- DESCRIPTION:
--
-- This package was created for the course retake Policy going
-- into affect Fall, 2011.
--

-- GLOBAL VARIABLES are define in package body

-- PROCEDURES

 PROCEDURE P_RepeatReplaceDisp;

 PROCEDURE P_Count
    (pidm_in          IN spriden.spriden_pidm%TYPE,
     taken_out        OUT NUMBER,
     remain_out    OUT NUMBER);

END wwskrprp; -- package
 * 
 *  PROCEDURE P_Count
	    (pidm_in       IN spriden.spriden_pidm%TYPE,
	     taken_out     OUT NUMBER,
	     remain_out    OUT NUMBER)
	AS

	lv_max NUMBER;

	BEGIN

	   lv_max := NVL (bwcklibs.F_GetGtvsdaxRule ('RPRPMAX', 'HISTORY'),0);

	   SELECT COUNT(*), lv_max - COUNT(*)
	   INTO taken_out, remain_out
	   FROM whvrprp
	   WHERE whvrprp_pidm = pidm_in;

	END P_Count;*/
	
	public static void pPCount(NNumber pidm, Ref<NNumber> taken, Ref<NNumber>remain)
	{
		IDataCommand cmd = DbManager.getDataAccessFactory().createDataCommand("WWSKRPRP.P_COUNT", DbManager.getDataBaseFactory());
		
		cmd.addParameter("@PIDM_IN", pidm);
		cmd.addParameter("@TAKEN_OUT", NNumber.class);
		cmd.addParameter("@REMAIN_OUT", NNumber.class);
		
		cmd.execute();
		
		taken.val = cmd.getParameterValue("@TAKEN_OUT", NNumber.class);
		remain.val = cmd.getParameterValue("@REMAIN_OUT", NNumber.class);
	}
}
