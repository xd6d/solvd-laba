package com.solvd.laba.block1.oop.model.storage;

import com.solvd.laba.block1.oop.exceptions.AmountException;
import com.solvd.laba.block1.oop.exceptions.NoSuchItemException;
import com.solvd.laba.block1.oop.model.interfaces.Iterator;
import com.solvd.laba.block1.oop.model.interfaces.Storage;
import com.solvd.laba.block1.oop.model.product.Product;

public class ProductStorage implements Storage<Product> {
    private Node first;
    private Node last;

    @Override
    public void add(Product product, int amount) throws AmountException {
        checkAmountPositive(amount);
        Node current = first;
        while (current != null) {
            if (current.product.equals(product)) {
                current.amount += amount;
                return;
            }
            current = current.next;
        }
        Node l = last;
        Node newNode = new Node(last, null, product, amount);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
    }

    private void checkAmountPositive(int amount) throws AmountException {
        if (amount < 0)
            throw new AmountException("Set positive amount. Amount: %d".formatted(amount));
    }

    @Override
    public void remove(Product product, int amount) throws NoSuchItemException, AmountException {
        checkAmountPositive(amount);
        Node current = first;
        while (current != null) {
            if (current.product.equals(product)) {
                if (current.amount >= amount) {
                    current.amount -= amount;
                } else
                    throw new AmountException
                            ("There are not enough products at the storage: %d.".formatted(current.amount));
                return;
            }
            current = current.next;
        }
        throw new NoSuchItemException("Recording about this product is absent. Product: %s".formatted(product.getName()));
    }

    @Override
    public int getAmount(Product product) {
        Node current = first;
        while (current != null) {
            if (current.product.equals(product))
                return current.amount;
            current = current.next;
        }
        return 0;
    }

    public void forEach(Iterator<Product> iterator) {
        Node current = first;
        while (current != null) {
            iterator.manipulate(current.product);
            current = current.next;
        }
    }

    private static class Node {
        Node previous;
        Node next;
        Product product;
        int amount;

        private Node(Node previous, Node next, Product product, int amount) {
            this.previous = previous;
            this.next = next;
            this.product = product;
            this.amount = amount;
        }
    }
}
