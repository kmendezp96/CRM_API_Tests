package entities;

public class Country {
    private String text;
    private String key;

    public Country(String text, String key) {
        this.text = text;
        this.key = key;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "{ \n" +
                "\"text\": \"" + text + "\", \n" +
                "\"key\": \"" + key + "\" \n"  +
                '}';
    }
}

