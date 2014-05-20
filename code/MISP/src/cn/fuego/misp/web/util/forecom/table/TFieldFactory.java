package cn.fuego.misp.web.util.forecom.table;

public class TFieldFactory
{

	public static TField createTField(String f,String v)
	{
		TField tf= new TField();
		tf.setName(f);
		tf.setValue(v);		
		return tf;
	}
	
}
