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
import java.util.List;

@WebServlet("/memberList.do")
public class MemberListController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MemberDAO dao = new MemberDAO();
        List<MemberVO> members = dao.memberList();

//        //테스트
//        for (MemberVO member : members) {
//            System.out.println("member = " + member);
//        }

        //view 전달
        response.setContentType("text/html;charset=UTF-8"); //MINE TYPE
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<table border='1'>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>번호</th>");
        out.println("<th>아이디</th>");
        out.println("<th>비밀번호</th>");
        out.println("<th>이름</th>");
        out.println("<th>나이</th>");
        out.println("<th>이메일</th>");
        out.println("<th>전화번호</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        for (MemberVO member : members) {
            out.println("<tr>");
            out.println("<td>" + member.getNumber() + "</td>");
            out.println("<td>" + member.getId() + "</td>");
            out.println("<td>" + member.getPassword() + "</td>");
            out.println("<td>" + member.getName() + "</td>");
            out.println("<td>" + member.getAge() + "</td>");
            out.println("<td>" + member.getEmail() + "</td>");
            out.println("<td>" + member.getPhone() + "</td>");
            out.println("</tr>");
        }

        out.println("</tbody>");
        out.println("<tr>");
        out.println("<td colspan='7' align='right'>");
        out.println("<a href='member/memberRegister.html'>등록</a>");
        out.println("</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
