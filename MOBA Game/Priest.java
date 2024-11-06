package PracticePack2;


public interface Priest extends SharedSkillPool{
    default void Pray() {
        System.out.println("Pray");
    }

    default void TaiChi() {
        System.out.println("Tai Chi");
    }

    default void Swordsmanship() {
        System.out.println("Swordsmanship");
    }
}
    

