package monster;

import event.Function;

import java.util.HashMap;

public class Boss extends Monster{
    public Boss(){
        this.name = "보스";
        this.hp = Function.ranInt(200, 100);
        this.atk = Function.ranInt(40,20);
        this.df = Function.ranInt(30, 15);
        this.dropExp = Function.ranInt(1000,500);
        this.dropItem = new HashMap<>();

        this.dropItem.put("왕 검", 16);
        this.dropItem.put("왕 갑옷", 24);
        this.dropItem.put("와 헬멧", 12);
        this.dropItem.put("왕 하의", 12);
    }
}
