Create a `RegistrationService` with remote interface as **Stateful** Session Bean
  - Add `person` and `address` fields as state
  - Add three methods:
      - `addPerson(firstName, lastName, birthDate)` which sets a person
      - `addAddress(street, number, city, postCode)` which sets an address
      - `savePerson()` that links the address to the person and saves them with the `PersonService`