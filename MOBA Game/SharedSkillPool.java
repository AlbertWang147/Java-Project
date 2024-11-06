package PracticePack2;


public interface SharedSkillPool {
    
    default void AddStrength() {
        System.out.println("Add Strength");
    }

    default void AddSpeed() {
        System.out.println("Add Speed");
    }
}

