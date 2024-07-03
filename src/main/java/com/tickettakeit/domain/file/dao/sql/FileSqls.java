package com.tickettakeit.domain.file.dao.sql;

public class FileSqls {
    public static final String SELECT_FILE_INFO_BY_ID = "SELECT id, file_name, save_file_name, content_type, delete_flag, create_date, modify_date FROM file_info WHERE id = :fileId";
    public static final String INSERT_FILE_INFO = "INSERT INTO file_info(file_name, save_file_name, content_type, delete_flag, create_date, modify_date) values(:fileName, :saveFileName, :contentType, 0, NOW(), NOW())";
}
