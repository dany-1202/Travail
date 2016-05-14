package ch.ge.hes.delbiaggio.listener;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;

import ch.ge.hes.delbiaggio.domaine.Livre;
import ch.ge.hes.delbiaggio.ecran.EcranNouveauLivre;

public class FieldNewBookChanged implements Property.ValueChangeListener{
	
	private Livre book;
	private Button btnCreate;
	
	public FieldNewBookChanged(Livre book,Button btnCreate) {
		this.book = book;
		this.btnCreate = btnCreate;
	}
	
	@Override
	public void valueChange(ValueChangeEvent event) {
		EcranNouveauLivre ecran = (EcranNouveauLivre)UI.getCurrent().getContent();
		System.out.println("le titre du livre est: " + book.getTitre());
		if(!(book.getTitre()==null || book.getAuteur()==null || book.getEditeur()==null || book.getAnnee()== -1)){	
        	btnCreate.setEnabled(true);
		}else{
			btnCreate.setEnabled(false);
		}	
	}
}
