package model;
import dao.BorrowerDao;

/**
 *
 * @author sanglv, quang
 */
public class BorrowerInfo extends UserInfo {
    
    private BorrowerStatus status;
    public BorrowerInfo( int id, String name, String birthday, String sex, String address, String email , String phone , String username, String password, BorrowerStatus status) {
        super(id, name, birthday, sex, address, email, phone, username, password);
        this.status = status;
    }
    public static BorrowerInfo getBorrower(int id){
        return BorrowerDao.getBorrower(id);   
    } 
    public void updateInfo(){
    
        super.updateInfo();
        this.status = status;
    }
    /**
     * @return the status
     */
    public BorrowerStatus getStatus() {
        return status;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(BorrowerStatus status) {
        this.status = status;
    }
        public static BorrowerInfo login(String username , String password){
        return BorrowerDao.login(username ,password);
    }
}
