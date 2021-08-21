package tw.org.iii.cma.MusicWeb.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.org.iii.cma.MusicWeb.dao.TimeInfoDAO;
import tw.org.iii.cma.MusicWeb.domain.TimeInfoBean;

@Service
@Transactional
public class TimeInfoService {
	@Autowired
	private TimeInfoDAO timeInfoDao;

	@Transactional(readOnly = true)
	public List<TimeInfoBean> select(TimeInfoBean timeInfoBean) {
		List<TimeInfoBean> result = null;
		if (timeInfoBean != null && timeInfoBean.getId() != null && !timeInfoBean.getId().equals(0)) {
			TimeInfoBean temp = timeInfoDao.select(timeInfoBean.getId());
			if (temp != null) {
				result = new ArrayList<TimeInfoBean>();
				result.add(temp);
			}
		} else {
			result = timeInfoDao.select();
		}
		return result;
	}

	public TimeInfoBean insert(TimeInfoBean timeInfoBean) {
		TimeInfoBean result = null;
		if (timeInfoBean != null && timeInfoBean.getId() != null) {
			result = timeInfoDao.insert(timeInfoBean);
		}
		return result;
	}

	public TimeInfoBean update(TimeInfoBean timeInfoBean) {
		TimeInfoBean result = null;
		if (timeInfoBean != null && timeInfoBean.getId() != null) {
			result = timeInfoDao.update(timeInfoBean.getId(), timeInfoBean.getShowdate(), timeInfoBean.getEntertime(),
					timeInfoBean.getShowtime(), timeInfoBean.getShowtotaltime(), timeInfoBean.getActivityid());
		}
		return result;
	}

	public boolean delete(TimeInfoBean timeInfoBean) {
		boolean result = false;
		if (timeInfoBean != null && timeInfoBean.getId() != null) {
			result = timeInfoDao.delete(timeInfoBean.getId());
		}
		return result;
	}
}
