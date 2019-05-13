	create table customer 
		(
			id 			bigint not null auto_increment, 
			email 			varchar(255), 
			first_name 		varchar(255), 
			last_name 		varchar(255), 
			token 			varchar(255), 
			primary key 		(id)
		) engine=InnoDB
	create table dish 
		(
			id 			bigint not null auto_increment, 
			cost 			double precision not null, 
			name 			varchar(255), 
			menu_id 		bigint, 
			primary key 		(id)
		) engine=InnoDB
	create table menu 
		(
			id 			bigint not null auto_increment, 
			discount_percent	double precision, 
			primary key 		(id), 
			check 			(discount_percent<15)
		) engine=InnoDB
	create table order_item 
		(
			id 			bigint not null auto_increment, 
			quantity 		integer, 
			dish_id 		bigint, 
			purchase_id 		bigint, 
			primary key 		(id)
		) engine=InnoDB
	create table purchase 
		(
		id 				bigint not null auto_increment, 
		date 				datetime, 
		extra_fees 			double precision,
		customer_id 			bigint, 
		primary key 			(id)
		) engine=InnoDB
	create table restaurant 
		(
		id 				bigint not null auto_increment, 
		image_url 			varchar(255), 
		name 				varchar(255), 
		menu_id 			bigint not null, 
		primary key 			(id)
		) engine=InnoDB
		
	alter table customer add constraint UK_dwk6cx0afu8bs9o4t536v1j5v unique (email)
	alter table customer add constraint UK_i1p08swb0onyuxes5tjx73rqg unique (token)
	alter table dish add constraint FKljuksxg35var0r9a3y09l148h foreign key (menu_id) references menu (id)
	alter table order_item add constraint FKs7aplknkrukmckr29wijlvcy1 foreign key (dish_id) references dish (id)
	alter table order_item add constraint FKop179ve526cnm1etgba1xjhl5 foreign key (purchase_id) references purchase (id)
	alter table purchase add constraint FK2pehe23hwdcyql94c531rbf70 foreign key (customer_id) references customer (id)
	alter table restaurant add constraint FKooiid4751i6wv4ebwbi6gjfr3 foreign key (menu_id) references menu (id)
