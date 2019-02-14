package com.cart.shoppingcart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.dao.ProductDAO;
import com.cart.dao.ProductDAOImpl;
import com.cart.model.Product;

@WebServlet("/Cart")
public class Cart extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private HttpSession httpSession;
	private ProductDAO productDAO;
	private Product product;
	private String productId;
//	private int productQuantity;
	private int cartQuantity;
	private List<Product> cartProducts;
	private RequestDispatcher requestDispatcher;
	
	@SuppressWarnings("unchecked")
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			httpSession = request.getSession(false); // session is not created still getting the session object
			System.out.println("session ? "+httpSession);
			if(httpSession == null)
			{
				System.out.println("inside == null");
				requestDispatcher = request.getRequestDispatcher("/login.jsp");
				requestDispatcher.forward(request, response);
			}
			
			else if(httpSession != null)
			{
				System.out.println("inside != null");
				productDAO      = new ProductDAOImpl();
				productId       = request.getParameter("productId");
				cartProducts	= (List<Product>)httpSession.getAttribute("cartProducts");
				//productQuantity = Integer.parseInt(request.getParameter("quantity"));
				product         = productDAO.getProduct(productId);
				cartQuantity	= (int)httpSession.getAttribute("cartQuantity");
				cartQuantity	= cartQuantity+1;
				
				cartProducts.add(product);
				httpSession.setAttribute("cartProducts", cartProducts); 
				httpSession.setAttribute("cartQuantity", cartQuantity);
				
				requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);				
			}
		
		}
		
		catch(Exception e)
		{
			System.out.println("--------------------- EXCEPTION FROM CART.JAVA ------------------------------");
			e.printStackTrace();
		}
		
	}

}
