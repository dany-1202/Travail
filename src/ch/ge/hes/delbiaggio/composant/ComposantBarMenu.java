package ch.ge.hes.delbiaggio.composant;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.UI;

import ch.ge.hes.delbiaggio.BiblioUI;
import ch.ge.hes.delbiaggio.listener.ConnectionPress;
import ch.ge.hes.delbiaggio.listener.DeconnexionPressed;
import ch.ge.hes.delbiaggio.listener.LivresPressed;

import com.vaadin.ui.HorizontalLayout;

public class ComposantBarMenu extends HorizontalLayout{
	private Label lbNampeApp; 
	private Button btnLivres; 
	private Button btnConnexion;
	
	public ComposantBarMenu() {
		initBarMenu();
		BiblioUI ui = (BiblioUI)UI.getCurrent();
		if(VaadinService.getCurrentRequest().getWrappedSession().getAttribute("username")==null){
				btnConnexion = new Button("Connexion");
				btnConnexion.addClickListener(new ConnectionPress());				
		}else{
				btnConnexion = new Button("Déconnexion");
				btnConnexion.addClickListener(new DeconnexionPressed());
		}
		addComponents(lbNampeApp,btnLivres,btnConnexion);
		setComponentAlignment(btnConnexion, Alignment.TOP_RIGHT);
		setComponentAlignment(btnLivres, Alignment.TOP_CENTER);
	}
		
	private void initBarMenu(){
		setMargin(true);
		setWidth("100%");
		lbNampeApp = new Label("App Bibliothèque");
		btnLivres = new Button("Livres");
		btnLivres.setStyleName("link");
		btnLivres.addClickListener(new LivresPressed());		
	}
}
