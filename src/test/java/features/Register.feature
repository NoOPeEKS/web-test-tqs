Feature: Register

  Scenario: Registrarse con correo existente

    Given usuario en portada
    When usuario click Create an Account
    And usuario llena formulario email repetido
    And usuario click boton create an account
    Then error mail existente

  Scenario Outline: Password incorrecta

    Given usuario en portada
    When usuario click Create an Account
    And usuario añade passwd <passwd>
    Then mensaje error <error>

    Examples:
      |passwd     |  error  |
      |ex1        |  length |
      |ex1aaaaa   |  classes |
      |Ex1aaaaa   |  no_error |

  Scenario Outline: Password no confirmada

    Given usuario en portada
    When usuario click Create an Account
    And usuario llena formulario sin passwd
    And usuario añade passwd <passwd>
    And usuario confirma <passwdConf>
    And usuario click boton create an account
    Then mostrar mensaje <error>

    Examples:
      | passwd | passwdConf |  error  |
      |  a     | a          | no      |
      | a      |   b         | si      |
      | ejemPlo1 | ejemplo1  |  si     |
      | ejemPlo2 | ejemPlo2  |  no     |
      |          |    ej3    |  required |


  Scenario: Registrarse Sin Errores

    Given usuario en portada
    When usuario click Create an Account
    And usuario llena formulario email nuevo
    And usuario click boton create an account
    Then usuario redirigido My Account

