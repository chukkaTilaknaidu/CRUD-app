package daofactory;

import persistence.IStudentDao;
import persistence.StudentDaoImpl;

public class StudentDaoFactory {

	// Private constructor prevents external instantiation
	private StudentDaoFactory() {
	}

	// Static reference to an instance of IStudentDao
	private static IStudentDao iss = null;

	// Static factory method to get an instance of IStudentDao
	public static IStudentDao getStudentDao() {
		if (iss == null) {
			iss = new StudentDaoImpl(); // Creating an instance of the DAO implementation
		}
		return iss;
	}
}
