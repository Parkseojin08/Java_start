package monster;


import event.Function;

import java.util.HashMap;

public class MonsterEasy extends Monster{
    public MonsterEasy(){
        this.name = "고블린";
        this.hp = Function.ranInt(30, 20);
        this.atk = Function.ranInt(7,5);
        this.df = Function.ranInt(8, 5);
        this.dropExp = Function.ranInt(40,20);

        this.dropItem = new HashMap<>();

        this.dropItem.put("소 검", 2);
        this.dropItem.put("소 갑옷", 4);
        this.dropItem.put("소 헬멧", 2);
        this.dropItem.put("소 하의", 2);
    }
}

