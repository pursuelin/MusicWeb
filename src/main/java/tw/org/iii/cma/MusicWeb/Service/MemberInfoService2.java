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
public class MemberInfoService2 {
	@Autowired
	private TicketSettingDAO ticketSettingDao;
	
	@Transactional(readOnly = true)
	public List<TicketSettingBean> select(TicketSettingBean ticketSettingBean) {
		List<TicketSettingBean> result = null;
		if(ticketSettingBean!=null && ticketSettingBean.getId()!=null && !ticketSettingBean.getId().equals(0)) {
			TicketSettingBean temp = ticketSettingDao.select(ticketSettingBean.getId());
			if(temp!=null) {
				result = new ArrayList<TicketSettingBean>();
				result.add(temp);
			}
		} else {
			result = ticketSettingDao.select(); 
		}
		return result;
	}
	public TicketSettingBean insert(TicketSettingBean ticketSettingBean) {
		TicketSettingBean result = null;
		if(ticketSettingBean!=null && ticketSettingBean.getId()!=null) {
			result = ticketSettingDao.insert(ticketSettingBean);
		}
		return result;
	}
	public TicketSettingBean update(TicketSettingBean ticketSettingBean) {
		TicketSettingBean result = null;
		if(ticketSettingBean!=null && ticketSettingBean.getId()!=null) {
			result = ticketSettingDao.update(ticketSettingBean.getId(), ticketSettingBean.getTicketKind(),
					ticketSettingBean.getCost(), ticketSettingBean.getStorage(), ticketSettingBean.getSoldDeadline(),
					ticketSettingBean.getActivityId());
			}
		
		return result;
	}
	public boolean delete(TicketSettingBean ticketSettingBean) {
		boolean result = false;
		if(ticketSettingBean!=null && ticketSettingBean.getId()!=null) {
			result = ticketSettingDao.delete(ticketSettingBean.getId());
		}
		return result;
	}
}


