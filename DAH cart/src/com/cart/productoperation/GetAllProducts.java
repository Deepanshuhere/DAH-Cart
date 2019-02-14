package com.cart.productoperation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.dao.ProductDAO;
import com.cart.dao.ProductDAOImpl;
 
@WebServlet("/GetAllProducts")
public class GetAllProducts extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;
    private HttpSession httpSession;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			productDAO  = new ProductDAOImpl();
			httpSession = request.getSession(false);
			
			if(httpSession != null)
				httpSession.setAttribute("products", productDAO.getAllProducts());

			request.getRequestDispatcher("/displayproducts.jsp").forward(request, response);
		}
		
		catch (Exception exception) 
		{
			System.out.println("-------- INSIDE GETALLPRODUCTS.JAVA CATCH --------");
			exception.printStackTrace();
		}
	}
}