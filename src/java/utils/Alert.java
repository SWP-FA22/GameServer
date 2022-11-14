package utils;

public final class Alert {

    public final Integer ALERT_SUCCESS = 0;
    public final Integer ALERT_DANGER = 1;
    public final Integer ALERT_WARNING = 2;
    public final Integer ALERT_INFO = 3;
    public final Integer ALERT_PRIMARY = 4;
    public final Integer ALERT_SECONDARY = 5;
    public final Integer ALERT_LIGHT = 6;
    public final Integer ALERT_DARK = 7;

    private final String[] ALERT_MAPPING = {
        "success",
        "danger",
        "warning",
        "info",
        "primary",
        "secondary",
        "light",
        "dark"
    };

    private String message;
    private String type;

    public Alert() {
    }

    public Alert(String message, Integer type) {
        this.message = message;
        setType(type);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(Integer type) {
        if (0 <= type && type < ALERT_MAPPING.length) {
            this.type = ALERT_MAPPING[type];
        }
    }
}
