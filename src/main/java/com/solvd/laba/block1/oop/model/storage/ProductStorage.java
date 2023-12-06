package com.solvd.laba.block1.oop.model.storage;

import com.solvd.laba.block1.oop.exceptions.AmountException;
import com.solvd.laba.block1.oop.exceptions.NoSuchItemException;
import com.solvd.laba.block1.oop.model.interfaces.Storage;
import com.solvd.laba.block1.oop.model.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

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

    public void forEach(Consumer<Node> consumer) {
        Node current = first;
        while (current != null) {
            consumer.accept(current);
            current = current.next;
        }
    }

    @Override
    public ProductStorage filter(Predicate<Node> filter) {
        ProductStorage newProductStorage = new ProductStorage();
        Node current = first;
        while (current != null) {
            if (filter.test(current)) {
                if (newProductStorage.first == null) {
                    newProductStorage.first = new Node(null, null, current.product, current.amount);
                    newProductStorage.last = newProductStorage.first;
                } else {
                    Node newNode = new Node(newProductStorage.last, null, current.product, current.amount);
                    newProductStorage.last.next = newNode;
                    newProductStorage.last = newNode;
                }
            }
            current = current.next;
        }
        return newProductStorage;
    }

    @Override
    public long sum(ToIntFunction<Node> toIntFunction) {
        long sum = 0;
        Node current = first;
        while (current != null) {
            sum += toIntFunction.applyAsInt(current);
            current = current.next;
        }
        return sum;
    }

    @Override
    public List<Double> mapToDouble(ToDoubleFunction<Node> toDoubleFunction) {
        List<Double> list = new ArrayList<>();
        Node current = first;
        while (current != null) {
            list.add(toDoubleFunction.applyAsDouble(current));
            current = current.next;
        }
        return list;
    }

    public static class Node {
        private Node previous;
        private Node next;
        private Product product;
        private int amount;

        private Node(Node previous, Node next, Product product, int amount) {
            this.previous = previous;
            this.next = next;
            this.product = product;
            this.amount = amount;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
    }
}
