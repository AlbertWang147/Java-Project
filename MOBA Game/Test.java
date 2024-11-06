package PracticePack2;

public class test {
    public static void main(String[] args) {

        HeroAttribute1 Monk=new HeroAttribute1();

        Monk.AddHealth();
        Monk.Escape();
        Monk.Buddha();

        Monk.AddStrength();
        Monk.AddSpeed();

        Monk.setLife(100);
        Monk.setMovementSpeed(100);
        Monk.setAttackPower(100);


        HeroAttribute2 Priest =new HeroAttribute2();

        Priest.Pray();
        Priest.TaiChi();
        Priest.Swordsmanship();

        Priest.AddStrength();
        Priest.AddSpeed();

        Priest.setLife(200);
        Priest.setMovementSpeed(200);
        Priest.setAttackPower(200);
    }
}


