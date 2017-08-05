package com.asiainfo.a4.gathersend.myGatherSend.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.asiainfo.a4.gathersend.myGatherSend.Base.MathDeal;
import com.asiainfo.a4.gathersend.myGatherSend.Base.SendLogOper;
import com.asiainfo.a4.gathersend.myGatherSend.Interface.InputFuntionInterface;

public class MyRunnable implements Runnable {
	Logger log =Logger.getLogger(MyRunnable.class);
	private SendLogOper slo;
	int dayallcount;
	String funclass;


	public void setFunclass(String funclass) {
		this.funclass = funclass;
	}



	public void setDayallcount(int dayallcount) {
		this.dayallcount = dayallcount;
	}



	public void setSlo(SendLogOper slo) {
		this.slo = slo;
	}



	public void run() {
		// TODO Auto-generated method stub
		log.info("线程开始。。。。。。。");
    	Calendar calend = Calendar.getInstance();
    	mySend2 tsend2;
		try {
			tsend2 = new mySend2();
    	int an2 = tsend2.getnum();
    	int hours2 = calend.get(Calendar.HOUR_OF_DAY); // 时
		int minutes2 = calend.get(Calendar.MINUTE);    // 分
		int seconds2 = calend.get(Calendar.SECOND);    // 秒
		int dayseconds2 = hours2*60*60 + minutes2*60 + seconds2;
		
		Class<?> cls = Class.forName(funclass);
		InputFuntionInterface p = (InputFuntionInterface) cls.newInstance();
		MathDeal.setP(p);
		
		
		List<?> list = MathDeal.glist(an2, MathDeal.sresult(this.dayallcount,dayseconds2)+1);
		tsend2.isend(this.slo,list);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("线程结束。。。。。。。");
	}

}
