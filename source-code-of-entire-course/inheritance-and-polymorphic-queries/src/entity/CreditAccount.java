package entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="credit_account")
public class CreditAccount extends Account {
	
	@Column(name="credit_limit")
	private BigDecimal creditLimit;
	
	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}
}
