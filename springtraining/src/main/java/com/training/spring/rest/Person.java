package com.training.spring.rest;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.training.spring.rest.validation.StartWith;

@XmlRootElement
public class Person {

    @NotNull(message = "Kesinlikle tekil bir id vermeniz lazım")
    private Long      uniqueId;
    @NotEmpty
    @Size(min = 2, max = 20)
    @StartWith("is:")
    private String    name;
    @NotEmpty
    @Size(min = 3, max = 20)
    private String    surname;
    @NotEmpty
    @StartWith("no:")
    private String    phone;
    @Max(300)
    @Min(100)
    private Integer   height;
    @XmlTransient
    // @JsonIgnore
    @Past
    private LocalDate birthdate;
    @NotNull
    private EGender   gender;

    public String getName() {
        //        Class<Person> per = Person.class;
        //        Field[] declaredFieldsLoc = per.getDeclaredFields();
        //        for (Field fieldLoc : declaredFieldsLoc) {
        //            NotEmpty annotationLoc = fieldLoc.getAnnotation(NotEmpty.class);
        //
        //        }
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }


    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(final String phoneParam) {
        this.phone = phoneParam;
    }

    public Integer getHeight() {
        return this.height;
    }

    public void setHeight(final Integer heightParam) {
        this.height = heightParam;
    }

    public LocalDate getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(final LocalDate birthdateParam) {
        this.birthdate = birthdateParam;
    }

    public EGender getGender() {
        return this.gender;
    }

    public void setGender(final EGender genderParam) {
        this.gender = genderParam;
    }

    @Override
    public String toString() {
        return "Person [name="
               + this.name
               + ", surname="
               + this.surname
               + ", phone="
               + this.phone
               + ", height="
               + this.height
               + ", birthdate="
               + this.birthdate
               + ", gender="
               + this.gender
               + "]";
    }

    public Long getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(final Long uniqueIdParam) {
        this.uniqueId = uniqueIdParam;
    }


}
