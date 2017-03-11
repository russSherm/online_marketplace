# csci50700_spring2017_marketplace
Spring 2017 Online Marketplace

Instructions on executing from Tesla

Once all files are in Tesla directory, follow these steps to execute the code:

- Create Remote Connection with Tesla through Terminal/Command Line

- Log in to your tesla account using your username and password

- Find the correct directory and use the 'cd' command to switch to that directory

- Repeat these three steps again to open an additional Terminal/Command Line

- On one of the connections, compile all java files in the directory by running the 'javac *.java' command

- Establish Java RMI Registry connection by typing 'rmiregistry 1720&' and hitting enter

- Run Server file by running 'java -Djava.security.policy=policy Server' command

- On the other Terminal, run 'java -Djava.security.policy=policy Client'

- When prompted, enter your role. Entering "administrator" will log in to the Admin View. 

- Entering customer will direct you to the Customer View.

- Once finished, hit 'CTRL-C' and then enter 'fg' to check for continuing connections

- If still connected to rmiregistry 1720, again use the 'CTRL-C' command to end the connection



