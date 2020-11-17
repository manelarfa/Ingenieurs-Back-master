package doc.service;



import java.util.Date;

import doc.entities.Role;
import doc.entities.User;

public interface IAccountService {
	public User saveUser(
			String firstrname,
			String lastname,
			String email,
			String password,
			String role,
			boolean active,
			Date birthdDay,
			String etablissement,
			String grade,
			String tel,
			String specialite,
			String themeDeRecherche);
	public Role save(Role role);
	public User loadUserByEmail(String email);
	public void addRoleToUser(String email,String rolename);
}
