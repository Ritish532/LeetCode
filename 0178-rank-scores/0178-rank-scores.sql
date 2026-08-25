-- # Write your MySQL query statement below
-- select score , rank() over(order by score desc) as 'rank' from scores;
SELECT score,
       dense_rank() OVER (ORDER BY score DESC) AS `rank`
FROM Scores;