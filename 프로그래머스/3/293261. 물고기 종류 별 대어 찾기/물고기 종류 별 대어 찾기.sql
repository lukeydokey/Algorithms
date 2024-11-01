-- 코드를 작성해주세요
select id, fish_name, length
from fish_info as fi join fish_name_info as fni
on fi.fish_type = fni.fish_type
where (fi.fish_type, fi.length) in (
    select fish_type, max(length)
    from fish_info
    group by fish_type
)
order by fi.id asc