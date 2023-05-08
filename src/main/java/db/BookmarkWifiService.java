package db;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class BookmarkWifiService {
    public void insert(String wifiMgrNo, int bookmarkGroupId) {
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

            String sql = "INSERT INTO WIFIBOOKMARK(BOOKMARKGRID, BMWIFINO, REGISTERDATE) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, bookmarkGroupId);
            stmt.setString(2,wifiMgrNo);
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

    public List<BookmarkWifi> getAllBookmark() {
        List<BookmarkWifi> bookmarklist = null;

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
            bookmarklist = new ArrayList<>();
            conn = DriverManager.getConnection(url, id, pw);

            String sql = "SELECT BM.BOOKMARKID, BM.BOOKMARKGRID, WF.X_SWIFI_MGR_NO, BMG.BOOKMARKNAME, WF.X_SWIFI_MAIN_NM, BM.REGISTERDATE" +
                    " FROM WIFIBOOKMARK BM" +
                    " JOIN WIFI WF" +
                    " ON BM.BMWIFINO = WF.X_SWIFI_MGR_NO" +
                    " LEFT OUTER JOIN BOOKMARKGROUP BMG" +
                    " ON BM.BOOKMARKGRID = BMG.BOOKMARKID";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                BookmarkWifi bookmark = new BookmarkWifi();
                bookmark.setId(rs.getInt("BOOKMARKID"));
                bookmark.setBookmarkgroupId(rs.getInt("BOOKMARKGRID"));
                bookmark.setWifiNo(rs.getString("X_SWIFI_MGR_NO"));
                bookmark.setWifiName(rs.getString("X_SWIFI_MAIN_NM"));
                bookmark.setBookmarkName(rs.getString("BOOKMARKNAME"));
                bookmark.setRegisterDate(rs.getString("REGISTERDATE"));

                bookmarklist.add(bookmark);
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
        return bookmarklist;
    }

    public BookmarkWifi getBookmark(int bmid) {

        BookmarkWifi bookmark = null;
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

            String sql = "SELECT BM.BOOKMARKID, BM.BOOKMARKGRID, WF.X_SWIFI_MGR_NO, BMG.BOOKMARKNAME, WF.X_SWIFI_MAIN_NM, BM.REGISTERDATE" +
                    " FROM WIFIBOOKMARK BM" +
                    " JOIN WIFI WF" +
                    " ON BM.BMWIFINO = WF.X_SWIFI_MGR_NO" +
                    " JOIN BOOKMARKGROUP BMG" +
                    " ON BM.BOOKMARKGRID = BMG.BOOKMARKID" +
                    " WHERE BM.BOOKMARKID = ? ";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,bmid);
            rs = stmt.executeQuery();

            if (rs.next()) {
                bookmark = new BookmarkWifi();
                bookmark.setId(rs.getInt("BOOKMARKID"));
                bookmark.setBookmarkgroupId(rs.getInt("BOOKMARKGRID"));
                bookmark.setWifiName(rs.getString("X_SWIFI_MAIN_NM"));
                bookmark.setBookmarkName(rs.getString("BOOKMARKNAME"));
                bookmark.setRegisterDate(rs.getString("REGISTERDATE"));

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
        return bookmark;
    }

    public void delete(int bmid) {
        String url = "jdbc:mariadb://localhost:3306/wifiinfo";
        String id = "wifiuser";
        String pw = "zerobase";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로드 실패");
        }
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(url, id, pw);

            String sql =" DELETE FROM WIFIBOOKMARK " +
                    " WHERE BOOKMARKID = ? ";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, bmid);

            int affected = stmt.executeUpdate();

            if(affected > 0) {
//                System.out.println("삭제 성공");
            }
            else {
                System.out.println("삭제 실패");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
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
