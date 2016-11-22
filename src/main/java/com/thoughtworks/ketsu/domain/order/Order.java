package com.thoughtworks.ketsu.domain.order;

import com.thoughtworks.ketsu.domain.user.User;
import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order implements Record{
    private long id;
    private List<OrderItem> orderItems;
    private double totalPrice;
    private User owner;

    public Order(long id, User owner) {
        this.id = id;
        this.owner = owner;
    }

    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return toJson(routes);
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return new HashMap<String, Object>(){{
            put("uri", routes.orderUrl(owner, Order.this));
            put("total", totalPrice);
        }};
    }

    public long getId() {
        return id;
    }
}