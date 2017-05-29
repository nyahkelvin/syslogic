package net.systemic.rest.ds;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

/**
 *
 * @author kelvinashu
 */
public class DataSource {

    /**
     *
     * @return
     */
    public JdbcTemplate getJDBCTemplate() {
        JdbcTemplate jdbcTemplate = null;
        try {
            SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
            dataSource.setDriver(new com.mysql.jdbc.Driver());
            dataSource.setUrl("jdbc:mysql://localhost:3306/systemic?useSSL=false");
            dataSource.setUsername("root");
            dataSource.setPassword("2014menus");

            jdbcTemplate = new JdbcTemplate(dataSource);
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jdbcTemplate;
    }

}
