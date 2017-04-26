package brainiacs.courses;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import brainiacs.users.UserRepository;

@Service
public class CourseService
{
	@Autowired
	private CourseRepository courseRepo;

	
	public void addCourse(Course course)
	{
		
		courseRepo.save(course);
	}
	
	public ArrayList<Course> getCourses()
	{
		ArrayList<Course> courses = new ArrayList<Course>();
		courseRepo.findAll().forEach(courses::add);
		return courses;
	}
}

