package tw.org.iii.cma.MusicWeb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "taginfo")
public class TagInfoBean {
	@Id
	@Column(name = "TAGID")
	private Integer tagid;

	@Column(name = "TAGNAME")
	private String tagname;

	@Override
	public String toString() {
		return "model.TagInfoBean [" + tagid + "," + tagname + "]";
	}

	public Integer getTagid() {
		return tagid;

	}

	public void setTagid(Integer tagid) {
		this.tagid = tagid;
	}

	public String getTagname() {
		return tagname;
	}

	public void setTagname(String tagname) {
		this.tagname = tagname;
	}

}
