package utils;

import jakarta.servlet.ServletRequest;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AlertUtil {

    private final List<Alert> alerts = new LinkedList<>();

    public AlertUtil() {
    }

    public AlertUtil(Alert[] alerts) {
        this.alerts.addAll(Arrays.asList(alerts));
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public void clear() {
        alerts.clear();
    }

    public void addAlert(String message, Integer type) {
        alerts.add(new Alert(message, type));
    }

    public void bindTo(ServletRequest request) {
        request.setAttribute("alerts", alerts);
    }
}
