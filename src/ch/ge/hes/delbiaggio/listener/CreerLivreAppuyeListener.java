package ch.ge.hes.delbiaggio.listener;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import ch.ge.hes.delbiaggio.domaine.Livre;
import ch.ge.hes.delbiaggio.ecran.EcranListeLivre;
import ch.ge.hes.delbiaggio.ecran.EcranNouveauLivre;

@SuppressWarnings("serial")
public class CreerLivreAppuyeListener implements Button.ClickListener {
	
	private Livre book;
	
	public CreerLivreAppuyeListener(Livre book) {
		this.book = book;
	}
	
	@Override
    public void buttonClick(ClickEvent event) {
		//Il faut ajouter le livre
        Notification.show("Livre ajouté !");
        UI.getCurrent().setContent(new EcranListeLivre());    	   	
    }	
}
