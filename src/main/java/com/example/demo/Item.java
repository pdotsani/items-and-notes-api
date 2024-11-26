package com.example.demo;

import com.google.cloud.spring.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

@Entity(name = "Item")
public class Item {
    @Id
    private Long id;

    private String bodyPart;

    private String muscles;

    private String memo;

    public Item(String bodyPart, String muscles, String memo) {
        this.bodyPart = bodyPart;
        this.muscles = muscles;
        this.memo = memo;
    }

    public String getBodyPart() {
        return this.bodyPart;
    }

    public String getMuscles() {
        return this.muscles;
    }

    public String getMemo() { return this.memo; }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", bodyPart='" + bodyPart + '\'' +
                ", muscles='" + muscles + '\'' +
                ", memo='" + memo + '\'' +
                '}';
    }
}
