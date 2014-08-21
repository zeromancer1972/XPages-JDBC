package org.openntf.bstemplate.renderer;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

public class Panel extends Renderer {

	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		writer.startElement("div", component);
		writer.writeAttribute("class", "panel panel-default", null);
		if (component.getAttributes().get("title") != null) {
			writer.startElement("div", component);
			writer.writeAttribute("class", "panel-heading", null);
			writer.startElement("h4", component);
			writer.writeAttribute("class", "panel-title", null);
			writer.write((String) component.getAttributes().get("title"));
			writer.endElement("h4");
			writer.endElement("div");
		}
		writer.startElement("div", component);
		writer.writeAttribute("class", "panel-body", null);

	}

	@Override
	public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
		super.encodeChildren(context, component);
	}

	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		writer.endElement("div");
		writer.endElement("div");
	}

	@Override
	public boolean getRendersChildren() {
		return true;
	}
}
