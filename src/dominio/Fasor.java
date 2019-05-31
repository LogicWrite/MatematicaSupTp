package dominio;
import dominio.ComplexNumber.ComplexType;
import java.text.DecimalFormat;

public class Fasor {

	private double frecuencia, fase, amplitud;
	private FuncionTrigonometrica funcionTrigonometrica;
	
	public Fasor(double unaAmplitud,  FuncionTrigonometrica unaFuncionTrigonometrica, double unaFrecuencia, double unaFase){
		this.frecuencia = unaFrecuencia;
		this.fase = unaFase;
		this.amplitud = unaAmplitud;
		this.funcionTrigonometrica = unaFuncionTrigonometrica;
	}
	
	public String mostrarFasor() {
		String cadena;
		DecimalFormat df = new DecimalFormat("#.##");

		//cadena = this.getAmplitud() + "*";
		cadena = df.format(this.getAmplitud()) + "*";

		if(this.getFuncionTrigonometrica() == FuncionTrigonometrica.SENO)
			cadena = cadena.concat("sen(");
		else
			cadena = cadena.concat("cos(");

		//cadena = cadena.concat(this.getFrecuencia() + "*t");
		cadena = cadena.concat(df.format(this.getFrecuencia()) + "*t");

		if(this.getFase() >= 0) {
			cadena = cadena.concat(" + ");
			//cadena = cadena.concat(this.getFase() + ")");
			cadena = cadena.concat(df.format(this.getFase()) + ")");
		}
		else {
			cadena = cadena.concat(" - ");
			//cadena = cadena.concat(this.getFase()*(-1) + ")");
			cadena = cadena.concat(df.format(this.getFase()*(-1)) + ")");
		}

		return cadena;
	}

	public double getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(double frecuencia) {
		this.frecuencia = frecuencia;
	}

	public double getFase() {
		return fase;
	}

	public void setFase(double fase) {
		this.fase = fase;
	}

	public double getAmplitud() {
		return amplitud;
	}

	public void setAmplitud(double amplitud) {
		this.amplitud = amplitud;
	}

	public FuncionTrigonometrica getFuncionTrigonometrica() {
		return funcionTrigonometrica;
	}

	public void setFuncionTrigonometrica(FuncionTrigonometrica funcionTrigonometrica) {
		this.funcionTrigonometrica = funcionTrigonometrica;
	}
	
	private boolean tienenLaMismaFuncionTrigonometrica(Fasor unFasor) {
		return this.funcionTrigonometrica == unFasor.funcionTrigonometrica;
	}
	
	private boolean noTienenLaMismaFuncionTrigonometrica(Fasor unFasor) {
		return !tienenLaMismaFuncionTrigonometrica(unFasor);
	}
	
	public void pasateDeFuncionTrigonometrica() {
		if(funcionTrigonometrica == FuncionTrigonometrica.COSENO) {
			this.setFuncionTrigonometrica(FuncionTrigonometrica.SENO);
			this.setFase(this.getFase() + Math.PI/2);
		}
		else {
			this.setFuncionTrigonometrica(FuncionTrigonometrica.COSENO);
			this.setFase(this.getFase() - Math.PI/2);
		}
	}
	
	public ComplexNumber obtenerNumeroComplejoEquivalente() {
		return new ComplexNumber(amplitud, fase, ComplexType.POLAR);
	}
	
	private boolean tienenLaMismaFrecuencia(Fasor unFasor){
		return this.frecuencia == unFasor.frecuencia;
	}
	
	private boolean noTienenLaMismaFrecuencia(Fasor unFasor){
		return !tienenLaMismaFrecuencia(unFasor);
	}
	
	private boolean puedenSumarseoRestarse(Fasor unFasor){
		return tienenLaMismaFrecuencia(unFasor);
	}
	
	private boolean noPuedenSumarseoRestarse(Fasor unFasor){
		return !puedenSumarseoRestarse(unFasor);
	}
	
	public Fasor plus(Fasor unFasor){
		if(noPuedenSumarseoRestarse(unFasor))
			throw new ExcepcionPorSumaDeFasoresInvalidaPorFrecuenciasDistintas();

		if(noTienenLaMismaFuncionTrigonometrica(unFasor)) {
			unFasor.pasateDeFuncionTrigonometrica();
			ComplexNumber sumaFasores = this.obtenerNumeroComplejoEquivalente().plus(unFasor.obtenerNumeroComplejoEquivalente());
			unFasor.pasateDeFuncionTrigonometrica();

			return new Fasor(sumaFasores.getModule(), this.funcionTrigonometrica, this.frecuencia, sumaFasores.getAngle());
		}
		else {
			ComplexNumber sumaFasores = this.obtenerNumeroComplejoEquivalente().plus(unFasor.obtenerNumeroComplejoEquivalente());

			return new Fasor(sumaFasores.getModule(), this.funcionTrigonometrica, this.frecuencia, sumaFasores.getAngle());
		}
	}
	
	public Fasor minus(Fasor unFasor) {
		if(noPuedenSumarseoRestarse(unFasor))
			throw new ExcepcionPorSumaDeFasoresInvalidaPorFrecuenciasDistintas();

		if(noTienenLaMismaFuncionTrigonometrica(unFasor)) {
			unFasor.pasateDeFuncionTrigonometrica();
			ComplexNumber sumaFasores = this.obtenerNumeroComplejoEquivalente().minus(unFasor.obtenerNumeroComplejoEquivalente());
			unFasor.pasateDeFuncionTrigonometrica();

			return new Fasor(sumaFasores.getModule(), this.funcionTrigonometrica, this.frecuencia, sumaFasores.getAngle());
			
		}
		else {
			ComplexNumber sumaFasores = this.obtenerNumeroComplejoEquivalente().minus(unFasor.obtenerNumeroComplejoEquivalente());

			return new Fasor(sumaFasores.getModule(), this.funcionTrigonometrica, this.frecuencia, sumaFasores.getAngle());
		}
	}
}
