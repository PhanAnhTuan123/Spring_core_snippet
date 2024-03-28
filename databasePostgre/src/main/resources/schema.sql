drop table if exists "widgets";

drop sequence if exists widgets_id_seq;
create sequence widgets_id_seq increment 1 minvalue  1 maxvalue  922372036824775807 cache 1;

create table "widgets"(
    "id" bigint default nextval("widgets_id_seq") not null,
    "name" text,
    "purpose" text,
    constraint "widgets_pkey" primary key
                      (
                      "id"
                          )
)