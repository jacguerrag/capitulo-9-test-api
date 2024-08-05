Feature: Gestion de usuarios Crear y consultar usuarios

  @Escenario_1
  Scenario: Crear un nuevo usuario con informacion valida
    Given Yo creo un nuevo usuario con email "jose@gmail.com" nombre "Jose" apellido "Perez" y avatar "avatar"
    Then Yo deberia de ver un codigo de respuesta 201 y en la respuesta el id nombre y marca de tiempo no vacios

  @Escenario_2
  Scenario: Obtener detalles de un usuario
    Given Yo realizo la consulta de un usuario con ID "2"
    Then Yo puedo validar el codigo de estado en 200 y los campos email nombre apellido y avatar.
