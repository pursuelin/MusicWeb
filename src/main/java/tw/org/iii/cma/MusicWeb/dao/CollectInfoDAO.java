package tw.org.iii.cma.MusicWeb.dao;

import java.util.List;

import tw.org.iii.cma.MusicWeb.domain.CollectInfoBean;

public interface CollectInfoDAO {
	public abstract CollectInfoBean select(Integer id);

	public abstract List<CollectInfoBean> select();

	public abstract CollectInfoBean insert(CollectInfoBean collectInfoBean);

	public abstract CollectInfoBean update(Integer id,  Integer memberid,
			Integer likeamt,  Integer activityid);

	public abstract boolean delete(Integer id);
	
}
