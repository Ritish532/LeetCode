# Write your MySQL query statement below
SELECT firstName , lastName , city , state 
FROM Person as P
left join Address as A
on  P.personId = A.personId;