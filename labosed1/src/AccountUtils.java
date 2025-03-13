import invalidPasswordException;

class AccountUtils {
    static void accountCheck(String username, String password) {
        int nChar = 0;
        int nNum = 0;
        if (password.contains(username)){
            throw new InvalidPasswordException("Cannot contain username");
        }
        for (int i = 0; i < password.length(); i++){
            if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                nNum += 1;
            }
            if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
                nChar += 1;
            }
        }
        if (nNum < 2){
            throw new InvalidPasswordException("Minimum two digits needed");
        }
        if (nChar < 3){
            throw new InvalidPasswordException("Minimum three capital letters needed");
        }
        if (password.length() < 5 || password.length() > 9){
            throw new InvalidPasswordException("Must have more than 5 and less than 10 characters");
        }
    }

}
