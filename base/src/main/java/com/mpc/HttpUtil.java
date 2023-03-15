package com.mpc;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class HttpUtil {

    public static String request() throws IOException {
        // 发送http请求
        URL url = new URL("https://baize.crxn.cn/api/yibin/yibinb2c/weixin/getshortlink");
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setRequestMethod("POST");
        httpConn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("sign", "C4C0CB8FB33123C3EF08FD0B775FE95FAAC963B2B0452E0AC66CF943587B1584");
        headerMap.put("timestamp", "1673510842630");



        if(Objects.nonNull(headerMap)){
            Set<String> keySet = headerMap.keySet();
            keySet.forEach(key -> httpConn.setRequestProperty(key,headerMap.get(key)));
        }

        httpConn.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());
        // 请求参数
        writer.write("{\"page_url\": \"pages/product/index?skuId=25890\",\"page_title\": \"海狸拾袋\", \"is_permanent\":false}");
        writer.flush();
        writer.close();
        httpConn.getOutputStream().close();

        // 返回值解析
        InputStream responseStream = httpConn.getResponseCode() / 100 == 2
                ? httpConn.getInputStream()
                : httpConn.getErrorStream();
        Scanner s = new Scanner(responseStream).useDelimiter("\\A");
        String response = s.hasNext() ? s.next() : "";
        System.out.println(response);

        response = response.replaceAll("\\+", "%2B");
        System.out.println(response);
        return response;
    }

    public static void main(String[] args) throws IOException {
        request();
    }



}
