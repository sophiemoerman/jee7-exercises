#TODO

- Create `PersonReader`, `PersonProcessor` and `PersonWriter` class
  - The `PersonReader` reads the `people.csv` file line per line
  - The `PersonProcessor` converts each line to a `Person` object
      - Make sure you handle persons with special last names!
  - The `PersonWriter` uses the `EntityManager` to save `Person`s