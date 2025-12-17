package monster;

import event.Function;

import java.util.HashMap;

public class Boss extends Monster{
    public Boss(){
        this.name = "보스";
        this.hp = Function.ranInt(20, 10);
        this.atk = Function.ranInt(7,3);
        this.df = Function.ranInt(5, 2);
        this.dropExp = Function.ranInt(10,5);
        this.dropItem = new HashMap<>();

        this.dropItem.put("왕 검", 16);
        this.dropItem.put("왕 갑옷", 24);
        this.dropItem.put("와 헬멧", 12);
        this.dropItem.put("왕 하의", 12);
    }
}
