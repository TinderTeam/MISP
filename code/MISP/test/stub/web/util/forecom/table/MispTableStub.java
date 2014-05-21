package stub.web.util.forecom.table;

import java.util.ArrayList;
import java.util.List;

import cn.fuego.misp.web.action.util.BreadTrail;
import cn.fuego.misp.web.util.forecom.table.MispTable;

public class MispTableStub
{
	public static MispTable getBasicMispTableStub()
	{
		MispTable mTable= new MispTable(TFieldStub.getBasicTFieldListStub(),ObStub.getBasicObList());
		
		return mTable;

	}
}
