package cn.java.study.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;


import cn.java.study.service.TypeService;

public class AServlet extends HttpServlet {
	private TypeService tyservice = new TypeService();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");//注意：发送xml这里要修改！！
		
		String strparent =request.getParameter("parentid");
		
		System.out.println("strparent===="+strparent);
		
		int  parentid = Integer.parseInt(strparent);
		System.out.println("parentid"+parentid);
		String str = JSONArray.fromObject(tyservice.findByParentId(parentid)).toString();
		response.getWriter().print(str);
		System.out.println(str);
		
	}

}
