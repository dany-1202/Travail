package ch.ge.hes.delbiaggio.ecran;

import java.beans.Beans;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.IntegerRangeValidator;
import com.vaadin.data.validator.NullValidator;
import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.AbstractField;
import com.vaadin.ui.AbstractTextField;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Field;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.ge.hes.delbiaggio.composant.ComposantBarMenu;
import ch.ge.hes.delbiaggio.domaine.Livre;
import ch.ge.hes.delbiaggio.listener.CreerLivreAppuyeListener;
import ch.ge.hes.delbiaggio.listener.FieldNewBookChanged;

@SuppressWarnings("serial")
public class EcranNouveauLivre extends VerticalLayout{
	private FormLayout fl;
	private FieldGroup groupe;
	private Field<?> tfTitre; 
	private Field<?> tfAuteur;
	private Field<?> tfEditeur;	
	private Field<?> tfAnnee;	
	private Button btnCree;	
	private Livre book = new Livre();
	
	
	public EcranNouveauLivre(){
		setMargin(true);
		setSizeFull();	
		initComponent();
		addComponent(new ComposantBarMenu());
		addComponent(fl);
		setComponentAlignment(fl, Alignment.TOP_CENTER);
	}
	
	private void initComponent(){
		BeanItem <Livre> item = new BeanItem<Livre>(book);
		groupe = new FieldGroup(item);
		initBtnCree();
		initTfTitre();
		initTfAuteur();
		initTfEditeur();
		initTfAnnee();		
		fl = new FormLayout(tfTitre,tfAuteur,tfEditeur,tfAnnee,btnCree);
		fl.setComponentAlignment(tfTitre, Alignment.MIDDLE_RIGHT);
		fl.setComponentAlignment(tfAnnee, Alignment.MIDDLE_RIGHT);
		fl.setSizeFull();		
	}
	
	@SuppressWarnings("unchecked")
	private void initTfTitre(){				
		tfTitre = groupe.buildAndBind("titre");
		tfTitre.addValueChangeListener(new FieldNewBookChanged(book,btnCree));
		tfTitre.addValidator(new StringLengthValidator("Nb de caractères doit être compris entre [1 - 50]",1, 50, true));
		((AbstractTextField) tfTitre).setNullRepresentation("");				
	}
	
	private void initTfAuteur(){
		tfAuteur = groupe.buildAndBind("auteur");
		tfAuteur.addValueChangeListener(new FieldNewBookChanged(book,btnCree));
		tfAuteur.addValidator(new StringLengthValidator("Nb de caractères doit être compris entre [1 - 50]",1, 50, true));
		((AbstractTextField) tfAuteur).setNullRepresentation("");
	}
	
	private void initTfEditeur(){
		tfEditeur = groupe.buildAndBind("editeur");
		tfEditeur.addValueChangeListener(new FieldNewBookChanged(book,btnCree));
		tfEditeur.addValidator(new StringLengthValidator("Nb de caractères doit être compris entre [1 - 50]",1, 50, true));
		((AbstractTextField) tfEditeur).setNullRepresentation("");
	}
	
	private void initTfAnnee(){
		tfAnnee = groupe.buildAndBind("annee");
		tfAnnee.addValueChangeListener(new FieldNewBookChanged(book,btnCree));
		((AbstractField<String>) tfAnnee).setValidationVisible(false);
		((AbstractTextField) tfAnnee).setNullRepresentation("");
		((AbstractComponent) tfAnnee).setImmediate(true);
		((AbstractTextField) tfAnnee).setInputPrompt("Entrez une année");
	}
	
	private void initBtnCree(){		
		btnCree = new Button("Créer");		
		btnCree.setEnabled(false);
		btnCree.setClickShortcut(KeyCode.ENTER);
		btnCree.addClickListener(new CreerLivreAppuyeListener(book));
	}
	
}
