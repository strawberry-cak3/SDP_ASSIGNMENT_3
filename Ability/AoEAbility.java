package Ability;

import Damage.DamageEffect;

// Refined Abstraction 2
public class AoEAbility extends Ability {

    public AoEAbility(String abilityName, DamageEffect damageEffect) {
        super(abilityName, damageEffect);
    }

    @Override
    public void cast(String targetArea) {
        System.out.println("\nCasting AoE spell '"
                + abilityName + "' around area: "
                + targetArea + "!");
        damageEffect.applyDamage("all enemies in "
                + targetArea, 400);
    }
}
