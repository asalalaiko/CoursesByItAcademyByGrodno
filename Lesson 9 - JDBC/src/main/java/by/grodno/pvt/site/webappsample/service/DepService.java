package by.grodno.pvt.site.webappsample.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class DepService {

	private static DepService depService;

	public static final Logger LOGGER = Logger.getLogger(DepService.class);

	private DepService() {
	}

	public static DepService getService() {
		if (depService == null) {
			depService = new DepService();
		}
		return depService;
	}

	public List<Dep> getDeps() {
		List<Dep> result = new ArrayList<Dep>();
		try (Connection conn = DBUtils.getConnetion(); Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(SQL.SELECT_ALL_DEP);

			while (rs.next()) {

				Dep dep = mapRawToDeps(rs);

				result.add(dep);
			}

			rs.close();
		} catch (Exception e) {
			LOGGER.error("Something went wrong...", e);
		}

		return result;
	}

	public void addDep(Dep dep) {
		try (Connection conn = DBUtils.getConnetion();
			 PreparedStatement stmt = conn.prepareStatement(SQL.INSERT_DEP, Statement.RETURN_GENERATED_KEYS)) {

			stmt.setString(1, dep.getDepName());
			stmt.setString(2, dep.getDepInf());


			stmt.executeUpdate();

			ResultSet generatedKeys = stmt.getGeneratedKeys();
			generatedKeys.next();
			LOGGER.info("Dep created with id: " + generatedKeys.getLong(1));

		} catch (Exception e) {
			LOGGER.error("Something went wrong...", e);
		}
	}

		private Dep mapRawToDeps(ResultSet rs) throws SQLException {
		Integer id = rs.getInt(1);
		String dName = rs.getString(2);
		String dInfo = rs.getString(3);
		Dep dep = new Dep(id, dName, dInfo);
		return dep;
	};

	public void deleteDep(Integer number) {
		try (Connection conn = DBUtils.getConnetion();
			 PreparedStatement stmt = conn.prepareStatement(SQL.DELETE_DEP_BY_ID)) {

			stmt.setInt(1, number);

			stmt.execute();

		} catch (Exception e) {
			LOGGER.error("Something went wrong...", e);
		}

	};
}
