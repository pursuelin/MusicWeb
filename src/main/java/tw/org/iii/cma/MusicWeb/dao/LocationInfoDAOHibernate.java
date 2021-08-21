package tw.org.iii.cma.MusicWeb.dao;
import java.util.List;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import tw.org.iii.cma.MusicWeb.domain.LocationInfoBean;

@Repository
public class LocationInfoDAOHibernate implements LocationInfoDAO {
	@PersistenceContext
	private Session session;
	public Session getSession() {
		return session;
		}	
	@Override
	public LocationInfoBean select(Integer locationid) {
		if(locationid!=null) {
			return this.getSession().get(LocationInfoBean.class, locationid);
		}
		return null;
	}
	@Override
	public List<LocationInfoBean> select() {
		return this.getSession().createQuery(
				"from LocationInfoBean", LocationInfoBean.class).list();
	}
	@Override
	public LocationInfoBean insert(LocationInfoBean locactioninfobean) {
		if(locactioninfobean!=null && locactioninfobean.getLocationid()!=null) {
			LocationInfoBean temp =
					this.getSession().get(LocationInfoBean.class, locactioninfobean.getLocationid());
			if(temp==null) {
				this.getSession().save(locactioninfobean);
				return locactioninfobean;
			}
		}
		return null;
	}
	@Override
	public LocationInfoBean update(Integer locationid,String showaddr, String showplace) {
		if(locationid!=null) {
			LocationInfoBean bean = this.getSession().get(LocationInfoBean.class, locationid);
			if(bean!=null) {
				bean.setShowAddr(showaddr);
				bean.setShowplace(showplace);
				return bean;
			}
		}
		return null;
	}
	@Override
	public boolean delete(Integer locationid) {
		if(locationid!=null) {
			LocationInfoBean bean = this.getSession().get(LocationInfoBean.class, locationid);
			if(bean!=null) {
				this.getSession().delete(bean);
				return true;
			}
		}
		return false;
	}
}
