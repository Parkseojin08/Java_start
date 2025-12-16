package user;

import java.util.ArrayList;
import java.util.Arrays;

public class User {
    private String name;
    private int level;
    private int exp;
    private int hp;
    private int atk;
    private int df;

     public User(){
        this.name = "";
        this.level = 1;
        this.exp = 0;
        this.hp = 0;
        this.atk = 0;
        this.df = 0;
    }

    public void setAll(String name, int hp, int atk, int df){
         this.name = name;
         this.hp = hp;
         this.atk = atk;
         this.df = df;
    }
    public ArrayList getAll(){
         ArrayList<String> lists = new ArrayList<>(Arrays.asList(name, String.valueOf(level), String.valueOf(exp), String.valueOf(hp), String.valueOf(atk), String.valueOf(df)));
         return lists;
    }
    // 겟터 셋터

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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
