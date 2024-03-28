drop table if exists  "books";
drop table if exists "authors";

DROP  TABLE  IF EXISTS  "authors";
CREATE TABLE "authors" (
                           "id" bigint DEFAULT  nextval('authors_id_seq') not null ,
                           "name" text,
                           "age" integer,
                           constraint "authors_pkey" primary key("id")
);
create table "books"(
    "isbn" text not null,
    "title" text,
    "author_id" bigint,
    constraint "book_pkey" foreign key ("isbn") references authors(id)
);