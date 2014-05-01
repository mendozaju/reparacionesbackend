create sequence hibernate_sequence;
create table PRODUCT(PRODUCT_ID integer not null, PRODUCT_NAME varchar(255), PRODUCT_PRICE double, PRODUCT_STOCK integer, primary key (PRODUCT_ID));
insert into PRODUCT(PRODUCT_ID, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_STOCK) values (1,'Tablet Bangho XT45',1200.59,10);
insert into PRODUCT(PRODUCT_ID, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_STOCK) values (2,'Samsung Galaxy S4',6399.29,400);
insert into PRODUCT(PRODUCT_ID, PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_STOCK) values (3,'Monitor LED LG',2600,15);
commit;
