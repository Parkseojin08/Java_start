package monster;

import event.Function;

interface Moment{
    public int monsterAtk();
    void monsterDef(int atk);
}

public class Monster implements Moment{
    String name;
    int hp;
    int atk;
    int df;
    Monster(){
        this.name = "고블린";
        this.hp = Function.ranInt(20, 10);
        this.atk = Function.ranInt(7,3);
        this.df = Function.ranInt(5, 2);
    }

    public int monsterAtk(){
        return atk;
    }

    public void monsterDef(int atk){
        int result = atk - df;
        if(result <= 0){
            System.out.println("온스터가 아무런 피해도 받지 않았다!");
        }
        else{
            System.out.printf("몬스터가 %d의 피해를 입었다.", result);
            this.hp -= result;
        }
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

    public Object getName() {
        return this.name;
    }
}

