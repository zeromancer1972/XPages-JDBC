package org.openntf.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.context.FacesContext;

import com.ibm.xsp.extlib.relational.util.JdbcUtil;

public class DataConnector {
	
	public List<HashMap<String, Object>> getRecords() {
		HashMap<String, Object> data = null;
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		try {
			Connection conn = JdbcUtil.createNamedConnection(FacesContext.getCurrentInstance(), "postgres");
			PreparedStatement prep = conn.prepareStatement("SELECT * FROM names ORDER BY lastname");
			ResultSet result = prep.executeQuery();
			while (result.next()) {
				data = new HashMap<String, Object>();
				data.put("id", result.getObject("id"));
				data.put("lastname", result.getObject("lastname"));
				data.put("firstname", result.getObject("firstname"));
				list.add(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
