package net.hedtech.banner.student.gsu.student.Wharprp.controller;

import morphis.foundations.core.appsupportlib.model.IDBBusinessObject;
import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Wharprp.WharprpTask;
import net.hedtech.banner.student.gsu.student.Wharprp.model.WharprpModel;
import morphis.foundations.core.appdatalayer.data.DbManager;
import morphis.foundations.core.appdatalayer.events.BeforeQuery;
import morphis.foundations.core.appdatalayer.events.QueryEvent;

public class ShrtcknController extends DefaultBlockController {

	public ShrtcknController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WharprpTask getTask() {
		return (WharprpTask) super.getTask();
	}

	public WharprpModel getFormModel() {
		return getTask().getModel();
	}

	@BeforeQuery
	public void shrtckn_BeforeQuery(QueryEvent queryEvent) {
		((IDBBusinessObject)queryEvent.getSource()).getSelectCommandParams().add((DbManager.getDataBaseFactory().createDataParameter("PIDM",this.getFormModel().getKeyBlock().getPidm())));
	}
	
	
	
	
}