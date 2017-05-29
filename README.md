# UBISAPP
RESTful Web Services Application
Server:
apache-maven-3.5.0, Spring, HTTP (8081) 
Technologies:
-Database: SQLITE
-c3p0: for connection pool 
API:
-/ticket_details/{id}: method=GET,  receives JSON with ticket details 
-/buy_ticket method=POST: send JSON with: "eventId" and "owner"
-/cancel_ticket method=POST: send JSON with: "id", "eventId" and "owner"
-/list_events: method=GET, receives JSON with list of events 
