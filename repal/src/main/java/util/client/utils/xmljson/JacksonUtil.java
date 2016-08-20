package util.client.utils.xmljson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JacksonUtil {

	/**
	 * json转java对象
	 * 
	 * @param args
	 */
	public static <T> T json2Obj(String json, Class<T> t) {
		ObjectMapper objectMapper = new ObjectMapper();
		T obj = null;
		try {
			obj = objectMapper.readValue(json, t);
			//System.out.println("readJson2Entity=" + obj);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return obj;
	}

	/**
	 * java对象转json字符串
	 * 
	 * @param args
	 */
	public static String obj2Json(Object obj) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = null;
		try {
			json = objectMapper.writeValueAsString(obj);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println("obj2Json=" + json);
		return json;
	}

	public static JSONObject obj2JSON(Object obj) {
		return JSON.parseObject(obj2Json(obj));
	}

}
