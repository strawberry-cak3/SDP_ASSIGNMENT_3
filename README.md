# Assignment 3: Bridge Design Pattern — Dota 2 Ability System

**Course:** Software Design Patterns  
**Topic:** Structural Pattern — Bridge  
**Domain:** Dota 2 Ability & Damage System

---

## 1. Project Overview

This repository demonstrates the **Bridge Design Pattern** implemented in Java within the context of the game **Dota 2**.

The main objective of the Bridge pattern is to decouple an abstraction from its implementation so that the two can vary independently. In game development, abilities often vary by **casting mechanics** (e.g., Targeted Spells, AoE Spells) as well as by **damage types/effects** (e.g., Physical, Magical, Pure).

Without the Bridge pattern, combining $N$ casting mechanics with $M$ damage types using standard class inheritance would require $N \times M$ subclasses (leading to a class explosion). Using the Bridge pattern, we maintain two independent class hierarchies linked via composition, reducing the total required classes to $N + M$.

---

## 2. Architecture & Pattern Mapping

The pattern components are mapped to the Dota 2 domain as follows:

| Bridge Component | Class / Interface Name | Description |
| :--- | :--- | :--- |
| **Abstraction** | `Ability` (Abstract Class) | Defines the high-level ability contract and holds a reference to `DamageEffect`. |
| **Refined Abstraction 1** | `TargetedAbility` | Concrete ability targeting a single unit (e.g., *Stifling Dagger*). |
| **Refined Abstraction 2** | `AoEAbility` | Concrete ability targeting an area of effect (e.g., *Light Strike Array*). |
| **Implementor** | `DamageEffect` (Interface) | Low-level interface defining how damage/effects are applied to targets. |
| **Concrete Implementor 1** | `PhysicalDamageEffect` | Implements physical damage rules (interacting with target armor). |
| **Concrete Implementor 2** | `MagicalDamageEffect` | Implements magical damage rules (interacting with magic resistance). |
| **Concrete Implementor 3** | `PureDamageEffect` | Implements pure damage rules (bypassing armor and resistance). |
| **Client** | `Main` / `DotaGameClient` | Assembles abstraction and implementor objects dynamically at runtime. |

### Structural Class Diagram

```
                 +-----------------------+                    +------------------------+
                 |       Ability         |  (has a)           |      DamageEffect      |
                 +-----------------------+ -----------------> +------------------------+
                 | - damageEffect        |                    | + applyDamage(...)     |
                 +-----------------------+                    +------------------------+
                 | + setDamageEffect(...)|                                |
                 | + cast(...)           |                                |
                 +-----------------------+                                |
                             ^                                            |
             +---------------+---------------+              +-------------+-------------+---------------------------+
             |                               |              |                           |                           |
   +-------------------+           +------------------+  +----------------------+  +---------------------+ +--------------------+
   |  TargetedAbility  |           |    AoEAbility    |  | PhysicalDamageEffect |  | MagicalDamageEffect | | PureDamageEffect   |
   +-------------------+           +------------------+  +----------------------+  +---------------------+ +--------------------+
   | + cast(...)       |           | + cast(...)      |  | + applyDamage(...)   |  | + applyDamage(...)  | | + applyDamage(...) |
   +-------------------+           +------------------+  +----------------------+  +---------------------+ +--------------------+
```

---

## 3. Key Clean Code Principles Applied

The implementation strictly adheres to standard software engineering best practices and Clean Code guidelines:

1. **Clear Separation of Concerns (Single Responsibility Principle):**
    * High-level casting mechanics (targeting, AoE range) are strictly handled inside `Ability` subclasses.
    * Low-level damage calculations and resistances are encapsulated entirely within `DamageEffect` implementations.

2. **Open/Closed Principle & Backward Compatibility:**
    * Adding a new damage type (e.g., `PureDamageEffect`) does **not** require modifying any existing `Ability` class.
    * Adding a new ability type (e.g., `PassiveAbility` or `VectorTargetedAbility`) does **not** break or alter existing `DamageEffect` interfaces or classes.

3. **Meaningful Naming Conventions:**
    * Class names clearly express both their domain purpose (`TargetedAbility`, `PhysicalDamageEffect`) and their role in the Bridge pattern structure, making code intent self-explanatory.

4. **Small, Focused Classes:**
    * Each class adheres to a single responsibility and maintains a minimal footprint without bloated methods or multi-purpose logic blocks.

5. **Elimination of Code Duplication (DRY Principle):**
    * Damage application logic is localized inside dedicated `DamageEffect` implementations rather than being repeatedly duplicated inside various ability subclasses.

6. **Runtime Flexibility via Composition:**
    * Using the setter method `setDamageEffect(...)`, an ability's damage behavior can be dynamically changed at runtime (e.g., simulating item purchases like *Ethereal Blade* or damage-type modifiers).

---

## 4. How to Run

### Prerequisites
* Java Development Kit (JDK 8 or higher)

### Compilation & Execution
1. Clone the repository:
   ```bash
   git clone <your-repository-url>
   cd <repository-folder>
   ```
2. Compile the source files:
   ```bash
   javac -d bin src/*.java
   ```
3. Run the main client application:
   ```bash
   java -cp bin Main
   ```

---

## 5. Sample Output

```text
Casting targeted spell 'Stifling Dagger' directly on Enemy Crystal Maiden!
[Physical Damage] Applies 250 physical damage to Enemy Crystal Maiden (reduced by armor).

Casting AoE spell 'Light Strike Array' around area: Roshpit!
[Magical Damage] Deals 400 magic damage to all enemies in Roshpit (reduced by magic resistance).

--- Hero activates spell modifier item ---

Casting targeted spell 'Stifling Dagger' directly on Enemy Axe!
[Magical Damage] Deals 250 magic damage to Enemy Axe (reduced by magic resistance).
```