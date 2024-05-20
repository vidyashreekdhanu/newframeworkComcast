package Com.Crm.genric.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class javautility {
	public int getrandomnum()
	{
		Random ra = new Random();
		int randomnum = ra.nextInt(5000);
		return randomnum;
		
		
	}
	public String getsystem_dateYYYYDDMM()
	{
		Date da = new Date();
		SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");
		String date = sim.format(da);
		return date;
	
				
	}
	public String getrequireddate(int days)
	{
		Date da = new Date();
	SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");
	String date = sim.format(da);
	
	Calendar cal = sim.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH, days);
	String reqdate = sim.format(cal.getTime());
	return reqdate;
		
	}

	
}
