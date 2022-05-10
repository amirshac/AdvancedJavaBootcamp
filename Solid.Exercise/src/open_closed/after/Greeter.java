package open_closed.after;
public class Greeter implements Greetable {
    String formality;

    @Override
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

    @Override
    public void setFormality(String formality) {
        this.formality = formality;
    }
}
