# ⚙️ backTiendaSucursal

**API REST** para un sistema de gestión de tiendas con sucursales, construida con **Java 11 + Spring Boot 2.5** y **MongoDB**, documentada con **Swagger**. Es el backend de [FrontTiendaSucursal](https://github.com/estevan118/FrontTiendaSucursal).

![Java](https://img.shields.io/badge/Java_11-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot_2.5-6DB33F?style=flat-square&logo=springboot&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-47A248?style=flat-square&logo=mongodb&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=flat-square&logo=swagger&logoColor=black)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat-square&logo=apachemaven&logoColor=white)

## 🧩 Módulos

El repositorio contiene dos servicios Spring Boot:

| Servicio | Recursos |
|---|---|
| `lagenerica/` | Clientes, proveedores, consolidado |
| `tiendastrom/` | Productos, ventas (con detalle), reportes |

Cada servicio sigue una arquitectura en capas: **Controller → Repository (Spring Data MongoDB) → Model**.

## 🚀 Cómo ejecutarlo

Requisitos: JDK 11 y una instancia de MongoDB.

```bash
cd lagenerica      # o tiendastrom
./mvnw spring-boot:run
```

La documentación interactiva de la API queda disponible en `/swagger-ui.html`.

## 👤 Autor

**Estevan Hernandez Capera** · [@estevan118](https://github.com/estevan118)
