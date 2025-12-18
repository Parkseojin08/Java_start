package event;


import user.User;

import monster.*;

import java.util.HashMap;
import java.util.InputMismatchException;

public class Fight{

    public static void fights(User user, Monster monster){
        while (true) {
            if (monster.getHp() <= 0) {
                    FightEvent.userWin(user, monster);
                if( Function.ranInt(101,1) >= 70){
                    FightEvent.dropItem(monster, user);
                }
                if(user.getExp() >= user.getExpPlus()){
                    UserEvents.userLevelUp(user);
                }
                break;
            }else if(user.getHp() <= 0){
                FightEvent.userDefeat(user, monster);
                break;
            }
            try{
                FightEvent.battleUi(user, monster);
                int choice = Function.scan.nextInt();
                if(choice == 1){
                  monster.setHp(monster.getHp() - FightEvent.fightAtk(user.getName(), monster.getName(),user.getAtk(), monster.getDf() ));
                  user.setHp(user.getHp() - FightEvent.fightAtk(monster.getName(), user.getName(),monster.getAtk(), user.getDf() ));
                } else if (choice == 2) {
                    System.out.println("도망쳤다!");
                    user.setHp(user.getMaxHp());
                    break;
                }else {
                    System.out.println("1 or 2를 숫자를 입력해주세요.");
                }
            }catch(InputMismatchException e){
                System.out.println("1 or 2를 선택해주세요.");
            }
        }
    }


}
