import jmetal.core.Problem;
import jmetal.core.Solution;
import jmetal.core.Variable;
import jmetal.encodings.solutionType.RealSolutionType;

//Exercise 2
public class Schaffer extends Problem{ // Part 1 create a class that inherets problem

	public Schaffer(String solutionType) { // Part 2 define a constructor 
		numberOfVariables_ = 30;
		numberOfObjectives_ = 1;
		numberOfConstraints_ = 0;
		problemName_ = "Schaffer";
		
		if(solutionType.compareTo("Real") == 0) {
			solutionType_ = new RealSolutionType(this);
		}else {
			System.out.println("Error: Solution type " + solutionType + " invalid");
			System.exit(-1);
		}
		lowerLimit_ = new double [numberOfVariables_];
		upperLimit_ = new double [numberOfVariables_];
		
		for(int i = 0 ; i < numberOfVariables_; i++) {
			lowerLimit_[i] = 0;
			upperLimit_[i] = 1;
		}
	}
	
	@Override
	public void evaluate(Solution solution) throws jmetal.util.JMException {
		Variable[] decisionVariables = solution.getDecisionVariables();
		double [] x = new double [numberOfVariables_];
		
		for(int i = 0; i < numberOfVariables_; i++) {
			x[i] = decisionVariables[i].getValue();
		}
		
		double f1 = 0.0; // Function F1(x)
		double f2 = 0.0; // Function F2(x)
		
		
		int alpha = 1;
		int beta = 1;
		double f = alpha*f1+beta*f2; // Function F(x)
		
		solution.setObjective(0, f);

	}
}