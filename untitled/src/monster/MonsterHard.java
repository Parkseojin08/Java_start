package monster;

import event.Function;

public class MonsterHard extends Monster{
    public MonsterHard(){
        this.name = "힘힘 고블린";
        this.hp = Function.ranInt(30, 20);
        this.atk = Function.ranInt(14,7);
        this.df = Function.ranInt(10, 5);
    }
}
