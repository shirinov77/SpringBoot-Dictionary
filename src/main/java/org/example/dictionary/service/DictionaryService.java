package org.example.dictionary.service;

import org.example.dictionary.entity.Dictionary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DictionaryService {

    private JdbcTemplate jdbcTemplate;

    public DictionaryService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Dictionary> rowMapper = new RowMapper<Dictionary>() {

        @Override
        public Dictionary mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Dictionary(
                    rs.getLong("id"),
                    rs.getString("word"),
                    rs.getString("meaning"),
                    rs.getTimestamp("created_at").toLocalDateTime()
            );
        }
    };

    public List<Dictionary> getAll() {
        String sql = "SELECT * FROM dictionary ORDER BY created_at DESC";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public List<Dictionary> search(String keyword) {
        String sql = "SELECT * FROM dictionary WHERE word ILIKE ? OR meaning ILIKE ? ORDER BY id";
        return jdbcTemplate.query(sql, new Object[]{"%" + keyword + "%", "%" + keyword + "%"}, rowMapper);
    }

    public void create(Dictionary dictionary) {
        String sql = "INSERT INTO dictionary (word, meaning, created_at) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, dictionary.getWord(), dictionary.getMeaning(), LocalDateTime.now());
    }

    public void update(Dictionary dictionary) {
        String sql = "UPDATE dictionary SET word = ?, meaning = ? WHERE id = ?";
        jdbcTemplate.update(sql, dictionary.getWord(), dictionary.getMeaning(), dictionary.getId());
    }

    public void delete(Long id) {
        String sql = "DELETE FROM dictionary WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public Dictionary getById(Long id) {
        String sql = "SELECT * FROM dictionary WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
    }

}
