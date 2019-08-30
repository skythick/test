package cn.java.study.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import cn.itcast.servlet.BaseServlet;
import cn.java.study.common.JsonUtils;
import cn.java.study.domain.Node;
import cn.java.study.service.TypeService;

public class TypeServlet extends BaseServlet {
	private TypeService typeservice = new TypeService();
	

	public String findAllType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1、调用service 得到所有的类型
		 * 2、保存request域中
		 * 3、转发到list.jsp
		 */
		request.setAttribute("typelist", typeservice.findAllType());
		return "f:/itemlist2.jsp";
	}
	public String findAllType2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1、调用service 得到所有的类型
		 * 2、保存request域中
		 * 3、转发到list.jsp
		 */
		request.setAttribute("typelist", typeservice.findAllType2());
		return "f:/test3.jsp";
	}
	
	public String findAllNode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1、调用service 得到所有的类型
		 * 2、保存request域中
		 * 3、转发到list.jsp
		 */
		List<Node> nodelist = typeservice.findAllNode();
		//把list数据转化成JSONArray数组
		JSONArray jsonarr = JsonUtils.removeNullBean(nodelist);
		String nodejson = jsonarr.toString();
		System.out.println("nodejson =="+nodejson);
		request.setAttribute("typejson", nodejson);
		return "f:/test2.jsp";
	}
	
	public String findById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");//注意：发送xml这里要修改！！
		
		String strparent =request.getParameter("parentid");
		
		System.out.println("strparent===="+strparent);
		
		int  parentid = Integer.parseInt(strparent);
		System.out.println("parentid"+parentid);
		String str = JSONArray.fromObject(typeservice.findByParentId(parentid)).toString();
		response.getWriter().print(str);
		System.out.println(str);
		return null;
	}
}
