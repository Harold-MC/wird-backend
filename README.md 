# Servicio Meteorológico con Ktor y Redis

Este proyecto es un servicio que consulta datos meteorológicos desde la API de OpenWeatherMap, con almacenamiento en caché utilizando Redis para mejorar el rendimiento y reducir las consultas repetitivas a la API.

## Requisitos Previos

- **Java 17**: Asegúrate de tener instalado Java 17 en tu máquina.
- **Gradle**: Necesario para construir y ejecutar el proyecto.
- **Redis**: Instalado y corriendo en `localhost` en el puerto predeterminado (`6379`).
- **API Key** de [OpenWeatherMap](https://openweathermap.org/api): Necesaria para acceder a los datos meteorológicos.

## Configuración

Antes de ejecutar el proyecto, asegúrate de configurar las siguientes variables de entorno:

- **`OPENWEATHER_API_KEY`**: Clave de la API de OpenWeatherMap. Puedes configurarla en tu terminal con el siguiente comando:

  ```bash
  export OPENWEATHER_API_KEY=d235f521a1b14ae53f15903a32e47a44

## Estructura del Proyecto

-   **`com.wird.weather.Main.kt`**: Punto de entrada del proyecto.
-   **`com.wird.service.WeatherService.kt`**: Lógica de servicio para consultas meteorológicas y almacenamiento en caché en Redis.
-   **`com.wird.plugins.routing.kt`**: Configuración de rutas expuestas en el servicio.
## Instalación

1.  Clona este repositorio:
   
    `git clone https://github.com/Harold-MC/wird-backend.git` 
    
2.  Configura la variable de entorno `OPENWEATHER_API_KEY` como se mencionó anteriormente.
    
3.  Compila el proyecto:
    
    `./gradlew build` 
    

## Ejecución del Proyecto

Para ejecutar el proyecto en un entorno local, asegúrate de que Redis esté activo y accesible en `localhost:6379`.

Ejecuta el siguiente comando en la raíz del proyecto:

`./gradlew run` 

Esto iniciará el servicio en el puerto predeterminado de Ktor (`8080`).

## Uso del Servicio

Una vez que el proyecto esté ejecutándose, puedes hacer solicitudes a los endpoints para obtener datos meteorológicos. La ruta predeterminada para obtener información del clima es:

`GET http://localhost:8080/weather/{ciudad}` 

Reemplaza `{ciudad}` con el nombre de la ciudad para la cual deseas consultar el clima, un ejemplo pudiera ser:

`GET http://localhost:8080/weather/santiago,cl` 

## Despliegue en Producción

Para desplegar este proyecto en Heroku o cualquier otra plataforma, consulta la Documentación de Despliegue.

## Contribuciones

Las contribuciones son bienvenidas. Si deseas proponer cambios o mejoras, crea un "Pull Request" o abre un "Issue".

## Licencia

Este proyecto se distribuye bajo la licencia MIT.