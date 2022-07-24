package com.lottery.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person {
  @Id
  @JsonIgnore
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "age")
  private Long age;

  @Column(name = "city")
  private String city;

  public Person() {
  }

  public Person(String _name, Long _age, String _city) {
    this.name = _name;
    this.age = _age;
    this.city = _city;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Long getAge() {
    return age;
  }

  public String getCity() {
    return city;
  }

  public void setName(String _name) {
    this.name = _name;
  }

  public void setAge(Long _age) {
    this.age = _age;
  }

  public void setCity(String _city) {
    this.city = _city;
  }

  @Override
  public String toString() {
    return "Person{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", age=" + age +
        ", city='" + city + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person person = (Person) o;
    return id.equals(person.id) && name.equals(person.name) && age.equals(person.age) && city.equals(person.city);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, age, city);
  }
}
