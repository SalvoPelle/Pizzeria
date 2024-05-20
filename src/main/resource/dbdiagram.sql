Table pizze {
  id integer [primary key]
  name varchar
  ingredient varchar
  price decimal
}

Table ordine {
  id integer [primary key]
  is_open varchar
  num_tavolo integer
}

Table dettaglio_ordine {
  id_dettaglio integer [primary key]
  id_ordine integer
  id_pizze integer
  quantita integer
  prezzo decimal
}
Ref: dettaglio_ordine.id_pizze > pizze.id
Ref: dettaglio_ordine.id_ordine > ordine.id