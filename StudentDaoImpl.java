package persistence;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import JavaDataBaseConnectivity.copy.Jdbc;
import dto.Student;

public class StudentDaoImpl implements IStudentDao {

	Connection con = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	@Override
	public String addStudent(Integer id, String name, Integer marks) {
		String sqlInsertQuery = "insert into tilaknaidu.marks(`id`,`name`,`marks`)values(?,?,?)";
		try {
			con = Jdbc.getJdbcConnection();
			if (con != null) {
				pstm = con.prepareStatement(sqlInsertQuery);
			}
			if (pstm != null) {
				pstm.setInt(1, id);
				pstm.setString(2, name);
				pstm.setInt(3, marks);

				int rowAffected = pstm.executeUpdate();

				if (rowAffected == 1) {
					return "successful";
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			// Close resources
		}
		return "failure";
	}

	@Override
	public Student searchStudent(Integer id) {
		String sqlSearchQuery = "select id,name,marks from tilaknaidu.marks where id=?";
		Student std = null;
		try {
			con = Jdbc.getJdbcConnection();
			if (con != null) {
				pstm = con.prepareStatement(sqlSearchQuery);
			}
			if (pstm != null) {
				pstm.setInt(1, id);
			}
			if (pstm != null) {
				rs = pstm.executeQuery();
			}
			if (rs != null) {

				if (rs.next()) {
					std = new Student();
					std.setId(rs.getInt(1));
					std.setName(rs.getString(2));
					std.setMarks(rs.getInt(3));
					return std;
				} else {
					System.out.println("RECORDS NOT FOUND");
				}

			}

		} catch (SQLException se) {
			se.printStackTrace();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return std;

	}

	@Override
	public String updateStudent(Student student) {
		String sqlUpdateQuery = "update tilaknaidu.marks set name=?,marks=? where id=?";
		try {
			con = Jdbc.getJdbcConnection();
			if (con != null) {
				pstm = con.prepareStatement(sqlUpdateQuery);
			}

			if (pstm != null) {

				// pstm.setInt(1, student.getId());
				pstm.setString(1, student.getName());
				pstm.setInt(2, student.getMarks());
				pstm.setInt(3, student.getId());
				int rowaffected = pstm.executeUpdate();
				if (rowaffected == 1) {
					return "success";
				}
			}
			/*
			 * if (rs != null) { while (rs.next()) { System.out.println(rs.getInt(1) + " " +
			 * rs.getString(2) + " " + rs.getInt(3)); } } else {
			 * System.out.println("Records not updated"); }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "failuredd";
	}

	@Override
	public String deleteStudent(Integer id) {
		int ra = 0;
		String deleteQuery = "delete  from tilaknaidu.marks where id=?";
		try {
			con = Jdbc.getJdbcConnection();
			if (con != null) {
				pstm = con.prepareStatement(deleteQuery);
			}
			if (pstm != null) {
				pstm.setInt(1, id);
			}
			if (pstm != null) {
				ra = pstm.executeUpdate();
			}
			if (ra == 1) {
				return "success";
			}

		} catch (SQLException | IOException ioe) {
			ioe.printStackTrace();
		}

		return null;
	}

	// Other methods for searching, updating, and deleting students
}
