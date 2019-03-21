
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
import com.cart.model.Product;

@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;
	private String productName,productDescription;
	private int productId,productPrice,productQuantity;
	private Product product;
	private int updateStatus;
	private HttpSession httpSession;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("INSIDE UPDATE PRODUCT!!");

		try 
		{
			productId 	 	   = Integer.parseInt(request.getParameter("id"));
			productName        = request.getParameter("name");
			productPrice 	   = Integer.parseInt(request.getParameter("price"));
			productDescription = request.getParameter("description");
			productQuantity    = Integer.parseInt(request.getParameter("quantity"));
			product 		   = new Product();
			
			product.setId(productId);
			product.setName(productName);
			product.setPrice(productPrice);
			product.setDescription(productDescription);
			product.setQuantity(productQuantity);
			
			productDAO   = new ProductDAOImpl();
			updateStatus = productDAO.update(product);
			System.out.println("UPDATE STATUS IS ======> "+updateStatus);
		}
		
		catch(Exception exception) 
		{
			System.out.println("-------- INSIDE UPDATEPRODUCTS.JAVA CATCH --------");
			exception.printStackTrace();
		}
		
		
		if(updateStatus == 1)
		{
			httpSession = request.getSession(false);
			
			httpSession.setAttribute("products", productDAO.getAllProducts());
			request.getRequestDispatcher("/displayproducts.jsp").forward(request, response);
		}
		
		else
		{
			//jk
/*			httpSession = request.getSession(false);
			
			//httpSession.setAttribute("requestFrom", "updateproduct.jsp");
			request.setAttribute("id", productId);
			request.getRequestDispatcher("/GetProduct").forward(request, response);
*/		}

	}
}