package cn.ssm.entity;

public class Student {
    private String id;
    private String name;
    private String password;
    private String states;
    private String studytype;
    private Long createtime;

    public Student() {}

    public Long getCreatetime() {
        return createtime;
    }
    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    public String getStudytype() {
        return studytype;
    }

    public void setStudytype(String studytype) {
        this.studytype = studytype;
    }
}
