package honeybee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C28JDBC {
    private static String selectBookSQL = "select * from newbooks where title like ? order by bookno desc ";

    public static void main(String[] args) {
        // newbooks 테이블에서 도서명에 'IT CookBook'이 포함된 레코드 조회
        List<Book> bookdata = new ArrayList<>();

        // 검색할 도서명을 입력받음
        Scanner sc = new Scanner(System.in);
        System.out.println("조회할 도서명은?");
        String findbook = sc.nextLine();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = C31JDBCUtil.makeConn();
            pstmt = conn.prepareStatement(selectBookSQL);
            pstmt.setString(1,"%"+findbook+"%");

            // SQL문 실행후 결과집합 받음
            rs = pstmt.executeQuery();  // DML 실행시 사용

            while(rs.next()){
                Book book = new Book(rs.getInt(1),rs.getString(2)
                        ,rs.getString(3),rs.getInt(4), rs.getString(5));
                bookdata.add(book);
            }

        } catch (SQLException e) {
            System.out.println("db 주소나 아이디/비밀번호를 확인하세요");
        }finally {
             C31JDBCUtil.closeConn(rs,pstmt,conn);
        }

        for (Book b : bookdata) {
            System.out.println(b);
        }
    }
}
class Book2 {
    private int bookno;
    private String title;
    private String writer;
    private int price;
    private String regdate;
    public Book2() {}
    public Book2(int bookno, String title, String writer, int price, String regdate) {
        this.bookno = bookno;
        this.title = title;
        this.writer = writer;
        this.price = price;
        this.regdate = regdate;
    }

    public int getBookno() {
        return bookno;
    }

    public String getTitle() {
        return title;
    }

    public String getWriter() {
        return writer;
    }

    public int getPrice() {
        return price;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setBookno(int bookno) {
        this.bookno = bookno;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        String fmt = "%d %s %s %d %s";
        return String.format(fmt,bookno,title,writer,price,regdate);
    }
}