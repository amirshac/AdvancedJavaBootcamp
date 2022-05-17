package patterns.observer;

public class EmailReportListener implements ReportListener{

	protected String email;
	
	public EmailReportListener(String email) {
		this.email = email;
	}
	
	@Override
	public void update(Report report) {
		System.out.println(report + "sent email to " + email + " " + report.getMessage());
	}

}
