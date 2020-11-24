package by.grodno.pvt.site.webappsample;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.grodno.pvt.site.webappsample.service.Dep;
import by.grodno.pvt.site.webappsample.service.DepService;
import by.grodno.pvt.site.webappsample.service.User;
import by.grodno.pvt.site.webappsample.service.UserService;

public class JstlServlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Dep> deps = DepService.getService().getDeps();

		req.setAttribute("deps", deps);

		getServletContext().getRequestDispatcher("/jstl2.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			User user = new User(null,
					req.getParameter("firstName"),
					req.getParameter("lastName"),
					new SimpleDateFormat("yyy-MM-dd")
							.parse(req.getParameter("birthdate")),
					Boolean.valueOf(req.getParameter("male")),
					Double.valueOf(req.getParameter("salary")), Integer.valueOf(req.getParameter("department")));

			UserService.getService().addUser(user);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("/webappsample/jstl1");
	}

}
