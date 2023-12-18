package Main;

import jmetal.core.Problem;
import jmetal.core.Solution;
import jmetal.core.Variable;
import jmetal.encodings.solutionType.RealSolutionType;
import jmetal.util.JMException;

public class TP2_SensorDeploymentProblem extends Problem{
	
		double radius,dimension;
		double targets [];

		public TP2_SensorDeploymentProblem(String solutionType, int numberOfSensors, double radius, double dimension, double targers []) { 
			numberOfVariables_ = numberOfSensors * 2;
			numberOfObjectives_ = 2;
			numberOfConstraints_ = 1;
			problemName_ = "SensorProblem";
			
			this.radius = radius;
			this.dimension = dimension;
			this.targets = targets;
			
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
		
		// Method to calculate function f1
		public int calcualteF1(int[] t) {
			int f1 = 0;
			for (int i = 0; i < t.length; i++){
				if (t[i] > 0) {
					f1 += 1;
				}
			}
			return f1;
		}
		// Method to calculate function f2
		public int calculateF2(int[] t) {
			int f2 = t[0];
			for (int i = 1; i < t.length; i++) {
				if( t[i] < f2) {
					f2 = t[i];
				}
			}
			return f2;
		}
		
		// Method to calculate the distance between the sensor and the target
		public void calculateDistance (Variable [] decisionVariables, int counter, double distance, int []t) 
		throws JMException {
			for (int i = 0; i < this.targets.length; i = i + 2) {
	            for (int j = 0; j < numberOfVariables_; j = j + 2) {
	                distance = Math.sqrt(Math.pow(this.targets[i] - decisionVariables[j].getValue(), 2)
	                        + Math.pow(this.targets[i + 1] - decisionVariables[j + 1].getValue(), 2));
	                if (distance < this.radius) {
	                    t[counter] = t[counter] + 1;
	                }
	            }
	            counter = counter + 1;
	        }
		}
		
		@Override
		public void evaluate(Solution solution) throws JMException {
			Variable[] decisionVariables = solution.getDecisionVariables();
			
			// Initialize the variables
			int f1 = 0;
			int f2 = 0;
			int counter = 0;
			double distance = 0;
			int [] t  = new int[this.targets.length / 2];
			
			calculateDistance(decisionVariables, counter, distance, t);
			
	        f1 = -1 * calcualteF1(t);
	        f2 = -1 * calculateF2(t);
	        solution.setObjective(0, f1);
	        solution.setObjective(1, f2);
			
		}
}
