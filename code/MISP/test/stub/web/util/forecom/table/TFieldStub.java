package stub.web.util.forecom.table;

import java.util.ArrayList;
import java.util.List;

import cn.fuego.misp.web.action.util.BreadTrail;
import cn.fuego.misp.web.util.forecom.table.MispTable;
import cn.fuego.misp.web.util.forecom.table.TField;

public class TFieldStub
{
	public static TField getBasicTFieldStub()
	{
		TField tField= new TField();
		return tField;
	}
	
	public static TField getBasicTFieldStub(String name)
	{
		TField tField= new TField();
		tField.setName(name);
		return tField;
	}
	

	public static List<TField> getBasicTFieldListStub()
	{
		List<TField> list = new ArrayList<TField>();
		
		TField tField1= new TField("Field1");
		TField tField2= new TField("Field2");
		
		list.add(tField1);
		list.add(tField2);
		
		return list;

	}
}
