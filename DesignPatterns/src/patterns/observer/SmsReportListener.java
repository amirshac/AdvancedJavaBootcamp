package patterns.observer;

public class SmsReportListener implements ReportListener {

	String number;
	
	public SmsReportListener(String number) {
		this.number = number;
	}

	@Override
	public void update(Report report) {
		System.out.println(report + "sent SMS to number " + number + " " + report.getMessage());
	}
	
}
