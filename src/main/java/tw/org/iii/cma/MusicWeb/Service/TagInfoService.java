package tw.org.iii.cma.MusicWeb.Service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.org.iii.cma.MusicWeb.dao.TagInfoDAO;
import tw.org.iii.cma.MusicWeb.domain.TagInfoBean;

@Service
@Transactional
public class TagInfoService {
	@Autowired
	private TagInfoDAO tagInfoDao;
	
	@Transactional(readOnly = true)
	public List<TagInfoBean> select(TagInfoBean tagInfoBean) {
		List<TagInfoBean> result = null;
		if(tagInfoBean!=null && tagInfoBean.getTagid()!=null && !tagInfoBean.getTagid().equals(0)) {
			TagInfoBean temp = tagInfoDao.select(tagInfoBean.getTagid());
			if(temp!=null) {
				result = new ArrayList<TagInfoBean>();
				result.add(temp);
			}
		} else {
			result = tagInfoDao.select(); 
		}
		return result;
	}
	public TagInfoBean insert(TagInfoBean tagInfoBean) {
		TagInfoBean result = null;
		if(tagInfoBean!=null && tagInfoBean.getTagid()!=null) {
			result = tagInfoDao.insert(tagInfoBean);
		}
		return result;
	}
	public TagInfoBean update(TagInfoBean tagInfoBean) {
		TagInfoBean result = null;
		if(tagInfoBean!=null && tagInfoBean.getTagid()!=null) {
			result = tagInfoDao.update(tagInfoBean.getTagid(), tagInfoBean.getTagname());
		}
		return result;
	}
	public boolean delete(TagInfoBean tagInfoBean) {
		boolean result = false;
		if(tagInfoBean!=null && tagInfoBean.getTagid()!=null) {
			result = tagInfoDao.delete(tagInfoBean.getTagid());
		}
		return result;
	}
}


