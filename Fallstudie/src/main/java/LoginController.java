import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIInput;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.ComponentSystemEvent;
import jakarta.faces.validator.ValidatorException;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named
@ViewScoped
public class LoginController implements Serializable{
	
	private Benutzer benutzer;
	
	private String benutzerNameVal;
	
	public LoginController() {
		this.benutzer = new Benutzer();
		
	}
	
	public Benutzer getBenutzer() {
		return benutzer;
	}
	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}
	 
	
	
	public String getBenutzerNameVal() {
		return benutzerNameVal;
	}

	public void setBenutzerNameVal(String benutzerNameVal) {
		this.benutzerNameVal = benutzerNameVal;
	}





	

	public String login() {
		List<Benutzer> benutzerListe  = Shop.getInstance().getBenutzerListe();
		for(Benutzer b : benutzerListe) {
			if(b.equals(this.benutzer)) {
				return "index.xhtml" ;
			}
		}
	
		
		return "login.xhtml";
	}

	public void postValidateName(ComponentSystemEvent ev) throws AbortProcessingException {
	
		UIInput temp = (UIInput)ev.getComponent();
		this.benutzerNameVal =(String)temp.getValue();
		
	}
	
	public void validateLogin(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		List<Benutzer> benutzerListe  = Shop.getInstance().getBenutzerListe();
		for(Benutzer b : benutzerListe) {
			Benutzer temp = new Benutzer(this.benutzerNameVal, (String) value);
			if(b.equals(temp)) {return;}
		}
		System.out.println("Login falsch");
		throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login falscho", null));
	}
	
}