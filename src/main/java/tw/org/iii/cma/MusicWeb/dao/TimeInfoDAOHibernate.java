package tw.org.iii.cma.MusicWeb.dao;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import tw.org.iii.cma.MusicWeb.domain.TimeInfoBean;

@Repository
public class TimeInfoDAOHibernate implements TimeInfoDAO {
	@PersistenceContext
	private Session session;
	public Session getSession() {
		return session;
	}
	@Override
	public TimeInfoBean select(Integer id) {
		if (id != null) {
			return this.getSession().get(TimeInfoBean.class, id);
		}
		return null;
	}
	@Override
	public List<TimeInfoBean> select() {
		return this.getSession().createQuery(
				"from TimeInfoBean", TimeInfoBean.class).list();
		}
	@Override
	public TimeInfoBean insert(TimeInfoBean timeInfoBean) {
		if(timeInfoBean!=null && timeInfoBean.getId()!=null) {
			TimeInfoBean temp =
					this.getSession().get(TimeInfoBean.class, timeInfoBean.getId());
			if(temp==null) {
				this.getSession().save(timeInfoBean);
				return timeInfoBean;
			}
		}
		return null;
	}
	@Override
	public TimeInfoBean update(Integer id, java.util.Date showdate, java.sql.Time entertime,
			java.sql.Time showtime, Integer showtotaltime, Integer activityid) {
		if(id!=null) {
			TimeInfoBean bean = this.getSession().get(TimeInfoBean.class, id);
			if(bean!=null) {
				bean.setId(id);
				bean.setShowdate(showdate);
				bean.setEntertime(entertime);
				bean.setShowtime(showtime);
				bean.setShowtotaltime(showtotaltime);
				bean.setActivityid(activityid);
				return bean;
			}
		}
		return null;
	}
	@Override
	public boolean delete(Integer id) {
		if(id!=null) {
			TimeInfoBean TimeInfoBean = this.getSession().get(TimeInfoBean.class, id);
			if(TimeInfoBean!=null) {
				this.getSession().delete(TimeInfoBean);
				return true;
			}
		}
		return false;
	}
}