Feature: Realizar el proceso de contratación de una persona
  Como un reclutador
  quiero ingresar a la página https://opensource-demo
  para realizar el proceso de contratacion de una persona

  Background:
    Given Un reclutador Jorge accede hasta el modulo recruitment con usuario Admin y contraseña admin123

  @EscenarioInicial
  Scenario Outline: Realizar el proceso de contratación exitosa de un nuevo colaborador
    When Se anade un nuevo usuario y se realiza el proceso de contratacion
      | <name>   | <secondname> | <lastname> |  <Email> |
    Then Se valida todos los datos diligenciados en el formulario

    Examples:
      | name  | secondname | lastname | Email |
      | capes | somedesaa  | ledem    | t231as123123@gmail.com |






