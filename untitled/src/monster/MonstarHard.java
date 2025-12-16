package monster;

import event.Function;

public class MonstarHard extends MonstarEasy implements Moment{
    MonstarHard(){
        this.name = "고블린 3";
        this.hp = Function.ranInt(30, 20);
        this.atk = Function.ranInt(14,7);
        this.df = Function.ranInt(10, 5);
    }
}
