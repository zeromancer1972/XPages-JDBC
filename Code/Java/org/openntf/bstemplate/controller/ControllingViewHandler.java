package org.openntf.bstemplate.controller;

import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import com.ibm.xsp.application.ViewHandlerExImpl;

public class ControllingViewHandler extends ViewHandlerExImpl {
	public ControllingViewHandler(final ViewHandler delegate) {
		super(delegate);
	}

	@Override
	public UIViewRoot createView(FacesContext context, String pageName) {
		
		return super.createView(context, pageName);
	}

}
