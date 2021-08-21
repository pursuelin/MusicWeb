package tw.org.iii.cma.MusicWeb.dao;

import java.util.List;

import tw.org.iii.cma.MusicWeb.domain.MemberInfoBean;


public interface MemberInfoDAO {
	
	public abstract MemberInfoBean select(Integer memberid);

	public abstract List<MemberInfoBean> select();

	public abstract MemberInfoBean insert(MemberInfoBean memberInfoBean);

	public abstract MemberInfoBean update(String account,  String email,
			String passwd,  String name, Integer memberid);

	public abstract boolean delete(Integer memberid);
	
}