package pe.edu.upc.micomedor.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "UserWeb")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    @Column(length = 30, unique = true)
    private String username;
    @Column(length = 200)
    private String password;

    private Boolean enabled;
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "mail", nullable = false, length = 50)
    private String mail;

    public Users() {
    }

    public Users(int idUser, String username, String password, Boolean enabled, String name, String mail) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.name = name;
        this.mail = mail;
    }


    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}


