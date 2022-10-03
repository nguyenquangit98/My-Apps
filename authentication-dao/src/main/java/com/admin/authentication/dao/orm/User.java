package com.admin.authentication.dao.orm;

import lombok.*;

import javax.persistence.*;

@Builder
@Entity(name = User.ENTITY_NAME)
@Table(name = User.TABLE_NAME)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class User {

    public static final String ENTITY_NAME = "User";
    public static final String TABLE_NAME = "user";
    public static final String COLUMN_ID_NAME = "id";
    public static final String COLUMN_USERNAME_NAME = "username";
    public static final String COLUMN_PASSWORD_NAME = "password";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID_NAME, nullable = false)
    private Integer id;

    @Column(name = COLUMN_USERNAME_NAME, unique = true, length = 64)
    private String username;

    @Column(name = COLUMN_PASSWORD_NAME, length = 64)
    private String password;
}
