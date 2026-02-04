SELECT e.firstName, e.lastName, s.city, s.state
FROM Person e
Left JOIN Address s
ON e.personID=s.personID;
