Feature: Register

  Scenario: Registrarse Con Correo Existente

    Given el usuario esta en la portada
    When el usuario hace click en Create an Account
    And el usuario rellena la informacion con un email repetido
    And el usuario le da click al boton de Create an Account
    Then aparece error de mail existente en la pagina de Registro

  Scenario Outline: Password incorrecta

    Given el usuario esta en la portada
    When el usuario hace click en Create an Account
    And el usuario añade una <passwd>
    Then aparece el mensaje de error <error>

    Examples:
      |passwd     |  error  |
      |ex1        |  length |
      |ex1aaaaa   |  classes |
      |Ex1aaaaa   |  no_error |

  Scenario Outline: Password no confirmada

    Given el usuario esta en la portada
    When el usuario hace click en Create an Account
    And el usuario rellena la informacion sin la passwd
    And el usuario añade una <passwd>
    And el usuario confirma su <passwdConf>
    And el usuario le da click al boton de Create an Account
    Then se muestra el mensaje de <error>

    Examples:
      | passwd | passwdConf |  error  |
      |  a     | a          | no      |
      | a      |   b         | si      |
      | ejemPlo1 | ejemplo1  |  si     |
      | ejemPlo2 | ejemPlo2  |  no     |
      |          |    ej3    |  required |


  Scenario: Registrarse Sin Errores

    Given el usuario esta en la portada
    When el usuario hace click en Create an Account
    And el usuario rellena la informacion con un email nuevo
    And el usuario le da click al boton de Create an Account
    Then aparece la pagina de My Account

