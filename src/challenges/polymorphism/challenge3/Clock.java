package challenges.polymorphism.challenge3;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/*
Escreve uma hierarquia de classes para criação de relógios para
diferentes lugares do mundo, defina uma classe pai que tenha as
propriedades Hora, minuto e segundo com seus respectivos getters
e setters (atendendo as regras do funcionamento de um relógio)
e um metodo que deverá retornar a hora no formato HH:MM:SS,
a partir dessa classe crie 2 implementações, uma chamada relógio
Americando e outra chamada relógio Brasileiro, lembrando que para
o relógio americano não existem as horas de 13 até 24. Defina também
na super classe um metodo que ficará por responsabilidade da classe
que extende-la definir seu funcionamemnto, esse metodo deve receber um
relógio ( independente da implementação) e deve-se extrair as informações
dele e usa-la no objeto que recebeu para setar as novas informações do relógio.
 */
public abstract class Clock {
    protected LocalTime time;

    protected Clock() {
        time = LocalTime.now();
    }

    protected String getTime() {
        return getFormattedTime();
    }


    protected int getHour() {
        return time.getHour();
    }

    protected void setHour(int hours) {
        if(hours < 0 || hours >= 24) throw new IllegalArgumentException("Hora inválida: " + hours);
        this.time = time.withHour(hours);
    }

    protected int getMinute() {
        return time.getMinute();
    }

    protected void setMinute(int minutes) {
        if(minutes < 0 || minutes >= 60) throw new IllegalArgumentException("Minutos inválido: " + minutes);
        this.time = time.withMinute(minutes);
    }

    protected int getSecond() {
        return time.getSecond();
    }

    protected void setSecond(int seconds) {
        if(seconds < 0 || seconds >= 60) throw new IllegalArgumentException("Segundos inválido: " + seconds);
        this.time = time.withSecond(seconds);
    }

    protected String getFormattedTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return this.time.format(formatter);
    }

    protected abstract void clockFactory(Clock clock);
}
