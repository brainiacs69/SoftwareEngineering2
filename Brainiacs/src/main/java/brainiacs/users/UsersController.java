package brainiacs.users;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import brainiacs.courses.Course;

@RestController
public class UsersController 
{
	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/game/{id}")
	public Integer playGame(@PathVariable Integer id)
	{
		return id;
	}
	
	@RequestMapping("/{teacher}/courses")
	public List<Course> getCourses(@RequestBody User user)
	{
		return userService.getCoursesById(user.getUsername());
	}

}
