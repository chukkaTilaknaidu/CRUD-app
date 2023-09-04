package persistence;

import dto.Student;

public interface IStudentDao {
	// operations to be implemented
	public String addStudent(Integer id, String name, Integer marks);

	public Student searchStudent(Integer id);

	public String updateStudent(Student student);

	public String deleteStudent(Integer id);

}
