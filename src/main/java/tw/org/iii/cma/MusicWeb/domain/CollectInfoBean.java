package tw.org.iii.cma.MusicWeb.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "collectinfo")
public class CollectInfoBean {

		@Id
		@Column(name = "id")
		private Integer id;
		@Column(name = "memberid")
		private Integer memberid;
		@Column(name = "likeamt")
		private Integer likeamt;
		@Column(name = "activityid")
		private Integer activityid;
		@Override
		public String toString() {
			return "model.CollectInfoBean [" + id + "," + memberid + "," + likeamt + "," + activityid + "]";
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getMemberid() {
			return memberid;
		}
		public void setMemberid(Integer memberid) {
			this.memberid = memberid;
		}
		public Integer getLikeamt() {
			return likeamt;
		}
		public void setLikeamt(Integer likeamt) {
			this.likeamt = likeamt;
		}
		public Integer getActivityid() {
			return activityid;
		}
		public void setActivityid(Integer activityid) {
			this.activityid = activityid;
		}
		
}
