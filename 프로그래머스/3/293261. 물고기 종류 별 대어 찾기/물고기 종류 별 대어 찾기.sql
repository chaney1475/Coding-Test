-- 코드를 작성해주세요
select f.ID, fn.FISH_NAME, f.LENGTH
from FISH_INFO as f join FISH_NAME_INFO as fn
on f.FISH_TYPE = fn.FISH_TYPE
where (f.FISH_TYPE, f.LENGTH) in (
    select FISH_TYPE, max(length)
    from FISH_INFO
    group by FISH_TYPE
)
order by f.id;