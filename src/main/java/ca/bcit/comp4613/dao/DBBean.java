package ca.bcit.comp4613.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DBBean {
	private String queryString = "empty";
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet queryResults = null;
	private ResultSetMetaData meta = null;
	private Vector<Vector<String>> vRows = null;

	public DBBean() {
	}

	public void connect(String driver, String url, String user, String pass) {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String qs) {

		queryString = qs;
	}

	public void generateResultSet() throws SQLException {
		vRows = new Vector<Vector<String>>();
		int numCols;

		statement = connection.createStatement();

		queryResults = statement.executeQuery(queryString);
		meta = queryResults.getMetaData();
		numCols = meta.getColumnCount();

		while (queryResults.next()) {
			Vector<String> vOneRow = new Vector<String>();
			for (int ndx = 1; ndx <= numCols; ndx++) {
				vOneRow.addElement(queryResults.getString(ndx));
			}
			vRows.addElement(vOneRow);
		}

	}

	public void setResultSet(ResultSet rs) {
		queryResults = rs;
	}

	public Vector<Vector<String>> getResults() {

		return vRows;
	}

	public Vector<String> getColumnNames() throws SQLException {

		Vector<String> columnNames = new Vector<String>();
		try {
			for (int i = 0; i < meta.getColumnCount(); i++) {
				columnNames.add(meta.getColumnName(i + 1));
			}
		} catch ( SQLException e ){
			e.printStackTrace();
		}
		return columnNames;
	}

	public void cleanUp() {
		try {
			connection.close();
			statement.close();
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
	}
}
