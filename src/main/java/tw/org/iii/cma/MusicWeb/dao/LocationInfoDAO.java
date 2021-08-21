package tw.org.iii.cma.MusicWeb.dao;
import java.util.List;

import tw.org.iii.cma.MusicWeb.domain.LocationInfoBean;

public interface LocationInfoDAO {
	public abstract LocationInfoBean select(Integer locationid);

	public abstract List<LocationInfoBean> select();

	public abstract LocationInfoBean insert(LocationInfoBean locactioninfobean);

	public abstract LocationInfoBean update(Integer locationid,String showaddr, String showplace);

	public abstract boolean delete(Integer locationid);


}
