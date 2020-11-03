package by.grodno.pvt.site.webappsample;

import by.grodno.pvt.site.webappsample.service.DepService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JstlServlet31 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String parameter = req.getParameter("number");

		DepService.getService().deleteDep(Integer.valueOf(parameter));

		resp.sendRedirect("/webappsample/jstl11");
	}

}
