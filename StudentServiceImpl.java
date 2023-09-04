package service;

import daofactory.StudentDaoFactory;

import dto.Student;
import persistence.IStudentDao;

public class StudentServiceImpl implements IStudentService {

	private IStudentDao iss = null;

	@Override
	public String addStudent(Integer id, String name, Integer marks) {
		iss = StudentDaoFactory.getStudentDao();
		if (iss != null) {
			// System.out.println("iss is not null");
			return iss.addStudent(id, name, marks);
		} else {
			return "failure";
		}
	}

	@Override
	public Student searchStudent(Integer id) {
		iss = StudentDaoFactory.getStudentDao();
		if (iss != null) {
			return iss.searchStudent(id);
		} else {
			return null;
		}

	}

	@Override
	public String updateStudent(Student student) {
		iss = StudentDaoFactory.getStudentDao();

		if (iss != null) {
			return iss.updateStudent(student);
		} else {
			return "failure at seviceimpl";
		}
	}

	@Override
	public String deleteStudent(Integer id) {
		iss = StudentDaoFactory.getStudentDao();
		if (iss != null) {
			return iss.deleteStudent(id);
		}
		return "failure at service layer";
	}

	// Other methods for searching, updating, and deleting students
}
