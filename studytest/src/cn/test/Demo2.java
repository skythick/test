package cn.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import cn.java.study.common.JsonUtils;
import cn.java.study.dao.DaoFactory;
import cn.java.study.dao.TypeDao;
import cn.java.study.domain.Node;
import cn.java.study.domain.Type;
import cn.java.study.service.TypeService;

public class Demo2 {
	@Test
	public void fun(){
		TypeService typeservice = new TypeService();
		List<Node> nodelist = typeservice.findAllNode();
		//把list数据转化成JSONArray数组
		JSONArray jsonarr = JsonUtils.removeNullBean(nodelist);
		System.out.println(jsonarr);
	}

}
