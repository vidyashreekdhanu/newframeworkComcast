package Com.Comcast.Crm.lister;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer{
int count=0;
int limitcount=5;
	public boolean retry(ITestResult result) {
		if (count<limitcount) {
			count++;
			return true;
			
		}
		return false;
	}

}
