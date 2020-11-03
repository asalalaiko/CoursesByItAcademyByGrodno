package by.grodno.pvt.site.webappsample;

import by.grodno.pvt.site.webappsample.service.User;
import by.grodno.pvt.site.webappsample.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class JstlServlet4 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String parameter = req.getParameter("number");

		List<User> users = UserService.getService().getUserbyId(Integer.valueOf(parameter));

		req.setAttribute("users", users);

		getServletContext().getRequestDispatcher("/jstl4.jsp").forward(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			User user = new User(Integer.valueOf(req.getParameter("id")),
					req.getParameter("firstName"),
					req.getParameter("lastName"),
					new SimpleDateFormat("yyy-MM-dd")
							.parse(req.getParameter("birthdate")),
					Boolean.valueOf(req.getParameter("male")));
			user.setSalary(Double.valueOf(req.getParameter("salary")));
			UserService.getService().editUser(user);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("/webappsample/jstl1");
	}
}
