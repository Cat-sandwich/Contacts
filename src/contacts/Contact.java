package contacts;

public class Contact {
    private String name;
    private String value;
    public Contact(String name, String value)
    {
        if (name != null && value != null)
        {
            this.name = name;
            this.value = value;
        }

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
