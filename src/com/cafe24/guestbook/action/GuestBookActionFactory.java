package com.cafe24.guestbook.action;

import com.cafe24.mvc.action.AbstractActionFactory;
import com.cafe24.mvc.action.Action;

public class GuestBookActionFactory extends AbstractActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;

		if("deleteform".equals(actionName)) {

		} else if ("add".equals(actionName)) {
			
		} else if ("delete".equals(actionName)) {
			
		} else {	//index.jsp	//
			action = new ListAction();
		}
		
		return action;
	}

}
