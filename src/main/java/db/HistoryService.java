package db;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class HistoryService {
    public void historyInsert(History history) {
        String url = "jdbc:mariadb://localhost:3306/wifiinfo";
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

            String sql = "insert into WIFIHISTORY (LAT, LNT, SEARCHDATE)\n" +
                    "value (?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,history.getLat());
            stmt.setString(2,history.getLnt());
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

    public List<History> historyWifiList() {
        List<History> historyWifiList = new ArrayList<>();

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
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, id, pw);

            String sql =" select * " +
                    " from WIFIHISTORY "+
                    " order by ID desc ";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int historyId = rs.getInt("ID");
                String lat = rs.getString("LNT");
                String lnt = rs.getString("LAT");
                String searchDate = rs.getString("SEARCHDATE");

                History historyWifi = new History();
                historyWifi.setId(historyId);
                historyWifi.setLat(lnt);
                historyWifi.setLnt(lat);
                historyWifi.setSearchDate(searchDate);

                historyWifiList.add(historyWifi);
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
        return historyWifiList;
    }

    public void delete(int historyId) {
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

            String sql =" DELETE FROM WIFIHISTORY " +
                    " WHERE ID = ? ";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, historyId);

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
