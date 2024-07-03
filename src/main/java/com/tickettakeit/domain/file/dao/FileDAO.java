package com.tickettakeit.domain.file.dao;

import com.tickettakeit.domain.file.dto.FileInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

import static com.tickettakeit.domain.file.dao.sql.FileSqls.*;

@Repository
public class FileDAO {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<FileInfo> fileInfoRowMapper = BeanPropertyRowMapper.newInstance(FileInfo.class);

    public FileDAO(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public FileInfo selectFileInfoById(Integer fileId) {
        Map<String, Integer> params = new HashMap<>();
        params.put("fileId", fileId);

        return jdbc.queryForObject(SELECT_FILE_INFO_BY_ID, params, fileInfoRowMapper);
    }

    public Integer insertFileInfo(String fileName, String saveFileName, String contentType) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("fileName", fileName)
                .addValue("saveFileName", saveFileName)
                .addValue("contentType", contentType);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(INSERT_FILE_INFO, params, keyHolder);

        return keyHolder.getKey().intValue();
    }
}
