package brainiacs.main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = {"brainiacs.games", "brainiacs.courses", "brainiacs.users"} )
@ComponentScan(basePackages = {"brainiacs.games", "brainiacs.courses", "brainiacs.users", "brainiacs.main"})
@EnableJpaRepositories(basePackages = {"brainiacs.games", "brainiacs.courses", "brainiacs.users"})
public class Main {

	public static void main(String[] args) 
	{

		SpringApplication.run(Main.class, args);

	}

}
