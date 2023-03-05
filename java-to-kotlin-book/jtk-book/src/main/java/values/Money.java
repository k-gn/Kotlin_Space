package values;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

public class Money {

	private final BigDecimal amount;
	private final Currency currency;

	private Money(BigDecimal amount, Currency currency) { // <1> private constructor
		this.amount = amount;
		this.currency = currency;
	}

	public static Money of(BigDecimal amount, Currency currency) { // <1> 정적 팩터리 메서드
		return new Money(
			/*
				BigDecimal 의 setScale 함수는 setter 이름이지만 실제론 상태를 변경하지 않아 혼란을 야기할 수 있다.
				따라서 withScale 같은 이름의 확장함수를 추가해 바로잡을 수 있다.
			 */
			amount.setScale(currency.getDefaultFractionDigits()),
			currency);
	}


	public static Money of(String amountStr, Currency currency) { // <2> 정적 팩터리 메서드
		return Money.of(new BigDecimal(amountStr), currency);
	}

	public static Money of(int amount, Currency currency) {
		return Money.of(new BigDecimal(amount), currency);
	}

	public static Money zero(Currency userCurrency) {
		return Money.of(BigDecimal.ZERO, userCurrency);
	}


	public BigDecimal getAmount() { // <2> getter
		return amount;
	}

	public Currency getCurrency() { // <3> getter
		return currency;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Money money = (Money) o;
		return amount.equals(money.amount) &&
			currency.equals(money.currency);
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, currency);
	}

	@Override
	public String toString() {
		return amount.toString() + " " + currency.getCurrencyCode();
	}

	public Money add(Money that) { // <4> add calculator
		if (!this.currency.equals(that.currency)) {
			throw new IllegalArgumentException(
				"cannot add Money values of different currencies");
		}

		return new Money(this.amount.add(that.amount), this.currency);
	}
}
