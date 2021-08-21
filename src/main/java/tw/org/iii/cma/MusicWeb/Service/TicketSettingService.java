package tw.org.iii.cma.MusicWeb.Service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.org.iii.cma.MusicWeb.dao.TicketSettingDAO;
import tw.org.iii.cma.MusicWeb.domain.TicketSettingBean;

@Service
@Transactional
public class TicketSettingService {
	@Autowired
	private TicketSettingDAO ticketSettingDao;
	
	@Transactional(readOnly = true)
	public List<TicketSettingBean> select(TicketSettingBean ticketSettingbean) {
		List<TicketSettingBean> result = null;
		if(ticketSettingbean!=null && ticketSettingbean.getId()!=null && !ticketSettingbean.getId().equals(0)) {
			TicketSettingBean temp = ticketSettingDao.select(ticketSettingbean.getId());
			if(temp!=null) {
				result = new ArrayList<TicketSettingBean>();
				result.add(temp);
			}
		} else {
			result = ticketSettingDao.select(); 
		}
		return result;
	}
	public TicketSettingBean insert(TicketSettingBean ticketSettingbean) {
		TicketSettingBean result = null;
		if(ticketSettingbean!=null && ticketSettingbean.getId()!=null) {
			result = ticketSettingDao.insert(ticketSettingbean);
		}
		return result;
	}
	public TicketSettingBean update(TicketSettingBean ticketSettingbean) {
		TicketSettingBean result = null;
		if(ticketSettingbean!=null && ticketSettingbean.getId()!=null) {
			result = ticketSettingDao.update(ticketSettingbean.getId(), ticketSettingbean.getTicketKind(),
					ticketSettingbean.getCost(), ticketSettingbean.getStorage(), ticketSettingbean.getSoldDeadline(),ticketSettingbean.getActivityId());
		}
		return result;
	}
	public boolean delete(TicketSettingBean ticketSettingbean) {
		boolean result = false;
		if(ticketSettingbean!=null && ticketSettingbean.getId()!=null) {
			result = ticketSettingDao.delete(ticketSettingbean.getId());
		}
		return result;
	}
}
