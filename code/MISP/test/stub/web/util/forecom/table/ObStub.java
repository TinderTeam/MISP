package stub.web.util.forecom.table;

import java.util.ArrayList;
import java.util.List;

import cn.fuego.misp.web.util.forecom.table.TField;

public class ObStub
{
	private String field1 ="Value1";
	
	private String field2 ="Value2";
	/**
	 * @return the field1
	 */
	public String getField1()
	{
		return field1;
	}
	/**
	 * @param field1 the field1 to set
	 */
	public void setField1(String field1)
	{
		this.field1 = field1;
	}
	/**
	 * @return the field2
	 */
	public String getField2()
	{
		return field2;
	}
	/**
	 * @param field2 the field2 to set
	 */
	public void setField2(String field2)
	{
		this.field2 = field2;
	}
	
	public static List<ObStub> getBasicObList(){
		List<ObStub> list =new ArrayList<ObStub>();
		list.add(new ObStub());
		list.add(new ObStub());
		return list;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ObStub [field1=" + field1 + ", field2=" + field2 + "]";
	}

	
}
