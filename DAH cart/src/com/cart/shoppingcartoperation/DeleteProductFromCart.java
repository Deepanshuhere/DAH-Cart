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
import com.cart.model.Product;


@WebServlet("/DeleteProductFromCart")
public class DeleteProductFromCart extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private int productId;
	private int productQuantity;
	private List<Cart> cartProducts;
	private Iterator<Cart> iterator;
	private HttpSession httpSession; 
	private RequestDispatcher requestDispatcher;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			productId		= Integer.parseInt(request.getParameter("productId"));
			productQuantity = -1;
			
			httpSession		= request.getSession(false);
			cartProducts	= (List<Cart>)httpSession.getAttribute("cartProducts");
			iterator		= cartProducts.iterator();
			
			while(iterator.hasNext())
			{												   
				Cart tempCart = iterator.next();
				if(tempCart.getProduct().getId() == productId)
				{
					Product tempProduct = tempCart.getProduct();
					int tempPrice 		= tempProduct.getPrice() / tempProduct.getQuantity();
					tempProduct.setQuantity(tempProduct.getQuantity()+ (productQuantity));
					
					if(tempProduct.getQuantity() == 0)
					{
						httpSession.setAttribute("productId", productId);
						requestDispatcher = request.getRequestDispatcher("DeleteCartProduct");
						requestDispatcher.forward(request, response);
					}
					
					tempProduct.setPrice(tempPrice * tempProduct.getQuantity());
				}
			}
			
		
			httpSession.setAttribute("cartProducts", cartProducts);
			
			requestDispatcher = request.getRequestDispatcher("CartAmount");
			requestDispatcher.include(request, response);
			
			requestDispatcher = request.getRequestDispatcher("/cart.jsp");
			requestDispatcher.forward(request, response);
		}
		
		catch (Exception exception) 
		{
			System.out.println("-------------------- EXCEPTION FROM DELTEPRODUCTFROMCART.JAVA CATCH BLOCK -------------------------");
			exception.printStackTrace();
		}
	}

}
