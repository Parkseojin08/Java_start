package monster;

import event.Function;

import java.util.HashMap;

public class MonsterHard extends Monster{
    public MonsterHard(){
        this.name = "힘힘 고블린";
        this.hp = Function.ranInt(50, 30);
        this.atk = Function.ranInt(20,10);
        this.df = Function.ranInt(15, 10);
        this.dropExp = Function.ranInt(160,80);

        this.dropItem = new HashMap<>();

        this.dropItem.put("대 검", 8);
        this.dropItem.put("대 갑옷", 12);
        this.dropItem.put("대 헬멧", 6);
        this.dropItem.put("대 하의", 6);
    }
}
