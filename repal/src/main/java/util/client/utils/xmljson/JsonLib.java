package util.client.utils.xmljson;



import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.*;

/***
 * jsonlib工具类
 * 
 * @author jannal
 */
public class JsonLib {
	/**
	 * json转成成Object对象
	 * 
	 * @param json
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T json2Obj(String json, Class<T> clazz) {
		JSONObject jsonObject = JSONObject.fromObject(json);
		return (T) JSONObject.toBean(jsonObject, clazz);
	}

	/**
	 * 
	 * @param json
	 * @param clazz object类名
	 * @param classMap object类的泛型
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T json2Obj(String json, Class<T> clazz, Map<String, Class> classMap) {
		JSONObject jsonObject = JSONObject.fromObject(json);
		return (T) JSONObject.toBean(jsonObject, clazz, classMap);
	}
    

      
/*    *//**
     * 转json为list 
     *@author oliver
     *@time 2015年2月10日 上午11:19:09
     *//*
    public static Map<String, Object> parseJSON2Map(String jsonStr){  
        Map<String, Object> map = new HashMap<String, Object>();  
        //最外层解析  
        JSONObject json = JSONObject.fromObject(jsonStr);  
        for(Object k : json.keySet()){  
            Object v = json.get(k);   
            //如果内层还是数组的话，继续解析  
            if(v instanceof JSONArray){  
                List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();  
                Iterator<JSONObject> it = ((JSONArray)v).iterator();  
                while(it.hasNext()){  
                    JSONObject json2 = it.next();  
                    list.add(parseJSON2Map(json2.toString()));  
                }  
                map.put(k.toString(), list);  
            } else if(v.toString().startsWith("{")){
            	parseJSON2Map(v.toString());
            } else{
                map.put(k.toString(), v);  
            }
        }  
        return map;  
    }
    
    
    
    public static List<Map<String, Object>> parseJSON2List(String jsonStr){  
        JSONArray jsonArr = JSONArray.fromObject(jsonStr);  
        List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();  
        Iterator<JSONObject> it = jsonArr.iterator();  
        while(it.hasNext()){  
            JSONObject json2 = it.next();  
            list.add(parseJSON2Map(json2.toString()));  
        }  
        return list;  
    }  */
      
    /**
     * 转json为list 
     *@author oliver
     *@time 2015年2月10日 上午11:19:09
     */

    public static List<Map<String, Object>> parseJSON2List(String jsonStr,Map<String,Object> map){  
        JSONArray jsonArr = JSONArray.fromObject(jsonStr);
        List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();  
        Iterator<JSONObject> it = jsonArr.iterator();  
        while(it.hasNext()){  
            JSONObject json2 = it.next();  
            list.add(parseJSON2Map(json2.toString(),map));  
        }  
        return list;  
    }  
    
    /**
     * 转json为map
     *@author oliver
     *@time 2015年2月10日 上午11:18:51
     */
    public static Map<String, Object> parseJSON2Map(String jsonStr,Map<String,Object> map){    
        //最外层解析  
        JSONObject json = JSONObject.fromObject(jsonStr);  
        for(Object k : json.keySet()){  
            Object v = json.get(k);   
            //如果内层还是数组的话，继续解析  
            if(v instanceof JSONArray){  
                List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();  
                Iterator<JSONObject> it = ((JSONArray)v).iterator();  
                while(it.hasNext()){  
                    JSONObject json2 = it.next();  
                    list.add(parseJSON2Map(json2.toString(),map));  
                }  
                map.put(k.toString(), list);  
            } else if(v.toString().startsWith("{")){
            	parseJSON2Map(v.toString(),map);
            } else{
                map.put(k.toString(), v);  
            }
        }  
        return map;  
    }
    
    /**
     * 返回map
     *@author oliver
     *@time 2015年2月10日 下午1:29:34
     */
	public static Map<String, Object> getJsonMap(String json) {
		Map<String,Object> map = new HashMap<String,Object>();
		parseJSON2Map(json,map);
		return map;
	}
	public static void main(String[] args){
	    String j = "{'hmac':'cba9f9181e299c4ab0447d1e989f95585ba89324','params':{'loginName':'15210761741'}}";
	    j= "18511634065";
	    Map m = getJsonMap(j);
	    System.out.println(m.get("loginName"));
	}
}
