package challenges.polymorphism.challenge3;

public class BrazilClock extends Clock {

    public BrazilClock() {
        super();
    }

    @Override
    protected void clockFactory(Clock clock) {
        if (clock instanceof USAClock) {
            this.setHour(clock.getHour());
            this.setMinute(clock.getMinute());
            this.setSecond(clock.getSecond());
        } else {
            this.setHour(clock.getHour());
            this.setMinute(clock.getMinute());
            this.setSecond(clock.getSecond());
        }
    }
}
