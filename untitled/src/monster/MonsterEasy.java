package monster;


import event.Function;

public class MonsterEasy extends Monster{

    public MonsterEasy(){
        this.name = "고블린";
        this.hp = Function.ranInt(20, 10);
        this.atk = Function.ranInt(7,3);
        this.df = Function.ranInt(4, 2);
        this.dropExp = Function.ranInt(20,10);
    }
}

