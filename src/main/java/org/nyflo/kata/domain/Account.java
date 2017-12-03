package org.nyflo.kata.domain;

import java.util.LinkedList;
import java.util.List;

public class Account {

    private final List<Operation> operations = new LinkedList<>();

    public double getBalance() {
        return operations.stream().mapToDouble(Operation::getAmount).sum();
    }

    public void makeOperation(Operation operation) {
        operations.add(operation);
    }

    public List<Operation> getOperations() {
        return operations;
    }
}
