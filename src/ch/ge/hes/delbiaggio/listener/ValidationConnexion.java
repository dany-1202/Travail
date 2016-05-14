package ch.ge.hes.delbiaggio.listener;

import com.vaadin.server.VaadinService;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import ch.ge.hes.delbiaggio.BiblioUI;
import ch.ge.hes.delbiaggio.domaine.Utilisateur;
import ch.ge.hes.delbiaggio.ecran.EcranAccueil;
import ch.ge.hes.delbiaggio.ecran.EcranConnexion;



@SuppressWarnings("serial")
public class ValidationConnexion implements Button.ClickListener {

	private Utilisateur user;
	
	public ValidationConnexion(Utilisateur user){
		this.user = user;
	}
		
	public void buttonClick(ClickEvent event) {
		UI.getCurrent().getContent();
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		
		//Vérification temporaire
		if(user.getUsername().equals("admin") && user.getPassword().equals("admin")){	
			VaadinService.getCurrentRequest().getWrappedSession().setAttribute("username", user.getUsername());
			UI.getCurrent().setContent(new EcranAccueil());
		}else{
			UI.getCurrent().setContent(new EcranConnexion());
			Notification.show("Identifiant / mot de passe erroné!",Notification.Type.WARNING_MESSAGE);
		}
	}
}
