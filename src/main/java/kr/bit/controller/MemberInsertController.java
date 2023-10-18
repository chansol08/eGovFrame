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

@WebServlet("/memberInsert.do")
public class MemberInsertController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //요청 바인딩
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        //MemberVO vo = new MemberVO(id, password, name, age, email, phone);
        MemberVO vo = new MemberVO();
        vo.setId(id);
        vo.setPassword(password);
        vo.setName(name);
        vo.setAge(age);
        vo.setEmail(email);
        vo.setPhone(phone);

        //System.out.println(vo);

        //db 저장
        MemberDAO dao = new MemberDAO();
        int count = dao.memberInsert(vo);

        if (count > 0) {
//            PrintWriter out = response.getWriter();
//            out.println("insert success!");
            response.sendRedirect("/memberList.do");
        } else {
            throw new ServletException("not insert");
        }
    }
}
