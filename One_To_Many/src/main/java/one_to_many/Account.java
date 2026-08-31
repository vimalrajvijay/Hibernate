package one_to_many;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private long ac_no;
	private String accountHolderName;
	public Account() {
		
	}
	public Account(long ac_no, String accountHolderName) {
		this.ac_no = ac_no;
		this.accountHolderName = accountHolderName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getAc_no() {
		return ac_no;
	}
	public void setAc_no(long ac_no) {
		this.ac_no = ac_no;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", ac_no=" + ac_no + ", accountHolderName=" + accountHolderName + "]";
	}
}
