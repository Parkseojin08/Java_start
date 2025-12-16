package monster;

import event.Function;

public class MonstarMiddle extends MonstarEasy implements Moment{
    MonstarMiddle(){
        this.name = "고블린 2";
        this.hp = Function.ranInt(25, 15);
        this.atk = Function.ranInt(10,5);
        this.df = Function.ranInt(7, 4);
    }
}
