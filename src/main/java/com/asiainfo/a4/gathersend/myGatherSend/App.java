package com.asiainfo.a4.gathersend.myGatherSend;

import java.io.FileNotFoundException;
import java.io.IOException;



import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.asiainfo.a4.gathersend.myGatherSend.Base.RunPremeter;
import com.asiainfo.a4.gathersend.myGatherSend.Base.SendLogOper;
import com.asiainfo.a4.gathersend.myGatherSend.Base.sendConfig;
import com.asiainfo.a4.gathersend.myGatherSend.service.MyRunnable;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException, IOException, InterruptedException{
    	Logger log =Logger.getLogger(App.class);
/*        log.info( "Hello World!" );
        log.info( System.getProperties().getProperty("os.name") );
        log.info( System.getProperties().getProperty("os.arch") );
        log.info( System.getProperties().getProperty("os.version") );
        log.info( "/".equals("/home".substring(0, 1)) );
        Thread.sleep(1000000);*/
        //mySend ms = new mySend();
        //ms.getnum();
        //System.out.println(ms.getnum());
        
        
        //MathDeal f = new MathDeal();
		//Calendar calendar = Calendar.getInstance();
		
		//int hours = calendar.get(Calendar.HOUR_OF_DAY); // 时
		//int minutes = calendar.get(Calendar.MINUTE);    // 分
		//int seconds = calendar.get(Calendar.SECOND);    // 秒
		//int dayseconds = hours*60*60 + minutes*60 + seconds;
		//System.out.println(String.format("hours: %s,minutes: %s,seconds: %s,dayseconds: %s", hours, minutes, seconds,dayseconds));
		//mySend2 tsend = new mySend2();
		//int an = tsend.getnum();
		//System.out.println(f.glist(an, 10).toArray()[1]);
		//List<?> list = f.glist(an, f.sresult(10000000,dayseconds));
		
		//System.out.println(tsend.getnum());
		//System.out.println("哈哈哈哈哈哈哈哈");
		//tsend.isend(list);
		//System.out.println(f.sresult(10000000, dayseconds));
		//System.out.println("哈哈哈哈哈哈哈哈");
		
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		log.info(cachedThreadPool);
		
		ClassPathXmlApplicationContext tt = new ClassPathXmlApplicationContext("spring-bean.xml");
		SendLogOper slo = new SendLogOper();
		sendConfig sc = (sendConfig) tt.getBean("sendconf");
		RunPremeter rp = (RunPremeter) tt.getBean("runconf");
        slo.initSendPool(sc.sendconf());
        tt.close();
        MyRunnable mr = new MyRunnable();
        mr.setSlo(slo);
        mr.setDayallcount(Integer.parseInt(rp.getConf().getProperty("dayallcount")));

        mr.setFunclass(rp.getConf().getProperty("funclass"));

        
		while (true) {
			cachedThreadPool.execute(mr);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

        
    }
}
