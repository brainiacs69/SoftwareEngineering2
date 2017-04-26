package brainiacs.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AuthController 
{
	
	
	
	@Autowired
	private UserService userService;
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/authenticate/{user}")
	public void register(@RequestBody User user)
	{
		userService.addUser(user);
	}
	@RequestMapping(method = RequestMethod.POST, value = "/authenticate/login")
	public User login(@RequestBody User user)
	{
		for(int i = 0; i < userService.getUsers().size(); i++)
		{
			if(userService.getUsers().get(i).equals(user))
			{
				return userService.getUsers().get(i); 
			}
		}
		return null;
	}
	
	
	
	
}
