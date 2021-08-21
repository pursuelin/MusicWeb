package tw.org.iii.cma.MusicWeb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "locationinfo")
public class LocationInfoBean {
	@Id
	@Column(name = "locationid")
	private Integer locationid;
	
	@Column(name = "showaddr")
	private String showaddr;
	
	@Column(name = "showplace")
	private String showplace;

	@Override
	public String toString() {
		return "model.MemberInfoBean [" + locationid + "," + showaddr + "," + showplace + "]";
	}

	public Integer getLocationid() {
		return locationid;
	}

	public void setLocationid(Integer locationid) {
		this.locationid = locationid;
	}

	public String getShowaddr() {
		return showaddr;
	}

	public void setShowAddr(String showaddr) {
		this.showaddr = showaddr;
	}

	public String getShowplace() {
		return showplace;
	}

	public void setShowplace(String showplace) {
		this.showplace = showplace;
	}


}
