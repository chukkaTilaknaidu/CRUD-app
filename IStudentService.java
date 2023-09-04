package service;

import dto.Student;

public interface IStudentService {
	// operations to be implemented
	public String addStudent(Integer id, String name, Integer marks);

	public Student searchStudent(Integer id);

	public String deleteStudent(Integer id);

	public String updateStudent(Student std);

}
