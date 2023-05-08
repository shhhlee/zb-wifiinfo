package db;

public class BookmarkWifi {
    private int id;
    private String wifiName;
    private String bookmarkName;
    private int bookmarkgroupId;
    private String wifiNo;
    private String registerDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWifiName() {
        return wifiName;
    }

    public void setWifiName(String wifiName) {
        this.wifiName = wifiName;
    }

    public String getBookmarkName() {
        return bookmarkName;
    }

    public void setBookmarkName(String bookmarkName) {
        this.bookmarkName = bookmarkName;
    }

    public int getBookmarkgroupId() {
        return bookmarkgroupId;
    }

    public void setBookmarkgroupId(int bookmarkgroupId) {
        this.bookmarkgroupId = bookmarkgroupId;
    }

    public String getWifiNo() {
        return wifiNo;
    }

    public void setWifiNo(String wifiNo) {
        this.wifiNo = wifiNo;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }
}
