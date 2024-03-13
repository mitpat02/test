package ca.sheridancollege.patemitm.controller;

//import java.awt.print.Pageable;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.patemitm.beans.Student;
import ca.sheridancollege.patemitm.repository.StudentRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class StudentController {
	
	//@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("studentList",studentRepository.findAll());
		
		Student temp = studentRepository.findByName("Jaspreet");
		System.out.println(temp);
		
		return "index";
	}

	@PostMapping("/sendStudent")
	public String sendStudent(Model model, @ModelAttribute Student student) {
		
		Student temp = studentRepository.save(student);	
		//System.out.println(temp);
	
		model.addAttribute("student", new Student());
//		model.addAttribute("student", temp);
		model.addAttribute("studentList",studentRepository.findAll());
		return "index";
	}
	
	@GetMapping("/findByNameAndAge/{name}/{age}")
	//to retrieve name and g=age from form we have used @PAthVariable
	public String findByNameAndAge(Model model, @PathVariable String name,@PathVariable Integer age) {
	Student student = studentRepository.findByNameAndAge(name, age);
	model.addAttribute("student", student);
	return "displayIndividual";
	}
	
	@GetMapping("/findByAgeIsNull")
	public String findByAge(Model model) {
	List<Student> studentList = studentRepository.findByAgeIsNull();
	model.addAttribute("studentList", studentList);
	return "displayGroup";
	}
	
	@GetMapping("/findByBirthdayAfter/{year}/{month}/{day}")
	public String findByBirthdayAfter(Model model, @PathVariable int year, @PathVariable int month,
	@PathVariable int day) {
	LocalDate birthday = LocalDate.of(year, Month.of(month), day);
	List<Student> studentList = studentRepository.findByBirthdayAfter(birthday);
	model.addAttribute("studentList", studentList);
	return "displayGroup";
	}
	
	@GetMapping("/findByNameContaining/{namePart}")
	public String findByNameContaining(Model model, @PathVariable String namePart) {
	List<Student> studentList = studentRepository.findByNameContaining(namePart);
	model.addAttribute("studentList", studentList);
	return "displayGroup";
	
	}
	@GetMapping("findByOrderByName")
	public String findByOrderByName(Model model) {
		
		Pageable page = PageRequest.of(0, 3);
		
	model.addAttribute("studentList", studentRepository.findByOrderByName(page));
	
	return "displayGroup";
	}




}
