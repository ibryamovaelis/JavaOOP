package word;

public class TextModifier {
    private StringBuilder text;
    private String cut = "";

    TextModifier(StringBuilder text) {
        this.text = text;
    }

    public StringBuilder getText() {
        return text;
    }

    public void setCut(String cut) {
        this.cut = cut;
    }

    public String getCut() {
        return cut;
    }

    public void setText(StringBuilder text) {
        this.text = text;
    }
}
