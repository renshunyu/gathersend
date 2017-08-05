/**
 * 
 */
package com.asiainfo.a4.gathersend.myGatherSend.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;









import org.apache.log4j.Logger;

import com.asiainfo.a4.gathersend.myGatherSend.Base.FileToString;
import com.asiainfo.a4.gathersend.myGatherSend.Base.SendLogOper;
import com.asiainfo.a4.gathersend.myGatherSend.Base.StringDeal;
import com.asiainfo.a4.gathersend.myGatherSend.Base.sendConfig;
import com.asiainfo.a4.gathersend.myGatherSend.Interface.SendInterface;

/**
 * @author rensy
 *
 */
public class mySend implements SendInterface{
	Logger log =Logger.getLogger(mySend.class);
	File fi=null;
	Properties cf = new Properties();
	
	public mySend() throws FileNotFoundException, IOException{
		//cf.load(new FileReader(new File("src\\main\\resource\\uac.properties")));
		fi = new File("record");
	}
	
	public int getnum() {
		// TODO Auto-generated method stub
		if (!fi.isDirectory()){
			log.info("报文目录有误");
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

		// TODO Auto-generated method stub
		SendLogOper slo = new SendLogOper();
		sendConfig sc = new sendConfig();
		
        slo.initSendPool(sc.sendconf());
        String str = null;
		int i = 0;
		for (i=0;i<list.toArray().length;i++){
			log.info(list.get(i));
			str = FileToString.readFromFile(new File(fi.getPath()+"\\"+fi.list()[(Integer) list.get(i)]));
			str = StringDeal.strdeal(str);
			str = StringDeal.strdeal2(str);
			str = StringDeal.strdeal3(str);
			slo.tcpSend(str);
			
			
		}
		slo.endSendPool();
		
	}

}
