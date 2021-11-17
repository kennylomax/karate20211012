Feature: MyAPI

Background:
  * url 'http://localhost:8080/api/materials'

Scenario: get All Material 
  Given path ''
  When method GET
  Then status 200
  And match $ ==  [{"id":1,"name":"Bob"},{"id":2,"name":"Fred"},{"id":3,"name":"Jack"}]

  Given path '/1'
  When method GET
  Then status 200
  And match $ ==  {"id":1,"name":"Bob"}

Scenario: add new Material 
  Given path '/'
  When request {"name":"Frank"}
  And method post 
  Then status 201 
  And print 'Response from Add is: ', response 
  And match response == {"id":4,"name":"Frank"}

  And method get 
  Then status 200
  And match $ ==  [{"id":1,"name":"Bob"},{"id":2,"name":"Fred"},{"id":3,"name":"Jack"}, {"id":4,"name":"Frank"}]

  Given path '/4'
  And method delete 
  Then status 200
  And print 'Response from Delete is: ', response 
  
  Given path '/'
  And method get 
  Then status 200
  And match $ ==  [{"id":1,"name":"Bob"},{"id":2,"name":"Fred"},{"id":3,"name":"Jack"}]

Scenario: adjust  Material 
  Given path '/1'
  When request {"id":1, "name":"Bob1"}
  And method put 
  Then status 200 
  And print 'Response from Adjust is: ', response 
  And match response == {"id":1,"name":"Bob1"}

  And method get 
  Then status 200
  And match $ ==  [{"id":1,"name":"Bob1"},{"id":2,"name":"Fred"},{"id":3,"name":"Jack"}]


Scenario: delete non-existent Material 
  Given path '/6'
  And method delete 
  Then status 404 
  

Scenario: adjust non-existent Material 
  Given path '/6'
  When request {"id":1, "name":"Bob1"}
  And method put 
  Then status 400

  Given path '/6'
  When request {"id":6, "name":"Bob1"}
  And method put 
  Then status 404
  
  




