package doc.web;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import doc.entities.User;
import doc.service.AccountService;
import lombok.Data;

@RestController
public class UserController {

	@Autowired
	AccountService accountService;
	@PostMapping("/register")
	public User register(@RequestBody UserForm userForm)
	{
		
		System.err.println(userForm);
		return accountService.saveUser(
				userForm.getFirstname(),
				userForm.getLastname(),
				userForm.getEmail(),
				userForm.getPassword(),
				userForm.getRole(),
				userForm.getActive(),
				userForm.getBirthdDay(),
				userForm.getEtablissement(),
				userForm.getGrade(),
				userForm.getTel(),
				userForm.getSpecialite(),
				userForm.getThemeDeRecherche()
				);
	}
}
@Data
class UserForm{
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String role;
	private Boolean active;
	private Date birthdDay;
	private String etablissement;
	private String grade;
	private String tel;
	private String specialite;
	private String themeDeRecherche;
}
