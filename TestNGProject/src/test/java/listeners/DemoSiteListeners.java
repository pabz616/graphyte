package listeners;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class DemoSiteListeners implements ITestListener {
	
	public void onTestStart (ITestResult result) {
		System.out.println("******* Test Started! : "+result.getName());
	}
	
	public void onTestSuccess (ITestResult result) {
		System.out.println("******* Test Passed! : "+result.getName());
	}
	
	public void onTestFailure (ITestResult result) {
		System.out.println("******* Issue! Test Failed! Please confirm its legit and file a bug : "+result.getName());
		//TODO Take screenshots on test failure
	}
	
	public void onTestSkipped (ITestResult result) {
		System.out.println("******* Test Skipped! : "+result.getName());
	}
	
	public void onStart (ITestContext context) {
		//TODO Add custom code
	}
	
	public void onFinish (ITestContext context) {
		System.out.println("******* Testing Completed! : "+context.getName());
	}
}
