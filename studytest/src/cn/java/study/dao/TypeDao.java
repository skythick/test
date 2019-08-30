package cn.java.study.dao;

import java.util.List;

import cn.java.study.domain.Type;

public interface TypeDao {
	public List<Type> findAllType();
	
	public Type findById(int i);

	public List<Type> findByParentId(int parentid);

}
