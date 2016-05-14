package ch.ge.hes.delbiaggio.listener;

import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import ch.ge.hes.delbiaggio.ecran.EcranListeLivre;

public class LivresPressed implements Button.ClickListener {
	public void buttonClick(ClickEvent event) {
		UI ui = UI.getCurrent();
		ui.setContent(new EcranListeLivre());
	}
}
