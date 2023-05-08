package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WifiDbService {

    public void dbInsert(Wifi wifi) {
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

            String sql = "insert into WIFI (X_SWIFI_MGR_NO, X_SWIFI_WRDOFC, X_SWIFI_MAIN_NM, X_SWIFI_ADRES1, X_SWIFI_ADRES2, X_SWIFI_INSTL_FLOOR, X_SWIFI_INSTL_TY, X_SWIFI_INSTL_MBY, X_SWIFI_SVC_SE, X_SWIFI_CMCWR, X_SWIFI_CNSTC_YEAR, X_SWIFI_INOUT_DOOR, X_SWIFI_REMARS3, LAT, LNT, WORK_DTTM)\n" +
                    "value (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,wifi.X_SWIFI_MGR_NO);
            stmt.setString(2,wifi.X_SWIFI_WRDOFC);
            stmt.setString(3,wifi.X_SWIFI_MAIN_NM);
            stmt.setString(4,wifi.X_SWIFI_ADRES1);
            stmt.setString(5,wifi.X_SWIFI_ADRES2);
            stmt.setString(6,wifi.X_SWIFI_INSTL_FLOOR);
            stmt.setString(7,wifi.X_SWIFI_INSTL_TY);
            stmt.setString(8,wifi.X_SWIFI_INSTL_MBY);
            stmt.setString(9,wifi.X_SWIFI_SVC_SE);
            stmt.setString(10,wifi.X_SWIFI_CMCWR);
            stmt.setString(11,wifi.X_SWIFI_CNSTC_YEAR);
            stmt.setString(12,wifi.X_SWIFI_INOUT_DOOR);
            stmt.setString(13,wifi.X_SWIFI_REMARS3);
            stmt.setString(14,wifi.LAT);
            stmt.setString(15,wifi.LNT);
            stmt.setString(16,wifi.WORK_DTTM);

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

    public List<Wifi> list() {
        List<Wifi> wifiList = new ArrayList<>();
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

            String sql =" select X_SWIFI_MGR_NO, X_SWIFI_WRDOFC, X_SWIFI_MAIN_NM, X_SWIFI_ADRES1, X_SWIFI_ADRES2, X_SWIFI_INSTL_FLOOR, X_SWIFI_INSTL_TY, X_SWIFI_INSTL_MBY, X_SWIFI_SVC_SE, X_SWIFI_CMCWR, X_SWIFI_CNSTC_YEAR, X_SWIFI_INOUT_DOOR, X_SWIFI_REMARS3, LAT, LNT, WORK_DTTM " +
                    " from WIFI ";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Wifi wifi = new Wifi();
                wifi.X_SWIFI_MGR_NO = rs.getString("X_SWIFI_MGR_NO");
                wifi.X_SWIFI_WRDOFC = rs.getString("X_SWIFI_WRDOFC");
                wifi.X_SWIFI_MAIN_NM = rs.getString("X_SWIFI_MAIN_NM");
                wifi.X_SWIFI_ADRES1 = rs.getString("X_SWIFI_ADRES1");
                wifi.X_SWIFI_ADRES2 = rs.getString("X_SWIFI_ADRES2");
                wifi.X_SWIFI_INSTL_FLOOR = rs.getString("X_SWIFI_INSTL_FLOOR");
                wifi.X_SWIFI_INSTL_TY = rs.getString("X_SWIFI_INSTL_TY");
                wifi.X_SWIFI_INSTL_MBY = rs.getString("X_SWIFI_INSTL_MBY");
                wifi.X_SWIFI_SVC_SE = rs.getString("X_SWIFI_SVC_SE");
                wifi.X_SWIFI_CMCWR = rs.getString("X_SWIFI_CMCWR");
                wifi.X_SWIFI_CNSTC_YEAR = rs.getString("X_SWIFI_CNSTC_YEAR");
                wifi.X_SWIFI_INOUT_DOOR = rs.getString("X_SWIFI_INOUT_DOOR");
                wifi.X_SWIFI_REMARS3= rs.getString("X_SWIFI_REMARS3");
                wifi.LAT = rs.getString("LAT");
                wifi.LNT = rs.getString("LNT");
                wifi.WORK_DTTM = rs.getString("WORK_DTTM");

                wifiList.add(wifi);
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
        return wifiList;
    }

    public Wifi detail(String X_SWIFI_MGR_NO) {
        Wifi wifi = null;
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
                    " from WIFI "+
                    " where X_SWIFI_MGR_NO = ? ";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,X_SWIFI_MGR_NO);
            rs = stmt.executeQuery();

            if (rs.next()) {
                wifi = new Wifi();
                wifi.X_SWIFI_MGR_NO = rs.getString("X_SWIFI_MGR_NO");
                wifi.X_SWIFI_WRDOFC = rs.getString("X_SWIFI_WRDOFC");
                wifi.X_SWIFI_MAIN_NM = rs.getString("X_SWIFI_MAIN_NM");
                wifi.X_SWIFI_ADRES1 = rs.getString("X_SWIFI_ADRES1");
                wifi.X_SWIFI_ADRES2 = rs.getString("X_SWIFI_ADRES2");
                wifi.X_SWIFI_INSTL_FLOOR = rs.getString("X_SWIFI_INSTL_FLOOR");
                wifi.X_SWIFI_INSTL_TY = rs.getString("X_SWIFI_INSTL_TY");
                wifi.X_SWIFI_INSTL_MBY = rs.getString("X_SWIFI_INSTL_MBY");
                wifi.X_SWIFI_SVC_SE = rs.getString("X_SWIFI_SVC_SE");
                wifi.X_SWIFI_CMCWR = rs.getString("X_SWIFI_CMCWR");
                wifi.X_SWIFI_CNSTC_YEAR = rs.getString("X_SWIFI_CNSTC_YEAR");
                wifi.X_SWIFI_INOUT_DOOR = rs.getString("X_SWIFI_INOUT_DOOR");
                wifi.X_SWIFI_REMARS3= rs.getString("X_SWIFI_REMARS3");
                wifi.LAT = rs.getString("LAT");
                wifi.LNT = rs.getString("LNT");
                wifi.WORK_DTTM = rs.getString("WORK_DTTM");

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
        return wifi;
    }

    public List<Wifi> listNear(String Lat, String Lnt) {
        List<Wifi> wifiList = new ArrayList<>();

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

            String sql = "SELECT *" +
                    " ,round(6371*acos(cos(radians( ? ))*cos(radians(LAT))*cos(radians(LNT)-radians( ? ))+sin(radians( ? ))*sin(radians(LAT))), 4)" +
                    " AS DISTANCE" +
                    " FROM WIFI" +
                    " ORDER BY DISTANCE" +
                    " LIMIT 20;";

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, Lnt);
            stmt.setString(2, Lat);
            stmt.setString(3, Lnt);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Wifi wifi = new Wifi();
                wifi.setDist(rs.getString("DISTANCE"));
                wifi.setX_SWIFI_MGR_NO(rs.getString("X_SWIFI_MGR_NO"));
                wifi.setX_SWIFI_WRDOFC(rs.getString("X_SWIFI_WRDOFC"));
                wifi.setX_SWIFI_MAIN_NM(rs.getString("X_SWIFI_MAIN_NM"));
                wifi.setX_SWIFI_ADRES1(rs.getString("X_SWIFI_ADRES1"));
                wifi.setX_SWIFI_ADRES2(rs.getString("X_SWIFI_ADRES2"));
                wifi.setX_SWIFI_INSTL_FLOOR(rs.getString("X_SWIFI_INSTL_FLOOR"));
                wifi.setX_SWIFI_INSTL_TY(rs.getString("X_SWIFI_INSTL_TY"));
                wifi.setX_SWIFI_INSTL_MBY(rs.getString("X_SWIFI_INSTL_MBY"));
                wifi.setX_SWIFI_SVC_SE(rs.getString("X_SWIFI_SVC_SE"));
                wifi.setX_SWIFI_CMCWR(rs.getString("X_SWIFI_CMCWR"));
                wifi.setX_SWIFI_CNSTC_YEAR(rs.getString("X_SWIFI_CNSTC_YEAR"));
                wifi.setX_SWIFI_INOUT_DOOR(rs.getString("X_SWIFI_INOUT_DOOR"));
                wifi.setX_SWIFI_REMARS3(rs.getString("X_SWIFI_REMARS3"));
                wifi.setLAT(rs.getString("LAT"));
                wifi.setLNT(rs.getString("LNT"));
                wifi.setWORK_DTTM(rs.getString("WORK_DTTM"));

                wifiList.add(wifi);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (stmt != null && !stmt.isClosed()) {
                    stmt.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return wifiList;
    }

}
