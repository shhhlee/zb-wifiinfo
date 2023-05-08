package db;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class WifiDbMain {

    int apisize = 10000001;
    public void wifiDataInsert() {
        WifiDbService wifiDbService = new WifiDbService();
        try {
            int start = 1;
            while (start <= apisize) {
                int end = start+999;
                String url = "http://openapi.seoul.go.kr:8088/524262524b646c7437334472754856/json/TbPublicWifiInfo/"+start+"/"+end+"/";

                OkHttpClient client = new OkHttpClient();

                Request.Builder builder = new Request.Builder().url(url).get();
                builder.addHeader("password","123");
                Request request = builder.build();

                Response response = client.newCall(request).execute();
                if (response.isSuccessful()) {
                    ResponseBody body = response.body();
                    if (body != null) {
                        String s = body.string();
                        Object obj = JSONValue.parse(s);
                        JSONObject jObj = (JSONObject) obj;
                        JSONObject obj1 = (JSONObject) jObj.get("TbPublicWifiInfo");
                        String size = obj1.get("list_total_count").toString();
                        apisize = Integer.parseInt(size);
                        JSONArray obj3 = (JSONArray) obj1.get("row");
                        for (int i = 0; i < obj3.size(); i++) {
                            JSONObject object = (JSONObject) obj3.get(i);
                            String X_SWIFI_MGR_NO = object.get("X_SWIFI_MGR_NO").toString();
                            String X_SWIFI_WRDOFC = object.get("X_SWIFI_WRDOFC").toString();
                            String X_SWIFI_MAIN_NM = object.get("X_SWIFI_MAIN_NM").toString();
                            String X_SWIFI_ADRES1 = object.get("X_SWIFI_ADRES1").toString();
                            String X_SWIFI_ADRES2 = object.get("X_SWIFI_ADRES2").toString();
                            String X_SWIFI_INSTL_FLOOR = object.get("X_SWIFI_INSTL_FLOOR").toString();
                            String X_SWIFI_INSTL_TY = object.get("X_SWIFI_INSTL_TY").toString();
                            String X_SWIFI_INSTL_MBY = object.get("X_SWIFI_INSTL_MBY").toString();
                            String X_SWIFI_SVC_SE = object.get("X_SWIFI_SVC_SE").toString();
                            String X_SWIFI_CMCWR = object.get("X_SWIFI_CMCWR").toString();
                            String X_SWIFI_CNSTC_YEAR = object.get("X_SWIFI_CNSTC_YEAR").toString();
                            String X_SWIFI_INOUT_DOOR = object.get("X_SWIFI_INOUT_DOOR").toString();
                            String X_SWIFI_REMARS3 = object.get("X_SWIFI_REMARS3").toString();
                            String LAT = object.get("LAT").toString();
                            String LNT = object.get("LNT").toString();
                            String WORK_DTTM = object.get("WORK_DTTM").toString();

                            Wifi wifi = new Wifi();
                            wifi.setX_SWIFI_MGR_NO(X_SWIFI_MGR_NO);
                            wifi.setX_SWIFI_WRDOFC(X_SWIFI_WRDOFC);
                            wifi.setX_SWIFI_MAIN_NM(X_SWIFI_MAIN_NM);
                            wifi.setX_SWIFI_ADRES1(X_SWIFI_ADRES1);
                            wifi.setX_SWIFI_ADRES2(X_SWIFI_ADRES2);
                            wifi.setX_SWIFI_INSTL_FLOOR(X_SWIFI_INSTL_FLOOR);
                            wifi.setX_SWIFI_INSTL_TY(X_SWIFI_INSTL_TY);
                            wifi.setX_SWIFI_INSTL_MBY(X_SWIFI_INSTL_MBY);
                            wifi.setX_SWIFI_SVC_SE(X_SWIFI_SVC_SE);
                            wifi.setX_SWIFI_CMCWR(X_SWIFI_CMCWR);
                            wifi.setX_SWIFI_CNSTC_YEAR(X_SWIFI_CNSTC_YEAR);
                            wifi.setX_SWIFI_INOUT_DOOR(X_SWIFI_INOUT_DOOR);
                            wifi.setX_SWIFI_REMARS3(X_SWIFI_REMARS3);
                            wifi.setLAT(LAT);
                            wifi.setLNT(LNT);
                            wifi.setWORK_DTTM(WORK_DTTM);

                            wifiDbService.dbInsert(wifi);
                        }
                    }
                } else
                    System.err.println("Error Occurred");
                start += 1000;

            }
            System.out.println("저장끝");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
