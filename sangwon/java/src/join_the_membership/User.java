package join_the_membership;

import java.sql.Timestamp;

public class User {
    private String id;
    private String name;
    private String password;
    private String email;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private boolean isDeleted = false;
    private Timestamp deletedAt;

    public User(String id, String name, String password, String email, Timestamp createdAt) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = createdAt;
    }

    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }
    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }
}
