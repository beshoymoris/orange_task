Feature: opening manage application
 Scenario: I want to  check that user can open Managed Applications: improve operational capability in the cloud

  Given google website opened successfully
  When user select first orange link
  And select all products from solution
  Then get all product list values
  When choose cloud with clicking apply
  And choose manage application from cloud option
  Then  validate that the system opens the right article
