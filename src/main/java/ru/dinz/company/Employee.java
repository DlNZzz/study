package ru.dinz.company;

public abstract class Employee {

    private String name;
    private ID id;

    public Employee(String name) {
        this.name = name;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    abstract void work();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    class ID {
        private int id;
        private String name;
        private String post;

        public ID(int id, String name, String post) {
            this.id = id;
            this.name = name;
            this.post = post;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPost() {
            return post;
        }

        public void setPost(String post) {
            this.post = post;
        }

        @Override
        public String toString() {
            return "ID{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", post='" + post + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
