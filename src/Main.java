import Ability.*;
import Damage.*;

// Client
public class Main {
    public static void main(String[] args) {
        // low-level effects of damage
        DamageEffect physical = new PhysicalDamageEffect();
        DamageEffect magical = new MagicalDamageEffect();
        DamageEffect pure = new PureDamageEffect();

        // 1. new ability (Phantom Assassin's Stifling Dagger)
        Ability StiflingDagger = new TargetedAbility(
                "Stifling Dagger",
                physical);
        StiflingDagger.cast("Enemy Crystal Maiden");

        // 2. AoE ability with magic damage (Invoker's Sun Strike)
        Ability InvokerSunstrike = new AoEAbility(
                "Sun Strike",
                magical);
        InvokerSunstrike.cast("Roshpit");

        // 3. flexibility right in the game
        // (Modificator (Arcane Orb deals pure damage)
        Ability ArcaneOrbOD = new TargetedAbility("Arcane Orb", pure);
        System.out.println("\n--- Hero activates attack modifier ability ---");
        ArcaneOrbOD.setDamageEffect(pure);
        ArcaneOrbOD.cast("Enemy Invoker");

    }
}