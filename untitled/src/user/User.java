package user;

import java.util.ArrayList;
import java.util.Arrays;

public class User {
    private String name;
    private int level;
    private int exp;
    private int expPlus;
    private int hp;
    private int maxHp;
    private int atk;
    private int df;
    private int point;
    private ArrayList<String> inventory;

     public User(){
        this.name = "";
        this.level = 1;
        this.exp = 0;
        this.expPlus = this.level * 100;
        this.hp = 0;
        this.maxHp = 0;
        this.atk = 0;
         this.df = 0;
        this.point = 3;
        this.inventory = new ArrayList<>();
    }

    public void setAll(String name, int hp, int atk, int df){
         this.name = name;
         this.hp = hp;
         this.atk = atk;
         this.df = df;
    }

    public ArrayList getAll(){
         ArrayList<String> lists = new ArrayList<>(Arrays.asList(
                 name,
                 String.valueOf(level),
                 String.valueOf(exp),
                 String.valueOf(expPlus),
                 String.valueOf(hp),
                 String.valueOf(atk),
                 String.valueOf(df),
                 String.valueOf(point)));
         return lists;
    }


    // 셋터

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setExp(int exp){this.exp = exp;}

    public void setExpPlus(int expPlus) {
        this.expPlus = expPlus;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMaxHp(int maxHp){
        this.maxHp = maxHp;
    };
    public void setAtk(int atk) {
        this.atk = atk;
    }

    public void setDf(int df) {
        this.df = df;
    }

    public void setPoint(int point){
         this.point = point;
    }

    // 겟터
    public int getLevel() {
        return level;
    }
    public int getMaxHp() {
        return maxHp;
    }



    public int getExp() {
        return exp;
    }

    public int getExpPlus() {
        return expPlus;
    }

    public int getDf() {
        return df;
    }

    public String getName() {
        return name;
    }

    public int getAtk() {
        return atk;
    }

    public int getHp() {
        return hp;
    }

    public int getPoint(){return point;}

    public int getlevel() {
        return level;
     }
}
