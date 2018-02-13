package spider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.dao.CatalogDAO;
import com.dao.CommodityDAO;
import com.domain.Catalog;
import com.domain.Commodity;


@RunWith(SpringRunner.class)
@ContextConfiguration({ "/spring-config.xml" })
public class Test {
	
	 @Autowired
	 private CatalogDAO dao;
	 
	 @Autowired
	 private CommodityDAO cod;
	 
	 @org.junit.Test
		public void testSet() {
		/* Catalog a=new Catalog();
		 a.setCatalogName("222");
		 a.setCatalogNum("33343");
		 a.setChildNode(22);
		 a.setParentNum("2323");
		 a.setCreateTime(new Date());
		 int row=dao.add(a);
		 assertEquals(1,row);*/
//		 assertNotNull(dao.listCatalog(12121));
		 Commodity com=new Commodity();
		 com.setAuthor("111");
		 com.setChildCatalogNum("11");
		 com.setCommCatalog("33333");
		 com.setCommLabel("332");
		 com.setCommName("232");
		 com.setCommPrice("3323");
		 com.setId(22);
		 com.setIsbn("33");
		 com.setParentCatalogNum("333");
		 com.setPictureName("rrr");
		 com.setPreface("cs3");
		 com.setPress("454");
		 com.setPubData("ggt5");
		 com.setScore("333");
		 assertEquals(1,cod.add(com) );
		 
		}

}
