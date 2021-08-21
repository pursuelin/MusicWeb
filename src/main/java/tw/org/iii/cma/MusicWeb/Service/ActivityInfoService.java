package tw.org.iii.cma.MusicWeb.Service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.org.iii.cma.MusicWeb.dao.ActivityInfoDAO;
import tw.org.iii.cma.MusicWeb.domain.ActivityInfoBean;

@Service
@Transactional
public class ActivityInfoService {
	@Autowired
	private ActivityInfoDAO activityInfoDao;
	
	@Transactional(readOnly = true)
	public List<ActivityInfoBean> select(ActivityInfoBean activityInfoBean) {
		List<ActivityInfoBean> result = null;
		if(activityInfoBean!=null && activityInfoBean.getActivityid()!=null && !activityInfoBean.getActivityid().equals(0)) {
			ActivityInfoBean temp = activityInfoDao.select(activityInfoBean.getActivityid());
			if(temp!=null) {
				result = new ArrayList<ActivityInfoBean>();
				result.add(temp);
			}
		} else {
			result = activityInfoDao.select(); 
		}
		return result;
	}
	public ActivityInfoBean insert(ActivityInfoBean activityInfoBean) {
		ActivityInfoBean result = null;
		if(activityInfoBean!=null && activityInfoBean.getActivityid()!=null) {
			result = activityInfoDao.insert(activityInfoBean);
		}
		return result;
	}
	public ActivityInfoBean update(ActivityInfoBean activityInfoBean) {
		ActivityInfoBean result = null;
		if(activityInfoBean!=null && activityInfoBean.getActivityid()!=null) {
			result = activityInfoDao.update(activityInfoBean.getActivityid(),activityInfoBean.getTagid(),
					activityInfoBean.getBandpost(), activityInfoBean.getHost(), activityInfoBean.getPlayer()
				,activityInfoBean.getTheme(),activityInfoBean.getSubtitle(),activityInfoBean.getActivityintro()
				,activityInfoBean.getBandIntro(),activityInfoBean.getLocationId(),activityInfoBean.getTape(),activityInfoBean.getUploadTime()
				,activityInfoBean.getPurchaseWeb(),activityInfoBean.getMemberId());
		}
		return result;
	}
	public boolean delete(ActivityInfoBean activityInfoBean) {
		boolean result = false;
		if(activityInfoBean!=null && activityInfoBean.getActivityid()!=null) {
			result = activityInfoDao.delete(activityInfoBean.getActivityid());
		}
		return result;
	}
}


