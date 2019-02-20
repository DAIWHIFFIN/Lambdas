package uk.dmw.examples.lambdas;

import java.util.ArrayList;
import java.util.List;

public class LoopingWithLambdas {

	public static void main(String[] args)
	{
		String result="\",\"valueDate\":\"2004-06-01\"}],\"code\":\"UROLOGY\",\"display\":\"Urology\",\"designation\":[{\"value\":\"101\"}]},{\"extension\":[{\"url\":\"https://fhir.nhs.uk/STU3/StructureDefinition/Extension-eRS-EffectivefromDate-1\",\"valueDate\":\"2018-11-20\"}],\"code\":\"MEDICATION_AND_PHARMACY\",\"display\":\"Medication and Pharmacy\",\"designation\":[{\"value\":\"9914\"}]}]}]}}\r\n" + 
				"Expected: {";
		String field="Extension-eRS-EffectivefromDate-1\",\"valueDate\"";
		String toReplace="\"" + field + "\":[^,]*\"";
		System.out.println(toReplace);
		result = result.replaceAll("\"" + field + "\":[^,]*\"", "\"" + field + "\":\"<ignore>\"");
		System.out.println(result);
		
		
//		LoopingWithLambdas testClass = new LoopingWithLambdas();
//		testClass.loopList();
	}
	
	public void loopList()
	{
		createList().forEach(item->System.out.println(item));
	}
	
	private List<String> createList()
	{
		List<String> sourceList = new ArrayList<String>();
		sourceList.add("Simple String1");
		sourceList.add("Simple String2");
		sourceList.add("Simple String3");
		sourceList.add("Simple String4");
		return sourceList;
	}
}
