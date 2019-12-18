
public class EmailValidator {
	
	//1- Only once occurrence of @ and .
	//2- Min 4 letters before @
	//3- Min 3 letters between @ and .
	//4- Min 2 letters after .
	public static void main(String[] args) {
		String email = "polo@aol.co";
		
		// Logic to solve problem 
		int iat = email.indexOf('@');
		int idot = email.indexOf('.');
		
		if(iat == email.lastIndexOf('@') && idot == email.lastIndexOf('.') 
				&& iat > 3 && idot > iat+3 && email.length() > idot+2)
			System.out.println("Valid email");
		else
			System.out.println("Invalid email");
	}

}
