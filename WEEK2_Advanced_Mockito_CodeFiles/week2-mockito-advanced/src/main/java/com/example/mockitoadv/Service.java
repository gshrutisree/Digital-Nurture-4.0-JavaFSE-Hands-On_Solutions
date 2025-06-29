package com.example.mockitoadv;

public class Service {
    private final Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public String processData() {
        String data = repository.getData();
        return "Processed " + data;
    }
}
