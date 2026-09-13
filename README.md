# Battle Clash

A turn-based battle game in Java. Pick a mage, warrior, or archer and fight a
goblin, barbarian, or giant — each turn you attack, block, heal, or use a
character-specific special move. First to lose all health loses.

## Design

An abstract `Characters` class holds shared state (endurance, strength, armour,
heals, blocking) and shared behaviour. Six subclasses — `Mage`, `Warrior`,
`Archer`, `Goblin`, `Barbarian`, `Giant` — define their own stat lines and
special moves. `MainGame` runs the turn loop and input handling.

Each class has different tradeoffs: the mage has low health and many heals,
the warrior high health and few.

## Running it

```bash
cd src
javac TurnBasedBattle/*.java
java TurnBasedBattle.MainGame
```