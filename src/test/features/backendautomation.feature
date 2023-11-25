@charmander
Feature: pokemon Ability test


  Scenario: Get a ability by pokemon
    Given url 'https://pokeapi.co/api/v2/pokemon/charmander'
    When method GET
    Then status 200
    And match response.abilities[0].ability.name == 'blaze'

  @ditto
  Scenario: Get a ability by pokemon
    Given url 'https://pokeapi.co/api/v2/pokemon/ditto'
    When method GET
    Then status 200
    And match response.abilities[0].ability.name == 'limber'
