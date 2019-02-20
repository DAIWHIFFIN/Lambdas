package uk.dmw.examples.lambdas;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateTimeAgeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testdate();
	}

    private static void testdate() {
        try{
                int ackErrorCode = 0;
              boolean inError = false;
              String ackErrorCodeDescription = null;
            String msgDatetime="2018-12-13T14:00:10";
            String past = "-69620";
            String future = "120";
            //Calulate time difference in minutes between msgDatetime and time now
            DatatypeFactory dtf = DatatypeFactory.newInstance();
            XMLGregorianCalendar xmlCal = dtf.newXMLGregorianCalendar(msgDatetime);
            GregorianCalendar subXMLCal = xmlCal.toGregorianCalendar();
            GregorianCalendar nowCal = new GregorianCalendar();
            XMLGregorianCalendar nowXML = DatatypeFactory.newInstance().newXMLGregorianCalendar(nowCal);
            nowCal.add(Calendar.MINUTE, Integer.parseInt(future));
            nowXML = DatatypeFactory.newInstance().newXMLGregorianCalendar(nowCal);
            int futureCompareResult = subXMLCal.compareTo(nowCal);
            nowCal.add(Calendar.MINUTE, Integer.parseInt(past) - Integer.parseInt(future)); //subtract future as we added this previously
            nowXML = DatatypeFactory.newInstance().newXMLGregorianCalendar(nowCal);
            int pastCompareResult = subXMLCal.compareTo(nowCal);
            if (futureCompareResult  > 0 || pastCompareResult < 0) 
            {
                System.out.println("out of range");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        
        }

    }
}
