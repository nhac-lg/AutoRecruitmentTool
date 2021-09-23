package objmodels;

public class UpdateList {
    private String type;
    private String day;

    public UpdateList(String type, String day) {
        this.type = type;
        this.day = day;
    }

    public String getType() {
        return type;
    }

    public String getDay() {
        return day;
    }
}
