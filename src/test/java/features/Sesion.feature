Feature: Sesion

  Scenario: Iniciar Sesion y Cerrar Sesion

    Given usuario en portada principal
    When usuario hace sign in
    And usuario llena formulario sign in
    And usuario clica boton sign in
    Then usuario redirigido portada
    When usuario clica sign out
    Then usuario cierra sesion
    When espera cinco segundos
    Then usuario redirigido portada again