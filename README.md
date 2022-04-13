# Dojo-12-4

Práctica de microservicios conectados a RabbitMQ

## Microservicio facturar
### endpoint POST /facturasReactivas/guardarFactura
Ingreso por defecto
```json
{
    "nomCliente": "Janira Lopez",
    "total":2.52,
    "nomCajero": "Eddi Garcia"
}
```
Respuesta
```json
{
    "id": "ea89c569-f",
    "fecha": "2022-04-12",
    "nomCliente": "Janira Lopez",
    "total": 2.52,
    "aplicaDesc": false,
    "nomCajero": "Eddi Garcia"
}
```
*El id y la fecha se generan automáticamente

Se aplica descuento se manda el param aplicaDesc a true cuando el total a registrar es de más de $100
```json
{
    "nomCliente": "Gabriela Acevedo",
     "total": 800.15,
     "aplicaDesc": true,
     "nomCajero": "Sarah Yagual"
}
```
Respuesta
```json
{
        "id": "825dcc97-2",
        "fecha": "2022-04-12",
        "nomCliente": "Gabriela Acevedo",
        "total": 800.15,
        "aplicaDesc": true,
        "nomCajero": "Sarah Yagual"
}
```
### endpoint GET /facturasReactivas
Se obtendrán todas las facturas
```json
[
    {
        "id": "96c2cd2e-e",
        "fecha": "Tue Apr 12 05:00:00 UTC 2022",
        "nomCliente": "Juan Reyes",
        "total": 54.2,
        "aplicaDesc": false,
        "nomCajero": "Mishell Yagual"
    },
    {
        "id": "2190445a-5",
        "fecha": "Tue Apr 12 05:00:00 UTC 2022",
        "nomCliente": "Norma Elizondo",
        "total": 120.15,
        "aplicaDesc": true,
        "nomCajero": "Erick Burgos"
    },
    {
        "id": "07ff88c6-3",
        "fecha": "Tue Apr 12 05:00:00 UTC 2022",
        "nomCliente": "Sara Elizondo",
        "total": 20.15,
        "aplicaDesc": false,
        "nomCajero": "Mishell Yagual"
    },
    {
        "id": "4f3b6197-6",
        "fecha": "2022-04-12",
        "nomCliente": "Ximena Elizondo",
        "total": 320.15,
        "aplicaDesc": true,
        "nomCajero": "Sarah Yagual"
    },
    {
        "id": "825dcc97-2",
        "fecha": "2022-04-12",
        "nomCliente": "Gabriela Acevedo",
        "total": 800.15,
        "aplicaDesc": true,
        "nomCajero": "Sarah Yagual"
    },
    {
        "id": "2cf5560e-f",
        "fecha": "2022-04-12",
        "nomCliente": "Ruth Guerrero",
        "total": 15.15,
        "aplicaDesc": false,
        "nomCajero": "Mishell Yagual"
    },
    {
        "id": "395a7f83-3",
        "fecha": "2022-04-12",
        "nomCliente": "Oscar Reyes",
        "total": 5.15,
        "aplicaDesc": false,
        "nomCajero": "Erick Burgos"
    },
    {
        "id": "3083a9ad-3",
        "fecha": "2022-04-12",
        "nomCliente": "Franco Reyes",
        "total": 555.45,
        "aplicaDesc": false,
        "nomCajero": "Mishell Yagual"
    },
    {
        "id": "3dbe2b07-2",
        "fecha": "2022-04-12",
        "nomCliente": "Franco Reyes",
        "total": 555.45,
        "aplicaDesc": false,
        "nomCajero": "Mishell Yagual"
    }
]
```
### endpoint GET /facturasReactivas/factura/{id} 
Se obtiene la factura por el id correspondiente. Ejemplo: GET /facturasReactivas/factura/2190445a-5
```json
{
    "id": "2190445a-5",
    "fecha": "2022-04-12",
    "nomCliente": "Norma Elizondo",
    "total": 120.15,
    "aplicaDesc": true,
    "nomCajero": "Erick Burgos"
}
```
## Microservicio Clientes

### endpoint POST /clientes
Ingreso por defecto
```json
{
   "nombre": "Lucia",
   "telefono": "091652998",
   "documento": "51566257"
}
```
Respuesta (de referencia)
```json
 {
        "nombre": "Lucia",
        "telefono": "091652998",
        "id": "7d9653c3-b",
        "documento": "51566257"
 }
```
### endpoint GET /clientes
```json
[
    {
        "nombre": "Lucia",
        "telefono": "091652998",
        "id": "7d9653c3-b",
        "documento": "51566257"
    },
    {
        "nombre": "Maxi",
        "telefono": "098889699",
        "id": "583d61c9-c",
        "documento": "38242971"
    }
]
```

# Conclusiones
- El uso de docker para el levantamiento de microservicios es importante durante despliegue en ambientes de producción, ya que permite que una solución de SW sea desacoplable
- RabbitMQ permite el monitoreo de la comunicación entre microservicios

# Alcance
- La practica presentada está desplegada en AWS y son los dos microservicios que se conectan al servicio de rabbitMQ colocado en un contenedor

# Recomendaciones
- La comunicación con el contenedor de rabbitmq para el despliegue puede llegar a ser muy engorrosa, se recomienda leer y considerar los siguientes enlaces consultados de acuerdo con cada particularidad presentada durante el dojo
- Tener en cuenta las credenciales y en el aplication properties establecer el puerto a utilizar. Este a su vez debe ser el mismo en el que se debe levantar el contenedor
 
# Enlaces de interés
- [Running rabbitmq with docker.host.internal] https://stackoverflow.com/questions/24319662/from-inside-of-a-docker-container-how-do-i-connect-to-the-localhost-of-the-mach#:~:text=Use%20%2D%2Dnetwork%3D%22host%22,point%20to%20your%20docker%20host.
- [Dockerize with maven] https://www.educative.io/edpresso/how-do-you-dockerize-a-maven-project
- [RabbitMQ and Spring integration] https://www.sdos.es/blog/microservicios-mensajes-spring-rabbitmq
- [no-main-manifest-attribute error] https://ao.ms/spring-boot-no-main-manifest-attribute-in/


