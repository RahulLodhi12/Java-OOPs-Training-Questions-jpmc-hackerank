import java.util.Scanner;

class Mobile {
    Boolean touchScreenAvailable;
    Boolean enabled5G;
    Integer ram;
    Integer cameraPixel;
    String brandName;
    String deviceName;

    public Mobile(MobileBuilder mobileBuilder){
        this.touchScreenAvailable = mobileBuilder.touchScreenAvailable;
        this.enabled5G = mobileBuilder.enabled5G;
        this.ram = mobileBuilder.ram;
        this.cameraPixel = mobileBuilder.cameraPixel;
        this.brandName = mobileBuilder.brandName;
        this.deviceName = mobileBuilder.deviceName;
    }

    public Boolean isTouchScreenAvailable(){
        return touchScreenAvailable;
    }

    public Boolean isEnabled5G(){
        return enabled5G;
    }

    public Integer getRam(){
        return ram;
    }

    public Integer getCameraPixel(){
        return cameraPixel;
    }

    public String getBrandName(){
        return brandName;
    }

    public String getDeviceName(){
        return deviceName;
    }

    public void printDetails(){
        System.out.println("Mobile " + getDeviceName() + " of brand " + getBrandName() + " with following features: touch screen enabled " + isTouchScreenAvailable() + ", 5G enabled " + isEnabled5G() + ", ram " + getRam() + ", camera pixel " + getCameraPixel());
    }

    public static class MobileBuilder{
        Boolean touchScreenAvailable;
        Boolean enabled5G;
        Integer ram;
        Integer cameraPixel;
        String brandName;
        String deviceName;


        public MobileBuilder(String brandName, String deviceName){
            this.brandName = brandName;
            this.deviceName = deviceName;
        }

        public MobileBuilder setTouchScreenAvailable(Boolean touchScreenAvailable){
            this.touchScreenAvailable = touchScreenAvailable;
            return this; //current calling object.
        }

        public MobileBuilder setEnabled5G(Boolean enabled5G){
            this.enabled5G = enabled5G;
            return this;
        }

        public MobileBuilder setRam(Integer ram){
            this.ram=ram;
            return this;
        }

        public MobileBuilder setCameraPixel(Integer cameraPixel) {
            this.cameraPixel = cameraPixel;
            return this;
        }

        public Mobile build() {
            return new Mobile(this); //calls constructor
        }
    }
}

public class MobileSolution {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();

        Mobile[] mobiles = new Mobile[n];

        for(int i=0;i<n;i++){
            String a = sc.nextLine();
            String b = sc.nextLine();
            Boolean c = sc.nextBoolean(); sc.nextLine();
            Boolean d = sc.nextBoolean(); sc.nextLine();
            Integer e = sc.nextInt(); sc.nextLine();
            Integer f = sc.nextInt(); sc.nextLine();

            mobiles[i] = new Mobile.MobileBuilder(a,b)
                    .setTouchScreenAvailable(c)
                    .setEnabled5G(d)
                    .setRam(e)
                    .setCameraPixel(f)
                    .build();

        }

        for(Mobile m: mobiles){
            m.printDetails();
        }

    }

}

