package tw.org.iii.cma.MusicWeb.dao;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import tw.org.iii.cma.MusicWeb.domain.CollectInfoBean;

@Repository
public class CollectInfoDAOHibernate implements CollectInfoDAO {
	@PersistenceContext
	private Session session;
	public Session getSession() {
		return session;
	}
	@Override
	public CollectInfoBean select(Integer id) {
		if (id != null) {
			return this.getSession().get(CollectInfoBean.class, id);
		}
		return null;
	}
	@Override
	public List<CollectInfoBean> select() {
		return this.getSession().createQuery(
				"from CollectInfoBean", CollectInfoBean.class).list();
		}
	@Override
	public CollectInfoBean insert(CollectInfoBean collectInfoBean) {
		if(collectInfoBean!=null && collectInfoBean.getMemberid()!=null) {
			CollectInfoBean temp =
					this.getSession().get(CollectInfoBean.class, collectInfoBean.getMemberid());
			if(temp==null) {
				this.getSession().save(collectInfoBean);
				return collectInfoBean;
			}
		}
		return null;
	}
	@Override
	public CollectInfoBean update(Integer id,  Integer memberid,
			Integer likeamt,  Integer activityid) {
		if(memberid!=null) {
			CollectInfoBean bean = this.getSession().get(CollectInfoBean.class, memberid);
			if(bean!=null) {
				bean.setId(id);
				bean.setMemberid(memberid);
				bean.setLikeamt(likeamt);
				bean.setActivityid(activityid);
				return bean;
			}
		}
		return null;
	}
	@Override
	public boolean delete(Integer id) {
		if(id!=null) {
			CollectInfoBean collectInfoBean = this.getSession().get(CollectInfoBean.class, id);
			if(collectInfoBean!=null) {
				this.getSession().delete(collectInfoBean);
				return true;
			}
		}
		return false;
	}
}