package br.com.erudio;

public class Greeting {

    private final Long id;
    private final String current;

    public Greeting(Long id, String current) {
        this.id = id;
        this.current = current;
    }

    public Long getId() {
        return id;
    }

    public String getCurrent() {
        return current;
    }
}
