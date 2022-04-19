# ArteLista (laboratorio #5)
Este laboratorio tiene como propósito desarrollar una aplicación móvil que promocione las obras de arte del sitio oficial https://www.artelista.com/, los estudiantes deben seleccionar otra temática distinta a la del ejemplo, a fin de poner en práctica lo aprendido. A las especificaciones se adjunta un ejemplo solución del desafío aplicado a Pinterest.

## Requeirmientos del laboratorio
  
### Requerimientos generales:
1.	La aplicación debe utilizar la internacionalización de textos, tal como se estudió en la práctica de laboratorio 4.
2.	En la medida de lo posible debe realizarse la programación haciendo uso del Binding View tal como se estudió en el laboratorio 4.
3.	La navegación de la app debe controlarse a través del componente Navigation.
4.	El código debe ordenarse y estructurarse en base a lo sugerido por la arquitectura MVVM.
5.	La app debe consultar de un servidor de base de datos Cloud Firestore

### Requerimientos específicos
1.	la **Pantalla 1** Debe incluir un splash screen de la app, con algún tipo de animación, hay distintas formas de implementar esto, una de ellas haciendo uso de recursos drawable XML, que es como se enseña, sin embargo, hay otros métodos incluso propuestos por el mismo Material Design. Queda a libre albeldrío el método de implementación.
2.	la **Pantalla 2** La pantalla de Login debe desarrollarse en base a los siguientes requerimientos: (Tal como se practicó en el lab4)
    *	El diseño debe utilizar los edittext de Material Design.
    *	Limitar la cantidad de líneas y caracteres que pueden digitarse.
    *	Utilizar iconos livianos como Vector Assets
    *	Debe validar el usuario haciendo uso de la autenticación Firebase
    *	Al hacer click en crear cuenta debe crear una nueva cuenta en el servidor, la cual debe validarse al momento de ingresar a la app.
    *	Utilizar el validator para marcar los campos requeridos.


## Objetivos del Laboratorio

### Desde el punto de vista de diseño:
1.	Aplicar y poner en práctica los fundamentos de Layouts, View y ViewGroups para los distintos tipos de Layouts.

2.	Diseñar interfaces haciendo uso de componentes de terceros de Material Component con Material Design.

3.	Desarrollar la app haciendo uso del View Binding para la programación de cada uno de los Views.

### Desde el punto de vista de arquitectura de desarrollo y base de datos: 

1.	Desarrollar interfaces gráficas en Android bajo el esquema de desarrollo MVVM (Modelo Visto View Model)
2.	Desarrollar una app usando las tecnologías proporcionadas y sugeridas por Google con Android Jetpack tales como: 
    *	Navigation
    *	DataBinding
    *	ViewModel
    *	LifeCycle y LiveData
3.	Desarrollar habilidades con el uso de base de datos Cloud como Firebase para el almacenamiento de la información
4.	Aplicación del uso de librería de Google Maps.
