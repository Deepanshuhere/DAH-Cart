package com.cart.shoppingcartoperation;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.model.Cart;

@WebServlet("/DeleteCartProduct")
public class DeleteCartProduct extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private int productId;
	private HttpSession httpSession;
	private List<Cart> cartProducts;
	private int cartQuantity;
	private Iterator<Cart> iterator;
	private RequestDispatcher requestDispatcher;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			httpSession	 = request.getSession(false); 
			
			if(httpSession.getAttribute("productId") != null)
				productId = (int)request.getAttribute("productId");
			
			else
				productId	 = Integer.parseInt(request.getParameter("productId"));
			
			cartProducts = (List<Cart>)httpSession.getAttribute("cartProducts");
			cartQuantity = (int) httpSession.getAttribute("cartQuantity");
			iterator	 = cartProducts.iterator();
			
			while(iterator.hasNext())
			{
				Cart tempCart = iterator.next();
				if(tempCart.getProduct().getId() == productId)
				{
					iterator.remove();
					cartQuantity = cartQuantity-1;
				}
			}
			
			httpSession.setAttribute("cartQuantity", cartQuantity);
			httpSession.setAttribute("cartProducts", cartProducts);
			
			requestDispatcher = request.getRequestDispatcher("CartAmount");
			requestDispatcher.include(request, response);
			
			requestDispatcher = request.getRequestDispatcher("/cart.jsp");
			requestDispatcher.forward(request, response);
		}
		
		catch (Exception exception) 
		{
			System.out.println("------------------------------ EXCEPTION FROM DELETECARTPRODUCT.JAVA CATCH BLOCK ---------------------------");
			exception.printStackTrace();
		}
	}

}
