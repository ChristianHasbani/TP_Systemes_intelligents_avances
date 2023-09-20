package Main;

import jmetal.core.Problem;
import jmetal.core.Solution;
import jmetal.core.Variable;
import jmetal.encodings.solutionType.RealSolutionType;
import java.lang.Math;

//Exercise 2
public class TP1 extends Problem{ // Part 1 create a class that inherets problem

	public TP1(String solutionType, int numberOfVariables ) { // Part 2 define a constructor 
		numberOfVariables_ = numberOfVariables;
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
			lowerLimit_[i] = 0.0;
			upperLimit_[i] = 1.0;
		}
	}
	
	@Override
	public void evaluate(Solution solution) throws jmetal.util.JMException {
		Variable[] decisionVariables = solution.getDecisionVariables();
		double [] x = new double [numberOfVariables_];
		
		for(int i = 0; i < numberOfVariables_; i++) {
			x[i] = decisionVariables[i].getValue();
		}
		
		double f1 = x[0]; // Function F1(x)
		double f2; // Function F2(x)
		
//		Calculate the function F2(x)
		double g = 0;
		for(int i = 2; i < numberOfVariables_ ; i++) {
			g += x[i];
		}
		g = 1 + 9 * g/(numberOfVariables_-1); 
		f2 = g * (1- Math.sqrt(f1/g));
		
		double alpha = 1.0;
		double beta = 1.0;
		double f = alpha*f1+beta*f2; // Function F(x)
		
		solution.setObjective(0, f);

	}
}