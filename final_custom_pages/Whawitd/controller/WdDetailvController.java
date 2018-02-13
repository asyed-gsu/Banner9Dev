package net.hedtech.banner.student.gsu.student.Whawitd.controller;

import static morphis.foundations.core.types.Types.toStr;

import morphis.foundations.core.appdatalayer.data.DbManager;
import morphis.foundations.core.appdatalayer.events.AfterQuery;
import morphis.foundations.core.appdatalayer.events.BeforeQuery;
import morphis.foundations.core.appdatalayer.events.QueryEvent;
import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;
import morphis.foundations.core.appsupportlib.model.IDBBusinessObject;
import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import morphis.foundations.core.types.NNumber;
import morphis.foundations.core.types.NString;
import morphis.foundations.core.util.Ref;
import net.hedtech.banner.student.gsu.student.Whawitd.WhawitdTask;
import net.hedtech.banner.student.gsu.student.Whawitd.model.SumTot;
import net.hedtech.banner.student.gsu.student.Whawitd.model.WhawitdModel;
import net.hedtech.banner.student.gsu.student.Whawitd.services.WhawitdServices;
import net.hedtech.general.common.forms.controller.DefaultBlockController;

public class WdDetailvController extends DefaultBlockController {

	public WdDetailvController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WhawitdTask getTask() {
		return (WhawitdTask) super.getTask();
	}

	public WhawitdModel getFormModel() {
		return getTask().getModel();
	}
	
	@BeforeQuery
	public void whawitd_BeforeQuery(QueryEvent args) {
	((IDBBusinessObject)args.getSource()).getSelectCommandParams().add(DbManager.getDataBaseFactory().createDataParameter("KEYBLCK_LEVL_CODE",
		this.getFormModel().getKeyBlock().getKeyblckLevlCode()));	
		((IDBBusinessObject)args.getSource()).getSelectCommandParams().add(DbManager.getDataBaseFactory().createDataParameter("PIDM",
		this.getFormModel().getKeyBlock().getPidm()));	
		((IDBBusinessObject)args.getSource()).getSelectCommandParams().add(DbManager.getDataBaseFactory().createDataParameter("term_1",
				this.getFormModel().getSumTot().getTerm1()));
		((IDBBusinessObject)args.getSource()).getSelectCommandParams().add(DbManager.getDataBaseFactory().createDataParameter("term_2",
				this.getFormModel().getSumTot().getTerm2()));
	}

}