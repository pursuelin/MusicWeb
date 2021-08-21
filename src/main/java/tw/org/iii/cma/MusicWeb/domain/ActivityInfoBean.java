package tw.org.iii.cma.MusicWeb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACTIVITYINFO")
public class ActivityInfoBean {
	@Id
	@Column(name = "activityid")
	private Integer activityid;

	@Column(name = "tagid")
	private Integer tagid;

	@Column(name = "bandpost", columnDefinition = "text")
	private String bandpost;

	@Column(name = "host")
	private String host;

	@Column(name = "player")
	private String player;

	@Column(name = "theme")
	private String theme;

	@Column(name = "subtitle")
	private String subtitle;

	@Column(name = "activityintro", columnDefinition = "text")
	private String activityintro;

	@Column(name = "bandintro", columnDefinition = "text")
	private String bandIntro;

	@Column(name = "locationid")
	private Integer locationId;

	@Column(name = "tape", columnDefinition = "text")
	private String tape;

	@Column(name = "uploadtime")
	private java.util.Date uploadTime;

	@Column(name = "purchaseweb")
	private String purchaseWeb;

	@Column(name = "memberid")
	private Integer memberId;

	@Override
	public String toString() {
		return "model.ActivityInfoBean [" + activityid + "," + tagid + "," + bandpost + "," + host + "," + player + ","
				+ theme + "," + subtitle + "," + activityintro + "," + bandIntro + "," + locationId + "," + tape + ","
				+ uploadTime + "," + purchaseWeb + "," + memberId + "]";
	}

	public Integer getActivityid() {
		return activityid;
	}

	public void setActivityid(Integer activityid) {
		this.activityid = activityid;
	}

	public Integer getTagid() {
		return tagid;
	}

	public void setTagid(Integer tagid) {
		this.tagid = tagid;
	}

	public String getBandpost() {
		return bandpost;
	}

	public void setBandpost(String bandpost) {
		this.bandpost = bandpost;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getActivityintro() {
		return activityintro;
	}

	public void setActivityintro(String activityintro) {
		this.activityintro = activityintro;
	}

	public String getBandIntro() {
		return bandIntro;
	}

	public void setBandIntro(String bandIntro) {
		this.bandIntro = bandIntro;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getTape() {
		return tape;
	}

	public void setTape(String tape) {
		this.tape = tape;
	}

	public java.util.Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(java.util.Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getPurchaseWeb() {
		return purchaseWeb;
	}

	public void setPurchaseWeb(String purchaseWeb) {
		this.purchaseWeb = purchaseWeb;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

}
