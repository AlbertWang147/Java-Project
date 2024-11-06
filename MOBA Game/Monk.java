package PracticePack2;


public interface Monk extends SharedSkillPool{
    default void AddHealth() {
        System.out.println("Add Health");
    }

    default void Escape() {
        System.out.println("Escape");
    }

    default void Buddha() {
        System.out.println("Buddha");
    }
}

