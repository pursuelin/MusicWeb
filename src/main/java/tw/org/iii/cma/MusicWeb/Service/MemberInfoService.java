package tw.org.iii.cma.MusicWeb.Service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.org.iii.cma.MusicWeb.dao.MemberInfoDAO;
import tw.org.iii.cma.MusicWeb.domain.MemberInfoBean;

@Service
@Transactional
public class MemberInfoService {
	@Autowired
	private MemberInfoDAO memberInfoDao;
	
	@Transactional(readOnly = true)
	public List<MemberInfoBean> select(MemberInfoBean memberInfoBean) {
		List<MemberInfoBean> result = null;
		if(memberInfoBean!=null && memberInfoBean.getMemberid()!=null && !memberInfoBean.getMemberid().equals(0)) {
			MemberInfoBean temp = memberInfoDao.select(memberInfoBean.getMemberid());
			if(temp!=null) {
				result = new ArrayList<MemberInfoBean>();
				result.add(temp);
			}
		} else {
			result = memberInfoDao.select(); 
		}
		return result;
	}
	public MemberInfoBean insert(MemberInfoBean memberInfoBean) {
		MemberInfoBean result = null;
		if(memberInfoBean!=null && memberInfoBean.getMemberid()!=null) {
			result = memberInfoDao.insert(memberInfoBean);
		}
		return result;
	}
	public MemberInfoBean update(MemberInfoBean memberInfoBean) {
		MemberInfoBean result = null;
		if(memberInfoBean!=null && memberInfoBean.getMemberid()!=null) {
			result = memberInfoDao.update(memberInfoBean.getAccount(), memberInfoBean.getEmail(),
					memberInfoBean.getPasswd(), memberInfoBean.getName(), memberInfoBean.getMemberid());
		}
		return result;
	}
	public boolean delete(MemberInfoBean memberInfoBean) {
		boolean result = false;
		if(memberInfoBean!=null && memberInfoBean.getMemberid()!=null) {
			result = memberInfoDao.delete(memberInfoBean.getMemberid());
		}
		return result;
	}
}


