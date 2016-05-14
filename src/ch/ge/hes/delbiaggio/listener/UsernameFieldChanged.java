package ch.ge.hes.delbiaggio.listener;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;

import ch.ge.hes.delbiaggio.domaine.Utilisateur;

public class UsernameFieldChanged implements Property.ValueChangeListener{

	private Utilisateur user;
	
	public UsernameFieldChanged(Utilisateur user){
		this.user = user;
	}
		
	
	@Override
	public void valueChange(ValueChangeEvent event) {
		user.setUsername(event.getProperty().getValue()+"");		
	}

}
