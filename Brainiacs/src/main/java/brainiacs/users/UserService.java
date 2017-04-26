package brainiacs.users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import brainiacs.courses.Course;

@Service
public class UserService
{
	@Autowired
	private UserRepository userRepo;
	
	
	
	
	
	
	public ArrayList<Course> getCoursesById(String user)
	{
		ArrayList<Course> courses = new ArrayList<Course>();
		userRepo.findCoursesByUser(user).forEach(courses::add);
		return courses;
		
	}
	public ArrayList<User> getUsers()
	{
		ArrayList<User> users = new ArrayList<User>();
		userRepo.findAll().forEach(users::add);
		return users;
	}
	
	public void addUser(User user)
	{
		userRepo.save(user);
	}

}
