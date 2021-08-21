package tw.org.iii.cma.MusicWeb.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
	@Entity
	@Table(name = "taginfo")
public class TagInfoBean2 {
		@Id
		@Column(name = "tagid")
		private Integer tagid;

		@Column(name = "tagname")
		private String tagname;

		public Integer getTagid() {
			return tagid;
		}
		@Override
		public String toString() {
			return "model.TagInfoBean [" + tagid + "," + tagname + "]";
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
