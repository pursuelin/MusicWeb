package tw.org.iii.cma.MusicWeb.dao;

import java.util.List;

import tw.org.iii.cma.MusicWeb.domain.TagInfoBean;


public interface TagInfoDAO {
	
	public abstract TagInfoBean select(Integer tagid);

	public abstract List<TagInfoBean> select();

	public abstract TagInfoBean insert(TagInfoBean tagInfoBean);

	public abstract TagInfoBean update(Integer tagid,  String tagname);

	public abstract boolean delete(Integer tagid);
	
}