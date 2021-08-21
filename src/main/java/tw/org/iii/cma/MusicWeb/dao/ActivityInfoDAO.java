package tw.org.iii.cma.MusicWeb.dao;

import java.util.Date;
import java.util.List;
import tw.org.iii.cma.MusicWeb.domain.ActivityInfoBean;

public interface ActivityInfoDAO {

	public abstract ActivityInfoBean select(Integer activityid);

	public abstract List<ActivityInfoBean> select();

	public abstract ActivityInfoBean insert(ActivityInfoBean activityInfoBean);

	public abstract ActivityInfoBean update(Integer activityid, Integer tagid, String bandpost, String host,
			String player, String theme, String subtitle, String activityintro, String bandIntro, Integer locationId,
			String tape, java.util.Date uploadTime, String purchaseWeb, Integer memberId);

	public abstract boolean delete(Integer activityid);



}
