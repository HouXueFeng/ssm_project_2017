package cn.itcast.ssm.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import cn.itcast.ssm.po.User;

/**
 * @author CreateBy HouXueFeng
 * @version 2017年3月14日 上午10:51:23
 * @description 这是一个jackjsondemo
 */
public class JackJsonDemo {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		List<User> list = new ArrayList<User>();
		User user = new User();
		User user1 = new User();

		user.setId(1);
		user.setBirthday(new Date());
		user.setAddress("西安");
		user.setUsername("侯雪枫");
		user.setSex("男");
		user1.setId(2);
		user1.setBirthday(new Date());
		user1.setAddress("河南");
		user1.setUsername("冯帆");
		user1.setSex("男");
		list.add(user);
		list.add(user1);

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(list);
		System.out.println(json);

	}

	public static void readJsonObject() throws JsonParseException, JsonMappingException, IOException {  
	        ObjectMapper mapper = new ObjectMapper();  
	  
	   
	    		List<User> list = (List<User>) mapper.readValue(new File("c:/person.json"),  
	    				User.class);  
	    		
	    		System.out.println(list.get(0).getUsername());
	        
	}   
}
