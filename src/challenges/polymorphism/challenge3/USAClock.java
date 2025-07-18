package challenges.polymorphism.challenge3;

import java.util.HashMap;
import java.util.Map;

public class USAClock extends Clock {

    Map<Integer, Integer> equivalentHoursMap = new HashMap<>();

    public USAClock() {
        super();
        createEquivalentHoursMap();
    }

    @Override
    protected void clockFactory(Clock clock) {

    }

    @Override
    protected void setHour(int hours) {
        if(isAm(hours)) {
            super.setHour(hours);
        } else {
            super.setHour(getEquivalentHour(hours));
        }

    }

    @Override
    protected void setMinute(int minutes) {
        super.setMinute(minutes);
    }


    @Override
    protected void setSecond(int seconds) {
        super.setSecond(seconds);
    }

    @Override
    protected String getFormattedTime() {
        return super.getFormattedTime();
    }

    private boolean isAm(int hour) {
        return hour <= 12;
    }

    private int getEquivalentHour(int hours) {
        return equivalentHoursMap.get(hours);
    }

    private void createEquivalentHoursMap() {
        for(int hour = 13; hour <= 23; hour++) {
            equivalentHoursMap.put(hour, hour - 12);
        }
    }
}
