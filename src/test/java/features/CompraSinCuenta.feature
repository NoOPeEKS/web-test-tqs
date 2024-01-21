Feature: Compra Sin Cuenta

  Scenario Outline: Compra con codigo postal erroneo

    Given usuario sin cuenta main page
    When usuario click oferta
    And usuario click producto oferta
    And usuario añade producto y cantidad <cantidad>
    And usuario click carrito y checkout
    And usuario llena formulario codigo postal erroneo
    Then recibir error nuevo


    Examples:
      | cantidad |
      | 20      |

  Scenario Outline: Compra con email erroneo

    Given usuario sin cuenta main page
    When usuario click oferta
    And usuario click producto oferta
    And usuario añade producto y cantidad <cantidad>
    And usuario click carrito y checkout
    And usuario llena formulario email erroneo
    Then recibir error email


    Examples:
      | cantidad |
      | 20      |



  Scenario Outline: Compra Sin Cuenta

    Given usuario sin cuenta main page
    When usuario click oferta
    And usuario click producto oferta
    And usuario añade producto y cantidad <cantidad>
    And usuario click carrito y checkout
    And usuario llena formulario correcto
    And usuario click place order
    Then compra realizada


    Examples:
      | cantidad |
      | 10       |


  Scenario Outline: Crear cuenta despues de compra

    Given usuario sin cuenta main page
    When usuario click oferta
    And usuario click producto oferta
    And usuario añade producto y cantidad <cantidad>
    And usuario click carrito y checkout
    And usuario llena formulario correcto
    And usuario click place order
    Then compra realizada correctamente
    And usuario crea cuenta despues de comprar
    Then aparece confirmacion creacion cuenta



    Examples:
      | cantidad |
      | 20      |