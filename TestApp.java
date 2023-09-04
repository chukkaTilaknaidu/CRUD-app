package controller;

import service.IStudentService;

import servicefactory.StudentServiceFactory;

import java.sql.ResultSet;
import java.util.Scanner;

import dto.Student;

public class TestApp {
	static Scanner scanner = new Scanner(System.in);
	static int id;

	public static void main(String[] args) {

		while (true) {

			System.out.println("press 1 for insertion ::");
			System.out.println("press 2 for search ::");
			System.out.println("press 3 for delete ::");
			System.out.println("press 4 for update ::");
			System.out.println("press 5 for exit ::");
			System.out.println("Enter your choice ::");
			String option = scanner.next();

			switch (option) {
			case "1":
				insertion();
				break;
			case "2":
				studentSearch();
				break;
			case "3":
				deleted_row();
				break;
			case "4":
				update_student();
				break;
			case "5":
				System.out.println("Thanks for using............ ");
				System.exit(0);
			default:
				System.out.println("YOUR INPUT IS INVALID..................");

			}

		}

	}

	public static void deleted_row() {
		IStudentService studentService = StudentServiceFactory.getStudentService();

		System.out.println("enter the id to be deleted");
		id = scanner.nextInt();

		Student std = studentService.searchStudent(id);
		if (std != null) {
			String student = studentService.deleteStudent(id);
			if (student.equalsIgnoreCase("success")) {
				System.out.println("row deleted sucessfully");
			}

		} else {
			System.out.println("row not deleted , check once");
		}

	}

	public static void update_student() {
		System.out.println("enter the id to be updated");
		int id = scanner.nextInt();
		IStudentService studentService = StudentServiceFactory.getStudentService();
		Student student = studentService.searchStudent(id);
		if (student != null) {

			Student std = new Student();
			std.setId(student.getId());

			System.out.println("ENTER NEW  NAME");
			String newname = scanner.next();

			if (newname.equals("") || newname == "") {
				std.setName(student.getName());
			} else {
				std.setName(newname);
			}
			System.out.println("enter new marks");
			String marks_new = scanner.next();
			if (marks_new.equals("") || marks_new == "") {
				std.setMarks(student.getMarks());
			} else {
				std.setMarks(Integer.parseInt(marks_new));
			}

			String status = studentService.updateStudent(std);

			if (status.equals("success")) {
				System.out.println("records updated sucessfully");
			} else {
				System.out.println("records not found at " + id);
			}

		} else {
			System.out.println("record not foundedd in the database");
		}
		scanner.close();
	}

	public static void studentSearch() {
		ResultSet rs = null;

		IStudentService studentService = StudentServiceFactory.getStudentService();
		System.out.println("Enter the id number ::");
		id = scanner.nextInt();
		Student student = studentService.searchStudent(id);

		if (student != null) {
			System.out.println("Student ID: " + student.getId());
			System.out.println("Student Name: " + student.getName());
			System.out.println("Student Marks: " + student.getMarks());
		} else {
			System.out.println("Record not found in the database");
		}

	}

	public static void insertion() {

		IStudentService studentService = StudentServiceFactory.getStudentService();

		System.out.print("Enter the student id :: ");
		id = scanner.nextInt();

		System.out.print("Enter the student name :: ");
		String name = scanner.next();

		System.out.print("Enter the student marks :: ");
		int marks = scanner.nextInt();

		String msg = studentService.addStudent(id, name, marks);
		if (msg.equalsIgnoreCase("successful")) {
			System.out.println("Record inserted successfully");
		} else {
			System.out.println("Record insertion failed....");
		}

	}

}
