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

import com.cart.dao.ProductDAO;
import com.cart.dao.ProductDAOImpl;
import com.cart.model.Cart;
import com.cart.model.Product;

@WebServlet("/AddProductToCart")
public class AddProductToCart extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private int productId;
	private int productQuantity;
	private List<Cart> cartProducts;
	private Iterator<Cart> iterator;
	private HttpSession httpSession; 
	private ProductDAO productDAO;
	private RequestDispatcher requestDispatcher;
	private Product product;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			productId		= Integer.parseInt(request.getParameter("productId"));
			productQuantity = 1;
			httpSession		= request.getSession(false);
			cartProducts	= (List<Cart>)httpSession.getAttribute("cartProducts");
			iterator		= cartProducts.iterator();
			productDAO		= new ProductDAOImpl();
			product			= productDAO.getProduct(productId);
			
			if(product.getQuantity() < productQuantity)
			{
				requestDispatcher = request.getRequestDispatcher("/cart.jsp");
				requestDispatcher.forward(request, response);
			}
			
			else
			{
				while(iterator.hasNext())
				{												   
					Cart tempCart = iterator.next();
					if(tempCart.getProduct().getId() == productId)
					{
						Product tempProduct = tempCart.getProduct();
						int tempPrice 		= tempProduct.getPrice() / tempProduct.getQuantity();
						tempProduct.setQuantity(tempProduct.getQuantity()+ (productQuantity));
						tempProduct.setPrice(tempPrice * tempProduct.getQuantity());
					}
				}
			
		
				httpSession.setAttribute("cartProducts", cartProducts);
			
				requestDispatcher = request.getRequestDispatcher("CartAmount");
				requestDispatcher.include(request, response);
			
				requestDispatcher = request.getRequestDispatcher("/cart.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		
		catch (Exception exception) 
		{
			System.out.println("-------------------- EXCEPTION FROM UPDATECART.JAVA CATCH BLOCK -------------------------");
			exception.printStackTrace();
		}
	}

}
