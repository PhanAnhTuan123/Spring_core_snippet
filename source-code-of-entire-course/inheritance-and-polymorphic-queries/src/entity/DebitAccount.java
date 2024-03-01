package entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="debit_account")
public class DebitAccount extends Account {
	
	@Column(name="overdraft_fee")
	private BigDecimal overdraftFee;
	
	public void setOverdraftFee(BigDecimal overdraftFee) {
		this.overdraftFee = overdraftFee;
	}
}
