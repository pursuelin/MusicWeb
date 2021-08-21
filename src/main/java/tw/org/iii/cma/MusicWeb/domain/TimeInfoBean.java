package tw.org.iii.cma.MusicWeb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIMEINFO")
public class TimeInfoBean {
	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "showdate")
	private java.util.Date showdate;

	@Column(name = "entertime")
	private java.sql.Time entertime;

	@Column(name = "showtime")
	private java.sql.Time showtime;

	@Column(name = "showtotaltime")
	private Integer showtotaltime;

	@Column(name = "activityid")
	private Integer activityid;

	@Override
	public String toString() {
		return "model.TagInfoBean [" + id + "," + showdate + "," + entertime + "," + showtime + "," + showtotaltime
				+ "," + activityid + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public java.util.Date getShowdate() {
		return showdate;
	}

	public void setShowdate(java.util.Date showdate) {
		this.showdate = showdate;
	}

	public java.sql.Time getEntertime() {
		return entertime;
	}

	public void setEntertime(java.sql.Time entertime) {
		this.entertime = entertime;
	}

	public java.sql.Time getShowtime() {
		return showtime;
	}

	public void setShowtime(java.sql.Time showtime) {
		this.showtime = showtime;
	}

	public Integer getShowtotaltime() {
		return showtotaltime;
	}

	public void setShowtotaltime(Integer showtotaltime) {
		this.showtotaltime = showtotaltime;
	}

	public Integer getActivityid() {
		return activityid;
	}

	public void setActivityid(Integer activityid) {
		this.activityid = activityid;
	}

}
