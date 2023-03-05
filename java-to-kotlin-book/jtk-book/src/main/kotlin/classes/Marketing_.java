package classes;

public class Marketing_ {

	public static boolean isHotmailAddress(EmailAddress_ address) {
		return address.getDomain().equalsIgnoreCase("hotmail.com");
	}
}
