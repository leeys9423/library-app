package com.group.libraryapp.repository.fruit;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class FruitJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public FruitJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveFruit(String name, LocalDate warehousingDate, long price) {
        String sql = "INSERT INTO fruit (name, warehousing_date, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, name, warehousingDate, price);
    }

    public boolean isUserNotExist(long id) {
        String sql = "SELECT * FROM fruit WHERE id = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> 0, id).isEmpty();
    }

    public boolean isUserNotExist(String name) {
        String sql = "SELECT * FROM fruit WHERE name = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> 0, name).isEmpty();
    }

    public void updateFruit(long id) {
        String sql = "UPDATE fruit SET is_sold = 'Y' WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public long salesAmount(String name) {
        String sql = "SELECT SUM(price) FROM fruit WHERE is_sold = 'Y' AND name = ? GROUP BY name";
        try {
            return jdbcTemplate.queryForObject(sql, long.class, name);
        } catch (EmptyResultDataAccessException e) {
            return 0L;
        }
    }

    public long notSalesAmount(String name) {
        String sql = "SELECT SUM(price) FROM fruit WHERE is_sold = 'N' AND name = ? GROUP BY name";
        try {
            return jdbcTemplate.queryForObject(sql, long.class, name);
        } catch (EmptyResultDataAccessException e) {
            return 0L;
        }
    }
}
