package classes;

import java.util.Objects;

public class EmailAddress {
	private final String localPart; // <1> - 불변 값 선언
	private final String domain;

	public static EmailAddress parse(String value) { // <2> - 정적 팩터리 메서드
		var atIndex = value.lastIndexOf('@');
		if (atIndex < 1 || atIndex == value.length() - 1)
			throw new IllegalArgumentException(
				"EmailAddress must be two parts separated by @"
			);
		return new EmailAddress(
			value.substring(0, atIndex),
			value.substring(atIndex + 1)
		);
	}

	public EmailAddress(String localPart, String domain) { // <3> 생성자 초기화
		this.localPart = localPart;
		this.domain = domain;
	}

	public String getLocalPart() { // <4> getter
		return localPart;
	}

	public String getDomain() { // <4> getter
		return domain;
	}

	@Override
	public boolean equals(Object o) { // <5> equals and hashcode 재정의
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EmailAddress that = (EmailAddress) o;
		return localPart.equals(that.localPart) &&
			domain.equals(that.domain);
	}

	@Override
	public int hashCode() {
		return Objects.hash(localPart, domain);
	}

	@Override
	public String toString() { // <6> toString 재정의
		return localPart + "@" + domain;
	}
}