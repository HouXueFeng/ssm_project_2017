package cn.itcast.ssm.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

			/**
			Byhouxuefeng
			2017年3月6日
			日期类型
			*/
public class CustomDateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String source) {
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			return formatter.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
