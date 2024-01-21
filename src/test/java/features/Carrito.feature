Feature: Carrito

  Scenario Outline: Añadir producto al carrito

    Given usuario en main page
    When usuario click gear y bags
    And usuario click producto
    And usuario elige <cantidad> y click boton add
    Then carrito actualizado


    Examples:
      | cantidad |
      | 1        |
      | 2        |

  Scenario Outline: Añadir productos maximos al carrito

    Given usuario en main page
    When usuario click gear y bags
    And usuario click producto
    And usuario elige <cantidad> y click boton add
    Then carrito actualizado y error


    Examples:
      | cantidad |
      | 10000    |
