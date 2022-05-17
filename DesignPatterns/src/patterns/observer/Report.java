package patterns.observer;

public class Report {
	protected ReportType type;
	protected String msg;
	
	public Report(ReportType type, String msg) {
		this.type = type;
		this.msg = msg;
	}

	public String getMessage() {
		return this.msg;
	}
	
	@Override
	public String toString() {
		return type + " report ";
	}
}
