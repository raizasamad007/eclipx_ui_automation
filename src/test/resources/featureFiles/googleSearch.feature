Feature: Google Search Feature

#Search for a text in the Google search page and click on the first link from the search results. 
#Verify the presence of the searched text in the webpage

Scenario: Verify google search feature
Given User is on the Google Search page and a search box is displayed
When User enters search text "Eclipx" on the search box
And User clicks on the first link available in the search results
Then Searched text "Eclipx" should be displayed in the page.



    
      
  
