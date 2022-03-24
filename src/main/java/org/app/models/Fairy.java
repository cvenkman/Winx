package org.app.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Created by cvenkman on Mar, 2022
 **/
public class Fairy {
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;

    @Min(value = 0, message = "Age should be greater than 0")
    private int age;

    @NotEmpty(message = "Powers should not be empty")
    @Size(min = 1, max = 100, message = "Powers should be between 1 and 100 characters")
    private String powers;

    public Fairy() {
    }

    public Fairy(String name, int age, String powers) {
        this.name = name;
        this.age = age;
        this.powers = powers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPowers() {
        return powers;
    }

    public void setPowers(String powers) {
        this.powers = powers;
    }
}
