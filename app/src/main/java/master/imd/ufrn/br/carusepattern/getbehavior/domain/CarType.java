package master.imd.ufrn.br.carusepattern.getbehavior.domain;

public enum CarType {

    SMALL_CAR("small"),
    MID_CAR("mid"),
    BIG_CAR("big");

    private String info;

    CarType(String info){
        this.info = info;
    }

    public String getInfo(){
        return this.info;
    }

}
