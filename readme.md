# Chess Game

### Entities/Object
* Game
* Board
* Player
* Pieces
* Box
***

### Design
* #### Pieces
  * All pieces like King, Queen, Bishop, Knight, Rook, Pawn inherits from pieces
  * _functions_: 
    * can move to a box, color, isKilled
* #### Box
  * Box have unique position on the board (X, Y) co-ordinates.
  * What piece it contains.
* #### Board
  * A 2 dimension matrix, that contains boxes and pieces.
  * Initializes all the boxes and pieces at start of the game.