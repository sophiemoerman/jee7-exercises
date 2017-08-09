package com.realdolmen.candyshop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// TODO: make an entity using table "candy_order"
public class Order {
    // TODO: add id (primary key, generated) and deliveryAddress (embedded)

    // TODO: Add a many to one association to Person. Make sure the bidirectional side is updated as well!

    // TODO: add a one to many association to OrderLine. Do not use a join-table (e.g. FK column "order_id" in "order_line")

    public double calculateTotal() {
        // TODO: implement this method
        return 0;
    }
}
