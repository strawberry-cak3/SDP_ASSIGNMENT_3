package Damage;

// Concrete Implementor 2
public class MagicalDamageEffect implements DamageEffect {
    @Override
    public void applyDamage(String targetName, int baseDamage) {
        System.out.println("[Magical Damage] Deals " + baseDamage +
                " magic damage to " + targetName +
                " (reduced by magic resistance).");
    }
}
