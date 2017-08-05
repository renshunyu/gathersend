package com.asiainfo.a4.gathersend.myGatherSend.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;








import org.apache.log4j.Logger;

import com.asiainfo.a4.gathersend.myGatherSend.Base.FileToList;
import com.asiainfo.a4.gathersend.myGatherSend.Base.FileToString;
import com.asiainfo.a4.gathersend.myGatherSend.Base.SendLogOper;
import com.asiainfo.a4.gathersend.myGatherSend.Base.StringDeal;
import com.asiainfo.a4.gathersend.myGatherSend.Base.sendConfig;
import com.asiainfo.a4.gathersend.myGatherSend.Interface.SendInterface;

public class mySend2 implements SendInterface{
	Logger log =Logger.getLogger(mySend2.class);
	File fi=null;
	Properties cf = new Properties();
	
	
	public mySend2() throws FileNotFoundException, IOException{
		//cf.load(new FileReader(new File("src\\main\\resource\\uac.properties")));
		fi = new File("record");
	}
	public int getnum() {
		// TODO Auto-generated method stub
		if (!fi.isDirectory()){
			log.error("报文目录有误");
			log.info("path=" + fi.getPath());
			log.info("absolutepath=" + fi.getAbsolutePath());
			log.info("name=" + fi.getName());
			return 0;
		}else if(fi.isDirectory()){
					
			return fi.listFiles().length;
		}
		return 0;
	}

	public void isend(List<?> list) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
				SendLogOper slo = new SendLogOper();
				sendConfig sc = new sendConfig();
		        slo.initSendPool(sc.sendconf());
				int i = 0;
				String str1 = null;
				for (i=0;i<list.toArray().length;i++){
					log.info(list.get(i));
					if ("/".equals(fi.getAbsolutePath().substring(0, 1))){;
						str1 = str1 + StringDeal.strdeal(StringDeal.strdeal2(FileToString.readFromFile(new File(fi.getPath()+"/"+fi.list()[(Integer) list.get(i)]))));
					}else{
						str1 = str1 + StringDeal.strdeal(StringDeal.strdeal2(FileToString.readFromFile(new File(fi.getPath()+"\\"+fi.list()[(Integer) list.get(i)]))));
					}	
				}
				str1 = StringDeal.strdeal3(str1);
				slo.tcpSend(str1);
				slo.endSendPool();
		
	}
	
	public void isend(SendLogOper slo,List<?> list) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		        List<?> acctlist = FileToList.readFromFile(new File("acct.txt"));
		        
		        int arow;
				int i = 0;
				String str1 = null;
				for (i=0;i<list.toArray().length;i++){
					log.info(list.get(i));
					
					arow = (int)(Math.random()*(acctlist.size()));
			        String ac = (String) acctlist.get(arow);
			        log.info("第"+i+"条日志主账号为："+ac);

					if ("/".equals(fi.getAbsolutePath().substring(0, 1))){;
						str1 = str1 + StringDeal.strdeal(StringDeal.strdeal2(FileToString.readFromFile(new File(fi.getPath()+"/"+fi.list()[(Integer) list.get(i)]))),ac);
					}else{
						str1 = str1 + StringDeal.strdeal(StringDeal.strdeal2(FileToString.readFromFile(new File(fi.getPath()+"\\"+fi.list()[(Integer) list.get(i)]))),ac);
					}
				}
				str1 = StringDeal.strdeal3(str1);
				slo.tcpSend(str1);
				//slo.endSendPool();
		
	}

}
