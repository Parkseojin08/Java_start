package event;


import user.User;

import monster.*;

public class Fight {

    public static void fights(User user, Monster monster){
        System.out.printf("""
                ==============================
                이름: %s
                HP: %d ATK: %d DF: %d
                
                USER: %s
                HP: %d ATK: %d DF: %d
                LEVEL: %d exp: %d / %d
                ==============================""",
                monster.getName(),monster.getHp(),monster.getAtk(),monster.getDf(),
                user.getName(),user.getHp(), user.getAtk(), user.getDf(), user.getlevel(), user.getExp(), user.getExpPlus());
    }
}
