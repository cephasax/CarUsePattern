package master.imd.ufrn.br.carusepattern.getbehavior.domain;

public class CarFactory {

    public Car getCar(CarType carType){
        switch (carType){
            case SMALL_CAR:
                return new SmallCar();
            case MID_CAR:
                return new MidCar();
            case BIG_CAR:
                return new BigCar();
            default:
                return new MidCar();
        }
    }

}
