package org.openntf.bstemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import lotus.domino.Document;

import com.ibm.xsp.extlib.util.ExtLibUtil;
import com.ibm.xsp.model.domino.wrapped.DominoDocument;

public class NavigationFooter implements Serializable {

	private static final long serialVersionUID = -8857086205056457935L;
	private final List<Page> navigation;

	public NavigationFooter() {
		boolean admin = false;
		String adminForm = "";
		String adminDoc = "";
		Document doc = null;
		this.navigation = new ArrayList<Page>();
		

		try {
			admin = ExtLibUtil.getCurrentDatabase().queryAccessRoles(
					ExtLibUtil.getCurrentSession().getEffectiveUserName()).contains("[Admin]");
			// render if not logged in
			navigation.add(new Page("Login", "login.xsp", "", false, ExtLibUtil.getCurrentSession().getEffectiveUserName().equals(
			"Anonymous")));

			// render if logged in
			navigation.add(new Page("Logout", "/" + ExtLibUtil.getCurrentDatabase().getFilePath()
					+ "?logout&redirectto=" + "/" + ExtLibUtil.getCurrentDatabase().getFilePath(),
					"", false, !ExtLibUtil.getCurrentSession().getEffectiveUserName().equals(
							"Anonymous")));

			// get current document
			try {
				FacesContext context = FacesContext.getCurrentInstance();
				DominoDocument xspdoc = (DominoDocument) ExtLibUtil.resolveVariable(context,
						"currentDocument");
				doc = xspdoc.getDocument();

				if (doc.getItemValueString("Form").equals("post")) {
					adminForm = "adminblog.xsp";
					adminDoc = "adminPost.xsp";
				} else if (doc.getItemValueString("Form").equals("tutorial")) {
					adminForm = "admintutorials.xsp";
					adminDoc = "adminTutorial.xsp";
				} else {
					adminForm = "admin.xsp";
					adminDoc = "admincontent.xsp";
				}

			} catch (Exception e) {
				adminForm = "admin.xsp";
				adminDoc = "admincontent.xsp";

			}
			if (doc != null) {
				navigation.add(new Page("Edit", adminDoc + "?action=editDocument&documentId="
						+ doc.getUniversalID(), "", false, admin));
			}
			navigation.add(new Page("Admin", adminForm, "", false, admin));

		} catch (Exception e) {

		}
	}

	public List<Page> getNavigation() {
		return navigation;
	}
}
