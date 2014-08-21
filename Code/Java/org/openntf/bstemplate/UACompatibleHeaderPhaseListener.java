package org.openntf.bstemplate;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletResponse;

public class UACompatibleHeaderPhaseListener implements PhaseListener {
	private static final long serialVersionUID = 1L;

	// @Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

	// @Override
	public void beforePhase(final PhaseEvent event) {
		try {
			final FacesContext facesContext = event.getFacesContext();
			final HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
			response.addHeader("X-UA-Compatible", "IE=10");
		} catch (Exception e) {
			System.out.println("err setting header");
		}
	}

	// @Override
	public void afterPhase(final PhaseEvent event) {

	}
}
