package com.asiainfo.a4.gathersend.myGatherSend.Base;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
/**
 * @author rensy
 *
 */
public class MathDeal {
	static Logger log =Logger.getLogger(MathDeal.class);
	static GsInput p = new GsInput();
	
	public static double result(double x){
		return p.result(x);
	}
	
	public static double dayresult(){
		double re = 0;
		int i = 0;
		for (i=1;i<=86400;i++){
			re = re + result(i);			
		};
		return re;
	}
	
	public static double qzresult(double x){
		return x/dayresult();
	}
	
	public static int sresult(double x,double y){
		double a = x/dayresult();
		log.info(a);
		return  (int) (a*result(y));
	}
	
	public static List<?> glist(int a,int b){
		List<Integer> list=new ArrayList<Integer>();
		int i=0;
		for (i=0;i<b;i++){
			list.add(i, (int)(Math.random()*a));
		};
		return list;
	}
	
}
