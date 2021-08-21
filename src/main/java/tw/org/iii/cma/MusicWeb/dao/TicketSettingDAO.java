package tw.org.iii.cma.MusicWeb.dao;

import java.util.List;

import tw.org.iii.cma.MusicWeb.domain.TicketSettingBean;

public interface TicketSettingDAO {

	public abstract TicketSettingBean select(Integer id);

	public abstract List<TicketSettingBean> select();

	public abstract TicketSettingBean insert(TicketSettingBean ticketSettingBean);

	public abstract TicketSettingBean update(Integer id, String ticketKind,
			Float cost, String storage, java.util.Date soldDeadline, Integer activityId);

	public abstract boolean delete(Integer id);

}