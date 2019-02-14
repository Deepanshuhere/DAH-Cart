package com.cart.productoperation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import com.cart.dao.ProductDAO;
import com.cart.dao.ProductDAOImpl;
import com.cart.model.Product;
import org.apache.commons.io.IOUtils;


@WebServlet("/AddProduct")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
				 maxFileSize=1024*1024*50,      	// 50 MB
				 maxRequestSize=1024*1024*100)   	// 100 MB

public class AddProduct extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private String categoryId,productName,path,productDescription,fileName;
	private int productPrice;
	private Product product;
	private Part part;
	private InputStream inputStream;
	private byte[] bytes;
	private FileOutputStream fileOutputStream;
	private ProductDAO productDAO;
	private HttpSession httpSession;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		productName        = request.getParameter("name");
		productPrice	   = Integer.parseInt(request.getParameter("price"));
		productDescription = request.getParameter("description");
		categoryId		   = request.getParameter("categoryId");

		System.out.println();
		System.out.println();
		System.out.println("category id is =>"+categoryId);
		System.out.println();
		System.out.println();
		
		product=new Product();
		product.setId(null);
		product.setName(productName);
		product.setPrice(productPrice);
		product.setDescription(productDescription);
		product.setCategoryId(categoryId);
		
		part=request.getPart("image");
		inputStream=part.getInputStream();
		bytes = IOUtils.toByteArray(inputStream);
		path="D:\\workspace\\spring_eclipse\\DAH cart\\WebContent\\images\\product image";
		fileName=path+File.separator+product.getId()+".jpg";
		fileOutputStream=new FileOutputStream(fileName);
		fileOutputStream.write(bytes);
		
		/*
		 create table product(id varchar2(20) primary key,name varchar2(100),price number,description varchar2(1500),category_id references category(categoryid));
		  */
		
		productDAO=new ProductDAOImpl();
		
		try 
		{
			if(productDAO.add(product) == 1)
			{
				httpSession = request.getSession(false);
				if(httpSession != null)
					httpSession.setAttribute("products", productDAO.getAllProducts());
				
				request.getRequestDispatcher("/admin.jsp").forward(request, response);
			}
			
			else
			{
				request.getRequestDispatcher("/add.jsp").forward(request, response);
			}
			
		}
		
		catch (Exception exception) 
		{
			System.out.println("--------- INSIDE ADDPRODUCT.JAVA CATCH -----");
			exception.printStackTrace();
		}
		
		finally
		{
			if(fileOutputStream!=null)
				fileOutputStream.close();
		}
		
	}

}