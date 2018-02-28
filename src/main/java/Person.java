public class Person {

    private int personid;
    private String personname;
    private String personemail;

    @Override
    public String toString() {
        return "Person{" +
                "personid=" + personid +
                ", personname='" + personname + '\'' +
                ", personemail='" + personemail + '\'' +
                '}';
    }



    public int getPersonid() {
        return personid;
    }

    public void setPersonid(int personid) {
        this.personid = personid;
    }

    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String personname) {
        this.personname = personname;
    }

    public String getPersonemail() {
        return personemail;
    }

    public void setPersonemail(String personemail) {
        this.personemail = personemail;
    }
}
