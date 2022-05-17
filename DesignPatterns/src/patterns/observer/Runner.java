package patterns.observer;

public class Runner {

	static public void testNewsChannel() {
		NewsChannel channel = new NewsChannel();
		
		channel.reportManager.subscribe(ReportType.GENERAL, new SmsReportListener("050-general-general"));
		channel.reportManager.subscribe(ReportType.GENERAL, new EmailReportListener("general@gmail.com"));
		
		channel.reportManager.subscribe(ReportType.WEATHER, new SmsReportListener("050-weather-weather"));
		channel.reportManager.subscribe(ReportType.WEATHER, new EmailReportListener("weather@gmail.com"));
		
		channel.reportManager.subscribe(ReportType.SPORT, new SmsReportListener("050-sports-sports"));
		channel.reportManager.subscribe(ReportType.SPORT, new EmailReportListener("sports@gmail.com"));
		
		ReportListener allListenerSms = new SmsReportListener("050-everything");
		ReportListener allListenerEmail = new EmailReportListener("everything@gmail.com");
		
		channel.reportManager.subscribe(ReportType.GENERAL, allListenerSms);
		channel.reportManager.subscribe(ReportType.GENERAL, allListenerEmail);
		channel.reportManager.subscribe(ReportType.WEATHER, allListenerSms);
		channel.reportManager.subscribe(ReportType.WEATHER, allListenerEmail);
		channel.reportManager.subscribe(ReportType.SPORT, allListenerSms);
		channel.reportManager.subscribe(ReportType.SPORT, allListenerEmail);

		
		channel.report(ReportType.GENERAL, "General news is very general today");
		channel.report(ReportType.SPORT, "Sport is healthy to your feet");
		channel.report(ReportType.WEATHER, "Weather is going to be hot today");
		
		System.out.println("\nUnsubscribing 'all' listener\n");
		channel.reportManager.unsubscribe(ReportType.GENERAL, allListenerEmail);
		channel.reportManager.unsubscribe(ReportType.WEATHER, allListenerEmail);
		channel.reportManager.unsubscribe(ReportType.SPORT, allListenerEmail);
		channel.reportManager.unsubscribe(ReportType.GENERAL, allListenerSms);
		channel.reportManager.unsubscribe(ReportType.WEATHER, allListenerSms);
		channel.reportManager.unsubscribe(ReportType.SPORT, allListenerSms);
		
		channel.report(ReportType.GENERAL, "General things");
		channel.report(ReportType.SPORT, "Lets play soccer");
		channel.report(ReportType.WEATHER, "Its cold now");
	
	}
	
	public static void main(String[] args) {
		testNewsChannel();
	}

}
