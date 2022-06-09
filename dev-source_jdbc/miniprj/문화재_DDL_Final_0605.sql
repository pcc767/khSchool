--- ��ȭ�� Table DDL ---
--table ���� ??????
--drop table tbl_palace_facility CASCADE CONSTRAINTS;
--drop table tbl_palace CASCADE CONSTRAINTS;
--drop table tbl_zzim CASCADE CONSTRAINTS;
--drop table tbl_review CASCADE CONSTRAINTS;
--drop table tbl_legacy CASCADE CONSTRAINTS;
--drop table tbl_user CASCADE CONSTRAINTS;



create table tbl_user (
	user_id	varchar2(40)		primary key,
	user_pw	varchar2(40)		null,
	user_name	varchar2(60)		null,
	user_email	varchar2(60)		null,
	user_phone	varchar2(40)		null
    
);

create table tbl_legacy (
	legacy_no	varchar2(12)		primary key,
	legacy_design_no	varchar2(20)		not null,
	legacy_trans_no	varchar2(40)		null,
	legacy_category_name	varchar2(60)		not null,
	legacy_name_kor	varchar2(200)		null,
	legacy_name_chi	varchar2(200)		null,
	legacy_area	varchar2(60)		null,
	legacy_address	varchar2(600)		null,
	legacy_admin	varchar2(100)		null,
	legacy_type	varchar2(40)		null,
	legacy_type2	varchar2(40)		null,
	legacy_type3	varchar2(40)		null,
	legacy_type4	varchar2(40)		null,
	legacy_quantity	varchar2(200)		null,
	legacy_era	varchar2(200)		null,
	legacy_owner	varchar2(100)		null,
	legacy_content	clob		null,
	legacy_enrolldate	varchar2(12)		null,
	legacy_longitude	varchar2(40)		null,
	legacy_latitude	varchar2(40)		null
);

create table tbl_review (
	review_no	number		primary key,
	review_content	varchar2(2000)		null,
	user_id	varchar2(40),
	legacy_no	varchar2(12),
	review_date date default sysdate,
    constraint user_id_fk1 foreign key(user_id) references tbl_user(user_id),
    constraint legacy_no_fk1 foreign key(legacy_no) references tbl_legacy(legacy_no)
);

create table tbl_zzim (
	user_id	varchar2(40),
	legacy_no	varchar2(12),
	zzim_date date default sysdate,
	primary key (user_id, legacy_no),
    constraint user_id_fk2 foreign key(user_id) references tbl_user(user_id),
    constraint legacy_no_fk2 foreign key(legacy_no) references tbl_legacy(legacy_no)
);



create table tbl_palace (
	palace_no	number		primary key,
	legacy_no	varchar2(12),
    constraint legacy_no_fk3 foreign key(legacy_no) references tbl_legacy(legacy_no)
);

create table tbl_palace_facility (
	p_facility_no	number		primary key,
	palace_no	number,
	p_facility_detail_no	number		null,
	p_facility_name_kor	varchar2(200)		null,
	p_facility_name_eng	varchar2(200)		null,
	p_facility_name_jpa	varchar2(200)		null,
	p_facility_name_chi	varchar2(200)		null,
	p_facility_content	clob		null,
	p_facility_content_eng	clob		null,
	p_facility_content_jpa	clob		null,
	p_facility_content_chi	clob		null,
    constraint palace_no_fk foreign key(palace_no) references tbl_palace(palace_no)
);

create sequence seq_review_no;

insert into tbl_palace (palace_no, legacy_no) values (1, 2886);
insert into tbl_palace (palace_no, legacy_no) values (2, 2888);
insert into tbl_palace (palace_no, legacy_no) values (3, 2889);
insert into tbl_palace (palace_no, legacy_no) values (4, 2890);
insert into tbl_palace (palace_no, legacy_no) values (5, 2891);


--���̺� ��ȸ?
--select * from tbl_user;
--select * from tbl_legacy;
--select * from tbl_palace;
--select * from tbl_palace_facility;
--select * from tbl_review;
--select * from tbl_zzim;