package Ability;

import Damage.DamageEffect;

// Abstraction
public abstract class Ability {
    protected DamageEffect damageEffect; // Imp
    protected String abilityName; // ability's name

    public Ability(String abilityName, DamageEffect damageEffect) {
        this.abilityName = abilityName;
        this.damageEffect = damageEffect;
    }

    // Dynamic change of damage
    public void setDamageEffect(DamageEffect damageEffect) {
        this.damageEffect = damageEffect;
    }

    public abstract void cast(String target);
}