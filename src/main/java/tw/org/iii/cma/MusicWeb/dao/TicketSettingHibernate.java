package tw.org.iii.cma.MusicWeb.dao;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import tw.org.iii.cma.MusicWeb.domain.TicketSettingBean;

@Repository
public class TicketSettingHibernate implements TicketSettingDAO {
	@PersistenceContext
	private Session session;
	public Session getSession() {
		return session;
	}
	@Override
	public TicketSettingBean select(Integer id) {
		if (id != null) {
			return this.getSession().get(TicketSettingBean.class, id);
		}
		return null;
	}
	@Override
	public List<TicketSettingBean> select() {
		return this.getSession().createQuery(
				"from TicketSettingBean", TicketSettingBean.class).list();
		}
	@Override
	public TicketSettingBean insert(TicketSettingBean ticketSettingBean) {
		if(ticketSettingBean!=null && ticketSettingBean.getId()!=null) {
			TicketSettingBean temp =
					this.getSession().get(TicketSettingBean.class, ticketSettingBean.getId());
			if(temp==null) {
				this.getSession().save(ticketSettingBean);
				return ticketSettingBean;
			}
		}
		return null;
	}
	@Override
	public TicketSettingBean update(Integer id, String ticketKind,
			Float cost, String storage, java.util.Date soldDeadline, Integer activityId) {
		if(id!=null) {
			TicketSettingBean bean = this.getSession().get(TicketSettingBean.class, id);
			if(bean!=null) {
				bean.setId(id);
				bean.setTicketKind(ticketKind);
				bean.setCost(cost);
				bean.setStorage(storage);
				bean.setSoldDeadline(soldDeadline);
				bean.setActivityId(activityId);
				return bean;
			}
		}
		return null;
	}
	@Override
	public boolean delete(Integer id) {
		if(id!=null) {
			TicketSettingBean TicketSettingBean = this.getSession().get(TicketSettingBean.class, id);
			if(TicketSettingBean!=null) {
				this.getSession().delete(TicketSettingBean);
				return true;
			}
		}
		return false;
	}
}