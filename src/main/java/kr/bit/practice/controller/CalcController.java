package kr.bit.practice.controller;

import kr.bit.practice.model.MyCalc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc.do")
public class CalcController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //요청 정보 바인딩
        int number1 = Integer.parseInt(request.getParameter("number1"));
        int number2 = Integer.parseInt(request.getParameter("number2"));
/*
        //기대 동작 수행 => model 분리
        int sum = 0;

        for (int i = number1; i < number2; i++) {
            sum += i;
        }
*/
        //기대 동작 수행
        MyCalc myCal = new MyCalc();
        int sum = myCal.sum(number1, number2);

        //결과 응답
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<td>TOTAL</td>");
        out.println("<td>");
        out.println(sum);
        out.println("</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
