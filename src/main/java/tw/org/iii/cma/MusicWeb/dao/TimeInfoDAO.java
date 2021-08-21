package tw.org.iii.cma.MusicWeb.dao;

import java.util.List;

import tw.org.iii.cma.MusicWeb.domain.TimeInfoBean;

public interface TimeInfoDAO {

	public abstract TimeInfoBean select(Integer id);

	public abstract List<TimeInfoBean> select();

	public abstract TimeInfoBean insert(TimeInfoBean timeInfoBean);

	public abstract TimeInfoBean update(Integer id, java.util.Date showdate, java.sql.Time entertime,
			java.sql.Time showtime, Integer showtotaltime, Integer activityid);

	public abstract boolean delete(Integer id);

}