package doc;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import doc.dao.RoleRepository;
import doc.entities.Annonce;
import doc.entities.Message;
import doc.entities.Role;
import doc.service.AccountService;
import doc.service.AnnonceService;
import doc.service.MessageService;

@SpringBootApplication
public class GestoDocApplication implements CommandLineRunner{

	@Autowired
	AccountService accountService;
	@Autowired
	AnnonceService annonceService;
	@Autowired
	MessageService messageService;
	
	public static void main(String[] args) {
		SpringApplication.run(GestoDocApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("===============================START=======================================");
		accountService.save(new Role(null,"ADMIN"));
		accountService.save(new Role(null,"USER"));
		accountService.saveUser("user","user","user@mail.com", "1234","USER",true,new Date(),"Etablissement","Grade","0655443322","Specialite","Theme de recherche");
		accountService.saveUser("admin","admin","admin@gmail.com","1234","ADMIN",true,new Date(),"Etablissement","Grade","0655443322","Specialite","Theme de recherche");
		for (int i = 1; i < 11; i++) {
			accountService.saveUser("user"+i,"user"+i,"user"+i+"@gmail.com","1234","USER",true,new Date(),"Etablissement","Grade","0655443322","Specialite","Theme de recherche");
		}
		for (int i = 1; i < 3; i++) {
		annonceService.saveAnnonce(new Annonce(null,"Sed do eiusmod tempor incididunt","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolo.",new Date(),"Urgent"));
		//annonceService.saveAnnonce(new Annonce(null,"Qui trum dona consequuntur","Aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora.",new Date(),"Normal"));
		//annonceService.saveAnnonce(new Annonce(null,"Quis nostrum exercitationem ullam corporis","Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure ",new Date(),"Fiable"));
		}
		for (int i = 1; i < 11; i++) {
			messageService.saveMessage(new Message(null,"Nom "+i,"nom"+i+"@mail.com","Message de nom"+i));
		}
		
	}

}
