package kr.bit.practice.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/h.do") /* mapping */
public class HelloStart extends HttpServlet {

    //1.클라이언트 요청을 받는 작업 => controller(servlet)
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //2.처리 작업 => model(java class)
        int sum = 0;

        for (int i = 1; i <= 100; i++) {
            sum += i;
        }

        //3.응답 작업 => view(jsp)
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println(sum);
        out.println("</body>");
    }
}