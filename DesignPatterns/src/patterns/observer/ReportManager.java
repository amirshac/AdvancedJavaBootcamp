package patterns.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportManager {
	Map< ReportType, List<ReportListener> > listeners = new HashMap<>();
	
	public ReportManager(ReportType... reports) {
		for (ReportType report : reports) {
			this.listeners.put(report, new ArrayList<>());
		}
	}
	
	public void subscribe(ReportType reportType, ReportListener listener) {
		List<ReportListener> reportListeners = listeners.get(reportType);
		reportListeners.add(listener);
	}
	
	public void unsubscribe(ReportType reportType, ReportListener listener) {
		List<ReportListener> reportListeners = listeners.get(reportType);
		reportListeners.remove(listener);
	}
	
	public void notify(ReportType reportType, Report report) {
		List<ReportListener> reportListeners = listeners.get(reportType);
		reportListeners.forEach(listener -> listener.update(report));
	}
}
