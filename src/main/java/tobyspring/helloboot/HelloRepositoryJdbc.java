package tobyspring.helloboot;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HelloRepositoryJdbc implements HelloRepository {
    private final JdbcTemplate jdbcTemplate;

    public HelloRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Hello findHello(String name) {
        try {

            return jdbcTemplate.queryForObject(
                    "SELECT name, count FROM hello WHERE name = ?",
                    (rs, rowNum) -> new Hello(rs.getString("name"), rs.getInt("count")),
                    name
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void increaseCount(String name) {
        Hello hello = findHello(name);
        if (hello == null) {
            jdbcTemplate.update("INSERT INTO hello(name, count) VALUES(?, 1)", name);
        } else {
            jdbcTemplate.update("UPDATE hello SET count = count + 1 WHERE name = ?", name);
        }
    }
}
