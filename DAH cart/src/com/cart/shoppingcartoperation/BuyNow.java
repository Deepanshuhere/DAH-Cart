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

import com.cart.dao.CustomerDAO;
import com.cart.dao.CustomerDAOImpl;
import com.cart.dao.ProductDAO;
import com.cart.dao.ProductDAOImpl;
import com.cart.model.Cart;
import com.cart.model.Customer;
import com.cart.model.Product;
import com.cart.model.Sales;

@WebServlet("/BuyNow")
public class BuyNow extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private HttpSession httpSession;
	private List<Cart> cartProducts;
	private Iterator<Cart> iterator;
	private String address;
	private ProductDAO productDAO;
	private Sales sales;
	private Customer customer;
	private CustomerDAO customerDAO; 
	private RequestDispatcher requestDispatcher;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			httpSession  = request.getSession(false);
			address		 = (String)request.getParameter("address");
			cartProducts = (List<Cart>)httpSession.getAttribute("cartProducts");
			iterator	 = cartProducts.iterator();
			productDAO	 = new ProductDAOImpl();
			customerDAO  = new CustomerDAOImpl();
			sales		 = new Sales();
			customer	 = customerDAO.getCustomer((String)httpSession.getAttribute("email"));
			
			while(iterator.hasNext())
			{
				Product tempProduct1 = iterator.next().getProduct();
				Product tempProduct2 = productDAO.getProduct(tempProduct1.getId());				
				
				tempProduct2.setQuantity(tempProduct2.getQuantity() - tempProduct1.getQuantity());
				productDAO  .update(tempProduct2);
			}
			
			sales.setCustomer(customer);
			sales.setAmount((int)httpSession.getAttribute("cartAmount"));
			sales.setDate(null);
			
			customer   .setAddress(address);
			customerDAO.update(customer, customer.getEmail());
			
			
			if(productDAO.addSales(sales) == 1 )
			{
				httpSession.setAttribute("cartQuantity", 0);
				requestDispatcher = request.getRequestDispatcher("/thankyou.jsp");
				requestDispatcher.forward(request, response);
			}
		}

		catch (Exception exception) 
		{
			System.out.println("----------------------------- EXCEPTION FROM BUYNOW.JAVA CATCH BLOCK ------------------------------ ");
			exception.printStackTrace();
		}
	}

}