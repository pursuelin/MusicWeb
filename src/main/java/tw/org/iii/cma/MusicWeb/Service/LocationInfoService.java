package tw.org.iii.cma.MusicWeb.Service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.org.iii.cma.MusicWeb.dao.LocationInfoDAO;
import tw.org.iii.cma.MusicWeb.domain.LocationInfoBean;

	@Service
	@Transactional
	public class LocationInfoService {
		@Autowired
		private LocationInfoDAO locationInfoDao;
		
		@Transactional(readOnly = true)
		public List<LocationInfoBean> select(LocationInfoBean locationInfoBean) {
			List<LocationInfoBean> result = null;
			if(locationInfoBean!=null && locationInfoBean.getLocationid()!=null && !locationInfoBean.getLocationid().equals(0)) {
				LocationInfoBean temp = locationInfoDao.select(locationInfoBean.getLocationid());
				if(temp!=null) {
					result = new ArrayList<LocationInfoBean>();
					result.add(temp);
				}
			} else {
				result = locationInfoDao.select(); 
			}
			return result;
		}
		public LocationInfoBean insert(LocationInfoBean locationInfoBean) {
			LocationInfoBean result = null;
			if(locationInfoBean!=null && locationInfoBean.getLocationid()!=null) {
				result = locationInfoDao.insert(locationInfoBean);
			}
			return result;
		}
		public LocationInfoBean update(LocationInfoBean locationInfoBean) {
			LocationInfoBean result = null;
			if(locationInfoBean!=null && locationInfoBean.getLocationid()!=null) {
				result = locationInfoDao.update(locationInfoBean.getLocationid(),
						locationInfoBean.getShowaddr(), locationInfoBean.getShowplace());
			}
			return result;
		}
		public boolean delete(LocationInfoBean locationInfoBean) {
			boolean result = false;
			if(locationInfoBean!=null && locationInfoBean.getLocationid()!=null) {
				result = locationInfoDao.delete(locationInfoBean.getLocationid());
			}
			return result;
		}
	}



