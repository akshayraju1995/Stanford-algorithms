

public class Daughter extends Mother{

    public Daughter(String name,String time){
        super(name, time);
    }
    @Override
    public void getClassName() {
        System.out.println("Daughter" + super.getName());
    }
}
