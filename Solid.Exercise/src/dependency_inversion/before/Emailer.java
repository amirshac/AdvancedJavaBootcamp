package dependency_inversion.before;
public class Emailer {
    public String generateWeatherAlert(String weatherConditions) {
        String alert = "It is " + weatherConditions;
        return alert;
    }
}
