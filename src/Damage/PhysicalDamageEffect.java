package Damage;

// Concrete Implementor 1
public class PhysicalDamageEffect implements DamageEffect {
    @Override
    public void applyDamage(String targetName, int baseDamage) {
        System.out.println("[Physical Damage] Applies " + baseDamage +
                " physical damage to " + targetName +
                " (reduced by armor).");
    }
}
