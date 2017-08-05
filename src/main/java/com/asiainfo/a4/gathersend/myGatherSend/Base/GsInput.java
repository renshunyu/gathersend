/**
 * 
 */
package com.asiainfo.a4.gathersend.myGatherSend.Base;

import com.asiainfo.a4.gathersend.myGatherSend.Interface.InputFuntionInterface;

/**
 * @author rensy
 *
 */
public class GsInput implements InputFuntionInterface{

	public double result(double x) {
		// TODO Auto-generated method stub
		int a1 = 10*60*60+30*60;
		int b1 = 1*60*60+30*60;
		
		int a2 = 16*60*60;
		int b2 = 2*60*60;
		
		//System.out.println(1/(Math.sqrt(2*Math.PI)));
		//System.out.println(0-(Math.pow(x-a1, 2)/(2*Math.pow(b1,2))));
		//System.out.println((1/(Math.sqrt(2*Math.PI)))*Math.exp(0-(Math.pow(x-a1, 2)/(2*Math.pow(b1,2)))));
		return ((1/(b2*Math.sqrt(2*Math.PI)))*Math.exp(0-(Math.pow(x-a1, 2)/(2*Math.pow(b1,2))))) + ((1/(b2*Math.sqrt(2*Math.PI)))*Math.exp(0-(Math.pow(x-a2, 2)/(2*Math.pow(b2,2)))));
	}

}
