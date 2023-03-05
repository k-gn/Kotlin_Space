package classes;

public class Marketing {

	public static boolean isHotmailAddress(EmailAddress address) {
		return address.getDomain().equalsIgnoreCase("hotmail.com");
	}
}
