Table pizze {
  id integer [primary key]
  name varchar
  ingredient varchar
  price double
  id_ordine int
}

Table ordine {
  id integer [primary key]
  is_open varchar [note: 'y: l ordine è aperto; n: ordine chiuso']
}

Ref: pizze.id_ordine > ordine.id // many-to-one