package by.grodno.pvt.site.webappsample;

import by.grodno.pvt.site.webappsample.service.DBUtils;
import by.grodno.pvt.site.webappsample.service.DepService;
import by.grodno.pvt.site.webappsample.service.Dep;
import by.grodno.pvt.site.webappsample.service.DepService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.List;

public class JstlServlet11 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Dep> deps = DepService.getService().getDeps();

		req.setAttribute("deps", deps);

		getServletContext().getRequestDispatcher("/jstl11.jsp").forward(req, resp);
	}



}
