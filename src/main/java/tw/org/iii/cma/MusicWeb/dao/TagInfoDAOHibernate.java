package tw.org.iii.cma.MusicWeb.dao;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import tw.org.iii.cma.MusicWeb.domain.TagInfoBean;

@Repository
public class TagInfoDAOHibernate implements TagInfoDAO {
	@PersistenceContext

	private Session session;

	public Session getSession() {
		return session;
	}
	@Override
	public TagInfoBean select(Integer tagid) {
		if(tagid!=null) {
			return this.getSession().get(TagInfoBean.class, tagid);
		}
		return null;
	}
	@Override
	public List<TagInfoBean> select() {
		return this.getSession().createQuery(
				"from TagInfoBean", TagInfoBean.class).list();
	}
	@Override
	public TagInfoBean insert(TagInfoBean bean) {
		if(bean!=null && bean.getTagid()!=null) {
			TagInfoBean temp =
					this.getSession().get(TagInfoBean.class, bean.getTagid());
			if(temp==null) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}
	@Override
	public TagInfoBean update(Integer tagid,  String tagname) {
		if(tagid!=null) {
			TagInfoBean bean = this.getSession().get(TagInfoBean.class, tagid);
			if(bean!=null) {
				bean.setTagid(tagid);
				bean.setTagname(tagname);

				return bean;
			}
		}
		return null;
	}
	@Override
	public boolean delete(Integer tagid) {
		if(tagid!=null) {
			TagInfoBean bean = this.getSession().get(TagInfoBean.class, tagid);
			if(bean!=null) {
				this.getSession().delete(bean);
				return true;
			}
		}
		return false;
	}
}
