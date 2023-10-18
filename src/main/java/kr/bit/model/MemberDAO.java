package kr.bit.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    /**
     * MySQL db connection method
     */
    public void getConnect() {
        String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&serverTimeZone=UTC";
        String user = "root";
        String password = "admin12345";

        //MySQL Driver Loading
        try {
            //동적 로딩
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * member insert method
     */
    public int memberInsert(MemberVO vo) {
        String sql = "insert into member(id, password, name, age, email, phone) values(?, ?, ?, ?, ?, ?)";

        getConnect();

        int count = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, vo.getId());
            ps.setString(2, vo.getPassword());
            ps.setString(3, vo.getName());
            ps.setInt(4, vo.getAge());
            ps.setString(5, vo.getEmail());
            ps.setString(6, vo.getPhone());
            //실행
            count = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }

        return count;
    }

    /**
     * member select method
     *
     * @return member list
     */
    public List<MemberVO> memberList() {
        String sql = "select * from member";

        getConnect();

        List<MemberVO> members = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                MemberVO member = new MemberVO();
                member.setNumber(rs.getInt("number"));
                member.setId(rs.getString("id"));
                member.setPassword(rs.getString("password"));
                member.setName(rs.getString("name"));
                member.setAge(rs.getInt("age"));
                member.setEmail(rs.getString("email"));
                member.setPhone(rs.getString("phone"));

                members.add(member);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }

        return members;
    }

    /**
     * disconnect method
     */
    public void disconnect() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
