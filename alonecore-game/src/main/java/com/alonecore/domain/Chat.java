package com.alonecore.domain;

import lombok.Data;

@Data
public class Chat {
    private int id;
    private  String speak;
    private  String name;

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", speak='" + speak + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpeak() {
        return speak;
    }

    public void setSpeak(String speak) {
        this.speak = speak;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
