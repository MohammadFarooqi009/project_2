package com.mycompany.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mycompany.utils.DatabaseUtils;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            String errorMessage = "Please provide an email and a password";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        try (Connection conn = DatabaseUtils.getConnection()) {
            String countSql = "SELECT COUNT(*) FROM users WHERE email = ?";
            PreparedStatement countStatement = conn.prepareStatement(countSql);
            countStatement.setString(1, email);
            ResultSet resultSet = countStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);

            if (count > 0) {
                // email already exists, redirect back to register.jsp
                response.sendRedirect("register.jsp");
            } else {
                // email does not exist, insert new row
                String insertSql = "INSERT INTO users (email, password) VALUES (?, ?)";
                PreparedStatement insertStatement = conn.prepareStatement(insertSql);
                insertStatement.setString(1, email);
                insertStatement.setString(2, password);
                insertStatement.executeUpdate();

                HttpSession session = request.getSession();
                session.setAttribute("email", email);
                session.setAttribute("password", password);
                response.sendRedirect("index.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("register.jsp");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}
