package db;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class BookmarkGroupService {
    public void bookmarkGroupInsert(BookmarkGroup bookmarkGroup) {
        String url = "jdbc:mariadb://localhost:3306/wifiinfo?useUnicode=true&characterEncoding=UTF-8";
        String id = "wifiuser";
        String pw = "zerobase";

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.KOREA);

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로드 실패");
        }
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, id, pw);

            String sql = "insert into BOOKMARKGROUP(BOOKMARKNAME, SEQ, REGISTERDATE)\n" +
                    "value (?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, bookmarkGroup.getBookmarkName());
            stmt.setInt(2,bookmarkGroup.getSeq());
            stmt.setString(3,dateFormat.format(new Date()));

            int affected = stmt.executeUpdate();

            if(affected > 0) {
//                System.out.println("저장 성공");
            }
            else {
                System.out.println("저장 실패");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (stmt != null)
                    stmt.close();
                if(conn != null)
                    conn.close();
            } catch (SQLException e) {
                System.out.println("conn.close() 에러");
            }
        }
    }

    public List<BookmarkGroup> list() {
        List<BookmarkGroup> bookmarkGroupList = new ArrayList<>();

        String url = "jdbc:mariadb://localhost:3306/wifiinfo?useUnicode=true&characterEncoding=UTF-8";
        String id = "wifiuser";
        String pw = "zerobase";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로드 실패");
        }
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, id, pw);

            String sql =" select * " +
                    " from BOOKMARKGROUP "+
                    " order by BOOKMARKID ";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int bookmarkgroupId = rs.getInt("BOOKMARKID");
                String bookmarkname = rs.getString("BOOKMARKNAME");
                int seq = rs.getInt("SEQ");
                String registerDate = rs.getString("REGISTERDATE");

                BookmarkGroup bg = new BookmarkGroup();
                bg.setId(bookmarkgroupId);
                bg.setBookmarkName(bookmarkname);
                bg.setSeq(seq);
                bg.setRegisterDate(registerDate);
                if(rs.getString("EDITDATE") != null && !rs.getString("EDITDATE").isEmpty()) {
                    bg.setEditDate(rs.getString("EDITDATE"));
                }

                bookmarkGroupList.add(bg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if(conn != null)
                    conn.close();
            } catch (SQLException e) {
                System.out.println("conn.close() 에러");
            }
        }
        return bookmarkGroupList;
    }

    public BookmarkGroup getBookmarkGroup(int bgid) {
        BookmarkGroup bookmarkGroup = null;

        String url = "jdbc:mariadb://localhost:3306/wifiinfo?useUnicode=true&characterEncoding=UTF-8";
        String id = "wifiuser";
        String pw = "zerobase";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로드 실패");
        }
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, id, pw);

            String sql =" select * " +
                    " from BOOKMARKGROUP "+
                    " where BOOKMARKID = ? ";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,bgid);
            rs = stmt.executeQuery();

            if (rs.next()) {
                bookmarkGroup = new BookmarkGroup();
                int bookmarkgroupId = rs.getInt("BOOKMARKID");
                String bookmarkname = rs.getString("BOOKMARKNAME");
                int seq = rs.getInt("SEQ");
                String registerDate = rs.getString("REGISTERDATE");

                bookmarkGroup.setId(bookmarkgroupId);
                bookmarkGroup.setBookmarkName(bookmarkname);
                bookmarkGroup.setSeq(seq);
                bookmarkGroup.setRegisterDate(registerDate);
                if(rs.getString("EDITDATE") != null && !rs.getString("EDITDATE").isEmpty()) {
                    bookmarkGroup.setEditDate(rs.getString("EDITDATE"));
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if(conn != null)
                    conn.close();
            } catch (SQLException e) {
                System.out.println("conn.close() 에러");
            }
        }
        return bookmarkGroup;

    }

    public void delete(int bgid) {
        String url = "jdbc:mariadb://localhost:3306/wifiinfo?useUnicode=true&characterEncoding=UTF-8";
        String id = "wifiuser";
        String pw = "zerobase";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로드 실패");
        }
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, id, pw);

            String sql =" DELETE FROM BOOKMARKGROUP where BOOKMARKID = ? ";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,bgid);

            int affected = stmt.executeUpdate();

            if(affected > 0) {
//                System.out.println("삭제 성공");
            }
            else {
                System.out.println("삭제 실패");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if(conn != null)
                    conn.close();
            } catch (SQLException e) {
                System.out.println("conn.close() 에러");
            }
        }
    }

    public void edit(BookmarkGroup bookmarkGroup) {
        String url = "jdbc:mariadb://localhost:3306/wifiinfo?useUnicode=true&characterEncoding=UTF-8";
        String id = "wifiuser";
        String pw = "zerobase";

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.KOREA);


        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로드 실패");
        }
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, id, pw);

            String sql = "UPDATE BOOKMARKGROUP" +
                    " SET BOOKMARKNAME  = ?," +
                    "     SEQ = ?," +
                    "     EDITDATE = ?" +
                    " WHERE BOOKMARKID = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, bookmarkGroup.getBookmarkName());
            stmt.setInt(2,bookmarkGroup.getSeq());
            stmt.setString(3,dateFormat.format(new Date()));
            stmt.setInt(4,bookmarkGroup.getId());

            int affected = stmt.executeUpdate();

            if(affected > 0) {
//                System.out.println("수정 성공");
            }
            else {
                System.out.println("수정 실패");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if(conn != null)
                    conn.close();
            } catch (SQLException e) {
                System.out.println("conn.close() 에러");
            }
        }
    }

}
