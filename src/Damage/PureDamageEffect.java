package Damage;

public class PureDamageEffect implements DamageEffect{
    @Override
    public void applyDamage(String targetName, int baseDamage) {
        System.out.println("[Pure Damage] Applies " + baseDamage +
                " pure damage to " + targetName);
    }
}
