Feature: Cuenta

    Scenario Outline: Cambiar nombre

      Given usuario inicia sesion
      When usuario abre menu
      And usuario click my account
      And usuario click edit info
      And usuario cambia nombre <name>
      And usuario cambia apellido <surname>
      And usuario click save
      Then nombre <name> editado
      And apellido <surname> editado

      Examples:
      | name    | surname |
      | Carlos  | Garcia  |
      | Joan    | Per3z   |
      | Marc21    | Fuentes |


    Scenario Outline: Cambiar email correctamente
      Given usuario inicia sesion con <emailLoggin>
      When usuario abre menu
      And usuario click my account
      And usuario click edit info
      And usuario click edit mail
      And usuario edita email <email>
      And usuario introduce passwd
      And usuario click save
      Then usuario entra nuevo mail <email>


      Examples:
      |email    | emailLoggin |
      |prueba11@email.com | prueba1@email.com     |
      |prueba1@email.com  | prueba11@email.com    |



    Scenario: Consultar Historial de Compras

      Given usuario inicia sesion
      When usuario abre menu
      And usuario click my account
      And usuario click my orders
      And usuario consulta pedido
      Then aparece detalle pedido


    Scenario: Consultar historial de Compras y repetir un pedido

      Given usuario inicia sesion
      When usuario abre menu
      And usuario click my account
      And usuario click my orders
      And usuario consulta pedido
      And usuario reordena pedido
      Then pedido completado

