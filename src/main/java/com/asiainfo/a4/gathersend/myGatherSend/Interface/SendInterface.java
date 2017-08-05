/**
 * 
 */
package com.asiainfo.a4.gathersend.myGatherSend.Interface;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * @author rensy
 *
 */
public interface SendInterface {
	
	public int getnum();
	public void isend(List<?> list) throws FileNotFoundException, IOException;
}
