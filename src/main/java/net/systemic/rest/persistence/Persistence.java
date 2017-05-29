package net.systemic.rest.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import net.systemic.rest.domain.User;
import net.systemic.rest.ds.DataSource;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author kelvinashu
 */
public class Persistence {

    private DataSource ds;

    public DataSource getDs() {
        return ds;
    }
    
    

    /**
     *
     * @return
     */
    public List<User> getAllUsers() {

        String sql = "SELECT * FROM systemic.users";

        List<User> users = getDs().getJDBCTemplate().query(sql, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet result, int rowNum) throws SQLException {
                User user = new User();

                user.setId(result.getInt("id"));
                user.setFirstName(result.getString("first_name"));
                user.setLastName(result.getString("last_name"));
                user.setDateOfBirth(result.getDate("date_of_birth"));
                user.setAge(result.getInt("age"));
                user.setSalary(result.getDouble("salary"));

                return user;
            }

        });
        return users;
    }

    /**
     *
     * @param user
     */
    public void addUser(User user) {

        String sql = "INSERT INTO users "
                + "(first_name, last_name, date_of_birth, age, salary) "
                + "VALUES (?, ?, ?, ?, ?)";

        getDs().getJDBCTemplate().update(sql, new Object[]{
            user.getFirstName(), user.getLastName(), user.getDateOfBirth(),
            user.getAge(), user.getSalary()});

    }

}
