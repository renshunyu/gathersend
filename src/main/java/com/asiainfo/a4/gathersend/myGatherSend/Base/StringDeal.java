/**
 * 
 */
package com.asiainfo.a4.gathersend.myGatherSend.Base;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * @author rensy
 *
 */
public class StringDeal {
	static Logger log =Logger.getLogger(StringDeal.class);
	public static String strdeal(String str){
		Date date = new Date();
	    SimpleDateFormat formater = new SimpleDateFormat();
	    formater.applyPattern("yyyy-MM-dd HH:mm:ss");
		String shijian = formater.format(date);
	    log.info(shijian);
		str = str.replaceAll("<OPERATE_TIME>.*?</OPERATE_TIME>", "<OPERATE_TIME>" + shijian + "</OPERATE_TIME>");
		str = str.replaceAll("<IDR_CREATION_TIME>.*?</IDR_CREATION_TIME>", "<IDR_CREATION_TIME>" + shijian + "</IDR_CREATION_TIME>");
		str = str.replaceAll("<SESSION_BEGIN_TIME>.*?</SESSION_BEGIN_TIME>", "<SESSION_BEGIN_TIME>"+shijian+"</SESSION_BEGIN_TIME>");
		str = str.replaceAll("<SESSION_END_TIME>.*?</SESSION_END_TIME>", "<SESSION_END_TIME>"+shijian+"</SESSION_END_TIME>");
		return str;
		
	}
	public static String strdeal(String str,String acct){
		Date date = new Date();
		SimpleDateFormat formater = new SimpleDateFormat();
		formater.applyPattern("yyyy-MM-dd HH:mm:ss");
		String shijian = formater.format(date);
		log.info(shijian+"开始");
		str = str.replaceAll("<MAIN_ACCOUNT_NAME>.*?</MAIN_ACCOUNT_NAME>", "<MAIN_ACCOUNT_NAME>" + acct + "</MAIN_ACCOUNT_NAME>");
		str = str.replaceAll("<OPERATE_TIME>.*?</OPERATE_TIME>", "<OPERATE_TIME>" + shijian + "</OPERATE_TIME>");
		str = str.replaceAll("<IDR_CREATION_TIME>.*?</IDR_CREATION_TIME>", "<IDR_CREATION_TIME>" + shijian + "</IDR_CREATION_TIME>");
		str = str.replaceAll("<SESSION_BEGIN_TIME>.*?</SESSION_BEGIN_TIME>", "<SESSION_BEGIN_TIME>"+shijian+"</SESSION_BEGIN_TIME>");
		str = str.replaceAll("<SESSION_END_TIME>.*?</SESSION_END_TIME>", "<SESSION_END_TIME>"+shijian+"</SESSION_END_TIME>");
		log.info(shijian+"结束");
		return str;

	}
	
	public static String strdeal2(String str){
		str = str.replaceAll("<ROOT>","");
		str = str.replaceAll("</ROOT>","");
		str = str.replaceAll("<?xml version=\"1.0\" encoding=\"UTF-8\"?>","");
		str = str.replaceAll("<\\?xml version=\"1\\.0\" encoding=\"UTF-8\"\\?>","");
		return str;
	}
	
	public static String strdeal3(String str){
		str = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "<ROOT>" + str + "</ROOT>";
		return str;
	}
}
