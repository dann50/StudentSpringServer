package com.example.springserver;

import com.example.springserver.model.Student;
import com.example.springserver.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

@SpringBootTest
class SpringServerApplicationTests {

	Random random = new Random();
	private final String[] firstNames =
			new String[]{"Ben", "Ashley", "Elvis", "David", "Paul", "Kevin", "George", "Harry"};
	private final String[] lastNames =
			new String[]{"Smith", "Harris", "James", "Newman", "Robson", "Banks", "Sullivan", "Rosk"};
	private final String[] depts =
			new String[]{"Physics", "Engineering", "Biology", "Chemistry"};
	private final String[] majors =
			new String[]{"Quantum Physics", "Electrical Engineering", "Medicare", "BioChemistry"};
	private final Supplier<LocalDate> dateSupplier =
			() -> LocalDate.of(random.nextInt(1995, 2005), random.nextInt(1, 13), random.nextInt(1, 28));
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@Autowired
	private StudentService studentService;

	private Student getRandomStudent() {
		int dept = 0;
		Student student = new Student();
		student.setName(firstNames[random.nextInt(firstNames.length)] + " " + lastNames[random.nextInt(lastNames.length)]);
		student.setDob(dateSupplier.get().format(formatter));
		dept = random.nextInt(depts.length);
		student.setDept(depts[dept]);
		student.setMajor(majors[dept]);
		return student;
	}

	@Test
	void addStudentTest() {
//		Student student = new Student();
//		//student.setId(2);
//		student.setName("Ben Smith");
//		student.setDob("2002-08-21");
//		student.setDept("Engineering");
//		student.setMajor("Electrical engineering");

		for (int i = 0; i < 1; i++) {
			Student student = getRandomStudent();
			studentService.saveStudent(student);
		}

	}

	@Test
	void getAllStudentsAndDelete() {
		List<Student> students = studentService.getAllStudents();
//		System.out.println(students);
		students.forEach(s -> studentService.deleteById(s.getId()));
	}

}
