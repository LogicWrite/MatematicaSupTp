package dominio;
//import org.jetbrains.annotations.NotNull;

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
                    this.setAngle(b);
                    this.a = module*Math.cos(angle);
                    this.b = module*Math.sin(angle);
                    break;

            }
        }

        ComplexNumber plus(/*@NotNull*/ ComplexNumber other){
            double newX = a + other.getA();
            double newY = b + other.getB();
            return  new ComplexNumber(newX,newY, ComplexType.BINOMICO);
        }

        ComplexNumber minus(/*@NotNull*/ ComplexNumber other){
            double newX = a - other.getA();
            double newY = b - other.getB();
            return  new ComplexNumber(newX,newY, ComplexType.BINOMICO);
        }

        String showAsBinomic(){
            return "(" + a + "," + b + ")";
        }

        String showAsPolar(){
            return "[" + module + "," + angle  + "]";
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
    
    private void setAngle(double unAngulo) {
        this.angle = unAngulo;
        if(angle<0)  angle=2*Math.PI+angle;
        if(angle>2*Math.PI)  angle= angle % (2*Math.PI);
    }

    public double getModule() {
        return module;
    }
    
    public ComplexNumber multiplicate(ComplexNumber otroNumeroComplejo){
    	return new ComplexNumber(this.getModule()*otroNumeroComplejo.getModule(),
    			this.getAngle() + otroNumeroComplejo.getAngle(),
    			ComplexType.POLAR);
    }
    
    public ComplexNumber divide(ComplexNumber otroNumeroComplejo){
    	if(otroNumeroComplejo.getModule() == 0){
    		throw new ExcepcionDivisionPorCero();
    	}
    	return new ComplexNumber(this.getModule() / otroNumeroComplejo.getModule(),
    			this.getAngle() - otroNumeroComplejo.getAngle(),
    			ComplexType.POLAR);
    }
    
    private boolean esUnNumeroEntero(double unNumero){
    	return Math.floor(unNumero) == unNumero;
    }
    
    private boolean esPositivo(double unNumero){
    	return unNumero > 0;
    }
    
    private boolean esUnNumeroNatural(double unNumero){
    	return esUnNumeroEntero(unNumero) && esPositivo(unNumero);
    }
    
    private boolean noEsUnNumeroNatural(double unNumero){
    	return !esUnNumeroNatural(unNumero);
    }

    public ComplexNumber pow(double unExponente){
    	if(noEsUnNumeroNatural(unExponente)){
    		throw new ExcepcionDebeSerUnNumeroNatural();
    	}
    	return new ComplexNumber(Math.pow(this.getModule(), unExponente),
    			this.getAngle() * unExponente,
    			ComplexType.POLAR);
    }
    
    
}
