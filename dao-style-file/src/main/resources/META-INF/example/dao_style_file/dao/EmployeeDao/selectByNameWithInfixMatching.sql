select
    /*%expand*/*
from
    employee
where
    name like /* @infix(inside) */'%X%' escape '$'
