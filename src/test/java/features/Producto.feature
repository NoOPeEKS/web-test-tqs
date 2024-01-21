Feature: Producto

  Scenario Outline: Añadir review a producto

    Given usuario loggeado
    When usuario escoge <producto>
    And usuario click reviews
    And usuario llena formulario review
    And usuario submit review
    Then review confirmada

    Examples:
      | producto                |
      | Radiant Tee             |
      | Hero Hoodie             |
      | Fusion Backpack         |
      | Argus All-Weather Tank  |

  Scenario Outline: Añadir a la wish list

    Given usuario loggeado
    When usuario escoge <producto>
    And usuario add to wish list
    Then <producto> en wish list

    Examples:
      | producto                |
      | Radiant Tee             |
      | Hero Hoodie             |
      | Fusion Backpack         |
      | Argus All-Weather Tank  |

  Scenario: Eliminar de la wish list

    Given usuario loggeado
    And usuario tiene producto en la wish list
    And usuario elimina producto wish list
    Then producto eliminado wish list