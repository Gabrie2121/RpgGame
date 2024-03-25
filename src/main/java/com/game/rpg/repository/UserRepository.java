package com.game.rpg.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.game.rpg.commom.exception.CustomException;
import com.game.rpg.entity.user.User;

@Repository
public class UserRepository {

    private NamedParameterJdbcTemplate template;

    public UserRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public Optional<User> findUserByUsername(String username) {
        String sql = "SELECT * FROM user U where U.username = :username";

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("username", username);

        Map<String, Object> result = template.queryForMap(sql, parameters);
        User user = new User();
        user.setId((Long) result.get("id"));
        user.setNome((String) result.get("nome"));
        user.setImagem((String) result.get("imagem"));
        user.setEmail((String) result.get("email"));
        user.setUsername((String) result.get("username"));
        user.setPassword((String) result.get("password"));

        Optional<User> optionalUser = Optional.ofNullable(user);
        return optionalUser;
    }

    public boolean userExists(String username) {
        String sql = "SELECT U.id from user U where U.username = :username";

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("username", username);

        boolean resultList = template.queryForList(sql, parameters).isEmpty();
        return !resultList;
    }

    public void createUser(User user) {
        try {
            String sql = "INSERT INTO user (nome,email,imagem,username,password)VALUES (:nome, :email, :image, :username, :password)";

            MapSqlParameterSource parameters = new MapSqlParameterSource();
            parameters.addValue("nome", user.getNome());
            parameters.addValue("email", user.getEmail());
            parameters.addValue("image", user.getImagem());
            parameters.addValue("username", user.getUsername());
            parameters.addValue("password", user.getPassword());

            template.update(sql, parameters);
        } catch (DuplicateKeyException e) {
            if (e.getMessage().contains("unique_email")) {
                throw new CustomException("Já existe uma conta nesse e-mail!");
            } else if (e.getMessage().contains("username")) {
                throw new CustomException("Já existe um usuario com o username selecionado!");
            } else {
                throw new CustomException("Ocorreu um erro interno!");
            }
        }
    }

}
