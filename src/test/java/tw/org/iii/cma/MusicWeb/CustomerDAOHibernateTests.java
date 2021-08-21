package tw.org.iii.cma.MusicWeb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tw.org.iii.cma.MusicWeb.dao.LocationInfoDAO;
import tw.org.iii.cma.MusicWeb.domain.LocationInfoBean;
@SpringBootTest
public class CustomerDAOHibernateTests {
	
	
	@Autowired
	private LocationInfoDAO customerDao;

	@Test
	public void testSelect() {
		LocationInfoBean carol = customerDao.select(1);
		System.out.println("carol="+carol);
	}

	}

