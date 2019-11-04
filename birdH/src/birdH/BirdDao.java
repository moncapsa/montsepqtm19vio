package birdH;

import java.util.*;
import java.sql.*;

public class BirdDao {

	public static Connection getConnection() {

		Connection conection = null;
		try {

			Class.forName("org.h2.Driver");
			conection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/bird", "sa", "a");
		} catch (Exception e) {
			System.out.println(e);
		}
		return conection;
	}

	public static int save(Bird bird) {
		int status = 0;

		try {
			Connection connection = BirdDao.getConnection();
			PreparedStatement preparedStatment = connection
					.prepareStatement("insert into BIRDS (name,latinName,location,observation) values (?,?,?,?)");
			preparedStatment.setString(1, bird.getName());
			preparedStatment.setString(2, bird.getLatinName());
			preparedStatment.setString(3, bird.getLocation());
			preparedStatment.setString(4, bird.getObservation());

			status = preparedStatment.executeUpdate();

			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int update(Bird bird) {

		int status = 0;
		try {
			Connection connection = BirdDao.getConnection();
			PreparedStatement preparedStatment = connection
					.prepareStatement("update BIRDS set name=?,latinName=?,location=?,observation=? where birdId=?");

			preparedStatment.setString(1, bird.getName());
			preparedStatment.setString(2, bird.getLatinName());
			preparedStatment.setString(3, bird.getLocation());
			preparedStatment.setString(4, bird.getObservation());
			preparedStatment.setInt(5, bird.getId());

			status = preparedStatment.executeUpdate();

			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int delete(int id) {
		int status = 0;

		try {

			Connection connection = BirdDao.getConnection();
			PreparedStatement prepareStatment = connection.prepareStatement("delete from BIRDS where birdid=?");

			prepareStatment.setInt(1, id);
			status = prepareStatment.executeUpdate();

			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static Bird getBirdById(int idBird) {

		Bird bird = new Bird();

		try {
			Connection connection = BirdDao.getConnection();
			PreparedStatement preparedStatment = connection
					.prepareStatement("select * from BIRDS where birdid=?");
			preparedStatment.setInt(1, idBird);

			ResultSet rs = preparedStatment.executeQuery();
			if (rs.next()) {
				bird.setId(rs.getInt(1)); 
				bird.setName(rs.getString(2));
				bird.setLatinName(rs.getString(3));
				bird.setLocation(rs.getNString(4));
				bird.setObservation(rs.getNString(5));
			}
			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return bird;
	}

	public static List<Bird> getAllBirds() {
		List<Bird> list = new ArrayList<Bird>();

		try {
			Connection connection = BirdDao.getConnection();
			PreparedStatement preparedStatment = connection.prepareStatement("select * from BIRDS");
			ResultSet rs = preparedStatment.executeQuery();
			while (rs.next()) {
				Bird bird = new Bird();
				bird.setId(rs.getInt(1)); 
				bird.setName(rs.getString(2));
				bird.setLatinName(rs.getString(3));
				bird.setLocation(rs.getNString(4));
				bird.setObservation(rs.getNString(5));
				list.add(bird);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}