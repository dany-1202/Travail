package ch.ge.hes.delbiaggio.ecran;

import java.util.ArrayList;
import java.util.Collection;

import com.vaadin.data.Container.Indexed;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.GeneratedPropertyContainer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.HeaderRow;

import ch.ge.hes.delbiaggio.composant.ComposantBarMenu;
import ch.ge.hes.delbiaggio.domaine.Livre;
import ch.ge.hes.delbiaggio.listener.NewBookPressed;

import com.vaadin.ui.VerticalLayout;

public class EcranListeLivre extends VerticalLayout {
	
	private Collection <Livre>livres;
	private Grid grLstLivre;
	private Button btnNewBook;
	
	public EcranListeLivre(){
		loadBooks();		
		initGrid();		
		btnNewBook = new Button("Nouveau");
		btnNewBook.addClickListener(new NewBookPressed());
		btnNewBook.setHeight("10%");
		addComponent();	
	}
	
	private void initGrid(){		
		BeanItemContainer<Livre> containerLivre = new BeanItemContainer<>(Livre.class,livres);		
		grLstLivre = new Grid(containerLivre);
		grLstLivre.setSizeFull();
		grLstLivre.removeColumn("no");
		HeaderRow row = grLstLivre.addHeaderRowAt(0);
		row.join("titre","annee","auteur","editeur").setHtml("<b>Liste des livres </b>");
		grLstLivre.setColumnOrder("titre","auteur","editeur","annee");
		grLstLivre.setSizeFull();
	}
	
	private void loadBooks(){
		livres = new ArrayList<Livre>();
		livres.add(new Livre(1,"Tintin","Zep","Paul",1987));
		livres.add(new Livre(2,"Le chacal","Pouf","Paul",1987));
		livres.add(new Livre(3,"Poulet","Titou","Jack",1967));
		livres.add(new Livre(4,"Razi","Tutu","Jean",1937));
	}
	
	private void addComponent(){
		ComposantBarMenu mnuBar = new ComposantBarMenu(); 
		mnuBar.setHeight("10%");
		addComponent(mnuBar);
		addComponent(grLstLivre);
		addComponent(btnNewBook);
		setComponentAlignment(btnNewBook, Alignment.TOP_RIGHT);
		setSizeFull();
		setComponentAlignment(grLstLivre, Alignment.TOP_LEFT);
	}
}
