package cn.java.study.dao;

import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {
	private static Properties props = null;
	static {
		// 加载配置文件内容到props对象中
		try {
			InputStream in = DaoFactory.class
					.getClassLoader().getResourceAsStream("dao.properties");
			props = new Properties();
			props.load(in);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	/**
	 * 返回一个具体UserDao的实现类对象
	 * @return
	 */
	public static TypeDao getTypeDao() {
		/**
		 * 给出一个配置文件，文件中给出UserDao接口的实现类名称！
		 * 我们这个方法，获取实现类的类名，通过反射完成创建对象！
		 */
		/*
		 * 得到dao实现类的名称
		 */
		String daoClassName = props.getProperty("cn.java.study.dao.TypeDao");
		
		/*
		 * 通过反射来创建实现类的对象　
		 */
		try {
			Class clazz = Class.forName(daoClassName);
			return (TypeDao)clazz.newInstance();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

}
