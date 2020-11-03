package by.grodno.pvt.site.webappsample.service;

public class SQL {

	public static final String SELECT_ALL = "select * from public.testtable order by id";
	public static final String SELECT_ALL_AND_DEP = "SELECT * FROM public.testtable t FULL JOIN public.dept d ON t.dept_num = d.id order by t.id";
	public static final String SELECT_BY_ID = "select * from public.testtable where id = ?";
	public static final String DELETE_BY_ID = "delete from public.testtable where id = ?";
	public static final String DELETE_DEP_BY_ID = "delete from public.dept where id = ?";
	public static final String INSERT = "INSERT INTO public.testTable "
			+ "(empl_name, empl_last_name, salary, birthdate,  male) VALUES (?,?,?,?,?)";
	public static final String UPDATE = "UPDATE public.testtable SET "
			+ "empl_name = ?, empl_last_name = ?, salary = ?, birthdate = ?, male = ? where id = ?";
	public static final String SELECT_ALL_DEP = "select * from public.dept order by id";
	public static final String INSERT_DEP = "INSERT INTO public.dept "
			+ "(dept_name, dept_description) VALUES (?,?)";

}
