package monster;

import event.Function;

import java.util.HashMap;
import java.util.Set;

public class Monster{
    String name;
    int hp;
    int atk;
    int df;
    int dropExp;
    HashMap<String, Integer> dropItem;

    Monster(){
        this.name = "고블린";
        this.hp = Function.ranInt(20, 10);
        this.atk = Function.ranInt(7,3);
        this.df = Function.ranInt(5, 2);
        this.dropExp = Function.ranInt(10,5);
        this.dropItem = new HashMap<>();

        this.dropItem.put("소 검", 2);
        this.dropItem.put("소 갑옷", 4);
        this.dropItem.put("소 헬멧", 2);
        this.dropItem.put("소 하의", 2);
    }

    public HashMap<String, Integer> getDropItemAll(){
        return dropItem;
    }

    public int getDropItemLength(){
        return dropItem.size();
    }

    public int getDropExp() {
        return dropExp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDf() {
        return df;
    }

    public void setDf(int df) {
        this.df = df;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public String getName() {
        return this.name;
    }
}

