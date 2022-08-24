# forex-gump
Second assignment for Testverktyg students

## What to do

### Unit Tests

1- Test the class ExchangeCalculator

### API Tests

1- GET api/v1/exchange/buy
{
    "currency": "GBP",
    "amount": 100.0
}

- Must respond with code 200

2- GET api/v1/exchange/sell/USD/100

- Must respond with code 200
- Property "currency" in response body must be of type string
- Property "amount" in response body must be of type number
  
3- GET api/v1/exchange/sell/usd/100

- Must respond with code 500

4- Export the Postman collection v2.1 and paste the content into "api-test-collection.json"

### CI/CD
- Write a pipeline (build.yml) running on ubuntu-18.04 such that when a pull is requested to
the main branch, it builds the application.
- Create a Heroku app and connect it to your GitHub repository

### Questions

1- Does the API respond with the proper codes in the three tested cases? Why?

2- Do Dtos need to be tested? Why?

3- Criticize the application. Reveal the weak parts you can spot and propose
ideas to improve them
