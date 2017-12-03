package org.nyflo.kata.domain;

public class Client {

    private final int id;

    public Client(final int id) {
        this.id = id;
    }

    public static Client of(final int id) {
        return new Client(id);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return id == client.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
