import java.text.NumberFormat;

public class Mind
{
	////////////////////
	//INSTANCE VARIABLES
	///////////////////
	double[][] inputData, outputData;
	Network network;
	
	///////////////
	//CONSTRUCTORS
	///////////////
	public Mind(Network n, double[][] inputs, double[][] outputs)
	{
		network = n;
		inputData = inputs;
		outputData = outputs;
	}
	
	/////////////////
	//MUTATOR METHODS
	/////////////////
	public void mutateData(double[][] i, double[][] o)
	{
		inputData = i;
		outputData = o;
	}
	
	//////////////////
	//ACCESSOR METHODS
	//////////////////
	public double[][] retrieveInputData()
	{
		return inputData;
	}
	
	public double[][] retrieveOutputData()
	{
		return outputData;
	}
	
	///////////////
	//OTHER METHODS
	///////////////
	public void learn(int iterations)
	{
		NumberFormat percentFormat = NumberFormat.getPercentInstance(); 
		percentFormat.setMinimumFractionDigits(4);

		for (int i=0;i<iterations;i++) //for every iteration
		{
			for (int j=0;j<inputData.length;j++) //for every individual input
			{
				network.computeOutputs(inputData[j]);
				network.calcError(outputData[j]);
				network.learn(); //i.e. adjust weights
			}
		}
	}
	
	public double[] predict(double[] inputs)
	{
		double[] prediction = new double[outputData[0].length];
		
		prediction = network.computeOutputs(inputs);
		
		return prediction;
	}
	
}//END CLASS MIND
