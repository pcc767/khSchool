package com.kh.pratice.set.model.vo;

import java.util.Objects;

public class Lottery {
	
	
	private String name;
    private String phone;

    public Lottery(){}

    public Lottery(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottery lottery = (Lottery) o;
        return Objects.equals(name, lottery.name) && Objects.equals(phone, lottery.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone);
    }


    @Override
    public String toString() {
        return "Lottery{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

}
