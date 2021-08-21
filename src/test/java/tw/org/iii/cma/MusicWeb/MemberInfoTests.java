package tw.org.iii.cma.MusicWeb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tw.org.iii.cma.MusicWeb.dao.MemberInfoDAO;
import tw.org.iii.cma.MusicWeb.domain.MemberInfoBean;

@SpringBootTest
public class MemberInfoTests {

	@Autowired
	private MemberInfoDAO MemberInfoDao;

	@Test
	public void testSelect() {
		
		MemberInfoBean carol = MemberInfoDao.select(1);
		System.out.println("boy="+carol);
	}

}
