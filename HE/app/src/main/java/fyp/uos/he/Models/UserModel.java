package fyp.uos.he.Models;
public class UserModel {
    String uID;
    String Name;
    String Email;
    String Password;
    String Phonenumber;
    String Address;
    String imgUrl;


    public UserModel(String uID,String name, String phonenumber, String address, String imgUrl){
        this.uID = uID;
        Name= name;
        Phonenumber= phonenumber;
        Address= address;
        Phonenumber=phonenumber;
        this.imgUrl = imgUrl;
    }

    public UserModel() {
    }



    public String getName(){ return Name;}
    public void setName(String name){ this.Name = name;}
    public String getEmail(){return Email;}
    public void setEmail(String email){this.Email = email;}
    public String getPassword(){return Password;}
    public void setPassword(String password){this.Password = password;}
    public String getPhonenumber(){ return Phonenumber;}
    public void  setPhonenumber(String phonenumber){ this.Phonenumber=phonenumber;}
    public String getAddress(){ return Address;}
    public void setAddress(String address){this.Address=address;}

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
