package ch.ge.hes.delbiaggio.listener;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import ch.ge.hes.delbiaggio.ecran.EcranConnexion;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public class ConnectionPress implements Button.ClickListener {

	public void buttonClick(ClickEvent event) {
		UI.getCurrent().setContent(new EcranConnexion());
	}
}
