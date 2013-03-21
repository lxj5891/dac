package org.antonyframework.util;

import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * DATABASE�� ��¥ �� �ð��� �����ϴ� Utility<br><br>
 * 
 * ��밡�� Format : <br>
 * YYYYMMDD         -> 20040714      (8�ڸ�) <br>
 * YYYYMM           -> 200407        (6�ڸ�) <br>
 * MMDD             -> 0714          (4�ڸ�) <br>
 * HHMISS           -> 093412        (6�ڸ�) <br>
 * HH24MISS         -> 213412        (6�ڸ�) <br>
 * HHMI             -> 0934          (4�ڸ�) <br>
 * HH24MI           -> 2134          (4�ڸ�) <br>
 * YYYYMMDDHHMISS   -> 20040714093412(14�ڸ�) <br>
 * YYYYMMDDHH24MISS -> 20040714213412(14�ڸ�) <br>
 * @version 1.0
 * @author JongWon Na
 */
public class DBDateTimeUtil {

	public String toString(){

		StringBuffer buf = new StringBuffer();
		buf.append("DBDateTimeUtil Values       \n");	
		buf.append("yyyy      =["+yyyy+"]       \n");
		buf.append("mm        =["+mm+"]         \n");		
		buf.append("dd        =["+dd+"]         \n");		
		buf.append("hh24miss  =["+hh24miss+"]   \n");		
		buf.append("dayOfWeek =["+dayOfWeek+"]  \n");		
		buf.append("iyyyy     =["+iyyyy+"]      \n");
		buf.append("imm       =["+imm+"]        \n");		
		buf.append("idd       =["+idd+"]        \n");		
		buf.append("ihh24miss =["+ihh24miss+"]  \n");		
		buf.append("iDayOfWeek=["+iDayOfWeek+"] \n");		

		return buf.toString();
	}
	private  int iyyyy;
	private  int imm;
	private  int idd;
	private  int ihh24miss;
	private  int iDayOfWeek;

	private  String yyyy;
	private  String mm;
	private  String dd;
	private  String hh24miss;
	private  String dayOfWeek;

	public String getYyyy(){         return this.yyyy;}
	public String getMm(){           return this.mm;}
	public String getDd(){           return this.dd;}
	public String getHh24miss(){     return this.hh24miss;}
	public String getDayOfTheWeek(){ return this.dayOfWeek;}

	public  void setYyyy(     String yyyy     ){this.yyyy=yyyy;          this.iyyyy     = Integer.parseInt(yyyy);}
	public  void setMm(       String mm       ){this.mm=mm;              this.imm       = Integer.parseInt(mm);}
	public  void setDd(       String dd       ){this.dd=dd;              this.idd       = Integer.parseInt(dd);}
	public  void setHh24miss( String hh24miss ){this.hh24miss=hh24miss;  this.ihh24miss = Integer.parseInt(hh24miss);}

	/**
	 * �ش����� ù��?? ���� ������ �����Ѵ�.<br>
	 * 
	 * @param  int iyyyy  �⵵
	 * @param  int imm    ��
	 * @return int ����
	 * @throws IllegalArgumentException
	 * @throws Exception
	 */
	public void setDayOfTheWeek(int iyyyy,int imm, int idd){

		Calendar calendar = new GregorianCalendar(iyyyy,imm-1,idd);
		this.iDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		setDayOfTheWeek();
	}
	/**
	 * �ش����� ���� ���ڿ��� ���Ѵ�.<br>
	 * 
	 * @param  
	 * @return 
	 * @throws IllegalArgumentException
	 * @throws Exception
	 */
	public void setDayOfTheWeek(){
		this.dayOfWeek = getDayOfTheWeek(this.iDayOfWeek);

	}
	/**
	 * �ش����� ���� ���ڿ��� �����Ѵ�.<br>
	 * 
	 * @param  int iDayOfWeek  ����
	 * @return String ����
	 * @throws IllegalArgumentException
	 * @throws Exception
	 */
	public static String getDayOfTheWeek(int iDayOfWeek){

		String dayOfWeek ="";
		switch(iDayOfWeek){
			case 1: dayOfWeek="Sun"; break;
			case 2: dayOfWeek="Mon"; break;
			case 3: dayOfWeek="Tue"; break;
			case 4: dayOfWeek="Wed"; break;
			case 5: dayOfWeek="Thu"; break;
			case 6: dayOfWeek="Fri"; break;
			case 7: dayOfWeek="Sat"; break;
		}
		return dayOfWeek;
	}	
	/**
	 * �ش����� ù��?? ���� ������ �����Ѵ�.<br>
	 * 
	 * @param  int iyyyy  �⵵
	 * @param  int imm    ��
	 * @return int ����
	 * @throws IllegalArgumentException
	 * @throws Exception
	 */
	public static int getFirstDay(int iyyyy,int imm){
		Calendar calendar = new GregorianCalendar(iyyyy,imm-1,1);
		return  calendar.get(Calendar.DAY_OF_WEEK);
	}
	/**
	 * �ش����� ���������� �����Ѵ�.<br>
	 * 
	 * @param  int iyyyy  �⵵
	 * @param  int imm    ��
	 * @return int ��������
	 * @throws IllegalArgumentException
	 * @throws Exception
	 */
	public static int getLastDay(int iyyyy,int imm){
	// calculate Day of Month
		int dd = 0;
		switch(imm){
			case 2 :
						if(((iyyyy % 4 == 0) && (iyyyy % 100 != 0)) || (iyyyy % 400 == 0)){
							dd = 29;
						} else {
							dd = 28;
						}
						break;
			case 4:
			case 6:
			case 9:
			case 11: dd = 30; 
						break;
			default : dd =31;
		}
		return dd;
	}


