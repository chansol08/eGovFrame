package kr.bit.controller;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/memberContent.do")
public class MemberContentController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int number = Integer.parseInt(request.getParameter("number"));

        MemberDAO dao = new MemberDAO();
        MemberVO member = dao.memberContent(number);

        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
        out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>");
        out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js'></script>");
        out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action='/memberUpdate.do' method='post'>");
        out.println("<input type='hidden' name='number' value='" + member.getNumber() + "'>");
        out.println("<table class='table table-bordered'>");

        if (member != null) {
            out.println("<tr>");
            out.println("<td colspan='2'>" + member.getName() + " 회원의 상세보기</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>번호</td>");
            out.println("<td>" + member.getNumber() + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>아이디</td>");
            out.println("<td>" + member.getId() + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>비밀번호</td>");
            out.println("<td>" + member.getPassword() + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>이름</td>");
            out.println("<td>" + member.getName() + "</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>나이</td>");
            out.println("<td><input type='text' name='age' value='" + member.getAge() + "'</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>이메일</td>");
            out.println("<td><input type='text' name='email' value='" + member.getEmail() + "'</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>전화번호</td>");
            out.println("<td><input type='text' name='phone' value='" + member.getPhone() + "'</td>");
            out.println("</tr>");
        } else {
            out.println("<tr>");
            out.println("<td>일치하는 회원이 없습니다.</td>");
            out.println("</tr>");
        }

        out.println("<tr>");
        out.println("<td colspan='2' align='center'>");
        out.println("<input class='btn btn-primary' type='submit' value='수정하기'>");
        out.println("<input class='btn btn-warning' type='reset' value='취소'>");
        out.println("<a href='/memberList.do'>리스트</a>");
        out.println("</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
