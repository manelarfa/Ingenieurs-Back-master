package doc.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String email;
	private String firstname;
	private String lastname;
	private String password;
	private boolean activated;
	private Date birthdDay;
	private String etablissement;
	//PH, PES, PA
	private String grade;
	private String tel;
	private String specialite;
	private String themeDeRecherche;
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Role> roles=new ArrayList<Role>();
}
