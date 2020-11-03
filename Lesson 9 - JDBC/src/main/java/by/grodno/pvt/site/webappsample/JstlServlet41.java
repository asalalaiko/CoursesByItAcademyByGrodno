package by.grodno.pvt.site.webappsample;

import by.grodno.pvt.site.webappsample.service.Dep;
import by.grodno.pvt.site.webappsample.service.DepService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class JstlServlet41 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String parameter = req.getParameter("number");

		List<Dep> deps = DepService.getService().getDepbyId(Integer.valueOf(parameter));

		req.setAttribute("deps", deps);

		getServletContext().getRequestDispatcher("/jstl41.jsp").forward(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Dep dep = new Dep(Integer.valueOf(req.getParameter("id")),
				req.getParameter("depName"),
				req.getParameter("depInf"));
		DepService.getService().editDep(dep);

		resp.sendRedirect("/webappsample/jstl11");
	}
}
