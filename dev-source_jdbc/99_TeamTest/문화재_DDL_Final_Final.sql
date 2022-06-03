--CREATE USER TEAMTEST IDENTIFIED BY 1234;
--GRANT RESOURCE, CONNECT TO TEAMTEST;


--drop table tbl_palace_facility CASCADE CONSTRAINTS;
--drop table tbl_palace CASCADE CONSTRAINTS;
--drop table tbl_zzim CASCADE CONSTRAINTS;
--drop table tbl_review CASCADE CONSTRAINTS;
--drop table tbl_legacy CASCADE CONSTRAINTS;
--drop table tbl_user CASCADE CONSTRAINTS;



create table tbl_user (
	user_id	varchar2(20)		primary key,
	user_pw	varchar2(20)		null,
	user_name	varchar2(30)		null,
	user_email	varchar2(30)		null,
	user_phone	varchar2(20)		null
    
);

create table tbl_legacy (
	legacy_no	varchar2(6)		primary key,
	legacy_design_no	varchar2(10)		not null,
	legacy_trans_no	varchar2(20)		null,
	legacy_category_name	varchar2(30)		not null,
	legacy_name_kor	varchar2(100)		null,
	legacy_name_chi	varchar2(100)		null,
	legacy_area	varchar2(30)		null,
	legacy_address	varchar2(300)		null,
	legacy_admin	varchar2(50)		null,
	legacy_type	varchar2(20)		null,
	legacy_type2	varchar2(20)		null,
	legacy_type3	varchar2(20)		null,
	legacy_type4	varchar2(20)		null,
	legacy_quantity	varchar2(50)		null,
	legacy_era	varchar2(100)		null,
	legacy_owner	varchar2(50)		null,
	legacy_content	clob		null,
	legacy_enrolldate	date		null,
	legacy_longitude	varchar2(20)		null,
	legacy_latitude	varchar2(20)		null
);

create table tbl_review (
	review_no	number		primary key,
	review_content	varchar2(1000)		null,
	user_id	varchar2(20),
	legacy_no	varchar2(6),
	review_date date default sysdate,
    constraint user_id_fk1 foreign key(user_id) references tbl_user(user_id),
    constraint legacy_no_fk1 foreign key(legacy_no) references tbl_legacy(legacy_no)
);

create table tbl_zzim (
	user_id	varchar2(20),
	legacy_no	varchar2(6),
	primary key (user_id, legacy_no),
    constraint user_id_fk2 foreign key(user_id) references tbl_user(user_id),
    constraint legacy_no_fk2 foreign key(legacy_no) references tbl_legacy(legacy_no)
);



create table tbl_palace (
	palace_no	number		primary key,
	legacy_no	varchar2(6),
    constraint legacy_no_fk3 foreign key(legacy_no) references tbl_legacy(legacy_no)
);

create table tbl_palace_facility (
	p_facility_no	number		primary key,
	palace_no	number,
	p_facility_detail_no	number		null,
	p_facility_name_kor	varchar2(100)		null,
	p_facility_name_eng	varchar2(100)		null,
	p_facility_name_jpa	varchar2(100)		null,
	p_facility_name_chi	varchar2(100)		null,
	p_facility_content	clob		null,
	p_facility_content_eng	clob		null,
	p_facility_content_jpa	clob		null,
	p_facility_content_chi	clob		null,
	legacy_no	varchar2(6),
    constraint legacy_no_fk4 foreign key(legacy_no) references tbl_legacy(legacy_no),
    constraint palace_no_fk foreign key(palace_no) references tbl_palace(palace_no)
);


--select * from tbl_user;
--select * from tbl_legacy;
--select * from tbl_palace;
--select * from tbl_palace_facility;
--select * from tbl_review;
--select * from tbl_zzim;