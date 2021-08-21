package tw.org.iii.cma.MusicWeb.dao;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import tw.org.iii.cma.MusicWeb.domain.ActivityInfoBean;

@Repository
public class ActivityInfoDAOHibernate implements ActivityInfoDAO {
	@PersistenceContext
	private Session session;
	public Session getSession() {
		return session;
	}
	@Override
	public ActivityInfoBean select(Integer memberid) {
		if (memberid != null) {
			return this.getSession().get(ActivityInfoBean.class, memberid);
		}
		return null;
	}
	@Override
	public List<ActivityInfoBean> select() {
		return this.getSession().createQuery(
				"from ActivityInfoBean", ActivityInfoBean.class).list();
		}
	@Override
	public ActivityInfoBean insert(ActivityInfoBean activityInfoBean) {
		if(activityInfoBean!=null && activityInfoBean.getActivityid()!=null) {
			ActivityInfoBean temp =
					this.getSession().get(ActivityInfoBean.class, activityInfoBean.getActivityid());
			if(temp==null) {
				this.getSession().save(activityInfoBean);
				return activityInfoBean;
			}
		}
		return null;
	}
	@Override
	public ActivityInfoBean update(Integer activityid, Integer tagid, String bandpost, String host,
			String player, String theme, String subtitle, String activityintro, String bandIntro, Integer locationId,
			String tape, java.util.Date uploadTime, String purchaseWeb, Integer memberId) {
		if(activityid!=null) {
			ActivityInfoBean bean = this.getSession().get(ActivityInfoBean.class, activityid);
			if(bean!=null) {
				bean.setActivityid(activityid);
				bean.setTagid(tagid);
				bean.setBandpost(bandpost);
				bean.setHost(host);
				bean.setPlayer(player);
				bean.setTheme(theme);
				bean.setSubtitle(subtitle);
				bean.setActivityintro(activityintro);
				bean.setBandIntro(bandIntro);
				bean.setLocationId(locationId);
				bean.setTape(tape);
				bean.setUploadTime(uploadTime);
				bean.setPurchaseWeb(purchaseWeb);
				bean.setMemberId(memberId);
				return bean;
			}
		}
		return null;
	}
	@Override
	public boolean delete(Integer activityid) {
		if(activityid!=null) {
			ActivityInfoBean activityInfoBean = this.getSession().get(ActivityInfoBean.class, activityid);
			if(activityInfoBean!=null) {
				this.getSession().delete(activityInfoBean);
				return true;
			}
		}
		return false;
	}
}