	/**
	 * Database�� ��¥�ð����� �ʱ�ȭ�Ѵ�.<br>
	 * 
	 * ���Format : YYYYMMDD
	 * @return
	 * @throws IllegalArgumentException
	 * @throws Exception
	 */
	public void init(){

//		String sDateTime = DBDateTimeCMD.getDateTime();
//
//		setYyyy(     sDateTime.substring(0,4));
//		setMm(       sDateTime.substring(4,6));
//		setDd(       sDateTime.substring(6,8));
//		setHh24miss( sDateTime.substring(8,14));
//		setDayOfTheWeek(this.iyyyy,this.imm,this.idd);
//		
		//System.out.println(sDateTime);		

		
	}
    public String getLoginDateString(){
        return getYyyy() +"."+ getMm() +"."+getDd()+"."+getDayOfTheWeek()+".";
    }
	private DBDateTimeUtil(){}
	
	public static DBDateTimeUtil getInstance(){
		return new DBDateTimeUtil();
	}	
	/**
	 * Database�� ��¥�� �����Ѵ�.<br> 
	 * 
	 * ���Format : YYYYMMDD
	 * @return
	 * @throws IllegalArgumentException
	 * @throws Exception
	 */
//	public static String getDate() throws IllegalArgumentException {
//		return DBDateTimeCMD.getDateTime("YYYYMMDD");
//	}

	/**
	 * Database�� �ð��� �����Ѵ�.<br>
	 * 
	 * ���Format : HH24MISS
	 * @return
	 * @throws IllegalArgumentException
	 * @throws Exception
	 */
//	public static String getTime() throws IllegalArgumentException {
//		return DBDateTimeCMD.getDateTime("HH24MISS");
//	}

	/**
	 * Database�� ��¥/�ð��� �����Ѵ�.<br>
	 * 
	 * ���Format : YYYYMMDDHH24MISS
	 * @return
	 * @throws IllegalArgumentException
	 * @throws Exception
	 */
//	public static String getDateTime() throws IllegalArgumentException  {
//		return DBDateTimeCMD.getDateTime("YYYYMMDDHH24MISS");
//	}

	/**
	 * Database�� ��¥ �� �ð� ������ �����Ѵ�.
	 * 
	 * @param formatString<br>
	 * ��밡�� Format : YYYYMMDD, YYYYMM, MMDD, <br>
	 *                   HHMISS, HH24MISS, HHMI, HH24MI, <br>
	 *                   YYYYMMDDHHMISS, YYYYMMDDHH24MISS <br>
	 * @return
	 * @throws IllegalArgumentException
	 * @throws Exception
	 */
//	public static String getDateTime(String formatString) throws IllegalArgumentException  {
//		return DBDateTimeCMD.getDateTime(formatString, "");
//	}	
	
	/**
	 * Database�� ��¥ �� �ð� ������ �����Ѵ�.
	 * 
	 * @param formatString<br>
	 * ��밡�� Format : YYYYMMDD, YYYYMM, MMDD, <br>
	 *                   HHMISS, HH24MISS, HHMI, HH24MI, <br>
	 *                   YYYYMMDDHHMISS, YYYYMMDDHH24MISS <br>
	 * @param operationString ex> "- 1", "+ 2"
	 * @return
	 * @throws IllegalArgumentException
	 * @throws WAFSQLException 
	 */
//	public static String getDateTime(String formatString, String operationString) throws IllegalArgumentException {
//		return DBDateTimeCMD.getDateTime(formatString, operationString);
//	}	


}
