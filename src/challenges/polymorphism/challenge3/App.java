package challenges.polymorphism.challenge3;

public class App {

    public static void main(String[] args) {
        Clock clock = new USAClock();

        clock.setHour(14);
        System.out.println("Tempo Atual: " + clock.getTime());

        //System.out.println("Hora atual: " + clock.getHour());
    }
}
