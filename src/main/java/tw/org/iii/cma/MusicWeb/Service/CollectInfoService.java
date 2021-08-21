package tw.org.iii.cma.MusicWeb.Service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.org.iii.cma.MusicWeb.dao.CollectInfoDAO;
import tw.org.iii.cma.MusicWeb.domain.CollectInfoBean;

@Service
@Transactional
public class CollectInfoService {
	@Autowired
	private CollectInfoDAO collectInfoDao;
	
	@Transactional(readOnly = true)
	public List<CollectInfoBean> select(CollectInfoBean CollectInfoBean) {
		List<CollectInfoBean> result = null;
		if(CollectInfoBean!=null && CollectInfoBean.getId()!=null && !CollectInfoBean.getId().equals(0)) {
			CollectInfoBean temp = collectInfoDao.select(CollectInfoBean.getId());
			if(temp!=null) {
				result = new ArrayList<CollectInfoBean>();
				result.add(temp);
			}
		} else {
			result = collectInfoDao.select(); 
		}
		return result;
	}
	public CollectInfoBean insert(CollectInfoBean CollectInfoBean) {
		CollectInfoBean result = null;
		if(CollectInfoBean!=null && CollectInfoBean.getId()!=null) {
			result = collectInfoDao.insert(CollectInfoBean);
		}
		return result;
	}
	public CollectInfoBean update(CollectInfoBean CollectInfoBean) {
		CollectInfoBean result = null;
		if(CollectInfoBean!=null && CollectInfoBean.getId()!=null) {
			result = collectInfoDao.update(CollectInfoBean.getId(), CollectInfoBean.getMemberid(),
					CollectInfoBean.getLikeamt(), CollectInfoBean.getActivityid());
		}
		return result;
	}
	public boolean delete(CollectInfoBean CollectInfoBean) {
		boolean result = false;
		if(CollectInfoBean!=null && CollectInfoBean.getId()!=null) {
			result = collectInfoDao.delete(CollectInfoBean.getId());
		}
		return result;
	}
}


