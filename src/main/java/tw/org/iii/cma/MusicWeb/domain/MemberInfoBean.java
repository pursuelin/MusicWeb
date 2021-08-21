package tw.org.iii.cma.MusicWeb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "memberinfo")
public class MemberInfoBean {
	@Id
	@Column(name = "MEMBERID")
	private Integer memberid;
	
	@Column(name = "ACCOUNT")
	private String account;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PASSWD")
	private String passwd;
	
	@Column(name = "NAME")
	private String name;

	@Override
	public String toString() {
		return "model.MemberInfoBean [" + memberid + "," + account + "," + email + "," + passwd + "," + name + "]";
	}

	public Integer getMemberid() {
		return memberid;
	}

	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
