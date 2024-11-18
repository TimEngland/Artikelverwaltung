
public class Benutzer {

	private String name;
	private String passwort;
	
	public Benutzer() {
		
	}
	public Benutzer(String name, String passwort) {
		this.name = name;
		this.passwort = passwort;	
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswort() {
		return passwort;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	@Override
	public boolean equals(Object obj) {
			if(obj instanceof Benutzer)	
			{
				Benutzer b = (Benutzer) obj;
				if (	b.getName().equals(this.getName())&&
						   b.getPasswort().equals(this.getPasswort())) 
				{ return true;}
				   
			}
	
			 return false;
	}
}
