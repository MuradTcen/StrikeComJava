update conflicts set industry_id = (select id from industries where name_ru='Обрабатывающие производства')
where industry_id = (select id from industries where name_ru='Электроэнергетика')
delete from industries where name_ru='Электроэнергетика'