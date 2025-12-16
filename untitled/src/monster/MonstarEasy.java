package monster;

import event.Function;

interface Moment{
    public int monsterAtk();
    void monsterDef(int atk);
}

public class MonstarEasy implements Moment{
    String name;
    int hp;
    int atk;
    int df;
    MonstarEasy(){
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
}

