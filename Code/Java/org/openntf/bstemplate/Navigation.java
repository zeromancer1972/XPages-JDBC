package org.openntf.bstemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Navigation implements Serializable {

	private static final long serialVersionUID = 8031965383531253276L;
	private final List<Page> navigation;

	public Navigation() {
		this.navigation = new ArrayList<Page>();
		this.navigation.add(new Page("OpenNTF Project", "http://www.openntf.org/main.nsf/blog.xsp?permaLink=NHEF-9N7CKD", "", true));

	}

	public List<Page> getNavigation() {
		return navigation;
	}
}
