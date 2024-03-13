package ca.sheridancollege.patemitm.bootstrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.patemitm.beans.Student;
import ca.sheridancollege.patemitm.repository.StudentRepository;

@Component
public class BootstrapData implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	//TODO comment this method for production
	public void run(String... args) throws Exception {
		Student jaspreet = new Student("Jaspreet", LocalDate.parse("1995-10-01"));
		Student sally = new Student("Sally", LocalDate.parse("2001-01-15"));
		Student xiao = new Student("Xiao", LocalDate.parse("1992-05-19"));
		Student tim = new Student("Tim", LocalDate.parse("1998-11-30"));

		Student allan = new Student("Allan", LocalDate.parse("1995-10-28"), 26);
		Student anne = new Student("Anne", LocalDate.parse("1990-01-01"), 32);
		Student amar = new Student("Amar", LocalDate.parse("1985-03-31"), 36);


		
		studentRepository.save(jaspreet);
		studentRepository.save(sally);
		studentRepository.save(xiao);
		studentRepository.save(tim);

		studentRepository.save(allan);
		studentRepository.save(anne);
		studentRepository.save(amar);
		

		
//		studentRepository.deleteById((long) 2);
	}

}
