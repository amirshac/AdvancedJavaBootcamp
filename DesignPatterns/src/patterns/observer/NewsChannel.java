package patterns.observer;

public class NewsChannel {
	public ReportManager reportManager;
	
	public NewsChannel() {
		this.reportManager = new ReportManager(ReportType.GENERAL, ReportType.SPORT, ReportType.WEATHER);
	}
	
	public void report(ReportType reportType, String msg) {
		report (new Report(reportType, msg));
	}
	
	public void report(Report report) {
		reportManager.notify(report.type, report);
	}
	
}
