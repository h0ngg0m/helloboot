package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@HellobootTest
public class JdbcTemplateTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }

    @Test
    void insertAndQuery() {
        jdbcTemplate.update("insert into hello(name, count) values(?, ?)", "Spring", 3);
        jdbcTemplate.update("insert into hello(name, count) values(?, ?)", "hong", 1);

        Integer i = jdbcTemplate.queryForObject("select count(*) from hello", Integer.class);
        Assertions.assertThat(i).isEqualTo(2);
    }

    @Test
    void insertAndQuery2() {
        jdbcTemplate.update("insert into hello(name, count) values(?, ?)", "Spring", 3);
        jdbcTemplate.update("insert into hello(name, count) values(?, ?)", "hong", 1);

        Integer i = jdbcTemplate.queryForObject("select count(*) from hello", Integer.class);
        Assertions.assertThat(i).isEqualTo(2);
    }
}
