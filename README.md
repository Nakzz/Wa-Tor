# Wa-Tor

[Wa-Tor](https://en.wikipedia.org/wiki/Wa-Tor) population dynamics simulation
devised by A. K. Dewdney in a Scientific American article entitled ["Computer Recreations: Sharks and fish
wage an ecological war on the toroidal planet Wa-Tor"](http://home.cc.gatech.edu/biocs1/uploads/2/wator_dewdney.pdf) (December 1984).


Wa-Tor is implemented as a two-dimensional grid showing fish, sharks and empty water. Swimming past the
edge of the grid results in the creature appearing on the opposite side. Sharks eat fish and may also starve.
Sharks and fish move, reproduce and die according to simple rules. From these simple rules complex emergent
behavior can arise.
"Time passes in discrete jumps, which I shall call chronons. During each chronon a fish or shark may
move north, east, south or west to an adjacent point, provided the point is not already occupied by a
member of its own species. A random-number generator makes the actual choice. For a fish the choice
is simple: select one unoccupied adjacent point at random and move there. If all four adjacent points
are occupied, the fish does not move. Since hunting for fish takes priority over mere movement, the
rules for a shark are more complicated: from the adjacent points occupied by fish, select one at
random, move there and devour the fish. If no fish are in the neighborhood, the shark moves just as a
fish does, avoiding its fellow sharks." (Dewdney, 1984).

## For the fish
1. At each chronon, a fish moves randomly to one of 4, adjacent unoccupied squares. If there are
no unoccupied squares, no movement takes place.
2. At each chronon, each fish ages. Once a fish's age exceeds a certain number of chronons
(fish_breed parameter) it may reproduce. Reproducing is done by leaving behind a new fish as it
moves to a new square. Both the original fish and new fish have their age reset to zero.

## For the sharks
1. At each chronon, a shark moves randomly to an adjacent square occupied by a fish. If there is
none, the shark moves to a random adjacent unoccupied square. If there are no free squares,
no movement takes place.
2. At each chronon, each shark ages. Once a shark has survived a certain number of chronons
(shark_breed parameter) it may reproduce in exactly the same way as the fish.
3. If a shark moves to a square occupied by a fish, it eats the fish and a certain amount of energy.
When this energy is depleted then the shark dies. This is implemented by resetting the time
since a shark last ate to zero. When the time the shark last ate reaches a certain time
(shark_starves parameter) then the shark dies.

### What are the parameters for the longest running simulation you can find?
