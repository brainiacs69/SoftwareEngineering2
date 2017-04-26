package brainiacs.courses;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController
{
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(method = RequestMethod.POST, value = "courses/create")
	public void createCourse(@RequestBody Course course)
	{
		courseService.addCourse(course);
	}
	
	@RequestMapping("/courses")
	public ArrayList<Course> getCourses()
	{
		return courseService.getCourses();
	}
	
	

}
