package ca.sheridancollege.patemitm.repository;

//import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.patemitm.beans.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	public Student findByName(String name);
	public List<Student> findByOrderByName();
	
	public List<Student> findByOrderByName(Pageable page);
	
	public Student findByNameAndAge(String name, Integer age);
	public List<Student> findByAgeIsNull();
	public List<Student> findByBirthdayAfter(LocalDate birthday);
	public List<Student> findByNameContaining(String namePart);

}
