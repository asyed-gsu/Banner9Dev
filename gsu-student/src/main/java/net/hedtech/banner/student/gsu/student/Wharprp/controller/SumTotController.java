package net.hedtech.banner.student.gsu.student.Wharprp.controller;

import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import morphis.foundations.core.types.NString;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.banner.student.gsu.student.Wharprp.WharprpTask;
import net.hedtech.banner.student.gsu.student.Wharprp.model.SumTot;
import net.hedtech.banner.student.gsu.student.Wharprp.model.WharprpModel;
import morphis.foundations.core.appdatalayer.events.RowAdapterEvent;

import java.util.List;

import org.apache.log4j.Logger;

import morphis.foundations.core.appdatalayer.data.DataCursor;
import morphis.foundations.core.appdatalayer.data.IDbDataParameter;
import morphis.foundations.core.appdatalayer.data.ResultSet;
import morphis.foundations.core.appdatalayer.events.AfterQuery;

public class SumTotController extends DefaultBlockController {
	
	final static Logger logger = Logger.getLogger(SumTotController.class);

	public SumTotController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WharprpTask getTask() {
		return (WharprpTask) super.getTask();
	}

	public WharprpModel getFormModel() {
		return getTask().getModel();
	}

	
}