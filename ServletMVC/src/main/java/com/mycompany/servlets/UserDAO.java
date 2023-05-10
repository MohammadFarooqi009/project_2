package com.mycompany.servlets;

import java.sql.SQLException;

public interface UserDAO {
    User findByEmail(String email) throws SQLException;
    void save(User user) throws SQLException;
}
