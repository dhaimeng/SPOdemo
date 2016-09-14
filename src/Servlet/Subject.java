package Servlet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Subject
 */
@WebServlet(name="Subject",urlPatterns="/EntityR/Subject")
public class Subject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Subject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());	//append׷�Ӹ�servlet·��/Demo1
//		PrintWriter out = response.getWriter();
		response.setContentType("text/html");		
		String key=request.getParameter("q");
		String root=this.getServletContext().getRealPath("/");
		String EntityPath=root+"localData\\EntityData\\"+key+".txt";
//		System.out.print(EntityPath);
		ArrayList<String> sameEntity=new ArrayList<String>();		
		try{
			FileReader fr = new FileReader(EntityPath);
			BufferedReader br = new BufferedReader(fr);
			String pre=br.readLine();
			while(pre!=null){
				sameEntity.add(pre);
				pre=br.readLine();
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		request.setAttribute("sameEntity",sameEntity);
		request.setAttribute("key",key);
		request.getRequestDispatcher("Beijing.jsp").forward(request,
				response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
