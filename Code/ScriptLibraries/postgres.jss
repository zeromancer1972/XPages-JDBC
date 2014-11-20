// postgres demo
function openRecord(id){
	var result:java.sql.ResultSet = @JdbcExecuteQuery("postgres", "SELECT * FROM xpagesdemo.names WHERE ID="+parseInt(id));
	while(result.next()){
		// add widget
		getComponent("lastname").setValue(result.getString("lastname"));
		getComponent("firstname").setValue(result.getString("firstname"));
		// update widget
		getComponent("updateId").setValue(result.getInt("id").toString());
		getComponent("updateLastname").setValue(result.getString("lastname"));
		getComponent("updateFirstname").setValue(result.getString("firstname"));
		// delete widget
		getComponent("deletionid").setValue(result.getInt("id").toString());
	}
}