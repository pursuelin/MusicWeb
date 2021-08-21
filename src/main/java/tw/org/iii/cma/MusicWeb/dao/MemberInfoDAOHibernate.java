package tw.org.iii.cma.MusicWeb.dao;
import java.util.List;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import tw.org.iii.cma.MusicWeb.domain.MemberInfoBean;

@Repository
public class MemberInfoDAOHibernate implements MemberInfoDAO {
	@PersistenceContext
	private Session session;
	public Session getSession() {
		return session;
	}
	@Override
	public MemberInfoBean select(Integer memberid) {
		if (memberid != null) {
			return this.getSession().get(MemberInfoBean.class, memberid);
		}
		return null;
	}
	@Override
	public List<MemberInfoBean> select() {
		return this.getSession().createQuery(
				"from MemberInfoBean", MemberInfoBean.class).list();
		}
	@Override
	public MemberInfoBean insert(MemberInfoBean memberInfoBean) {
		if(memberInfoBean!=null && memberInfoBean.getMemberid()!=null) {
			MemberInfoBean temp =
					this.getSession().get(MemberInfoBean.class, memberInfoBean.getMemberid());
			if(temp==null) {
				this.getSession().save(memberInfoBean);
				return memberInfoBean;
			}
		}
		return null;
	}
	@Override
	public MemberInfoBean update(String account,  String email,
			String passwd,  String name, Integer memberid) {
		if(memberid!=null) {
			MemberInfoBean bean = this.getSession().get(MemberInfoBean.class, memberid);
			if(bean!=null) {
				bean.setAccount(account);
				bean.setEmail(email);
				bean.setPasswd(passwd);
				bean.setName(name);
				return bean;
			}
		}
		return null;
	}
	@Override
	public boolean delete(Integer memberid) {
		if(memberid!=null) {
			MemberInfoBean memberInfoBean = this.getSession().get(MemberInfoBean.class, memberid);
			if(memberInfoBean!=null) {
				this.getSession().delete(memberInfoBean);
				return true;
			}
		}
		return false;
	}
}