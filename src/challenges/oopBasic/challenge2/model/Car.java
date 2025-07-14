package challenges.oopBasic.challenge2.model;

import challenges.oopBasic.challenge2.model.enums.CarDirection;
import challenges.oopBasic.challenge2.model.enums.CarGear;
import challenges.oopBasic.challenge2.model.exceptions.CarCannotBeTurnedOffException;
import challenges.oopBasic.challenge2.model.exceptions.CarCannotChangeDirectionException;
import challenges.oopBasic.challenge2.model.exceptions.CarCannotDecelerateException;
import challenges.oopBasic.challenge2.model.exceptions.CarIsTurnedOffException;
import challenges.oopBasic.challenge2.model.exceptions.CarCannotAccelerateException;
import challenges.oopBasic.challenge2.model.exceptions.InvalidGearException;

public class Car {

    // attributes
    private boolean isOn;
    private int speed;
    private CarDirection direction;
    private CarGear gear;

    // constructor
    public Car() {
        this.isOn = false;
        this.gear = CarGear.NEUTRAL_POINT;
        this.speed = 0;
    }

    // getters and setters
    public boolean isOn() {
        return isOn;
    }

    public int getSpeed() {
        return speed;
    }

    public CarDirection getDirection() {
        return direction;
    }

    public CarGear getGear() {
        return gear;
    }

    // methods
    public void start() {
        if(!isOn) this.isOn = true;
    }

    public void turnOff() {
        if(!this.isOn)
            throw new CarIsTurnedOffException("O carro já está desligado.");

        if(this.gear != CarGear.NEUTRAL_POINT || this.speed != 0)
            throw new CarCannotBeTurnedOffException("O carro não pode ser desligado: ele deve estar em ponto morto e com velocidade 0.");

        this.isOn = false;
    }

    public void accelerate() {
        if(!this.isOn)
            throw new CarIsTurnedOffException("O carro não pode acelerar pois está desligado.");

        if(this.speed >= 120)
            throw new CarCannotAccelerateException("Velocidade máxima de 120 km/h já atingida.");

        if(this.getGear() == CarGear.NEUTRAL_POINT)
            throw new CarCannotAccelerateException("Não é possível acelerar com o carro em ponto morto.");

        if(!isGearValid())
            throw new CarCannotAccelerateException("A marcha atual não é compatível com a velocidade do carro.");

        this.speed++;
    }

    public void decelerate() {
        if(!this.isOn)
            throw new CarIsTurnedOffException("O carro não pode diminuir a velocidade pois está desligado.");

        if(this.speed <= 0)
            throw new CarCannotDecelerateException("Velocidade mínima de 0 km/h já atingida.");

        if(!isGearValid())
            throw new CarCannotDecelerateException("A marcha atual não é compatível com a velocidade do carro.");

        this.speed--;
    }

    public void changeDirection(CarDirection direction) {
        if(!this.isOn)
            throw new CarIsTurnedOffException("Não é possível trocar a direção do carro pois ele está desligado.");

        if(this.speed < 1)
            throw new CarCannotChangeDirectionException("Velocidade mínima para troca de direção é 1 km/h");

        if(this.speed > 40) {
            throw new CarCannotChangeDirectionException("Velocidade máxima para troca de direção é 40 km/h");
        }

        this.direction = direction;
    }

    public void changeGear() {
        if(!this.isOn)
            throw new CarIsTurnedOffException("Não é possível trocar a direção do carro pois ele está desligado.");

        if (this.speed <= 0) {
            this.gear = CarGear.NEUTRAL_POINT;
        } else if (this.speed < 20) {
            this.gear = CarGear.FIRST_GEAR;
        } else if (this.speed < 40) {
            this.gear = CarGear.SECOND_GEAR;
        } else if (this.speed < 60) {
            this.gear = CarGear.THIRD_GEAR;
        } else if (this.speed < 80) {
            this.gear = CarGear.FOURTH_GEAR;
        } else if (this.speed < 100) {
            this.gear = CarGear.FIFTH_GEAR;
        } else if (this.speed <= 120) {
            this.gear = CarGear.SIXTH_GEAR;
        } else {
            throw new InvalidGearException("Velocidade acima do limite suportado.");
        }
    }

    private boolean isGearValid() {
        boolean isFirstGearValid =  (this.gear == CarGear.FIRST_GEAR) && (this.speed >= 0 && this.speed <= 20);
        boolean isSecondGearValid = (this.gear == CarGear.SECOND_GEAR) && (this.speed >= 21 && this.speed <= 40);
        boolean isThirdGearValid =  (this.gear == CarGear.THIRD_GEAR) && (this.speed >= 41 && this.speed <= 60);
        boolean isFourthGearValid = (this.gear == CarGear.FOURTH_GEAR) && (this.speed >= 61 && this.speed <= 80);
        boolean isFifthGearValid =  (this.gear == CarGear.FIFTH_GEAR) && (this.speed >= 81 && this.speed <= 100);
        boolean isSixthGearValid =  (this.gear == CarGear.SIXTH_GEAR) && (this.speed >= 101 && this.speed <= 120);

        return isFirstGearValid
                || isSecondGearValid
                || isThirdGearValid
                || isFourthGearValid
                || isFifthGearValid
                || isSixthGearValid;
    }

}
