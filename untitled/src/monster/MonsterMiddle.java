package monster;

import event.Function;

import java.util.HashMap;

public class MonsterMiddle extends Monster{
    public MonsterMiddle(){
        this.name = "힘 고블린";
        this.hp = Function.ranInt(40, 30);
        this.atk = Function.ranInt(15,10);
        this.df = Function.ranInt(15, 10);
        this.dropExp = Function.ranInt(80,40);

        this.dropItem = new HashMap<>();

        this.dropItem.put("중 검",4);
        this.dropItem.put("중 갑옷", 6);
        this.dropItem.put("중 헬멧", 3);
        this.dropItem.put("중 하의", 3);
    }
}
