Feature: Actualizar informacion de usuarios

  @Actualizar_1
  Scenario: Actualizar información de un usuario existente
    Given Yo actualizo el usuario "2" con el nombre "Jose" y trabajo "Product Manager"
    Then Yo deberia ver el status 200 y nombre y trabajo actualizados

  @Actualizar_2
  Scenario: Actualización parcial de un usuario
    Given Yo realizo la actualizacion parcial del usuario "2" con el trabajo "Project Manager"
    Then Yo deberia de ver el campo job actualizado con el nuevo cargo
