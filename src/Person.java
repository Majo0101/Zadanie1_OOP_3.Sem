public class Person {

    private String name;
    private String phoneNumber;
    private boolean phoneCall;
    private boolean phoneInternet;
    private boolean payMethod;
    private int balance;

    // setter
    public void setName(String name){
        this.name = name;
    }

    // setter
    public void setNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    // setter
    public void setService(boolean phoneCall, boolean phoneInternet){
        this.phoneCall = phoneCall;
        this.phoneInternet = phoneInternet;
    }

    // setter
    public void setPayment(boolean payMethod){
        this.payMethod = payMethod;
    }

    // setter
    public void setBalance(int balance){
        this.balance = balance;
    }

    // Print data with filter - Settings comes from main function
    public void printIf(char c){

        switch (c){
            case 'h':
                if (this.phoneCall){
                    System.out.format("| %-18s\t| %-18s\t| %-8d|%n",name,phoneNumber,balance);
                }
                break;

            case 'i':
                if (this.phoneInternet){
                    System.out.format("| %-18s\t| %-18s\t| %-8d|%n",name,phoneNumber,balance);
                }
                break;

            case 'f':
                if (this.payMethod && this.balance < 0){
                    System.out.format("| %-18s\t| %-18s\t| %-8d|%n",name,phoneNumber,balance);
                }
                break;

            case 'm':
                String tmp = "09";

                if (tmp.equals(this.phoneNumber.substring(0,2))){
                    System.out.format("| %-18s\t| %-18s\t| %-8d|%n",name,phoneNumber,balance);
                }
                break;

            default:
                System.out.println("Mismatch Error");
        }
    }
}
