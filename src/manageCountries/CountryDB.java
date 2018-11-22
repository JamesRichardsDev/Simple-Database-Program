package manageCountries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

import com.mysql.jdbc.PreparedStatement;

public class CountryDB {

	static Connection conn = null;
	static String URL = "jdbc:mysql://localhost:3306/mma?useSSL=false";

	static String username = "user";
	static String password = "sesame";

	public ArrayList<String> getCountries() throws Exception {
		ArrayList<String> array = new ArrayList<>();
		PreparedStatement statement = null;
		try {
			conn = (Connection) DriverManager.getConnection(URL, username, password);
			statement = (PreparedStatement) conn.prepareStatement("SELECT country FROM countries");

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				array.add(result.getString("country"));
			}
			Collections.sort(array);

		} catch (Exception e) {
			System.out.println("No connection was established");
		} finally {
			statement.close();
			conn.close();

		}

		return array;
	}

	public boolean addCountry(String country) throws Exception {
		PreparedStatement pst = null;
		try {
			conn = (Connection) DriverManager.getConnection(URL, username, password);
			if (conn != null) {
				pst = (PreparedStatement) conn.prepareStatement("INSERT INTO countries (country) VALUES(?)");
				pst.setString(1, country);
				pst.executeUpdate();
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		pst.close();
		conn.close();
		return true;
	}

	public boolean deleteCountry(String country) throws Exception {
		PreparedStatement pst = null;
		try {
			conn = (Connection) DriverManager.getConnection(URL, username, password);
			if (conn != null) {
				pst = (PreparedStatement) conn.prepareStatement("Delete FROM countries WHERE country = ?");
				pst.setString(1, country);
				pst.executeUpdate();
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			pst.close();
			conn.close();
		}
		return true;
	}




}
