package com.hanx.controller;

import com.hanx.dao.UserDAO;
import com.hanx.entity.User;
import netscape.javascript.JSObject;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class UserAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName,userPwd;
        userName = req.getParameter("uname");
        userPwd = req.getParameter("upwd");

        User user = new User(userName, userPwd);
        int cnt = UserDAO.addUser(user);
//        String show = cnt==0 ? "fail" : "success";

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",cnt);
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json;charset=UTF-8");
//        resp.setCharacterEncoding("UTF-8");
        out.print(jsonObject);
        out.flush();
    }
}
