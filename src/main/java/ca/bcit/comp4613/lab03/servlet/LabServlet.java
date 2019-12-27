package ca.bcit.comp4613.lab03.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import ca.bcit.comp4613.dao.DBBean;

public class LabServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String driver;
    private String url;
    private String user;
    private String pass;
	private DBBean db;
	private ServletContext context;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		ServletConfig servletConfig = getServletConfig();
        context = servletConfig.getServletContext();
        driver = context.getInitParameter("driver");
        url = context.getInitParameter("url");
        user = context.getInitParameter("login");
        
      //Start wildFly with argument: -DpasscodeForLab03=lab03
        
        try{
			String encryptedPass = context.getInitParameter("pass");
			String passcode = System.getProperty("passcodeForLab03");			
			
			StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
			encryptor.setAlgorithm("PBEWithMD5AndDES");
			encryptor.setPassword(passcode);
			pass = encryptor.decrypt( encryptedPass );
			
		}catch (Exception e ){
			throw new ServletException("Error decrypting DB password!!");
		}
		
		db = new DBBean();
		
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		db.connect(driver, url, user, pass);
		System.out.println("QUERY STRING: " + request.getParameter("queryInput"));
		db.setQueryString(request.getParameter("queryInput"));
		try {
			db.generateResultSet();
		} catch (SQLException e) {
			throw new ServletException(e);
		}
		HttpSession session = request.getSession();
		session.setAttribute("db", db);
		

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/header.jsp");
		dispatcher.include(request, response);
		dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/output.jsp");
		dispatcher.include(request, response);
		dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/footer.jsp"); 
		dispatcher.include(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	
	@Override
	public void destroy() {
		db.cleanUp();
	}
	
}
