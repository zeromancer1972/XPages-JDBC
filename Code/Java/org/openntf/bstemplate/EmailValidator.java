package org.openntf.bstemplate;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class EmailValidator implements Validator {
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if (!value.toString().matches("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?")) {
			FacesMessage message = new FacesMessage("Invalid E-Mail adress");
			// context.addMessage(component.getClientId(context), message);
			throw new ValidatorException(message);
		}
	}

}
