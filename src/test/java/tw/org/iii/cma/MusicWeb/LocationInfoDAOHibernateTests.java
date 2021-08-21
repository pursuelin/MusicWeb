package tw.org.iii.cma.MusicWeb;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.org.iii.cma.MusicWeb.dao.CollectInfoDAO;
import tw.org.iii.cma.MusicWeb.dao.LocationInfoDAO;
import tw.org.iii.cma.MusicWeb.domain.CollectInfoBean;
import tw.org.iii.cma.MusicWeb.domain.LocationInfoBean;
@SpringBootTest
public class LocationInfoDAOHibernateTests {
	
	
	@Autowired
	private LocationInfoDAO LocationInfoDao;

	@Test
	public void testSelect() {
		LocationInfoBean carol = LocationInfoDao.select(2);
		System.out.println("carol="+carol);
	}

	
}
