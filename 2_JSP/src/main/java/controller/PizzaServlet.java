package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PizzaServlet
 */
@WebServlet("/orderPizza.do")
public class PizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("요청 확인!!!");
		// 1) 전달된 값들 중에 한글이 있을 경우 인코딩 처리 (POST 방식에만 해당)
//		request.setCharacterEncoading("UTF-8");
		
		// 2) 요청 시 전달된 값 추출 후 가공처리(파싱) => 변수 또는 객체 기록
		/*
		 * 	  - request.getParameter("키값") : String타입의 데이터(값)
		 * 	  - request.getParameterValues("키값") : String[]
		 */
		
		// 피자 주문 시 전달되는 모든 값에 대해 변수로 추출
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String requestMsg = request.getParameter("requestMsg");
		
		String menu = request.getParameter("menu");
		String toppings = request.getParameter("topping");
		String sidemenus = request.getParameter("sidemenu");
		
		// --------------------------------------
		// 서블릿에서 요청받은 데이터를 jsp 에게 전달(공유)
		
		request.setAttribute("name", name);
		request.setAttribute("phone", phone);
		request.setAttribute("address", address);
		request.setAttribute("requestMsg", requestMsg);
		request.setAttribute("menu", menu);
		request.setAttribute("toppings", toppings);
		request.setAttribute("sidemenus", sidemenus);
		
		// 응답페이지를 jsp 맡김! (jsp로 응답)
		RequestDispatcher view = request.getRequestDispatcher("views/pizza/orderResult.jsp");
		view.forward(request, response);
 	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
