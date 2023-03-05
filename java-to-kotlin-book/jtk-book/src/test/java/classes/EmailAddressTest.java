package classes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmailAddressTest {

	@Test
	public void parsing() {
		assertEquals(
			new EmailAddress_("fred", "example.com"),
			EmailAddress_.parse("fred@example.com")
		);
	}

	@Test
	public void parsingFailures() {
		assertThrows(
			IllegalArgumentException.class,
			() -> EmailAddress_.parse("@")
		);
		assertThrows(
			IllegalArgumentException.class,
			() -> EmailAddress_.parse("fred@")
		);
		assertThrows(
			IllegalArgumentException.class,
			() -> EmailAddress_.parse("@example.com")
		);
		assertThrows(
			IllegalArgumentException.class,
			() -> EmailAddress_.parse("fred_at_example.com")
		);
	}

	@Test
	public void parsingWithAtInLocalPart() {
		assertEquals(
			new EmailAddress_("\"b@t\"", "example.com"),
			EmailAddress_.parse("\"b@t\"@example.com")
		);
	}

}