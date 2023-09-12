import javax.management.JMException;

import jmetal.core.Problem;
import jmetal.core.Solution;
import jmetal.core.Variable;
import jmetal.encodings.solutionType.RealSolutionType;

public class Schaffer extends Problem{

	public Schaffer(String solutionType, Integer numberOfVariables) {
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
	}
	
	@Override
	public void evaluate(Solution solution) throws jmetal.util.JMException {
		Variable[] decisionVariables = solution.getDecisionVariables();
		double [] x = new double [numberOfVariables_];
		
		for(int i = 0; i < numberOfVariables_; i++) {
			x[i] = decisionVariables[i].getValue();
		}
		double f = 0.0;
		solution.setObjective(0, f);

	}
}