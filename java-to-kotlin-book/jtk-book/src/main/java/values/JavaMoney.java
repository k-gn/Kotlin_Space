package values;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

public class JavaMoney {

	private final BigDecimal amount;
	private final Currency currency;

	private JavaMoney(BigDecimal amount, Currency currency) { // <1> private constructor
		this.amount = amount;
		this.currency = currency;
	}

	public static JavaMoney of(BigDecimal amount, Currency currency) { // <1> 정적 팩터리 메서드
		return new JavaMoney(
			/*
				BigDecimal 의 setScale 함수는 setter 이름이지만 실제론 상태를 변경하지 않아 혼란을 야기할 수 있다.
				따라서 withScale 같은 이름의 확장함수를 추가해 바로잡을 수 있다.
			 */
			amount.setScale(currency.getDefaultFractionDigits()),
			currency);
	}


	public static JavaMoney of(String amountStr, Currency currency) { // <2> 정적 팩터리 메서드
		return JavaMoney.of(new BigDecimal(amountStr), currency);
	}

	public static JavaMoney of(int amount, Currency currency) {
		return JavaMoney.of(new BigDecimal(amount), currency);
	}

	public static JavaMoney zero(Currency userCurrency) {
		return JavaMoney.of(BigDecimal.ZERO, userCurrency);
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
		JavaMoney money = (JavaMoney) o;
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

	public JavaMoney add(JavaMoney that) { // <4> add calculator
		if (!this.currency.equals(that.currency)) {
			throw new IllegalArgumentException(
				"cannot add Money values of different currencies");
		}

		return new JavaMoney(this.amount.add(that.amount), this.currency);
	}
}
