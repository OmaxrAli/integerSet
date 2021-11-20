
public class IntegerSet {




    private boolean[] theSet = new boolean[101];

    public IntegerSet(){

        for (int i = 0; i < this.theSet.length; i++) {
            this.theSet[i]= false;
        }

    }

    public static void main(String[] args) {

        IntegerSet set1= new IntegerSet();
        IntegerSet set2= new IntegerSet();

        set1.createE(0);
        set1.createE(13);
        set1.createE(100);

        set2.createE(0);
        set2.createE(1);
        set2.createE(100);
        System.out.println(set2.toString());
        System.out.println(set1.toString());
        System.out.println(IntegerSet.union(set1, set2));
        System.out.println(IntegerSet.intersection(set1, set2));

        System.out.println(set1.Equal(set2));

    }

    public void createE(int value){

        if(value>=0 && value<=100){
            this.theSet[value]= true;
        }
        else System.err.println("this value is not allowed");
    }

    public void deleteE(int value){
        if(value>=0 && value<=100){
            this.theSet[value]= false;
        }
        else System.err.println("this value is not allowed");
    }
    public static String union(IntegerSet s1, IntegerSet s2){
        IntegerSet union=new IntegerSet();
        for (int i = 0; i <= 100; i++) {

            if( s1.theSet[i]==true && s2.theSet[i]==true){
                union.createE(i);
            }
            else if(s1.theSet[i]==true && s2.theSet[i]==false){
                union.createE(i);
            }
            else if(s2.theSet[i]==true && s1.theSet[i]==false){
                union.createE(i);
            }

        }
        return "=> union"+ union.toString();
    }
    public static String intersection(IntegerSet s1, IntegerSet s2){
        IntegerSet intersection=new IntegerSet();
        for (int i = 0; i <= 100; i++) {

            if( s1.theSet[i]==true && s2.theSet[i]==true){
                intersection.createE(i);
            }
        }

        return "=> intersection"+ intersection.toString();
    }
    public String Equal( IntegerSet s2){

        boolean Equal= false;
        for (int i = 0; i <= 100; i++) {

            if( this.theSet[i]==true && s2.theSet[i]==true){
                Equal = true;
            }
            else if(this.theSet[i]==true && s2.theSet[i]==false){
                Equal = false;
                break;
            }
            else if(s2.theSet[i]==true && this.theSet[i]==false){
                Equal = false;
                break;
            }
        }

        if(Equal)
            return  "are Equal";
        else
            return "are not Equal";
    }

    @Override
    public String toString() {

        boolean isEmpty= true;

        for (int i = 0; i < this.theSet.length; i++) {
            if(this.theSet[i]){

                isEmpty= false;
                System.out.print("["+i+"]");
            }
        }
        if(isEmpty)
            return "---";
        return "\n__________________";
    }
}    