package tw.org.iii.cma.MusicWeb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ticketsetting")
public class TicketSettingBean {
	@Id
	@Column(name = "id", columnDefinition = "int")
	private Integer id;
	@Column(name = "ticketkind")
	private String ticketKind;
	@Column(name = "cost")
	private Float cost;
	@Column(name = "storage", columnDefinition = "smallint")
	private String storage;
	@Column(name = "solddeadline", columnDefinition = "smallint")
	private java.util.Date soldDeadline;
	@Column(name = "activityid", columnDefinition = "int")
	private Integer activityId;

	@Override
	public String toString() {
		return "model.TicketSettingBean [" + id + "," + ticketKind + "," + cost + "," + storage + "," + soldDeadline + ","
				+ activityId + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTicketKind() {
		return ticketKind;
	}

	public void setTicketKind(String ticketKind) {
		this.ticketKind = ticketKind;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public java.util.Date getSoldDeadline() {
		return soldDeadline;
	}

	public void setSoldDeadline(java.util.Date soldDeadline) {
		this.soldDeadline = soldDeadline;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

}
