package com.qrms.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.MessageFormat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * desctription: This class is to query on google map according to the city.
 * @author Yinshunming & Zhangzu
 *
 * @vertion 3.0
 * 
 * modify 1: Yinshunming & Zhangzu 
 * description: transplant from google map V2
 *         to V3
 * 
 * modify 2: Yinshunming & Wangxing 
 * description: this method is dropped
 */
public class QueryLL {

	/**
	 *description:the main method in the QueryLL class.It mainly to achieve the
	 * longtitude and latitude of the giving city.
	 * 
	 * @param String
	 * @return Stirng
	 */
	public static Double[] QueryCity(String city) {
		String address = city;
		String ret = "";
		if (address != null && !address.equals("")) {
			try {
				address = URLEncoder.encode(address, "UTF-8");// 进行这一步是为了避免乱码
			} catch (UnsupportedEncodingException e1) {

			}
			String[] options = new String[4];
			options[0] = "json";
			options[1] = address;
			options[2] = "false";
			String url = MessageFormat
					.format(
							"http://maps.google.com/maps/api/geocode/{0}?address={1}&sensor={2}",
							options);
			URL urlmy = null;
			try {
				urlmy = new URL(url);
				HttpURLConnection con = (HttpURLConnection) urlmy
						.openConnection();
				con.setFollowRedirects(true);
				con.setInstanceFollowRedirects(false);
				con.connect();
				BufferedReader br = new BufferedReader(new InputStreamReader(
						con.getInputStream(), "UTF-8"));
				String s = "";
				StringBuffer sb = new StringBuffer("");
				while ((s = br.readLine()) != null) {
					sb.append(s + "\r\n");
				}
				ret = "" + sb;
			} catch (MalformedURLException e) {
			} catch (IOException e) {

			}
		}
		JSONObject result = null;
		JSONArray jarr = null;
		Double[] rets = null;
		try {
			result = new JSONObject(ret);

			jarr = result.getJSONArray("results");
			JSONObject jo = (JSONObject) jarr.get(0); // 从数组中得到JSONObject对象
			rets = new Double[2];
			rets[0] = Double.valueOf(jo.getJSONObject("geometry")
					.getJSONObject("location").getDouble("lat"));
			rets[1] = Double.valueOf(jo.getJSONObject("geometry")
					.getJSONObject("location").getDouble("lng"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rets;
	}

}
