# How To Run

This was created on the intelliJ IDE.

1. Go to Run > Edit Configurations 
2. Add New Configuration > Application
3. Direct it to have the main class be ContactApplication and in program arguments put "server config.yml" (without quotes)
4. Run the program and access the API with choice of program/software (i.e. Postman)
	a. http://localhost:8080/{insert calls here}

# Design Choices

I decided to go with a Map since it would be the easiest to set up for myself at the moment. 
I would prefer to use a database (i.e. postgreSQL, etc) with a Contacts table if I were to iterate on this.
I used Dropwizard as the backbone to set up the API due to some familiarity. There is some template code that doesn't get used but is there to fulfill requirements.