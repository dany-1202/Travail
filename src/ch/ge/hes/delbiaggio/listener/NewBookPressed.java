package ch.ge.hes.delbiaggio.listener;

import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import ch.ge.hes.delbiaggio.ecran.EcranNouveauLivre;

public class NewBookPressed implements Button.ClickListener{
	public void buttonClick(ClickEvent event) {
		UI.getCurrent().setContent(new EcranNouveauLivre());
	}
}
