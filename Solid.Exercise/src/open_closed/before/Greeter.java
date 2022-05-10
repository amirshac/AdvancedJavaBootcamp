package open_closed.before;

public class Greeter {
    String formality;

    public String greet() {
        if (formality == "formal") {
            return "Good evening, sir.";
        }
        else if (formality == "casual") {
            return "Sup bro?";
        }
        else if (formality == "intimate") {
            return "Hello Darling!";
        }
        else {
            return "Hello.";
        }
    }

    public void setFormality(String formality) {
        this.formality = formality;
    }
}
