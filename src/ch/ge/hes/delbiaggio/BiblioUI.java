package ch.ge.hes.delbiaggio;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

import ch.ge.hes.delbiaggio.domaine.Utilisateur;
import ch.ge.hes.delbiaggio.ecran.EcranAccueil;

import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


//@Theme("coucou")
@SuppressWarnings("serial")
public class BiblioUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = BiblioUI.class)
	public static class Servlet extends VaadinServlet {
	}
	
	public  Utilisateur user = null;

	@Override
	protected void init(VaadinRequest request) {
		EcranAccueil ecranAccueil = new EcranAccueil();
		setContent(ecranAccueil);
	}
}