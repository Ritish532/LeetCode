# Write your MySQL query statement below
select author_id as id
from views as v
where author_id = v.viewer_id
group by author_id
order by id;