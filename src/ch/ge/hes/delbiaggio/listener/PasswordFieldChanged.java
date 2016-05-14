package ch.ge.hes.delbiaggio.listener;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;

import ch.ge.hes.delbiaggio.domaine.Utilisateur;

public class PasswordFieldChanged implements Property.ValueChangeListener{
	private Utilisateur user;
	
	public PasswordFieldChanged(Utilisateur user){
		this.user = user;
	}		
	
	@Override
	public void valueChange(ValueChangeEvent event) {
		user.setPassword(event.getProperty().getValue()+"");		
	}

}
