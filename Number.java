package Tool;


 class Number extends Node {

     Number(Double value) {
        super(7);
        this.value = value;

    }

    private final Double value;

    @Override
     public Double getValue(){
         return this.value;




     }


     @Override
     public String toString() {
         return "Priority: "+ value;

     }
 }
