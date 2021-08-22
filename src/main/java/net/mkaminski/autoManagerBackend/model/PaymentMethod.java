package net.mkaminski.autoManagerBackend.model;

import lombok.Getter;

@Getter
public enum PaymentMethod {
    CASH(0),
    CARD(1),
    TRANSFER(2);

    private final int id;

    PaymentMethod(int id) {
        this.id = id;
    }
}
