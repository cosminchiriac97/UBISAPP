# UBISAPP
RESTful Web Services Application<br/>
<br/>
Server:
<br/>
apache-maven-3.5.0, Spring, HTTP (8081) <br/>
Technologies:<br/>
-Database: SQLITE<br/>
-c3p0: for connection pool<br/> 
API:<br/>
-/ticket_details/{id}: method=GET,  receives JSON with ticket details <br/>
-/buy_ticket method=POST: send JSON with: "eventId" and "owner"<br/>
-/cancel_ticket method=POST: send JSON with: "id", "eventId" and "owner"<br/>
-/list_events: method=GET, receives JSON with list of events <br/>
