package monster;

import event.Function;

public class MonsterMiddle extends Monster{
    public MonsterMiddle(){
        this.name = "힘 고블린";
        this.hp = Function.ranInt(25, 15);
        this.atk = Function.ranInt(10,5);
        this.df = Function.ranInt(7, 4);
    }
}
