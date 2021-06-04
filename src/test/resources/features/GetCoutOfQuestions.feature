Feature: opening manage application
 Scenario: I want to  check that user can open Managed Applications: improve operational capability in the cloud

  Given user search for Orange Business services
  When user select first link
  And select all products from solution with viewing all options
  Then choose cloud with clicking apply
  And choose manage application from cloud
  Then  validate that the system opens the right article
