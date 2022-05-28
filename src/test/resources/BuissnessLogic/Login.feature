Feature: Login functionality

Background: User is successfully canceled initial login page
When User open "chrome" browser with exe as
When user enter URL as 
When user cancle initial Login window

@Smoketest
Scenario: Login functionality with valid credentials
When user navigate on Login button
When user click on MyProfile
When user enter "9588406397" as username 
When user enter "Sahadeo@123" as password
When user click on Login button
Then Application shows user profile to user

@Regressiontest
Scenario Outline: Login functionality with invalid username in UC and valid password
When user navigate on Login button
When user click on MyProfile
When user enters <username> as username 
When user enters <password> as password
When user click on Login button
Then Application shows appropriate error message

Examples:
          |username|password|
          |ABCDSS|Sahadeo@123|
          |9588406397|ABCD@123|
