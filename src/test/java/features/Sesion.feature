Feature: Sesion

  Scenario: Iniciar Sesion y Cerrar Sesion

    Given el usuario esta en la portada principal
    When el usuario hace click en Sign in
    And el usuario rellena la informacion del inicio de sesion
    And el usuario le da click al boton de Sign In
    Then el usuario es redirigido a la portada
    When el usuario hace click en su nombre y en Sign Out
    Then el usuario cierra la sesion
    When pasan cinco segundos
    Then el usuario es redirigido a la portada otra vez