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
		
		//1.�����������
		String num=request.getParameter("num");
		String password=request.getParameter("password");
		
		//��ȡsession
		HttpSession session=request.getSession();
		
		//�ж��������ȷ�ԣ�null������û�δ�����ύֱ�ӽ���
		//��Ϊ�û���Ȼ�������ύ������Ϊ��
		if(num==null||"".equals(num.trim())) {
			session.setAttribute("message", "ѧ����������");
			response.sendRedirect(request.getContextPath()+"/Login.jsp");
			return;
		}
		
		if(password==null||"".equals(password.trim())) {
			session.setAttribute("message", "������������");
			response.sendRedirect(request.getContextPath()+"/Login.jsp");
			return;
		}
		
		//����service����
		IstudentService service=new StudentServiceImpl();
		
		//����service�����checkUser()�������û�������֤
		Student student=service.checkUser(num,password);
		
		//��֤δͨ��������ת��½ҳ�棬���û��ٴ�������Ϣ����ʱҳ�����û�����һЩ��ʾ
		//���ʹ��sendRedirect�Է�ֹ�û���������Ϊ��������˺�
		if(student==null) {
			session.setAttribute("message","ѧ�Ż�������������");
			response.sendRedirect(request.getContextPath()+"/Login.jsp");
			return;
		}
		
		session.setAttribute("student", student);
		//��֤ͨ������ת����ҳ��index.jsp
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		
	}

}
