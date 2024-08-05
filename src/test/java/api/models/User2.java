package api.models;

public class User2 {
    private String name;
    private String job;
    private String updatedAt;

    public User2() {
    }

    public User2(String job, String name) {
        this.job = job;
        this.name = name;
    }

    public User2(String name, String job, String updatedAt) {
        this.name = name;
        this.job = job;
        this.updatedAt = updatedAt;
    }

    public User2(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "User2{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
