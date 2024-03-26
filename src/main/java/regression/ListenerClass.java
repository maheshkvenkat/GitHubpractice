package regression;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener{

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test case passed is "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	System.out.println("Test case Failed is "+result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    	System.out.println("Test case Skipped is "+result.getName());
    }

}
