alter table products
    alter column created_at type timestamp;
alter table users
    alter column created_at type timestamp;
alter table orders
    alter column order_date type timestamp;
alter table card
    alter column expiry_date type timestamp,
    alter column created_date type timestamp;
