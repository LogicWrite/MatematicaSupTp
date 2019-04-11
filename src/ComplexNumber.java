import org.jetbrains.annotations.NotNull;

public class ComplexNumber {
        private double a;
        private double b;
        private double module;
        private double angle; //Rads
        public ComplexNumber(double a, double b, ComplexType type){
            //Se setean las variables desde el principio y no hay que molestarse por acualizarlas ya que sera un objeto
            //inmutable
            switch (type){
                case BINOMICO:
                    this.a = a;
                    this.b = b;
                    module = calculateMod();
                    angle = calculateAngle();
                    break;
                case POLAR:
                    this.module = a;
                    this.angle = b;
                    this.a = module*Math.sin(angle);
                    this.b = module*Math.cos(angle);
                    break;

            }
        }

        ComplexNumber plus(@NotNull ComplexNumber other){
            double newX = a + other.getA();
            double newY = b + other.getB();
            return  new ComplexNumber(newX,newY, ComplexType.BINOMICO);
        }

        ComplexNumber minus(@NotNull ComplexNumber other){
            double newX = a - other.getA();
            double newY = b - other.getB();
            return  new ComplexNumber(newX,newY, ComplexType.BINOMICO);
        }

        enum ComplexType{
            BINOMICO,POLAR
        }

        private double calculateMod(){
            return Math.sqrt(a*a+b*b);
        }

        private  double calculateAngle(){
            angle =Math.atan2(b, a);
            if(angle<0)  angle=2*Math.PI+angle;
            return angle;
        }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getAngle() {
        return angle;
    }

    public double getModule() {
        return module;
    }
}
