package com.skilldistillery.film.data;

import java.sql.*;

public class FilmDaoDBImpl implements FilmDao {
	private static String url = "jdbc:mysql://localhost:3306/sdvid";
	private String user = "student";
	private String pass = "student";

	@Override
	public String getFilmTitleById(int id) {
		String title = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT title FROM film WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				title = rs.getString(1);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return title;
	}

	public FilmDaoDBImpl() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Error loading MySQL Driver!!!");
		}
	}
}
