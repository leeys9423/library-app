package com.group.libraryapp.dto.user.request;

public class UserCreateRequest {
   private String name;
   private Integer age; // Integer를 사용하는 이유 : Null 허용

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
