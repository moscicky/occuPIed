# occu-Pi-ed
Project for Embedded Systems at our UNI.

Goal is to build a web application using Raspbery Pi.

We've decied to build an app which mananges queue to the toilet. 

# workflow

It consits of 3 components. 

1. Java Spring Boot app deployed to the web (probably Herkoku) responsible for storing information about queue state. 
2. Java Spring Boot app on Raspberry Pi which is connected to card scanner, led display and diode. It queries the queue 
state and based on that allows or doesn't allow one to enter the toilet.
3. Front-end app responsible for presenting queue state and interaction with the queue. 

# issues
Unforunately, we don't have public IPs nor we want to mess with port forwarding so our workflow is somewhat reversed 
and it's RPI's job to hit the server constantly.
