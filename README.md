# hogwarts-data
Project in Kotlin to manage Hogwarts data

VERSION 1.0
La aplicación solicitada se ha desarrollado en Kotlin, aplicando la arquitectura MVVM, así como también aplicando la inyección de dependencias a través de Dagger Hilt.

En esta versión se han implementado los siguientes requisitos marcados:
-Pantalla de login:
  -Usuarios precargados
  -Guardar estado del login (Para ello se ha hecho uso de las SharedPreferences como recurso de almacenamiento persistente)
  -Permitir el logOut a través de un icono en la AppBar en el resto de pantallas.
-Pantalla de casas y favoritos:
  -Mostrar la información de las casas principales: Para ello, se ha hecho uso de los RecyclerViews, de cara a poder manejar el visualizado de más casas en caso de que se añadiesen de forma posterior.
  -Mostrar la información concreta de cada casa al pulsar sobre ellas y botón de favoritos: Para ello, se ha hecho uso de la librería Navigation, de cara a poder navegar entre las vistas (fragments).
-Pantalla de información:
  -Mostrar la información principal de la casa seleccionada en la anterior pantalla: Los listados se han vuelto a desarrollar con RecyclerViews.
  -Poder marcar como favoritos los líderes en su respectiva lista: 
    -Dicha funcionalidad se ha desarrollado en el viewHolder del listado, al cual se le pasa por parámetros la función
    del fragment que se encarga de modificar dicha información.
    -Dado que la API que se nos ha brindado es únicamente de lectura y no nos permite almacenar más información, se ha optado por almacenar los id's de los líderes
    favoritos a través de las SharedPreferences.
-Pantalla de personajes favoritos:
  -Mostrar la lista de los líderes marcados como favoritos: La lista se ha implementado haciendo uso de un RecyclerView, recuperando la información a través de las SharedPreferences.
  -Tener la opción de eliminar un líder como favorito: Se ha implementado la lógica necesaria para eliminar el id del líder que queramos eliminar de favoritos y actualizar
  esa información en las SharedPreferences.
  -Poder filtrar los líderes favoritos por nombre y apellidos: Se ha implementado haciendo uso de un SearchView.
  
MEJORAS PARA FUTURAS VERSIONES

-De cara a futuras versiones de la aplicación, se debería aplicar Room como base de datos local, de cara a poder almacenar los datos recogidos de la API al iniciar la APP
y no tener que estar haciendo llamadas innecesarias al servidor. Así como también, con esta mejora podríamos optimizar el almacenado de líderes favoritos.
-También, se debería mejorar la interfaz gráfica, puesto que en la primera versión de la misma se ha optado por realizar un MVP que cumpliese estrictamente con los requisitos
para poder llegar a los plazos marcados.
