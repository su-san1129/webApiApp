package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.User;

@Repository
public class UserRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private final RowMapper<User> USER_RM = new BeanPropertyRowMapper<User>(User.class);

	public List<User> findAll() {
		String sql = "SELECT * FROM users ORDER BY id;";
		return template.query(sql, USER_RM);
	}

	public User load(Integer id) throws DataAccessException {
		String sql = "SELECT * FROM users WHERE id = :id";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("id", id);
		return template.queryForObject(sql, paramMap, USER_RM);
	}

	public User findByMailAddress(String email) {
		String sql = "SELECT * FROM users WHERE email = :email";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("email", email);
		return template.queryForObject(sql, paramMap, USER_RM);
	}

	public void save(User user) {
		SqlParameterSource paramMap = new BeanPropertySqlParameterSource(user);
		String sql = "INSERT INTO users (name, email, password, weight, height, birth_day) VALUES (:name, :email, :password, :weight, :height, :birthDay)";
		template.update(sql, paramMap);
	}

}
