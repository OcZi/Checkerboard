# Checkerboard
Simulador de tabla de ajedrez designado a depuración.

# Uso y ejemplo
Una vez iniciado el programa, se encontrará dentro del menú principal
con las siguientes opciones:
```
[Checkerboard vX.X]
Chess table simulator.
Designed for debugging.
 
S - Start new game. # Crear un nuevo juego
Q - Quit # Finalizar el programa
```
# Nuevo juego
Si crea un nuevo juego, se generará una nueva tabla vacía
con los siguientes comandos disponibles:
```
   A  B  C  D  E  F  G  H
1  .  .  .  .  .  .  .  .
2  .  .  .  .  .  .  .  .
3  .  .  .  .  .  .  .  .
4  .  .  .  .  .  .  .  .
5  .  .  .  .  .  .  .  .
6  .  .  .  .  .  .  .  .
7  .  .  .  .  .  .  .  .
8  .  .  .  .  .  .  .  .

Execute a command:
Select <ID> - Select a piece to move by ID.
Remove <ID> - Remove a Chess piece.
New - Create a new Chess piece.
Quit - Quit menu.
```

# Comando new
Para crear una nueva ficha, debe de ejecutar el comando "new",
el cual le redirijá al selector de fichas disponibles:
```
Select new chess:
- pawn
- bishop
- knight
- rook
- queen
- king
```

Una vez seleccionado la ficha por su nombre, le pedirá las coordenadas
en la que estará la nueva ficha.
```
   A  B  C  D  E  F  G  H
1  .  .  .  .  .  .  .  .
2  .  .  .  .  .  .  .  .
3  .  .  .  .  .  .  .  .
4  .  .  .  .  .  .  .  .
5  .  .  .  .  .  .  .  .
6  .  .  .  .  .  .  .  .
7  .  .  .  .  .  .  .  .
8  .  .  .  .  .  .  .  .

Write the X axis:
3
Write the Y axis letter:
a
```

después de crearlo, la ficha se encontrará en la tabla con una id predeterminada (Que en este caso es P).
```
   A  B  C  D  E  F  G  H
1  .  .  .  .  .  .  .  .
2  .  .  .  .  .  .  .  .
3  P  .  .  .  .  .  .  .
4  .  .  .  .  .  .  .  .
5  .  .  .  .  .  .  .  .
6  .  .  .  .  .  .  .  .
7  .  .  .  .  .  .  .  .
8  .  .  .  .  .  .  .  .
```

# Comando select
Para mover una ficha en la tabla, debe de ejecutar el comando "select"
con el id de la ficha como argumento.
```
select p
```

Tal y como pide el comando "new", necesitará colocar las
coordenadas a la que se moverá la ficha.
```
   A  B  C  D  E  F  G  H
1  .  .  .  .  .  .  .  .
2  *  .  .  .  .  .  .  .
3  P  .  .  .  .  .  .  .
4  .  .  .  .  .  .  .  .
5  .  .  .  .  .  .  .  .
6  .  .  .  .  .  .  .  .
7  .  .  .  .  .  .  .  .
8  .  .  .  .  .  .  .  .

Write the X axis number:
2
Write the Y axis letter:
a
```
(Los '*' son los movimientos disponibles de la ficha).

# Comando remove
Si desea eliminar una ficha de la tabla, puede ejecutar el comando "remove"
con el id de la ficha como argumento.
```
# Command line
remove p 

   A  B  C  D  E  F  G  H
1  .  .  .  .  .  .  .  .
2  .  .  .  .  .  .  .  .
3  .  .  .  .  .  .  .  .
4  .  .  .  .  .  .  .  .
5  .  .  .  .  .  .  .  .
6  .  .  .  .  .  .  .  .
7  .  .  .  .  .  .  .  .
8  .  .  .  .  .  .  .  .
```

# Comando quit
Una vez quiera salir del juego, solo bastará con ejecutar el comando "quit",
regresando al menú principal.

# Otros

_Proyecto perteneciente a las pruebas de Heronode._
