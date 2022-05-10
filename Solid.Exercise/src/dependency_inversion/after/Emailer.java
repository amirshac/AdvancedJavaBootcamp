package dependency_inversion.after;
public class Emailer implements Notifier {
	@Override
    public String generateWeatherAlert(String weatherConditions) {
        String alert = "It is " + weatherConditions;
        return alert;
    }
}
