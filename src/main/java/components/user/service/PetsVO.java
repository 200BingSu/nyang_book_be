package components.user.service;



public class PetsVO {
    private int pets_key;
    private String pets_name;
    private Integer user_key;
    private String pets_birth;
    private String created_at;
    private String updated_at;



    public enum Gender {
       M,F,O
    }
    private Gender pets_gender;


}
