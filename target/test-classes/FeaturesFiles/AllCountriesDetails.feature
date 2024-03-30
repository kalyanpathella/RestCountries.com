Feature: get all countries deatils 

Scenario: featch all countries details 
Given define HTTP request using path "/all"
When submit request via HTTP GET method
Then verify the status code is 200
And vefiry the expected body and actual body both are same "src\test\resources\TestDataFiles\allCountriesDetails.json"
