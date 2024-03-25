package com.game.rpg.repository;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.game.rpg.entity.authentication.Login;

@Repository
public class AuthenticationRepository {

    private NamedParameterJdbcTemplate template;

    public AuthenticationRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public Login getUserAuthentication(String username) throws SQLException {
        String sql = "SELECT U.username, U.password from user U where U.username = :username";

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("username", username);

        Map<String, Object> result = template.queryForMap(sql, parameters);

        Login login = new Login();
        login.setEmail((String) result.get("username"));
        login.setPassword((String) result.get("password"));
        return login;
    }
}
