package org.app.dao;

import org.app.models.Fairy;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cvenkman on Mar, 2022
 **/
@Component
public class WinxDao {
    //show, save, update, delete
    public JdbcTemplate jdbcTemplate;

    @Autowired
    public WinxDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Fairy> index() {
        return jdbcTemplate.query("SELECT * FROM fairies",
                new BeanPropertyRowMapper<>(Fairy.class));
    }

    public Fairy show(String name) {
        return jdbcTemplate.query(
                "SELECT * FROM fairies WHERE name=?", new Object[]{name},
                new BeanPropertyRowMapper<>(Fairy.class)
                )
                .stream().findAny().orElse(null);
    }

    public void save(Fairy fairy) {
        jdbcTemplate.update(
                "INSERT INTO fairies VALUES(?, ?, ?)",
                fairy.getName(), fairy.getAge(), fairy.getPowers()
        );
    }

    public void update(String name, Fairy updatedFairy) {
        jdbcTemplate.update(
                "UPDATE fairies SET name=?, age=?, powers=? WHERE name=?",
                updatedFairy.getName(), updatedFairy.getAge(),
                updatedFairy.getPowers(), name
        );
    }

    public void delete(String name) {
        jdbcTemplate.update("DELETE FROM fairies WHERE name=?", name);
    }
}
