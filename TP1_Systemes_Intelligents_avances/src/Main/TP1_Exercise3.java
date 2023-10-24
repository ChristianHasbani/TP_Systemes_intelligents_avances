package Main;

import jmetal.core.Problem;
import jmetal.core.Solution;
import jmetal.core.Variable;
import jmetal.encodings.solutionType.RealSolutionType;
import java.lang.Math;

//Exercise 2
public class TP1_Exercise3 extends Problem{ 

	double alpha,beta;
	public TP1_Exercise3(String solutionType, int numberOfVariables ) { 
		numberOfVariables_ = numberOfVariables;
		numberOfObjectives_ = 2;
		numberOfConstraints_ = 0;
		problemName_ = "Ex3";
		
		upperLimit_ = new double[numberOfVariables_];
		lowerLimit_ = new double[numberOfVariables_];

		for(int i = 0 ; i < numberOfVariables_; i++) {
			lowerLimit_[i] = 0.0;
			upperLimit_[i] = 1.0;
		}
		
		if(solutionType.compareTo("Real") == 0) {
			solutionType_ = new RealSolutionType(this);
		}else {
			System.out.println("Error: Solution type " + solutionType + " invalid");
			System.exit(-1);
		}
		
	}
	
	@Override
	public void evaluate(Solution solution) throws jmetal.util.JMException {
		Variable[] decisionVariables = solution.getDecisionVariables();
		double [] x = new double [numberOfVariables_];
		double [] fx = new double[2];
		double f,sum = 0.0;
		
		for(int i = 0; i < numberOfVariables_; i++) {
			x[i] = decisionVariables[i].getValue();
			sum += x[i];
		}
		
		double gx = 1 + (9*sum/(numberOfVariables_ - 1));
		fx[0] = decisionVariables[0].getValue();
		fx[1] = gx * (1- Math.sqrt(decisionVariables[0].getValue()/gx));

		solution.setObjective(0, fx[0]);
		solution.setObjective(1, fx[1]);

	}
}