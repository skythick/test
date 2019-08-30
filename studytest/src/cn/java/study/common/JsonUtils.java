package cn.java.study.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonUtils {
	/**
	 * 把一个JSONArray 中的空参数字段进行移除
	 * @param jsonarr
	 * @return
	 */
	public static JSONArray removeNullElem(JSONArray jsonarr){
		for (int i = 0; i < jsonarr.size(); i++) {
			List<Object> keylist = new ArrayList<Object>();
			JSONObject jsono = (JSONObject) jsonarr.get(i);
			Set<Object> ojset = jsono.keySet();
			for (Object key : ojset) {
				String value = jsono.get(key).toString();
				if(value.isEmpty()||value.trim().equals("")){
					keylist.add(key);
				}
			}
			for (int j = 0; j < keylist.size(); j++) {
				jsono.remove(keylist.get(j));
			}
		}
		return jsonarr;
	}
	
	/**
	 * 给出一个list 把list中的空字段移除，并转化为JSONArray
	 * @param list
	 * @return
	 */
	public static <T> JSONArray removeNullBean(List<T> list){
		JSONArray jsonarr = JSONArray.fromObject(list);
		removeNullElem(jsonarr);
		return jsonarr;
	}

}
