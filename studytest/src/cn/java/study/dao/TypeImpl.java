package cn.java.study.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.java.study.domain.Type;

public class TypeImpl implements TypeDao {
	private QueryRunner qr = new TxQueryRunner();

	public List<Type> findAllType() {
		try {
			String sql = "select * from videotype";
			return qr.query(sql, new BeanListHandler<Type>(Type.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Type findById(int tpyeid) {
		try {
			String sql = "select * from videotype where tid = ?";
			Object[] params = {tpyeid};
			return qr.query(sql, new BeanHandler<Type>(Type.class),params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		

	}
	@Override
	public List<Type> findByParentId(int parentid) {
		try {
			String sql = "select * from videotype where parentid = ?";
			return qr.query(sql, new BeanListHandler<Type>(Type.class),parentid);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	
	}

}
