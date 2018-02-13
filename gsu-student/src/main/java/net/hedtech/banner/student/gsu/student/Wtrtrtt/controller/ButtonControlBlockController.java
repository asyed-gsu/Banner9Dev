package net.hedtech.banner.student.gsu.student.Wtrtrtt.controller;

import static morphis.foundations.core.appsupportlib.runtime.ItemServices.goItem;
import static morphis.foundations.core.types.Types.toStr;
import static net.hedtech.general.common.forms.services.BaseTaskServices.executeAction;

import morphis.core.utils.behavior.annotations.Before;
import morphis.foundations.core.appsupportlib.runtime.action.ActionTrigger;
import morphis.foundations.core.appsupportlib.runtime.control.IFormController;
import net.hedtech.general.common.forms.controller.DefaultBlockController;
import net.hedtech.general.common.libraries.Goqolib.services.GIconBtnClass;
import net.hedtech.banner.student.gsu.student.Wtrtrtt.WtrtrttTask;
import net.hedtech.banner.student.gsu.student.Wtrtrtt.model.WtrtrttModel;

public class ButtonControlBlockController extends DefaultBlockController {
	
	private GIconBtnClass getGIconBtnClass() {
		return (net.hedtech.general.common.libraries.Goqolib.services.GIconBtnClass) this.getTask().getTaskPart("GOQOLIB").getSupportCodeManager().getPackage("G$_ICON_BTN_CLASS");
	}	

	public ButtonControlBlockController(IFormController parentController, String name) {
		super(parentController, name);
	}

	@Override
	public WtrtrttTask getTask() {
		return (WtrtrttTask) super.getTask();
	}

	public WtrtrttModel getFormModel() {
		return getTask().getModel();
	}
	
	
   

	
}