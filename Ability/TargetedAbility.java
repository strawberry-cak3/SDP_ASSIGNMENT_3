package Ability;

import Damage.DamageEffect;


// Refined Abstraction 1
public class TargetedAbility extends Ability {

    public TargetedAbility(String abilityName, DamageEffect damageEffect) {
        super(abilityName, damageEffect);
    }

    @Override
    public void cast(String target) {
        System.out.println("\nCasting targeted spell '"
                + abilityName + "' directly on "
                + target + "!");
        damageEffect.applyDamage(target, 250);
    }
}
