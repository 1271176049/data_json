package mall_json1.mall_json1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.google.gson.Gson;
import com.sdp.edu.bean.T_MALL_CLASS_1;
import com.sdp.edu.bean.T_MALL_CLASS_2;
import com.sdp.edu.bean.T_MALL_TRADE_MARK;
import com.sdp.edu.mapper.Class1Mapper;
import com.sdp.edu.mapper.Class2Mapper;
import com.sdp.edu.mapper.Trade_markMapper;
import com.sdp.edu.utils.MySqlSessionFactory;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			SqlSessionFactory sessionFactory = MySqlSessionFactory.getSqlSessionFactory();
			SqlSession sqlSession = sessionFactory.openSession();
			Class1Mapper mapper = sqlSession.getMapper(Class1Mapper.class);
			List<T_MALL_CLASS_1> select_class_1 = mapper.select_class_1();
			Gson gson = new Gson();
			String string = gson.toJson(select_class_1);
			FileOutputStream fileoutputStream = new FileOutputStream(
					new File("E:\\STS_workspace\\mall_json1\\config\\class_1.js"));
			fileoutputStream.write(string.getBytes("UTF-8"));
			 
			
			for (T_MALL_CLASS_1 t_MALL_CLASS_1 : select_class_1) {
				int id = t_MALL_CLASS_1.getId();
				Class2Mapper mapper2 = sqlSession.getMapper(Class2Mapper.class);
				List<T_MALL_CLASS_2> select_class_2 = mapper2.select_class_2(id);
				Gson gson2=new Gson();
				String string2 = gson2.toJson(select_class_2);
				String filename="E:\\STS_workspace\\mall_json1\\config\\class_2_"+id+".js";
				FileOutputStream fileoutputStream2=new FileOutputStream(new File(filename));
				fileoutputStream2.write(string2.getBytes("UTF-8"));
			}
			for (T_MALL_CLASS_1 t_MALL_CLASS_1 : select_class_1) {
				int id = t_MALL_CLASS_1.getId();
				Trade_markMapper trade_markeMapper = sqlSession.getMapper(Trade_markMapper.class);
				List<T_MALL_TRADE_MARK> trade_marke = trade_markeMapper.select_trade_mark(id);
				Gson gson2=new Gson();
				String string2 = gson2.toJson(trade_marke);
				String filename="E:\\STS_workspace\\mall_json1\\config\\tm_class_1_"+id+".js";
				FileOutputStream fileoutputStream2=new FileOutputStream(new File(filename));
				fileoutputStream2.write(string2.getBytes("UTF-8"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
