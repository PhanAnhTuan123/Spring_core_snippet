create table "books"(
    "isbn" text not null,
    "title" text,
    constraint "books_pkey" primary key ("isbn")
)