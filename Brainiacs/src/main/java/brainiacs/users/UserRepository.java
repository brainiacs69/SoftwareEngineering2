package brainiacs.users;

import java.util.List;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import brainiacs.courses.Course;



public interface UserRepository extends CrudRepository<User, String>
{

	
	
	@Query("SELECT c FROM Course c JOIN c.teachers u WHERE u.username = :id")
	List<Course> findCoursesByUser(@Param("id") String username);
}
