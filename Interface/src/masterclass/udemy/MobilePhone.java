package masterclass.udemy;

public class MobilePhone implements ITelephone {
    private int myNumber;
    private boolean isOn;
    private boolean isRinging;

    public MobilePhone(int myNumber) {
        this.myNumber = myNumber;
    }

    @Override
    public void powerOn() {
        System.out.println("Mobile phone is turned on");
        isOn = true;
    }

    @Override
    public void dial(int phoneNumber) {
        System.out.println("Now ringing " + phoneNumber);
    }

    @Override
    public void answer() {
        if (isRinging) {
            System.out.println("the phone is answered");

        }
    }

    @Override
    public boolean isRinging() {
        return false;
    }
}
