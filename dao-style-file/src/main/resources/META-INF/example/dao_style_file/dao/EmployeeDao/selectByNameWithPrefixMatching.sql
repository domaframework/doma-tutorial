select
    /*%expand*/*
from
    employee
where
    name like /* @prefix(prefix) */'X%' escape '$'
