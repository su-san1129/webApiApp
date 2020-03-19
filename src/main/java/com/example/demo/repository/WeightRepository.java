package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Weight;

@Repository
public class WeightRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private final RowMapper<Weight> WEIGHT_RM = new BeanPropertyRowMapper<>(Weight.class);

	public List<Weight> findAll() {
		String sql = "SELECT * FROM weights ORDER BY id;";
		return template.query(sql, WEIGHT_RM);
	}

	public Weight load(Integer id) {
		String sql = "SELECT * FROM weights WHERE id = :id";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("id", id);
		return template.queryForObject(sql, paramMap, WEIGHT_RM);
	}

	public List<Weight> findByUserId(Integer userId) {
		String sql = "SELECT * FROM weights WHERE user_id = :userId ORDER BY id";
		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("userId", userId);
		return template.query(sql, paramMap, WEIGHT_RM);
	}

	public void save(Weight weight) {
		SqlParameterSource paramMap = new BeanPropertySqlParameterSource(weight);
		String sql = "INSERT INTO (user_id, weight, body_fat_parcentage, created_at, updated_at,) VALUES (:userId, :weight, :bodyFatParcentage, :createdAt, :updatedAt)";
		template.update(sql, paramMap);
	}

}
