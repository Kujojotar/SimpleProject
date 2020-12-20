package com.james.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.james.beans.Student;
import com.james.service.IstudentService;
import com.james.service.StudentServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.接受请求参数
		String num=request.getParameter("num");
		String password=request.getParameter("password");
		
		//获取session
		HttpSession session=request.getSession();
		
		//判断输入的正确性，null情况是用户未经过提交直接进入
		//空为用户虽然进行了提交但输入为空
		if(num==null||"".equals(num.trim())) {
			session.setAttribute("message", "学号输入有误");
			response.sendRedirect(request.getContextPath()+"/Login.jsp");
			return;
		}
		
		if(password==null||"".equals(password.trim())) {
			session.setAttribute("message", "密码输入有误");
			response.sendRedirect(request.getContextPath()+"/Login.jsp");
			return;
		}
		
		//创建service对象
		IstudentService service=new StudentServiceImpl();
		
		//利用service对象的checkUser()方法对用户进行验证
		Student student=service.checkUser(num,password);
		
		//验证未通过，则跳转登陆页面，让用户再次输入信息，此时页面向用户给出一些提示
		//最好使用sendRedirect以防止用户恶意输入为程序带来伤害
		if(student==null) {
			session.setAttribute("message","学号或密码输入有误");
			response.sendRedirect(request.getContextPath()+"/Login.jsp");
			return;
		}
		
		session.setAttribute("student", student);
		//验证通过，跳转到主页的index.jsp
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		
	}

}
