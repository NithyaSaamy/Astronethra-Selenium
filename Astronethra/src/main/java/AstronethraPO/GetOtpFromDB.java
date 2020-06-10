package AstronethraPO;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

public class GetOtpFromDB {
	private final CloseableHttpClient httpclient = HttpClients.createDefault();
	String Otp = null;
	public static Logger log = Logger.getLogger(GetOtpFromDB.class);
	
	public String sendGet(String Mobilenumber, String CountryCode) throws Exception 
	{
		log.info("inside getOtp from DB");
		//String finalURL= "http://localhost:8085/OtpServlet/GetOtpFromDB?Mobilenumber="+Mobilenumber+"&CountryCode="+CountryCode;
		String finalURL= "http://localhost:8014/OtpServlet/GetOtpFromDB?Mobilenumber="+Mobilenumber+"&CountryCode="+CountryCode;
		HttpGet request = new HttpGet(finalURL) ;
		log.info(request);

		try (CloseableHttpResponse response = httpclient.execute(request)) {
			log.info(response.getStatusLine().toString());
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String result = EntityUtils.toString(entity);
				log.info(result);
				JSONObject requestObj = JSONObject.fromObject(result);
				log.info("requestObj :"+requestObj);
				JSONObject results = requestObj.getJSONObject("json");
				log.info("results :"+results);
				JSONObject responseobjects = results.getJSONObject("response");
				log.info("response :" + responseobjects);
				Otp = responseobjects.getString("Otp");
				log.info("statusmessage from response :" +Otp);	             
			}

		}catch(Exception e) {
			log.info(e);
		}
		return Otp;

	}

}

