select
    /*%expand*/*
from
    employee
where
    name in /* names */('aaa', 'bbb')
